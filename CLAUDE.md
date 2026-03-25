# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Overview

This repository captures Kotlin and supporting Java implementations of algorithmic exercises. Contributions should remain small, testable, and easy to run from IntelliJ IDEA or the command line.

**Project Type**: IntelliJ IDEA project without build tool (no Gradle/Maven). Uses `kotlinc`/`javac` directly. Dependencies (Kotlin runtime, JUnit Jupiter 6.0.3) are resolved from the local Maven repository via `.idea/libraries/`.

## Project Structure

- `src/` — solution files; one class per file, named after the problem in `PascalCase`
- `src/test/kotlin/` — JUnit 5 test files; one test class per solution, named `<ClassName>Test.kt`
- `.idea/libraries/` — library descriptors pointing to `~/.m2` for Kotlin runtime and JUnit Jupiter

## Running Tests

Tests are run from IntelliJ IDEA (no build tool CLI available):
- **Single test class**: Right-click `<ClassName>Test.kt` → Run `<ClassName>Test`
- **All tests**: Right-click `src/test/kotlin/` → Run All Tests
- **Single test method**: Click the gutter icon next to a `@Test` function

To compile and run a solution's `main` for quick ad-hoc checks:
```bash
kotlinc src/FileName.kt -include-runtime -d build/filename.jar && java -jar build/filename.jar
```

## Solution & Test Pattern

- Each solution file contains only the solution class (no `main`). Test cases live exclusively in the corresponding test file.
- **When adding a new challenge, never implement the solution.** Create the solution file with a `TODO()` body and create the test file with all test cases.
- Every test must print the input and result using `contentToString()` for arrays or string interpolation for primitives/strings.

Solution structure:
```kotlin
/**
 * Problem title and full description, constraints, and worked examples.
 */
class SolutionName {
    fun solve(input: Type): ReturnType {
        TODO()
    }
}
```

Test structure:
```kotlin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionNameTest {

    private val solution = SolutionName()

    @Test
    fun `descriptive scenario and expected outcome`() {
        val input = ...
        val expected = ...
        println("Input: $input")
        val result = solution.solve(input)
        println("Expected: $expected | Got: $result")
        assertEquals(expected, result)
    }
}
```

- Use `assertArrayEquals()` for array results; verify in-place mutations by checking the array contents after the call
- Aim for 6–10 tests per solution: happy path, edge cases, boundaries, no-result scenarios
- Use backtick test names that read as plain English

## Solution Style

Solutions should reflect interview-style algorithmic thinking, not production code:

- Prioritize clarity of logic over abstraction or extensibility
- Use straightforward imperative or functional approaches that make the algorithm obvious
- Avoid over-engineering: no design patterns, no unnecessary abstractions, no dependency injection
- Variable names should be descriptive but concise (`left`, `right`, `freq`, `maxLen`)
- Inline logic where it aids readability; extract helpers only when they reduce duplication significantly
- Add a one-line comment for non-trivial complexity trade-offs (e.g., `// O(n) time, O(1) space`)

## Coding Conventions

- 4-space indentation; `val` by default; expression bodies where they improve readability
- Helpers stay `camelCase` and should be `private` inside the solution class

## Reviewing & Giving Tips

When the user asks for tips, feedback, or a review on their solution:
- **Do not show code.** Give feedback in plain English only.
- Describe what to change and why, not how to write it.

## Commit Format

Short, sentence-cased messages: `Add ReverseOnlyLetters solution`, `Fix MinimumValueToGetPositiveStepByStepSum test case`.
