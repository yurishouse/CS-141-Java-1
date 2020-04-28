
/**
 *
 * @author Alexandra Vaschillo
 */
public class Asg02_Part01 {

  
    /**
     * Method checks if a triangle with given lengths of sides is a right triangle
     * @param a triangle side
     * @param b triangle side
     * @param c triangle side
     * @return true if the triangle is right, false if it is not
     */
    public static boolean isRightTri(int a, int b, int c)
    {
        int sumA, sumB;  /* init variable sumA and sumB to store the value of 'c*c' and 'a*a+b*b' */
        /* here I compare the three lengths of the triangle, find the longest, give it the power of 2, and add the other two together with each one given the power of two*/
        if (a >= b && a >= c){
            sumA = a * a;
            sumB = b*b + c*c;
        } else if ( b >= a && b >= c ) {
            sumA = b*b;
            sumB = a*a + c*c;
        } else {
            sumA = c*c;
            sumB = a*a + b*b;
        }
        return sumA == sumB;   /* Compare sumA with sumB, if equal, return true, else return false */
    }
    /**
     * The method takes hour, minute, and "am", "pm" components of the time stamp of the moment when car crosses the bridge and calculates the toll rate.
     * If any of the time stamp components are invalid, -1 is being returned as an error code.
     * @param hour hour component of the time stamp 
     * @param min minute component of the time stamp
     * @param amPm either string "am" or "pm", component of the time stamp
     * @return the toll rate  
     */
    public static double toll520Bridge(int hour, int min, String amPm)
    {
        if ( ( hour < 0 || hour > 11 ) || ( min < 0 || min > 59 ) )   /* Check if the hour and minutes are valid, else return -1 */
            return -1;
        if (amPm.equals("am")) {
            /* compare the hour to the given chart, and return the price*/
            if (hour <= 4){
                return 1.25;
            } else if (hour <= 7){
                return 1.40;
            } else if (hour <= 10){
                return 2.05;
            } else {
                return 2.65;
            }
        } else if (amPm.equals("pm")){
            /* compare the hour to the given chart, and return the price*/
            if (hour <= 5){
                return 2.65;
            } else if (hour <= 8) {
                return 2.05;
            } else if (hour <= 10) {
                return 1.40;
            } else {
                return 1.25;
            }

        } else {
            /* if am / pm is not present, return -1 */
            return -1;
        }
    }


    public static void testIsRightTri()
    {
         //*** Test 1 ***//
        if(isRightTri(3, 4, 5)) System.out.println("Test 1 for isRightTri() PASSED");
        else System.out.println("Test 1 for isRightTri() Failed");
   
        //*** Test 2 ***//     
        if(isRightTri(4, 5, 3)) System.out.println("Test 2 for isRightTri() PASSED");
        else System.out.println("Test 2 for isRightTri() Failed");
        
        //*** Test 3 ***//     
        if(isRightTri(5, 4, 3)) System.out.println("Test 3 for isRightTri()) PASSED");
        else System.out.println("Test 3 for isRightTri() Failed");
        
        //*** Test 4 ***//     
        if(isRightTri(3, 5, 4)) System.out.println("Test 4 for isRightTri() PASSED");
        else System.out.println("Test 4 for isRightTri() Failed");
        
        //*** Test 5 ***//     
        if(isRightTri(5, 3, 4)) System.out.println("Test 5 for isRightTri() PASSED");
        else System.out.println("Test 5 for isRightTri() Failed");
        
        //*** Test 6 ***//     
        if(isRightTri(4, 3, 5)) System.out.println("Test 6 for isRightTri() PASSED");
        else System.out.println("Test 6 for isRightTri() Failed");
        
        //*** Test 7 ***//     
        if(!isRightTri(4, 4, 5)) System.out.println("Test 7 for isRightTri() PASSED");
        else System.out.println("Test 7 for isRightTri() Failed");
    }
    
    public static void testToll520Bridge()
    {
        //*** Test 1 ***//  
        if(toll520Bridge(5, 20, "aa")==-1) System.out.println("Test 1 for toll520Bridge() PASSED");
        else System.out.println("Test 1 for toll520Bridge() Failed");
        
        //*** Test 2 ***//  
        if(toll520Bridge(5, 65, "am")==-1) System.out.println("Test 2 for toll520Bridge() PASSED");
        else System.out.println("Test 2 for toll520Bridge() Failed");
        
        //*** Test 3 ***//  
        if(toll520Bridge(15, 15, "am")==-1) System.out.println("Test 3 for toll520Bridge() PASSED");
        else System.out.println("Test 3 for toll520Bridge() Failed");
        
        //*** Test 4 ***//  
        if(toll520Bridge(12, 0, "am")==1.25&&toll520Bridge(4, 59, "am")==1.25&&toll520Bridge(3, 35, "am")==1.25) System.out.println("Test 4 for toll520Bridge() PASSED");
        else System.out.println("Test 4 for toll520Bridge() Failed");
        
        //*** Test 5 ***//  
        if(toll520Bridge(5, 0, "am")==1.4&& toll520Bridge(7, 59, "am")==1.4 && toll520Bridge(6, 03, "am")==1.4) System.out.println("Test 5 for toll520Bridge() PASSED");
        else System.out.println("Test 5 for toll520Bridge() Failed");
        
        //*** Test 6 ***//  
        if(toll520Bridge(8, 0, "am")==2.05 && toll520Bridge(10, 59, "am")==2.05 && toll520Bridge(9, 15, "am")==2.05) System.out.println("Test 6 for toll520Bridge() PASSED");
        else System.out.println("Test 6 for toll520Bridge() Failed");
        
        //*** Test 7 ***//  
        if(toll520Bridge(11, 0, "am")==2.65 && toll520Bridge(4, 59, "pm")==2.65&& toll520Bridge(3, 55, "pm")==2.65) System.out.println("Test 7 for toll520Bridge() PASSED");
        else System.out.println("Test 7 for toll520Bridge() Failed");
        
        //*** Test 8 ***//  
        if(toll520Bridge(6, 0, "pm")==2.05 && toll520Bridge(8, 59, "pm")==2.05 && toll520Bridge(6, 15, "pm")==2.05) System.out.println("Test 8 for toll520Bridge() PASSED");
        else System.out.println("Test 8 for toll520Bridge() Failed");
        
        //*** Test 9 ***//  
        if(toll520Bridge(9, 0, "pm")==1.4 && toll520Bridge(10, 59, "pm")==1.4 && toll520Bridge(9, 3, "pm")==1.4) System.out.println("Test 9 for toll520Bridge() PASSED");
        else System.out.println("Test 9 for toll520Bridge() Failed");
        
        //*** Test 10 ***//  
        if(toll520Bridge(11, 0, "pm")==1.25 && toll520Bridge(11, 59, "pm")==1.25 && toll520Bridge(11, 40, "pm")==1.25) System.out.println("Test 10 for toll520Bridge() PASSED");
        else System.out.println("Test 10 for toll520Bridge() Failed");
    }
    
 
     /** Method main()contains all the tests 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        testIsRightTri();
        testToll520Bridge();
        
    }
    
}
