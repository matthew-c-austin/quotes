package quotes;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuoteReaderTest {
    public static final String ANSI_GREEN = "\u001B[32m";
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    private QuoteReader sut;
    private File filePath;

    @BeforeEach
    void setup() throws IOException{
        this.filePath = new File("src/test/resources/testQuote.json");
        this.sut = new QuoteReader(filePath);
    }

    @Test
    void testConstructor() throws IOException {
        //assert
        assertEquals(filePath, sut.getFilePath());

        System.out.println(ANSI_GREEN + "testConstructor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testGetRandomQuoteFromFile() throws IOException{
        Quote quote = sut.getRandomQuoteFromFile();
        assertNotNull(quote);
        String expectedAuthor = "Louis Armstrong";
        String expectedText = "What we play is life.";
        assertEquals(expectedAuthor, quote.getAuthor());
        assertEquals(expectedText, quote.getText());

        System.out.println(ANSI_GREEN + "testGetRandomQuote() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testReadQuotes() throws IOException{
        String author = "Louis Armstrong";
        String text = "What we play is life.";
        Quote expectedQuote = new Quote(author, text);
        List<Quote> expectedQuotes = new ArrayList<>();
        expectedQuotes.add(expectedQuote);
        expectedQuotes.add(expectedQuote);
        expectedQuotes.add(expectedQuote);

        File filePath = new File("src/test/resources/testQuotes.json");
        QuoteReader sut = new QuoteReader(filePath);
        List<Quote> actualQuotes = sut.getQuotes();

        assertNotNull(sut.getQuotes());
        assertEquals(expectedQuotes.size(), actualQuotes.size());

        for (int i = 0; i < expectedQuotes.size(); i++) {
            String expectedAuthor = expectedQuotes.get(i).getAuthor();
            String expectedText = expectedQuotes.get(i).getText();

            assertEquals(expectedAuthor, actualQuotes.get(i).getAuthor());
            assertEquals(expectedText, actualQuotes.get(i).getText());
        }

        System.out.println(ANSI_GREEN + "testReadQuotes() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testReadQuotesInvalidFileContentReturnsNull() throws IOException{
        File filePath = new File("src/test/resources/invalidTestQuotes.json");
        QuoteReader sut = new QuoteReader(filePath);
        List<Quote> actualQuotes = sut.getQuotes();
        assertNull(actualQuotes);

        System.out.println(ANSI_GREEN + "testReadQuotesInvalidFileContentReturnsNull() - test passed successfully" + ANSI_RESET);
    }
}
