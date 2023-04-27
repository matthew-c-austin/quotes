package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

public class QuoteReader{
    // Fields
    private List<Quote> quotes;
    private File filePath;

    // Constructor
    public QuoteReader(File filePath) throws IOException {
        this.filePath = filePath;
        this.quotes = readQuotes();
    }

    // Methods
    private List<Quote> readQuotes() throws IOException{
        try (FileReader fileReader = new FileReader(this.filePath)) {
            Gson gson = new Gson();
            Type quotesType = new TypeToken<List<Quote>>() {}.getType();

            return gson.fromJson(fileReader, quotesType);

        } catch (IOException ioe){
            System.out.println("Caught an IOException with stack trace:");
            ioe.printStackTrace();

            return null;
        }
    }
    public Quote getRandomQuote(){
        if (this.quotes == null || this.quotes.isEmpty()) {
            return null;
        }

        Random rand = new Random();

        return this.quotes.get(rand.nextInt(this.quotes.size()));
    }

    // Getters and Setters
    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }
}
