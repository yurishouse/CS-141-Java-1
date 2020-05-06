import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
/* Made by Zhongli Liang */
public class RandomsInFile {
    private static Scanner scanner = new Scanner(System.in);

    private static void sop(Object o) {
        System.out.print(o);
    }

    private static void sopln(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        sop("File you want to write to: ");  // ask user for the file name
        String file = scanner.nextLine();
        sop("Lower Limit: ");
        int lowerLim = askForIntegerInput();  // ask user for lower limit
        sop("Upper Limit: ");
        int upperLim = askForIntegerInput();  // ask for upper limit
        // ========================================
        if (lowerLim < 0 || upperLim < 0) {  // if  not positive, trigger warning
            sopln("Lower and Upper limit must be positive!");
            return;
        }
        if (lowerLim > upperLim) {  // if lower is greater than upper, swap them.
            int tmp = lowerLim;
            lowerLim = upperLim;
            upperLim = tmp;
        }

        try {  // catch the exceptions
            File fileObject = new File(file);
            PrintWriter fileWrite = new PrintWriter(fileObject);
            for (int count = 0; count < 100; count++) {
                fileWrite.println(randomIntBetween(lowerLim,upperLim));
            }
            fileWrite.flush();
            fileWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int askForIntegerInput() {  // function used to ask user for input
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                sopln("INPUT ERROR: Input is not an integer!");
            }
        }
    }
    private static final Random random = new Random();  // generate random numbers
    private static int randomIntBetween(int lowerbound, int upperbound) {
        int result;
        int range = upperbound - lowerbound + 1;
        int key = random.nextInt(range);
        result = key + lowerbound;
        return result;
    }
}
