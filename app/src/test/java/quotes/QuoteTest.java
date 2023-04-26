package quotes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QuoteTest {
    private Quote quote;
    // Declaring ANSI_GREEN to color the successful test souts :)
    public static final String ANSI_GREEN = "\u001B[32m";
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    @BeforeEach
    void setup() {
        String[] tags = {"trumpet-gods"};
        String author = "Louis Armstrong";
        String likes = "23 likes";
        String text = "What we play is life.";
        this.quote = new Quote(tags,author,likes,text);
    }

    @Test
    void testGetTags() {
        String[] expectedTags = {"trumpet-gods"};
        assertArrayEquals(expectedTags, quote.getTags());

        System.out.println(ANSI_GREEN + "testGetTags() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetTags() {
        String[] newTags = {"Dog"};
        quote.setTags(newTags);
        assertArrayEquals(newTags, quote.getTags());

        System.out.println(ANSI_GREEN + "testSetTags() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testGetAuthor() {
        String expectedAuthor = "Louis Armstrong";
        assertEquals(expectedAuthor, quote.getAuthor());

        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetAuthor() {
        String newAuthor = "Dave";
        quote.setAuthor(newAuthor);
        assertEquals(newAuthor, quote.getAuthor());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testGetLikes() {
        String expectedLikes = "23 likes";
        assertEquals(expectedLikes, quote.getLikes());

        System.out.println(ANSI_GREEN + "testGetLikes() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetLikes() {
        String newLikes = "1 like";
        quote.setLikes(newLikes);
        assertEquals(newLikes, quote.getLikes());

        System.out.println(ANSI_GREEN + "testSetLikes() - test passed successfully" + ANSI_RESET);
    }
    @Test
    void testGetText() {
        String expectedText = "What we play is life.";
        assertEquals(expectedText, quote.getText());

        System.out.println(ANSI_GREEN + "testGetAuthor() - test passed successfully" + ANSI_RESET);
    }

    @Test
    void testSetText() {
        String newText = "Nice";
        quote.setText(newText);
        assertEquals(newText, quote.getText());

        System.out.println(ANSI_GREEN + "testSetAuthor() - test passed successfully" + ANSI_RESET);
    }
}
