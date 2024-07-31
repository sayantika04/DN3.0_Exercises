public interface PaymentStrategy {
    void pay(double amount);
}
// Concrete strategy for Credit Card payment
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolderName);
    }
}

// Concrete strategy for PayPal payment
public class PayPalPayment implements PaymentStrategy {
    private String emailAddress;

    public PayPalPayment(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
        System.out.println("Email Address: " + emailAddress);
    }
}
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create different payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");

        // Create PaymentContext with CreditCardPayment strategy
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(100.0);

        // Change strategy to PayPalPayment
        paymentContext = new PaymentContext(payPalPayment);
        paymentContext.executePayment(200.0);
    }
}
