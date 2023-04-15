import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args){
        try(Reader reader = new InputStreamReader(new FileInputStream("input.txt"))) {
            StatisticTable table = new StatisticTable(reader);
            OutputCSV output = new OutputCSV("output.csv");
            output.writeToCSV(table);
        }
        catch (IOException e){
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }
}
