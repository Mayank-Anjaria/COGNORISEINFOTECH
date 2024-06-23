import java.util.*;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\nSelect an option from below : ");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.print("Enter your choice : ");
            String choice = scanner.next();

            if (!choice.matches("[1-5]"))
            {
                System.out.println("\nInvalid input. Please enter a valid choice.");
                continue;
            }

            if (choice.equals("5"))
            {
                System.out.println("\nExiting the program...");
                break;
            }

            try
            {
                System.out.print("Enter first number : ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number : ");
                double num2 = scanner.nextDouble();

                double result;

                switch (choice)
                {
                    case "1":
                        result = add(num1, num2);
                        System.out.println("\nAddition is : " + result);
                        break;
                    case "2":
                        result = subtract(num1, num2);
                        System.out.println("\nSubtraction is : " + result);
                        break;
                    case "3":
                        result = multiply(num1, num2);
                        System.out.println("\nMultiplication is : " + result);
                        break;
                    case "4":
                        try
                        {
                            result = divide(num1, num2);
                            System.out.println("\nDivision is : " + result);
                        }
                        catch (ArithmeticException e)
                        {
                            System.out.println("\nCan't divide by zero!");
                        }
                        break;
                    default:
                        System.out.println("\nInvalid choice.");
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nInvalid input. Please enter a valid number.");
                scanner.next();
            }
            catch (Exception e)
            {
                System.out.println("An error occurred : " + e.getMessage());
                scanner.next();
            }
        }

        scanner.close();
    }

    public static double add(double x, double y)
    {
        return x + y;
    }

    public static double subtract(double x, double y)
    {
        return x - y;
    }

    public static double multiply(double x, double y)
    {
        return x * y;
    }

    public static double divide(double x, double y) throws ArithmeticException
    {
        if (y == 0)
        {
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }
}