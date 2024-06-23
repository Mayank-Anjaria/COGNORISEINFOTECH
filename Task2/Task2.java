import java.util.*;

public class Task2
{
    public static void main(String[] args)
    {
        Catalog catalog = new Catalog();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println("Library Catalog System");
            System.out.println("1. Add a book");
            System.out.println("2. Show book");
            System.out.println("3. Search books by title");
            System.out.println("4. Search books by author");
            System.out.println("5. Checkout a book");
            System.out.println("6. Return a book");
            System.out.println("7. Exit");
            System.out.print("Choose an option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter book title catalog : ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author : ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    catalog.addBook(newBook);
                    System.out.println("\nBook added successfully!");
                    break;
                case 2:
                    catalog.showBooks();
                    break;
                case 3:
                    System.out.print("Enter title to search : ");
                    String searchTitle = scanner.nextLine();
                    System.out.println("Search results :");
                    for (Book book : catalog.searchByTitle(searchTitle))
                    {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    System.out.print("Enter author to search : ");
                    String searchAuthor = scanner.nextLine();
                    System.out.println("Search results : ");
                    for (Book book : catalog.searchByAuthor(searchAuthor))
                    {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    System.out.print("Enter title to checkout : ");
                    String checkoutTitle = scanner.nextLine();
                    catalog.checkoutBook(checkoutTitle);
                    break;
                case 6:
                    System.out.print("Enter title to return : ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;
                case 7:
                    running = false;
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
          
            System.out.println();
        }

        scanner.close();
    }
}