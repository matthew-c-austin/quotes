package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
        try (FileReader fileReader = new FileReader(this.filePath, StandardCharsets.UTF_16)) {
            Gson gson = new Gson();
            Type quotesType = new TypeToken<List<Quote>>() {}.getType();

            return gson.fromJson(fileReader, quotesType);

        } catch (IOException ioe){
            System.out.println("Caught an IOException with stack trace:");
            ioe.printStackTrace();

            return null;
        }
    }

    public Quote getRandomQuote() throws IOException {
        Quote apiQuote = fetchApiQuote();

        if (apiQuote != null){
            cacheQuote(apiQuote);
            return apiQuote;
        } else {
            return getRandomQuoteFromFile();
        }
    }

    protected Quote fetchApiQuote() throws IOException {
        // TODO: Incorporate all the stuff from today's lecture into this method
        // step 1: create url, and a connection
        URL quoteUrl = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection quoteConnection = (HttpURLConnection) quoteUrl.openConnection();

        // step 2: set our headers, check response code, use a try/catch to handle bad urls, close connection
        try {
            quoteConnection.setRequestMethod("GET");
            int quoteStatus = quoteConnection.getResponseCode();

            if (quoteStatus == 200) {
                // step 3: get data as a stream
                InputStreamReader quoteStreamReader = new InputStreamReader(quoteConnection.getInputStream());

                // step 4: use BufferedReader to read the input (can also use quoteStreamReader.read())
                try (BufferedReader quoteBufferedReader = new BufferedReader(quoteStreamReader)) {
                    String line = quoteBufferedReader.readLine();

                    // step 5: Use Gson to create object
                    Gson gson = new Gson();

                    return gson.fromJson(line, Quote.class);
                }
            } else{
                System.out.println("API Quote malfunctioned: " + quoteStatus);
            }
        } catch(MalformedURLException mue) {
            System.out.println("Bad URL");
            mue.printStackTrace();
        } catch(IOException ioe) {
            System.out.println("Problem with API");
            ioe.printStackTrace();
        } finally {
            quoteConnection.disconnect();
        }
        return null;
    }

    protected void cacheQuote(Quote quote) throws IOException {
        try (FileWriter writer = new FileWriter(this.filePath, StandardCharsets.UTF_16, false)) {
            this.quotes.add(quote);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this.quotes, writer);
        } catch(IOException ioe){
            System.out.println("Cache Malfunction!");
            ioe.printStackTrace();
        }
    }

    protected Quote getRandomQuoteFromFile() {
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
