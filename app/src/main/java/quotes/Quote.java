package quotes;

import com.google.gson.annotations.SerializedName;

public class Quote
{
    // Fields
    @SerializedName(value = "author", alternate = "quoteAuthor")
    private String author;
    @SerializedName(value = "text", alternate = "quoteText")
    private String text;

    // Constructor for the .json files
    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    // Constructor for the Formismatic API. We are forced to use more parameters in the constructor because were we to use the same number and type as the .json version, the compiler has no way of differentiating, even though we don't use the rest of the parameters.
    public Quote(String quoteText, String quoteAuthor, String senderName, String senderLink, String quoteLink) {
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
