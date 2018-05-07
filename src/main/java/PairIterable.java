import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PairIterable implements Iterable<Pair<Integer,String>> {
    private PairParser parser;
    private BufferedReader reader;

    public PairIterable(BufferedReader reader, PairParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    public static List<String> readAllLines(String fileNameInFolderResources) {
        InputStream inputStream = Main.class.getResourceAsStream(fileNameInFolderResources);
        Reader reader = new InputStreamReader(inputStream);
        List<String> result = new ArrayList<>();
        String currentLine;
        try (BufferedReader br = new BufferedReader(reader)) {
            while ((currentLine = br.readLine()) != null)
                result.add(currentLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Iterator<Pair<Integer, String>> iterator() {
        return new BufferedReaderIterator(reader);
    }

    private class BufferedReaderIterator implements Iterator<Pair<Integer, String>> {

        private BufferedReader r;

        public BufferedReaderIterator(BufferedReader r) {
            this.r = r;
        }

        @Override
        public boolean hasNext() {
            try {
                r.mark(1);
                if (r.read() < 0) {
                    return false;
                }
                r.reset();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        @Override
        public Pair<Integer, String> next() {
            try {
                return parser.parse(r.readLine());
            } catch (IOException e) {
                System.err.println("Some exception at file reading!");
                e.printStackTrace();
                return null;
            } catch (IllegalFormatException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
