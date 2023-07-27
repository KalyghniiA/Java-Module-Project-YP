package exception;

public class NegativeNumberException extends Exception{
    private String exp;

    public NegativeNumberException(String exp) {
        super(exp);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "NegativeNumberException: " + exp;
    }
}
