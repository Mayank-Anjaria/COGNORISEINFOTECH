import java.util.*;

// Book class
public class Book
{
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String title()
    {
        return title;
    }

    public String author()
    {
        return author;
    }

    public boolean isCheckedOut()
    {
        return checkedOut;
    }

    public void checkout()
    {
        checkedOut = true;
    }

    public void returnBook()
    {
        checkedOut = false;
    }

    @Override
    public String toString()
    {
        return "\nTitle : " + title + ", Author : " + author + ", Checked Out : " + checkedOut;
    }
}
