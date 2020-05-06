/*
   This program illustrates input validation techniques with the use of Exception mechanism
*/
package inputvalidation;
/**
 *
 * @author Alexandra Vaschillo
 */
import java.util.Scanner;  // Needed for the Scanner class


public class InputValidation
{
   public static void main(String[] args)
   {
      String str;   // To hold the user's name
      int a = 0;       // To hold the user's age
      double num = 0; // To hold the user's income
      
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the user's input.
      boolean again = true;
      while(again) // input validation loop
      {
        System.out.print("Enter an integer number please:> ");
        str = keyboard.nextLine(); // get a string containing an int number
        str = str.trim(); // remove any extra whitespace from string sides
        try    // trying to convert string to integer, expecting exceptions
        {
          a  = Integer.parseInt(str);  // convertion. 
          // At this point exception may happen. 
          // Exception will throw execution into the "catch" block right away
          //If convertion went well, execution coninues to the next statement below
          again =  false; // stop input validation loop
          // continue with the program
        }
        catch (Exception e) // handle the exception below
        {
          System.out.println("INPUT ERROR: Please enter an integer number!!"); 
          System.out.println(e.getMessage());
        }
      } // end of validation loop
           // Get the user's input.
      again = true;
      while(again) // input validation loop
      {
        System.out.print("Enter a floating point number please:> ");
        str = keyboard.nextLine(); // get a string containing a double number
        str = str.trim(); // remove any extra whitespace from sides
        try    // trying to convert string to double, expecting exceptions
        {
          num  = Double.parseDouble(str);  // convertion. 
          // At this point exception may happen. 
          // Exception will throw execution into the "catch" block right away
          //If convertion went well, execution coninues to the next statements below
          again =  false; // stop input validation loop
          // continue with the program
        }
        catch (Exception e) // handle the exception below
        {
          System.out.println("INPUT ERROR: Please enter a floating point number!!"); 
          System.out.println(e.getMessage());
        }
      } // end of validation loop
      
      // User input ready for use
     System.out.printf("\nThe integer number you entered is: %d", a);
     System.out.printf("\nThe floating point number you entered is: %f\n",num);
     
   }
}


