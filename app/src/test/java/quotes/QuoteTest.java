package quotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QuoteTest {
    private Quote quoteFromFile;
    private Quote quoteFromApi;
    // Declaring ANSI_GREEN to color the successful test souts :)
    public static final String ANSI_GREEN = "\u001B[32m";
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    @BeforeEach
    void setup() {
        String author = "Louis Armstrong";
        String text = "What we play is life.";
        this.quoteFromFile = new Quote(author,text);
        this.quoteFromApi = new Quote(author,text, "", "", "");
    }

    @Test
    void testGetAuthor() {
        String expectedAuthor = "Louis Armstrong";
        assertEquals(expectedAuthor, quoteFromFile.getAuthor());
        assertEquals(expectedAuthor, quoteFromApi.getAuthor());
        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetAuthor() {
        String newAuthor = "Dave";
        quoteFromFile.setAuthor(newAuthor);
        quoteFromApi.setAuthor(newAuthor);
        assertEquals(newAuthor, quoteFromFile.getAuthor());
        assertEquals(newAuthor, quoteFromApi.getAuthor());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testGetText() {
        String expectedText = "What we play is life.";
        assertEquals(expectedText, quoteFromFile.getText());
        assertEquals(expectedText, quoteFromApi.getText());
        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetText() {
        String newText = "Nice";
        quoteFromFile.setText(newText);
        quoteFromApi.setText(newText);
        assertEquals(newText, quoteFromFile.getText());
        assertEquals(newText, quoteFromApi.getText());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }
}
