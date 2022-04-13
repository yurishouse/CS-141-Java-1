import java.util.Scanner;
/* Made by Shiina Yuri */
public class GreatestAndLeast {
    private static Scanner scanner = new Scanner(System.in);
    private static void sop(Object o){ System.out.print(o);}
    private static void sopln(Object o){ System.out.println(o);}
    public static void main(String[] args) {
        // create three variables for storing the number, the biggest, the smallest.
        int number = -1;
        int biggestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        while (true) {  // while true, continue to ask user for numbers
            sop("Please enter a positive number (enter -99 to exit): ");
            number = scanner.nextInt();
            scanner.nextLine(); // Ignore '\n' in input buffer
            if (number == -99) {  // if -99 then break the loop
                break;
            }
            if (number > biggestNumber){  // if the current number entered is larger than the biggest, replace it.
                biggestNumber = number;
            }
            if (number < smallestNumber){  // if the current number entered is smaller than the biggest, replace it.
                smallestNumber = number;
            }
        }
        if (biggestNumber==Integer.MIN_VALUE){  // if no numbers are entered, give this message.
            sopln("No numbers were entered");
            return;
        }
        // print out the result.
        sopln("");
        sopln("The biggest number you entered is: "+biggestNumber);
        sopln("The smallest number you entered is: " + smallestNumber);
    }
}