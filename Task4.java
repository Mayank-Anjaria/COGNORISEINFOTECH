import java.util.*;

public class Task4
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to hangman game.");
        System.out.println("You have to guess the word, It's car brand name.");
        System.out.println("Good Luck.\n");

        String[] carBrands = {
                                "toyota", "honda", "ford", "chevrolet", "nissan", 
                                "bmw", "mercedes", "volkswagen", "audi", "lexus", 
                                "hyundai", "kia", "subaru", "mazda", "jaguar"
                            };
        Random random = new Random();
        
        String selectedWord = carBrands[random.nextInt(carBrands.length)];
        char[] wordArray = new char[selectedWord.length()];
        for (int i = 0; i < selectedWord.length(); i++)
        {
            wordArray[i] = '_';
        }
        
        int attempts = 6;
        ArrayList<Character> incorrectGuesses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (attempts > 0)
        {
            System.out.println("\nCurrent word : " + String.valueOf(wordArray));
            System.out.println("Incorrect guesses : " + incorrectGuesses);
            System.out.println("Remaining attempts : " + attempts);
            
            System.out.print("Enter a letter : ");
            char guess = scanner.next().charAt(0);
            
            boolean correctGuess = false;
            for (int i = 0; i < selectedWord.length(); i++)
            {
                if (selectedWord.charAt(i) == guess)
                {
                    wordArray[i] = guess;
                    correctGuess = true;
                }
            }
            
            if (!correctGuess)
            {
                incorrectGuesses.add(guess);
                attempts--;
            }
            
            displayHangman(attempts);
            
            if (String.valueOf(wordArray).equals(selectedWord))
            {
                System.out.println("Congratulations! You've guessed the word : " + selectedWord);
                break;
            }
        }
        
        if (attempts == 0)
        {
            System.out.println("You've run out of attempts. The word was : " + selectedWord);
        }
        
        scanner.close();
    }
    
    public static void displayHangman(int attempts)
    {
        switch (attempts)
        {
            case 6:
                System.out.println("\n------\n|\n|\n|\n|\n|");
                break;
            case 5:
                System.out.println("\n------\n|    O\n|\n|\n|\n|");
                break;
            case 4:
                System.out.println("\n------\n|    O\n|    |\n|\n|\n|");
                break;
            case 3:
                System.out.println("\n------\n|    O\n|   /|\n|\n|\n|");
                break;
            case 2:
                System.out.println("\n------\n|    O\n|   /|\\\n|\n|\n|");
                break;
            case 1:
                System.out.println("\n------\n|    O\n|   /|\\\n|   /\n|\n|");
                break;
            case 0:
                System.out.println("\n------\n|    X\n|   /|\\\n|   / \\\n|\n|");
                break;
        }
    }
}