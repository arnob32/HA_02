package exceptionshandling;

public class ExceptionHandler {
    public static void simulateChainedError() throws CustomException {
        try {
            throw new NullPointerException("Inner problem");
        } catch (NullPointerException e) {
            throw new CustomException("Outer error caused by another", e);
        }
    }
}