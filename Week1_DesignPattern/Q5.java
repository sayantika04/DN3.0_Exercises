public interface Notifier {
    void send(String message);
}
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
// Abstract decorator class
public abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete decorator for SMS notifications
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

// Concrete decorator for Slack notifications
public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message with message: " + message);
    }
}
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create an EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMSNotifierDecorator
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Decorate further with SlackNotifierDecorator
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification
        slackNotifier.send("Hello, this is a test notification!");
    }
}
