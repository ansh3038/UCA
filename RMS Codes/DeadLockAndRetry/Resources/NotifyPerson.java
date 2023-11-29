package DeadLockAndRetry.Resources;

public class NotifyPerson {
    private final static NotifyPerson notifyPerson = new NotifyPerson();
    private NotifyPerson() {}
    public static NotifyPerson getNotifyPersonResource() {
        return notifyPerson;
    }
    public void sendEmailToTheCustomer(final String customerEmail) throws InterruptedException {
        System.out.println("Sending Email To the Customer :" + customerEmail);
        Thread.sleep(5000);
        System.out.println("Email sent for the Customer :" + customerEmail);
    }
}
