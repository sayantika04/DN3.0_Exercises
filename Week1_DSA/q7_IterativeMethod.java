public class FinancialForecasting {

    // Method to calculate future value using iteration
    public static double calculateFutureValueIterative(double currentValue, double growthRate, int periods) {
        double futureValue = currentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Starting value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = calculateFutureValueIterative(currentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
