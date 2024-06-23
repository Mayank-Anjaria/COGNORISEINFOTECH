import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task7 extends JFrame implements ActionListener
{
    private JTextField displayField;
    private StringBuilder input;

    public Task7()
    {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons =
        {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "^", "sin", "cos",
            "tan", "log", "C", "DEL"
        };

        for (String text : buttons)
        {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        input = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        switch (command)
        {
            case "C":
                input.setLength(0);
                displayField.setText("");
                break;
            case "DEL":
                if (input.length() > 0)
                {
                    input.setLength(input.length() - 1);
                    displayField.setText(input.toString());
                }
                break;
            case "=":
                try
                {
                    double result = calculate(input.toString());
                    displayField.setText(String.valueOf(result));
                    input.setLength(0);
                    input.append(result);
                }
                catch (Exception ex)
                {
                    displayField.setText("Error");
                    input.setLength(0);
                }
                break;
            case "sqrt":
                applyFunction(Math::sqrt);
                break;
            case "^":
                input.append("^");
                displayField.setText(input.toString());
                break;
            case "sin":
                applyFunction(Math::sin);
                break;
            case "cos":
                applyFunction(Math::cos);
                break;
            case "tan":
                applyFunction(Math::tan);
                break;
            case "log":
                applyFunction(Math::log10);
                break;
            default:
                input.append(command);
                displayField.setText(input.toString());
                break;
        }
    }

    private void applyFunction(ScientificFunction func)
    {
        try
        {
            double value = Double.parseDouble(input.toString());
            double result = func.apply(value);
            displayField.setText(String.valueOf(result));
            input.setLength(0);
            input.append(result);
        }
        catch (Exception ex)
        {
            displayField.setText("Error");
            input.setLength(0);
        }
    }

    private double calculate(String expression)
    {
        try
        {
            return new ExprEvaluator().evaluate(expression);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Invalid expression");
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            Task7 calculator = new Task7();
            calculator.setVisible(true);
        });
    }

    @FunctionalInterface
    interface ScientificFunction
    {
        double apply(double value);
    }

    class ExprEvaluator
    {
        public double evaluate(String expression)
        {
            expression = expression.replaceAll(" ", "");
            return parseExpression(expression);
        }

        private double parseExpression(String expression)
        {
            if (expression.contains("+"))
            {
                String[] parts = expression.split("\\+");
                return parseExpression(parts[0]) + parseExpression(parts[1]);
            }
            else if (expression.contains("-"))
            {
                String[] parts = expression.split("(?<=\\d)-");
                return parseExpression(parts[0]) - parseExpression(parts[1]);
            }
            else if (expression.contains("*"))
            {
                String[] parts = expression.split("\\*");
                return parseExpression(parts[0]) * parseExpression(parts[1]);
            }
            else if (expression.contains("/"))
            {
                String[] parts = expression.split("/");
                return parseExpression(parts[0]) / parseExpression(parts[1]);
            }
            else if (expression.contains("^"))
            {
                String[] parts = expression.split("\\^");
                return Math.pow(parseExpression(parts[0]), parseExpression(parts[1]));
            }
            return Double.parseDouble(expression);
        }
    }
}