package org.example.slang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.example.slang.ast.ASTPrettyPrinter;
import org.example.slang.ast.FunctionDeclarationList;
import org.example.slang.parser.CSTtoASTConverter;
import org.example.slang.parser.Parser;
import org.example.slang.slang.Scanner;
import org.example.slang.slang.Slang;
import org.example.slang.utils.PrettyPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final Slang slang = new Slang();
    /* Holds the global scope, so keep it open all the time.  */
    private static final CSTtoASTConverter treeProcessor
            = new CSTtoASTConverter(slang);

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        run(CharStreams.fromFileName(path));
        if (slang.hadError()) System.exit(65);
        if (slang.hadRuntimeError()) System.exit(70);
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();

            if (line == null || line.equalsIgnoreCase("exit")) {
                /* Terminate the possibly EOF line.  */
                System.out.println();
                break;
            }

            slang.setHadError(false);
            slang.setHadRuntimeError(false);
            run(CharStreams.fromString(line));
        }
    }

    private static void run(CharStream source) {
        Scanner scanner = new Scanner(slang);
        var tokens = scanner.getTokens(source);

        if (slang.hadError()) return;

        Parser parser = new Parser(slang);
        var tree = parser.getSyntaxTree(tokens);

        /* ANTLR error recovers, so lets print it in its error recovered
           form.  */
        System.out.println("Syntax Tree: " + PrettyPrint.prettyPrintTree(tree, parser.getSlangParser().getRuleNames()));

        if (slang.hadError()) return;

        System.out.println("AST:");
        var pp = new ASTPrettyPrinter(System.out);
        var program = (FunctionDeclarationList) tree.accept(treeProcessor);
        program.prettyPrint(pp);
        if (slang.hadError()) return;
    }
}