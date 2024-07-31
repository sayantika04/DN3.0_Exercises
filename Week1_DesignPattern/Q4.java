public interface PaymentProcessor {
    void processPayment(double amount);
}
// PayPal payment gateway with its own method
public class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// Stripe payment gateway with its own method
public class StripeGateway {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}
// PayPalAdapter implementing PaymentProcessor and adapting PayPalGateway
public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}

// StripeAdapter implementing PaymentProcessor and adapting StripeGateway
public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.pay(amount);
    }
}
public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the adaptee classes
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Process payments using the adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
    }
}
