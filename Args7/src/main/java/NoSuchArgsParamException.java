public class NoSuchArgsParamException extends ReflectiveOperationException {
    private static final long serialVersionUID = -1L;

    /**
     * Constructor.
     */
    public NoSuchArgsParamException() {
        super();
    }

    /**
     * Constructor with a detail message.
     *
     * @param s the detail message
     */
    public NoSuchArgsParamException(String s) {
        super(s);
    }
}