# Slang: A Custom Statically-Typed Programming Language

## Project Overview
Slang is an original, functional programming language and interpreter developed as part of the "Razvoj interpretera" project. The language is designed to be readable and functional, avoiding esoteric complexity while providing a structured environment for programming. 

The core of the project is a multi-stage interpreter that translates high-level Slang code into executable logic through a rigorous translation pipeline.

---

## Interpreter Architecture
The development of Slang is divided into five critical stages of translation and execution:

1. Lexical Analysis: Tokenizing the source code into fundamental language units.
2. Syntax Analysis: Parsing tokens to verify the grammatical structure of the program.
3. Semantic Analysis: Ensuring logical consistency and performing static type checking, where variable types are verified during the translation phase.
4. Intermediate Code Generation: Translating the validated source into an optimized intermediate representation.
5. Interpretation: The final execution engine that processes the intermediate code to deliver program results.

---

## Language Specification and Features

### Data Handling and Types
* Static Typing: All variable types are known and validated before the program runs.
* Supported Types: Native support for Integers, Logical types (which can be represented numerically), and Arrays.

### Logical and Arithmetic Operations
* Operator Suite: Includes assignment, arithmetic, relational, and logical operators.
* Short-Circuit Evaluation: Logical operations utilize short-circuiting to optimize performance by skipping unnecessary sub-expression evaluations.

### Control Flow and Modularity
* Conditional Logic: Implements standard branching with if and else statements.
* Loops: Supports at least two distinct types of iterative loops for complex logic.
* Functions: Users can define modular functions including input parameters, specified return types, and a body consisting of a list of commands.

### System Integration
* Standard I/O: The language supports printing data to the standard output.
* Command Line Arguments: The interpreter can receive and process arguments directly from the command line.

---

## Technical Execution
This project is managed via GitHub Classroom. To run a script using the Slang interpreter:

1. Clone the repository locally.
2. Ensure the environment matches the implementation language chosen for the interpreter.
3. Execute the interpreter by passing a Slang source file and any required command-line arguments.

---
Developed as a team project for the Interpreter Development course.
