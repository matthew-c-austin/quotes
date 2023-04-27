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

    // TODO: Incorporate the fetchApiQuote() into the method below, and create a new method getRandomQuoteFromFile() with the current logic below
    public Quote getRandomQuote(){
        if (this.quotes == null || this.quotes.isEmpty()) {
            return null;
        }

        Random rand = new Random();

        return this.quotes.get(rand.nextInt(this.quotes.size()));
    }

    private Quote fetchApiQuote() throws IOException {
        // TODO: Incorporate all the stuff from today's lecture into this method
        return null;
    }

    private void cacheQuote(Quote quote) {
        // TODO: Create cacheQuote function
    }

    private Quote getRandomQuoteFromFile() {
        // TODO: Copy logic from getRandomQuote() into here
        return null;
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
