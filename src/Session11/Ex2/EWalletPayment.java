package Session11.Ex2;

public class EWalletPayment extends Payment implements Refundable {

    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng ví điện tử");
        printAmount();
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền qua ví điện tử: " + amount);
    }
}