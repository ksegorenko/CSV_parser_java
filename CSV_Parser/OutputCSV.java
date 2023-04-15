import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;

public class OutputCSV {
    public OutputCSV(String outputFileName) throws IOException {
        try {
            this.outputFileName = outputFileName;
            this.outputStream = new FileOutputStream(outputFileName);
        }
        catch (IOException e){
            throw new IOException("Sorry, can not open this file.");
        }
    }

    public void writeToCSV(StatisticTable table) throws IOException{
        try(Writer writer = new OutputStreamWriter(outputStream)){
            var sortedWordsTable = table.sortWords();
            Collections.reverse(sortedWordsTable);
            for (WordFrequency elem : sortedWordsTable) {
                if (elem.getWord().length() != 0)
                    writer.write(elem.toString() + "\n");
            }
            writer.flush();
        }
        catch(IOException e){
            throw new IOException("Sorry, I can not write something to this file.");
        }
    }

    private String outputFileName;
    private FileOutputStream outputStream;
}
