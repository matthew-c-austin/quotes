package quotes;

public class Quote
{
    // Fields
    // TODO: Delete tags and likes from all functions and tests. We won't be using them.
    private String[] tags;
    private String author;
    private String likes;
    private String text;

    // Constructor for the .json files
    public Quote(String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    // Constructor for the Formismatic API
    // TODO: Create constructor for the API version of the quotes

    // Getters and Setters
    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
