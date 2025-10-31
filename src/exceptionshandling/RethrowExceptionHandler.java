package exceptionshandling;

public class RethrowExceptionHandler {
    public static void riskyOperation(boolean problem) throws CustomException {
        try {
            if (problem) {
                throw new IllegalArgumentException("Bad input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Caught inside method");
            throw new CustomException("Re-thrown CustomException", e);
        }
    }
}