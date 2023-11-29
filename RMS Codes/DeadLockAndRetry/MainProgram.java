package DeadLockAndRetry;

import DeadLockAndRetry.Resources.NotifyPerson;
import DeadLockAndRetry.Resources.PrintBill;
import DeadLockAndRetry.Tasks.TaskExecutor;
import DeadLockAndRetry.exception.LockNotAcquiredException;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class MainProgram {

    private static ReentrantLock reentrantLockForNotifyPerson = new ReentrantLock();
    private static ReentrantLock reentrantLockForPrintBill = new ReentrantLock();

    public static Consumer<String> sendEmailAndPrintBill() {
        Consumer<String> consumer = (customerEmail) -> {
            sendEmailToTheCustomer(customerEmail);
            printBillForTheCustomer(customerEmail);
        };
        return consumer;
    }

    public static Consumer<String> printBillAndSendEmail() {
        Consumer<String> consumer = (customerEmail) -> {
            printBillForTheCustomer(customerEmail);
            sendEmailToTheCustomer(customerEmail);
        };
        return consumer;
    }

    public static void main(String args[]) {

        TaskExecutor taskExecutor1 =
                new TaskExecutor<String>(sendEmailAndPrintBill(), "RohitMangla@gmail.com");
        TaskExecutor taskExecutor2 =
                new TaskExecutor<String>(printBillAndSendEmail(), "GauravSir@gmail.com");

        Thread threadForTask1 = new Thread(taskExecutor1);
       Thread threadForTask2 = new Thread(taskExecutor2);

        threadForTask1.start();
        threadForTask2.start();
    }

    public static void sendEmailToTheCustomer(final String customerEmail) {
        try {

            int retryCount = 0;
            System.out.println("Taking Lock for Notify Person Resource for : "  + customerEmail);
            while (!reentrantLockForNotifyPerson.tryLock()) {

                if (retryCount > 3) {
                    throw new LockNotAcquiredException("Lock Not Acquired for the Notify Person");
                }

                Thread.sleep(1000);
                retryCount++;
                System.out.println("Lock Not Acquired for notify Person resource for : "  + customerEmail
                        + " Retry's Done : "+ retryCount);
            }

            System.out.println("Lock acquired for Notify Person Resource for : "  + customerEmail);
            Thread.sleep(2000);

            NotifyPerson.getNotifyPersonResource().sendEmailToTheCustomer(customerEmail);

        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        } catch (LockNotAcquiredException e) {
            throw e;
        } finally {
            reentrantLockForNotifyPerson.unlock();
            System.out.println("Lock released for Notify Person Resource for : "  + customerEmail);
        }
    }

    public static void printBillForTheCustomer(final String customerEmail) {
        try {

            System.out.println("Taking Lock for Print Bill Resource for : "  + customerEmail);

            while(!reentrantLockForPrintBill.tryLock()) {
                Thread.sleep(1000);
                System.out.println("Lock Not Acquired for Print Bill Resource for : "  + customerEmail);
            }

            System.out.println("Lock acquired for Print Bill Resource for : "  + customerEmail);
            Thread.sleep(2000);

            PrintBill.getPrintBillResource().printBill(customerEmail);

        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        } finally {
            reentrantLockForPrintBill.unlock();
            System.out.println("Lock released for Print Bill Resource for : "  + customerEmail);
        }
    }
}
