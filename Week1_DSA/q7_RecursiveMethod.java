public class FinancialForecasting {

    // Method to calculate future value using recursion
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Starting value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = calculateFutureValue(currentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
