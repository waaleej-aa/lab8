# Lab 8: Refactoring, Fail-Fast Design, Tracing and JUnit

Java lab for Software Construction. It covers four tasks: removing code smells, building immutable objects that fail fast, simulating MDC tracing, and unit testing with JUnit 5.

## Requirements

- JDK 16 or newer (Task 2 uses a Java `record`)
- Apache NetBeans (the project was built and run there)
- Maven, with internet access on the first build to download JUnit

## Tasks

### Task 1: Refactoring Legacy Code

Refactors `ReportManager` to remove four code smells.

| Smell | Fix |
| --- | --- |
| String concatenation in a loop | `String.join(",", data)` |
| `NullPointerException` on `type.equals()` | `type` removed; formatter injected, null rejected with `Objects.requireNonNull` |
| Hardcoded PDF/CSV conditionals | `ReportFormatter` interface with `PdfFormatter` and `CsvFormatter` |
| Static `EmailClient` dependency | `Notifier` interface injected through the constructor |

Files: `ReportFormatter`, `PdfFormatter`, `CsvFormatter`, `Notifier`, `ConsoleNotifier`, `ReportManager`, `Main`.

Behavior changes from the legacy code: no trailing comma in the output, and the injected formatter always runs.

### Task 2: Fail-Fast and Immutable Boundaries

`BankTransfer` is a record with `fromAccount`, `toAccount` and `amount` (`BigDecimal`). Its compact constructor rejects null values with `Objects.requireNonNull` and throws `IllegalArgumentException` unless `amount.signum() > 0`.

Run `Main` with one invalid case active at a time to see the uncaught stack trace:

- negative amount: `IllegalArgumentException`
- null account: `NullPointerException`

### Task 3A: Structured Tracing (MDC simulation)

`PaymentProcessor.charge(String txId, double amount)` prints `[TraceID: <txId>] Processing payment...` at the start and `Context Cleared` in a `finally` block, so the cleanup runs on both success and failure. In real SLF4J these two lines map to `MDC.put("traceId", txId)` and `MDC.clear()`.

### Task 3B: JUnit 5 Quality Gate

`OrderServiceTest` (package `com.uet.billing`) checks that `OrderService` applies `VipDiscount` without any database. The test name is `calculateTotal_appliesVipDiscount_withoutTouchingDatabase()` and it follows Arrange-Act-Assert: 100.0 in, 80.0 expected.

## Running

1. Open the project in NetBeans.
2. Run each task's `Main` class (right-click, **Run File**).
3. For the JUnit test, right-click `OrderServiceTest.java` in Test Packages and choose **Test File**.

## Maven setup for JUnit

Add to `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.2.5</version>
        </plugin>
    </plugins>
</build>
```


