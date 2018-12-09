import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an ID number to validate");
        String input = scanner.nextLine();
        Validator validator = new IDChecker();
        String output = "";
        if (validator.validate(input)) {
            output += "valid";
        } else
            output += "invalid";
        System.out.println("ID number: " + input + " is " + output);

    }
}

