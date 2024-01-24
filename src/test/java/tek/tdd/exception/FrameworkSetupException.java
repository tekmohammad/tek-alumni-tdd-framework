package tek.tdd.exception;

public class FrameworkSetupException extends RuntimeException {

    public FrameworkSetupException(String reason) {
        super(reason);
    }
}
