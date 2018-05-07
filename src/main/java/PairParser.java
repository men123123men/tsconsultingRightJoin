import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  PairParser {

    private Pattern pattern = Pattern.compile("^\\s*(?<KEY>\\d+)\\s*(?<VELUE>\\w+)");

    public Pair<Integer,String> parse(String input) throws IllegalFormatException {
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            int key = Integer.parseInt(matcher.group("KEY"));
            String value = matcher.group("VELUE");
            return Pair.createInstance(key, value);
        }
        else
            throw new IllegalFormatException(input);
    }
}
