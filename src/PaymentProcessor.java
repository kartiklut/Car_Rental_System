import Strategy.PaymentStrategy.PaymentStrategy;

public class PaymentProcessor {

    PaymentStrategy paymentStrategy;

    PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public boolean pay(double amount){
        // delegate to the strategy and return ITS result, don't hardcode true
        return paymentStrategy.pay(amount);
    }
}
