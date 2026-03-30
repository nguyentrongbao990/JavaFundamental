package Session11.Ex2;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];

        payments[0] = new CashPayment(150000);
        payments[1] = new CreditCardPayment(320000);
        payments[2] = new EWalletPayment(500000);

        for (Payment payment : payments) {
            payment.pay();

            if (payment instanceof Refundable) {
                ((Refundable) payment).refund();
            }

            System.out.println("----------------------");
        }
    }
}