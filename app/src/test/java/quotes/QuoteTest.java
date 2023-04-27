package quotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QuoteTest {
    private Quote jsonQuote;
    private Quote apiQuote;
    // Declaring ANSI_GREEN to color the successful test souts :)
    public static final String ANSI_GREEN = "\u001B[32m";
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    @BeforeEach
    void setup() {
        String author = "Louis Armstrong";
        String text = "What we play is life.";
        this.jsonQuote = new Quote(author,text);
        this.apiQuote = new Quote(author,text, "", "", "");
    }

    @Test
    void testGetAuthor() {
        String expectedAuthor = "Louis Armstrong";
        assertEquals(expectedAuthor, jsonQuote.getAuthor());
        assertEquals(expectedAuthor, apiQuote.getAuthor());
        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetAuthor() {
        String newAuthor = "Dave";
        jsonQuote.setAuthor(newAuthor);
        apiQuote.setAuthor(newAuthor);
        assertEquals(newAuthor, jsonQuote.getAuthor());
        assertEquals(newAuthor, apiQuote.getAuthor());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testGetText() {
        String expectedText = "What we play is life.";
        assertEquals(expectedText, jsonQuote.getText());
        assertEquals(expectedText, apiQuote.getText());
        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetText() {
        String newText = "Nice";
        jsonQuote.setText(newText);
        apiQuote.setText(newText);
        assertEquals(newText, jsonQuote.getText());
        assertEquals(newText, apiQuote.getText());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }
}
