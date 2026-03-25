# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Repository Overview

This repository captures Kotlin and supporting Java implementations of algorithmic exercises. Contributions should remain small, testable, and easy to run from IntelliJ IDEA or the command line.

**Project Type**: Gradle project with Kotlin DSL. Dependencies managed via `build.gradle.kts`.

## Project Structure

Solutions are organised by technique into packages. Each package lives under both `src/main/kotlin/` and `src/test/kotlin/`:

| Package | Techniques |
|---|---|
| `twopointers` | Two Pointers |
| `slidingwindow` | Sliding Window |
| `prefixsum` | Prefix Sum |
| `arrays` | General array problems |

Future packages to add as needed: `hashmaps`, `linkedlists`, `trees`, `binarysearch`, `dp`, etc.

**Rules:**
- Place each new solution in the package that matches its primary technique
- Both the solution file and its test file must declare the same package (e.g. `package twopointers`)
- File is named `PascalCase.kt`; test file is named `PascalCaseTest.kt`

- `build.gradle.kts` — Gradle build config

## Running Tests

**All tests (CLI):**
```bash
./gradlew test
```

**From IntelliJ IDEA:**
- **Single test class**: Right-click `<ClassName>Test.kt` → Run `<ClassName>Test`
- **All tests**: Right-click `src/test/kotlin/` → Run All Tests
- **Single test method**: Click the gutter icon next to a `@Test` function

## Solution & Test Pattern

- Each solution file contains only the solution class (no `main`). Test cases live exclusively in the corresponding test file.
- **When adding a new challenge, never implement the solution.** Create the solution file with a `TODO()` body and create the test file with all test cases.
- Every test must print the input and result using `contentToString()` for arrays or string interpolation for primitives/strings.

Solution structure:
```kotlin
package twopointers // use the appropriate package

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
package twopointers // must match the solution's package

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
