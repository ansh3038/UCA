package DeadLockAndRetry.exception;

public class LockNotAcquiredException extends RuntimeException {

    public LockNotAcquiredException(final String message) {
        super(message);
    }
}
