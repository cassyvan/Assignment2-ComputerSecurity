import java.util.Scanner;

public class PasswordGenerator {

    private int passLength;
    private Scanner scanner = new Scanner(System.in);
    private String password;

    private boolean checkLength(int length) {
        return length >= 5;
    }

    private void determinePassLength() {
        System.out
                .println("Hello! How long would you like password length to be? It must be at least 5 characters long");
        int userInputLength = Integer.parseInt(scanner.nextLine());
        if (!checkLength(userInputLength)) {
            System.out.println("Length of password must be greater than 5 characters. Please try again");
            System.exit(1);
        }
        passLength = userInputLength;
    }

    private void printPassRules() {
        System.out.println("At least one lowercase character");
        System.out.println("At least one uppercase character");
        System.out.println("A number");
        System.out.println("A special character such as !@#$%^&*()");
        System.out.println("No spaces");
        System.out.println("Must be a length of " + passLength + " characters");
    }

    private void generatePassword() {
        System.out.println("Please enter in a password: ");
        System.out.println("Password must contain the following:");
        printPassRules();
        String userPassword = scanner.nextLine();
        if (!checkPasswordCriteria(userPassword)) {
            System.out.println("Your password does not meet the following criteria:");
            printPassRules();
            System.out.println("Please try again.");
            System.exit(1);
        }
        password = userPassword;
        System.out.println("Congratulations. Here is your new password: " + password);
    }

    private boolean checkPasswordCriteria(String password) {
        Boolean hasUpperCase = false;
        Boolean hasLowerCase = false;
        Boolean hasNumber = false;
        Boolean hasSpecialCharacter = false;
        Boolean hasNoSpaces = false;
        if (password.length() != passLength) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                hasSpecialCharacter = true;
            }
            if (!Character.isWhitespace(ch)) {
                hasNoSpaces = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter && hasNoSpaces;
    }

    public void run() {
        determinePassLength();
        generatePassword();
    }
}
