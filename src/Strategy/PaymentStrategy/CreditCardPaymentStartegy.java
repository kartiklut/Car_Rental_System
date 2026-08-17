package Strategy.PaymentStrategy;

public class CreditCardPaymentStartegy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Booking Payment made by Credit Card is Paid Successfully! of amount "+amount);
        return true;
    }
}
