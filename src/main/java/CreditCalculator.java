public class CreditCalculator {
    int creditPeriod;
    int loanAmount;

    public CreditCalculator(int creditPeriod, int loanAmount) {
        this.creditPeriod = creditPeriod;
        this.loanAmount = loanAmount;
    }

    private static final double PERCENTS = 0.8;
    private static final double MONTHS_PER_YEAR = 12;

    //Рассчет месячного платежа

    public static double calculationOfMonthlyPayment(int creditPeriod, int loanAmount) {
        double calculationOfMonthlyPayments = Math.round(Math.abs((PERCENTS * loanAmount)
                / (1 - (1 / (1 + PERCENTS) * (MONTHS_PER_YEAR * creditPeriod)))) * 100);
        calculationOfMonthlyPayments = calculationOfMonthlyPayments / 100;
        System.out.printf("Месячный платеж: %s", calculationOfMonthlyPayments);
        System.out.println();
        return calculationOfMonthlyPayments;
    }


    //Рассчет общей суммы к возврату в банк
    public static double calculationOfTheTotalAmountToBeRefundedToTheBank(double calculationOfMonthlyPayment,
                                                                          int creditPeriod) {
        double totalAmountToBeRefunded = Math.round(calculationOfMonthlyPayment * MONTHS_PER_YEAR * creditPeriod * 100);
        totalAmountToBeRefunded = totalAmountToBeRefunded / 100;
        System.out.printf("Общая сумма к возврату в банк %s: ", totalAmountToBeRefunded);
        System.out.println();
        return totalAmountToBeRefunded;
    }

    // Рассчет переплаты за весь период
    public static double calculationOfOverpaymentForTheEntirePeriod(double totalAmountToBeRefunded, int loanAmount) {
        double overpayment = Math.round((totalAmountToBeRefunded - loanAmount) * 100);
        overpayment = overpayment / 100;
        System.out.printf("Переплаты за весь период: %s", overpayment);
        System.out.println();

        return overpayment;

    }

}

