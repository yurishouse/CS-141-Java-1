/*
 * This program illustrates file I/O with exception handling component.
 
 */
package fileio;

import java.util.Scanner;   // Needed for Scanner class
import java.io.*;           // Needed for File I/O classes

/**
 *
 * @author Alexandra Vaschillo
 */

public class FileIO {
  
    public static void main(String[] args) {
      String outFileName;      // Input File name
      int numTimes = 10;       // Number of times to repeat

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      
      // Get the filename from the user
      System.out.print("Enter the filename to write into: ");
      outFileName = keyboard.nextLine();
      
      // Checking if the file already exists.
      File file = new File(outFileName);
      if (file.exists())
      {
         System.out.println("The file " + outFileName +
                            " already exists. Will re-write its content");
      }

      try{ // handling exceptions if they arise
          // Open the file.
          PrintWriter outputFile = new PrintWriter(file);

          // Write some data to the file
          for (int i = 0; i < numTimes; i++)
          {
             // Write some string into the file
             outputFile.println("Blah-blah-blah");
          }

          // Close the file.
          outputFile.close();
          System.out.println("Data written to the file.");
      }
      catch (IOException e)
      {
         System.out.printf("ERROR writing to file %s!",outFileName); 
         System.out.printf("ERROR Message: %s!\n",e.getMessage());
      }
       
      try  // File manipulations may cause IOExceptions , we would like to handle them
      {
        int numLines = 0; // to store the number of lines in file
        file = new File(outFileName);
        // We can check if the file with the this name exists OR we can let the Exception to be thrown and caught in case the file does not exist
   /*     if (!file.exists()) // if file does not exist - output error message
        {
            System.out.printf("The file %s does not exist!\n",outFileName );
 
        }
     */   
        Scanner inFile = new Scanner(file);
        while (inFile.hasNext())
        {
           String tmp = inFile.nextLine();
           System.out.printf("%s\n", tmp);
           numLines++;
        }
        inFile.close();
        
    
        System.out.printf("Finished printing file \"%s\".\nThe file has %d lines total.",outFileName, numLines); 
      }
      catch(IOException e)
      {
          System.out.printf("ERROR reading from file %s!\n",outFileName);
          System.out.printf("ERROR Message: %s!\n",e.getMessage());
          System.exit(0);
      }
                  
   }
}
 
    
    
   
