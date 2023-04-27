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
    void testGetRandomQuote() {
        Quote quote = sut.getRandomQuote();
        assertNotNull(quote);
        String[] expectedTags = {"trumpet-gods"};
        String expectedAuthor = "Louis Armstrong";
        String expectedLikes = "23 likes";
        String expectedText = "What we play is life.";
        assertArrayEquals(expectedTags, quote.getTags());
        assertEquals(expectedAuthor, quote.getAuthor());
        assertEquals(expectedLikes, quote.getLikes());
        assertEquals(expectedText, quote.getText());

        System.out.println(ANSI_GREEN + "testGetRandomQuote() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testReadQuotes() throws IOException{
        String[] tags = {"trumpet-gods"};
        String author = "Louis Armstrong";
        String likes = "23 likes";
        String text = "What we play is life.";
        Quote expectedQuote = new Quote(tags,author,likes,text);
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
            String[] expectedTags = expectedQuotes.get(i).getTags();
            String expectedAuthor = expectedQuotes.get(i).getAuthor();
            String expectedLikes = expectedQuotes.get(i).getLikes();
            String expectedText = expectedQuotes.get(i).getText();

            assertArrayEquals(expectedTags, actualQuotes.get(i).getTags());
            assertEquals(expectedAuthor, actualQuotes.get(i).getAuthor());
            assertEquals(expectedLikes, actualQuotes.get(i).getLikes());
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
