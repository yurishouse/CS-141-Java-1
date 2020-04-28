package MathTutor;
/* Made by Zhongli Liang */
import java.util.Random;
import java.util.Scanner;

public class MathTutor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static boolean terminating = false; // Control flag

    public static void main(String[] args) {
        while (!terminating) { // Main loop
            printMenu();
            switch (askForIntInput()) { // Inline Choices
                case 1: // Addition problem
                    askAQuedtion('+');
                    break;
                case 2: // Subtraction problem
                    askAQuedtion('-');
                    break;
                case 3: // Quit
                    terminating = true;
                    break;
                default:
                    System.out.println("[ERROR] Choices invalid!");
            }
        }
    }

    private static int askForIntInput() {
        int i = scanner.nextInt();
        scanner.nextLine(); // Take '\n' out of the buffer
        return i;
    }

    private static void printMenu() {
        System.out.println("Math Tutor\n" +
                "1. Addition problem\n" +
                "2. Subtraction problem\n" +
                "3. Quit\n" +
                "Enter your choice (1 – 3):");
    }

    private static void askAQuedtion(char type) {
        // Generate 2 random int in [0-999]
        int a = (int) (random.nextFloat() * 999);
        int b = (int) (random.nextFloat() * 999);
        // Print Question
        System.out.format("%5d%n", a);
        System.out.print(type);
        System.out.format("%4d%n", b);
        System.out.println("-------");
        // Calculate Correct ANS
        int correctAnswer = -1000; // Since -1000 cannot be a valid answer, it is here to indicate an error
        switch (type) { // Calculate correct answer by question type
            case '+':
                correctAnswer = a + b;
                break;
            case '-':
                correctAnswer = a - b;
                break;
        }
        int answerFromUser = askForIntInput();
        if (correctAnswer == answerFromUser) {
            System.out.println("Congratulations, you are correct!");
        } else {
            System.out.println("Your answer is not correct, the correct answer is " + correctAnswer);
        }
    }
}
