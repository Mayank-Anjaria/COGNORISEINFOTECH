import java.util.*;

public class Task1
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int guess = 0;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number. Good luck!");

        while (attempts < maxAttempts)
        {
            System.out.print("\nAttempt " + (attempts + 1) + " - Enter your guess : ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess)
            {
                System.out.println("\nToo low! Try again.");
            }
            else if (guess > numberToGuess)
            {
                System.out.println("\nToo high! Try again.");
            }
            else
            {
                System.out.println("\nCongratulations! You guessed the correct number " + numberToGuess + " in " + attempts + " attempts.");
                break;
            }
        }

        if (attempts == maxAttempts)
        {
            System.out.println("\nSorry, you've used all your attempts. The correct number was : " + numberToGuess);
        }

        scanner.close();
    }
}