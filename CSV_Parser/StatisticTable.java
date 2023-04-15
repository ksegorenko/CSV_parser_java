import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
public class StatisticTable {
    public StatisticTable(Reader reader) throws IOException{
        wordMap = new HashMap<String, Integer>();
        Parser parser = new Parser(reader);
        while(reader.ready()){
            String word = parser.nextWord();
            wordMap.merge(word, 1, (prev, next) -> prev + 1);
            WordFrequency.totalWordsCount++;
        }
    }
    public ArrayList<WordFrequency> sortWords() {
        var sortedWordsTable = new ArrayList<WordFrequency>();
        for (Map.Entry<String, Integer> pair : wordMap.entrySet()){
            WordFrequency elem = new WordFrequency(pair.getKey(), pair.getValue());
            sortedWordsTable.add(elem);
        }
        sortedWordsTable.sort(new CompareElements());
        return sortedWordsTable;
    }

    private HashMap<String, Integer> wordMap;
}

class CompareElements implements Comparator<WordFrequency> {
    @Override
    public int compare(WordFrequency elem1, WordFrequency elem2){
        return elem1.getWordCount() - elem2.getWordCount();
    }
}
