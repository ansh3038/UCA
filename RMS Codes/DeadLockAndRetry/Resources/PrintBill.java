package DeadLockAndRetry.Resources;

public class PrintBill {
    private final static PrintBill printBill = new PrintBill();
    private PrintBill() {}

    public static PrintBill getPrintBillResource() {
        return printBill;
    }
    public void printBill(final String customerEmail) throws InterruptedException {
        System.out.println("Printing Bill for the Customer :" + customerEmail);
        Thread.sleep(5000);
        System.out.println("Bill printed for the Customer :" + customerEmail);
    }
}
