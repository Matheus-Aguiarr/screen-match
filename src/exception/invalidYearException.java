package exception;

public class invalidYearException extends RuntimeException {
    private String msg;
    public invalidYearException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }
}
