# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Overview

This repository captures Kotlin and supporting Java implementations of algorithmic exercises. Contributions should remain small, testable, and easy to run from IntelliJ IDEA or the command line.

**Project Type**: IntelliJ IDEA project without build tool (no Gradle/Maven). Uses kotlinc and javac directly.

## Project Structure & Module Organization
- `src/` contains independent problem solutions; each Kotlin file typically exposes one `main` entry for ad-hoc verification.
- Keep any new utilities collocated with the problem they support to avoid implicit shared state.
- IDE metadata (`.idea/`, `DataStructuresAndAlgorithmsKotlin.iml`) should only change when you intend to update project settings.

## Build, Test, and Development Commands

### Command-Line Compilation and Execution
Each Kotlin file can be compiled and run independently using kotlinc:
```bash
# Pattern for any Kotlin solution file
kotlinc src/FileName.kt -include-runtime -d build/filename.jar && java -jar build/filename.jar

# Examples
kotlinc src/AnswerQueries.kt -include-runtime -d build/answer-queries.jar && java -jar build/answer-queries.jar
kotlinc src/MinimumValueToGetPositiveStepByStepSum.kt -include-runtime -d build/min-value.jar && java -jar build/min-value.jar
```

For Java files:
```bash
javac -d build/classes src/Main.java && java -cp build/classes Main
```

### IntelliJ IDEA Workflow (Recommended)
- Create per-file run configurations targeting each file's `main` function for faster iteration
- Right-click on a Kotlin file → Run 'FileNameKt' to execute the embedded test harness
- The project uses JDK with Kotlin runtime library attached (see DataStructuresAndAlgorithmsKotlin.iml)

## Documentation & Testing Pattern
Each solution file follows a consistent pattern:
1. **KDoc header**: Comprehensive problem statement with constraints and worked examples
2. **Solution class**: Single class containing the algorithmic solution
3. **Test harness in main()**: At least 6-10 deterministic test cases with PASS/FAIL output

Example structure:
```kotlin
/**
 * Problem Title
 *
 * Full problem description...
 * Examples with explanations...
 */
class SolutionName {
    fun solve(input: Type): ReturnType {
        // implementation
    }
}

fun main() {
    val solution = SolutionName()

    // Test case 1: Description
    val result1 = solution.solve(input1)
    println("Test 1: Expected X, Got $result1 - ${if (result1 == X) "PASS" else "FAIL"}")
    // ... more test cases
}
```

When a solution is pending, leave `TODO` markers but keep the annotated tests for validation.

## Coding Style & Naming Conventions
- Use 4-space indentation and follow Kotlin coding conventions (immutable vals by default, expression bodies where appropriate).
- Match class/file names to challenge titles in `PascalCase`; helpers stay `camelCase`.
- Keep functions pure when possible and document non-trivial complexity decisions with a one-line comment.

## Testing Guidelines
- Each file contains its own test harness in the `main` function with console output showing PASS/FAIL
- Tests use inline assertions like `${if (result == expected) "PASS" else "FAIL"}`
- For array comparisons, use `.contentEquals()` and `.contentToString()`
- Always validate the complete `main` harness end-to-end before committing
- For structured tests outside of main, place suites under `src/test/kotlin` using JUnit 5 or Kotest (update build instructions if adding test frameworks)

## Commit & Pull Request Guidelines
- Follow the observed short, sentence-cased commit format (e.g., `Add MinimumValueToGetPositiveStepByStepSum`).
- Describe problem statements, key optimizations, and any runtime or memory trade-offs in the PR body.
- Link issues when applicable and mention new commands, configuration tweaks, or follow-up tasks that reviewers should note.
