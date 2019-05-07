public class NoSuchArgsOptionException extends ReflectiveOperationException {
    private static final long serialVersionUID = -1L;

    /**
     * Constructor.
     */
    public NoSuchArgsOptionException() {
        super();
    }

    /**
     * Constructor with a detail message.
     *
     * @param s the detail message
     */
    public NoSuchArgsOptionException(String s) {
        super(s);
    }
}