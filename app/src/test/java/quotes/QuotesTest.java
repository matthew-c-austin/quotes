package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuoteTest{
    // TODO: Write unit tests
    private Quote quote;

    @BeforeEach
    void setup() {
        String[] tags = {"trumpet-gods"};
        String author = "Louis Armstrong";
        String likes = "23 likes";
        String text = "What we play is life.";
        this.quote = new Quote(tags,author,likes,text);
    }

    @Test
    void testGetTags(){
        String[] expectedTags = {"trumpet-gods"};
        assertEquals(expectedTags, quote.getTags());
    }


}