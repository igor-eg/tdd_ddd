import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreditCalculator creditCalculator = new CreditCalculator(0, 0);
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введите информацию о периоде кредитования (в годах) и сумме кредита (рубл.) в формате: " +
                        "\"12, 1_000_000\"");
                String input = scanner.nextLine();

                if (input.equals("end")) {

                    break;
                }
                String[] creditCalculators = input.split(", ");
                creditCalculator = new CreditCalculator(Integer.parseInt(creditCalculators[0]),
                        Integer.parseInt(creditCalculators[1]));


                double calculationOfMonthlyPayment = creditCalculator.calculationOfMonthlyPayment
                        (creditCalculator.creditPeriod, creditCalculator.loanAmount);
                double totalAmountToBeRefunded = creditCalculator.calculationOfTheTotalAmountToBeRefundedToTheBank
                        (calculationOfMonthlyPayment, creditCalculator.creditPeriod);
                creditCalculator.calculationOfOverpaymentForTheEntirePeriod(totalAmountToBeRefunded,
                        creditCalculator.loanAmount);
            }

        } catch (RuntimeException exception) {
            System.out.println("Не верно ведена информация ");
        }

    }
}

