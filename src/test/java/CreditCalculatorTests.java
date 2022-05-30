import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CreditCalculatorTests {
    private static long suiteStartTime;
    private long testStartTime;
    CreditCalculator sut;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running StringTest");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("StringTest complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new nest");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @ParameterizedTest
    @MethodSource("source1")

    public void testCalculationOfMonthlyPayment(int creditPeriod, int loanAmount, double expected) {

        // when:
        double result = sut.calculationOfMonthlyPayment(creditPeriod, loanAmount);

        // then:

        Assertions.assertEquals(expected, result);

    }

    private static Stream<Arguments> source1() {
        return Stream.of(Arguments.of(12, 1000000, 10126.58), Arguments.of(10, 1000, 12.18), Arguments.of(1, 1000, 12.18));
    }

    @ParameterizedTest
    @MethodSource("source2")

    public void testCalculationOfTheTotalAmountToBeRefundedToTheBank(double calculationOfMonthlyPayment,
                                                                     int creditPeriod, double expected) {

        // when:
        double result = sut.calculationOfTheTotalAmountToBeRefundedToTheBank(calculationOfMonthlyPayment,
                creditPeriod);

        // then:

        Assertions.assertEquals(expected, result);

    }

    private static Stream<Arguments> source2() {
        return Stream.of(Arguments.of(10126.58, 12, 1458227.52), Arguments.of(12.18, 10, 1461.6), Arguments.of(1, 1000, 12.18));
    }


    @ParameterizedTest
    @MethodSource("source3")

    public void testCalculationOfOverpaymentForTheEntirePeriod(double totalAmountToBeRefunded, int loanAmount,
                                                               double expected) {

        // when:
        double result = sut.calculationOfOverpaymentForTheEntirePeriod(totalAmountToBeRefunded, loanAmount);

        // then:

        Assertions.assertEquals(expected, result);

    }

    private static Stream<Arguments> source3() {
        return Stream.of(Arguments.of(1458227.52, 1000000, 458227.52), Arguments.of(1461.6, 1000, 461.6),
                Arguments.of(10, 1000, 12.18));
    }

}
