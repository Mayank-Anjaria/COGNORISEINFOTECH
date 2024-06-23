import java.util.*;

// Catalog class
public class Catalog
{
    private ArrayList<Book> books;

    public Catalog()
    {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public ArrayList<Book> searchByTitle(String title)
    {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books)
        {
            if (book.title().toLowerCase().contains(title.toLowerCase()))
            {
                results.add(book);
            }
        }

        return results;
    }

    public ArrayList<Book> searchByAuthor(String author)
    {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books)
        {
            if (book.author().toLowerCase().contains(author.toLowerCase()))
            {
                results.add(book);
            }
        }

        return results;
    }

    public void checkoutBook(String title)
    {
        for (Book book : books)
        {
            if (book.title().equals(title) && !book.isCheckedOut())
            {
                book.checkout();
                System.out.println("\nBook checked out successfully!");
                return;
            }
        }

        System.out.println("\nBook not found or already checked out.");
    }

    public void returnBook(String title)
    {
        for (Book book : books)
        {
            if (book.title().equals(title) && book.isCheckedOut())
            {
                book.returnBook();
                System.out.println("\nBook returned successfully!");
                return;
            }
        }
        
        System.out.println("\nBook not found or not checked out.");
    }

    public void showBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("\nNo books in the catalog.");
        }
        else
        {
            System.out.println("\nBooks in catalog : ");
            for (Book book : books)
            {
                System.out.println(book);
            }
        }
    }
}