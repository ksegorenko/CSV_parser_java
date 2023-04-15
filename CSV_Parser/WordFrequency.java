public class WordFrequency {
    public static int totalWordsCount = 0;
    private final String word;
    private final int wordCount;

    public WordFrequency (String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }
    public String getWord(){
        return this.word;
    }
    public int getWordCount() {
        return this.wordCount;
    }
    @Override
    public String toString() {
            return word + ";" + wordCount + ";" + countPercent() + "%";
    }

    private double countPercent(){
        double result = ((double)wordCount/totalWordsCount) * 100;
        return (double)((int)(result * 100)) / 100;
    }
}
