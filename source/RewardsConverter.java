import java.util.Scanner;

public class RewardsConverter 
{
    public static void main(String[] args) 
    {
        // Creating a Scanner object to read input from the user.
        var scanner = new Scanner(System.in);

        System.out.println("Welcome to the Credit Card Rewards Converter!");

        // Prompting the user to enter a cash value that they want to convert to airline miles.
        System.out.println("Please enter a cash value to convert to airline miles: ");
        
        // Reading the user's input as a string.
        var input_value = scanner.nextLine();

        double cashValue;
        try 
        {
            // converting the user's input from a string to a double.
            cashValue = Double.parseDouble(input_value);
        } 
        catch (NumberFormatException exception) 
        {
            // If the input cannot be converted to a double, print an error message and exit.
            System.out.println("Could not parse input value as a double, exiting");
            return;  // Exit the program early because of the error.
        }

        // Print a message indicating that the conversion is happening.
        System.out.println("Converting $" + input_value + " to miles");
        
        // Create a RewardValue object using the cash value entered by the user.
        var rewardsValue = new RewardValue(cashValue);

        // Print out the converted value in miles.
        System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
    }
}

class RewardValue 
{
    private double cashValue;
    private double milesValue;
    private static final double MILES_TO_CASH_CONVERSION_RATE = 0.0035;

    // Constructor that accepts a cash value
    public RewardValue(double cashValue) {
        this.cashValue = cashValue;
        this.milesValue = cashValue / MILES_TO_CASH_CONVERSION_RATE;
    }

    // Constructor that accepts a miles value
    public RewardValue(double milesValue, boolean isMiles) {
        this.milesValue = milesValue;
        this.cashValue = milesValue * MILES_TO_CASH_CONVERSION_RATE;
    }

    // Method to get the cash value
    public double getCashValue() {
        return cashValue;
    }

    // Method to get the miles value
    public double getMilesValue() {
        return milesValue;
    }
}
