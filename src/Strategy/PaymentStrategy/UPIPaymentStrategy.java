package Strategy.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean pay(double amount){
        System.out.println("Booking Payment made by UPI is Paid Successfully! of amount "+amount);
        return true;
    }
}
