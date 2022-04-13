package NumericPattern;


import java.util.Scanner;

public class NumericPattern {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Ask for int input with prompt and err handling
     *
     * @param prompt prompt String
     * @return int
     */
    public static int validateInt(String prompt) {
        boolean failed = false;
        int result = 0;
        while (true) {
            failed = false;
            System.out.print(prompt);
            try {
                result = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                failed = true;
            }
            if (!failed)
                break;
        }
        return result;
    }

    /**
     * generate a string of numbers
     *
     * @param size      range, must be greater than 0
     * @param direction boolean, incremental if true
     * @return String of numbers
     * @throws IllegalArgumentException when size <= 0
     * @author Shiina Yuri
     */
    private static String numericPattern(int size, boolean direction) throws IllegalArgumentException {
        if (size < 1)
            throw new IllegalArgumentException();
        StringBuffer sb = new StringBuffer();
        int nextValue = direction ? 1 : size;
        while (true) {
            sb.append(nextValue);
            if (nextValue == (direction ? size : 1))
                break;
            nextValue += direction ? 1 : -1;
        }
        while (true) {
            nextValue += direction ? -1 : 1;
            if (nextValue == (direction ? 0 : (size + 1)))
                break;
            sb.append(nextValue);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Numeric Pattern Display\n" +
                             "\t" + "1. Print Type I pattern (like 12321)\n" +
                             "\t" + "2. Print Type II pattern (like 32123)\n" +
                             "\t" + "3. Quit");
            boolean direction;
            switch (validateInt("Enter your choice (1 - 3):")){
                case 1:
                    direction = true;
                    break;
                case 2:
                    direction = false;
                    break;
                case 3:
                    return;
                default:
                    System.out.println("The choice you entered is invalid!");
                    continue;
            }
            int size = -1;
            while (size<1) {
                size = validateInt("Please enter the size of the pattern. The size must be a positive integer. ");
            }
            System.out.println(numericPattern(size,direction));
        }
    }
}
