import java.io.IOException;
import java.io.Reader;

public class Parser {
    Parser(Reader reader) {
        this.reader = reader;
    }

    public String nextWord() throws IOException {
        StringBuilder word = new StringBuilder("");
        int charIndex = 0;
        while(charIndex != -1 && word.toString().equals("")){
            charIndex = reader.read();
            while(Character.isLetterOrDigit(charIndex)) {
                word.append((char) charIndex);
                charIndex = reader.read();
            }
        }
        return word.toString();
    }

    private final Reader reader;
}
