import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderMaker {
    public static BufferedReader fromFilePathString(String fileNameInResourceFolder){
        return new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(fileNameInResourceFolder)));
    }
}
