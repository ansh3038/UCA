package DeadLockAndRetry.Tasks;

import java.util.function.Consumer;

public class TaskExecutor<K> implements Runnable {
    private Consumer<K> consumer;
    private K consumerInput;

    public TaskExecutor(final Consumer<K> consumer, final K consumerInput) {
        this.consumer = consumer;
        this.consumerInput = consumerInput;
    }

    @Override
    public void run() {
        consumer.accept(consumerInput);
    }
}
