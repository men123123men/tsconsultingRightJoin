public class IllegalFormatException extends Exception{
    public IllegalFormatException(String fileLine) {
        super("Incorrect format table entry in '"+fileLine+"'");
    }
}
