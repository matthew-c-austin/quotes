package quotes;

public class Quote
{
    // Fields
    private String author;
    private String text;

    // Constructor for the .json files
    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    // Constructor for the Formismatic API. We are forced to use more parameters in the constructor because were we to use the same number and type as the .json version, the compiler has no way of differentiating, even though we don't use the rest of the parameters.
    public Quote(String quoteAuthor, String quoteText, String senderName, String senderLink, String quoteLink) {
        this.author = quoteAuthor;
        this.text = quoteText;
    }

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
