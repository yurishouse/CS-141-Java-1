
import Rectangle;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Arrays {

    /**
     * Determines if array is sorted
     *
     * @param arr the array
     * @return true if array is sorted in ascending order (ignore equal)
     * @throws IllegalArgumentException when arr is Empty
     */
    public static boolean isSorted(int[] arr) throws IllegalArgumentException {
        if (arr.length == 0)
            throw new IllegalArgumentException("arr cannot be empty");
        if (arr.length == 1)
            return true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Merge sorted arrays
     *
     * @param arr1 the array 1
     * @param arr2 the array 2
     * @return merged array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int headRes = 0;
        int head1 = 0;
        int head2 = 0;
        while (headRes < res.length) { //While result array not full
            if (head1 == arr1.length) { // if arr1 is out of elements
                res[headRes] = arr2[head2];
                headRes++;
                head2++;
                continue;
            }
            if (head2 == arr2.length) { // if arr2 is out of elements
                res[headRes] = arr1[head1];
                headRes++;
                head1++;
                continue;
            }
            if (arr1[head1] < arr2[head2]) {
                res[headRes] = arr1[head1];
                headRes++;
                head1++;
            } else {
                res[headRes] = arr2[head2];
                headRes++;
                head2++;
            }
        }
        return res;
    }

    /**
     * All unique elements
     *
     * @param array the array
     * @return true if all element of array is unique
     */
    public static boolean allUniqueElements(int[] array) {
        if (array.length < 1) {
            return false;
        }
        if (array.length < 2) {
            return true;
        }
        for (int index1 = 0; index1 < array.length - 1; index1++) {
            int valueAtIndex1 = array[index1];
            for (int index2 = index1 + 1; index2 < array.length; index2++) {
                int valueAtIndex2 = array[index2];
                if (valueAtIndex1 == valueAtIndex2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Convert 2D array to 1D array
     *
     * @param arr array in
     * @return output
     */
    public static int[] twoDConvert(int[][] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[arr.length * arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                res[i * arr[0].length + j] = arr[i][j];
            }
        }
        return res;
    }

    /**
     * Double squares.
     *
     * @param rectangles the rectangles
     */
    public static void doubleSquares(Rectangle[] rectangles) {
        for (Rectangle rectangle : rectangles) {
            if ((rectangle.getLength() - rectangle.getWidth()) < 0.000000000000001) {
                rectangle.setLength(rectangle.getLength()*2);
                rectangle.setWidth(rectangle.getWidth()*2);
            }
        }
    }

    /**
     * Remove elements in range {from, to}.
     *
     * @param arr  the arr
     * @param from the from
     * @param to   the to
     * @throws IllegalArgumentException if from>to
     */
    public static void removeInRange(ArrayList<Integer> arr, int from, int to) throws IllegalArgumentException {
        if (from > to)
            throw new IllegalArgumentException();
        for (int i = 0; i < arr.size(); i++) {
            Integer integer = arr.get(i);
            if ((integer >= from) && (integer <= to)) {
                arr.remove(i);
                i--;
            }
        }
    }

    /**
     * Repeat element in array list.
     *
     * @param arr   the arr
     * @param k times repeated
     * @throws IllegalArgumentException if k<=0
     */
    public static void repeat(ArrayList<String> arr, int k) throws IllegalArgumentException {
        if (k<=0)
            throw new IllegalArgumentException();
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            for (int count = 1; count < k; count++) {
                arr.add(i,s);
                i++;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int total = 0;
        int expectedTotal = 100;
        PrintStream out = System.out;
        total += testIsSorted(out);
        total += testMergeSortedArrays(out);
        total += testAllUniqueElements(out);
        total += testTwoDConvert(out);
        total += testDoubleSquares(out);
        total += testRemoveInRange(out);
        total += testRepeat(out);

        System.out.printf("\nYou earned %d out of %d points for Assignment 6\n", total, expectedTotal);
    }

    /**
     * Runs all tests for isSorted() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testIsSorted(PrintStream outputStream) {
        int expectedCount = 2;
        int count = 0;
        int pointValue = 10;
        int[] unsorted = {1, 2, 66, 7, 8};
        int[] sorted = {33, 66, 77, 99};
        int[] one = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for isSorted()----\r\n");
        // Test #1
        if (isSorted(sorted) == true && isSorted(unsorted) == false && isSorted(one) == true) {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01", "FAILED");

// Test #2        
        try {
            boolean ignoreMe = isSorted(empty);
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException", "FAILED");
        } catch (IllegalArgumentException e) {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException", "PASSED");
            count++;
        }

        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all tests for mergeSortedArrays()
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testMergeSortedArrays(PrintStream outputStream) {
        int expectedCount = 4;
        int count = 0;
        int pointValue = 20;
        int[] a1 = {2, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 17};
        int[] a3 = {1, 2, 3, 4, 5, 8, 9, 10, 12, 17};
        int[] a4 = {2, 2, 3, 3, 5, 5, 8, 8, 12, 12};
        int[] b1 = {3};
        int[] b2 = {7};
        int[] b3 = {3, 7};
        int[] empty = {};
        System.out.println("\r\n----Tests for mergeSortedArrays()----\r\n");
        // Test #1
        if (equal(mergeSortedArrays(a1, a2), a3)) {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01", "FAILED");

// Test #2 
        if (equal(mergeSortedArrays(a1, a1), a4)) {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02", "FAILED");

// Test #3
        if (equal(mergeSortedArrays(b1, b2), b3)) {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03", "FAILED");

// Test #4
        if (equal(mergeSortedArrays(empty, b2), b2) && equal(mergeSortedArrays(empty, empty), empty)) {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays", "FAILED");

        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all the tests for allUniqueElements() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testAllUniqueElements(PrintStream outputStream) {
        int expectedCount = 4;
        int count = 0;
        int pointValue = 15;
        int[] a1 = {2, 16, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 9, 17};
        int[] a3 = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for allUniqueElements()----\r\n");
        // Test #1
        if (allUniqueElements(a1)) {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01", "FAILED");

// Test #2 
        if (allUniqueElements(a2) == false) {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02", "FAILED");

// Test #3
        if (allUniqueElements(a3)) {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03", "FAILED");

// Test #4
        if (allUniqueElements(empty) == false) {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array", "FAILED");

        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all the tests for twoDConvert() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testTwoDConvert(PrintStream outputStream) {
        int expectedCount = 3;
        int count = 0;
        int pointValue = 15;
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] aConverted = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[][] c = {{1},
                {4},
                {7}};
        int[] cConverted = {1, 4, 7};
        int[][] b = {};
        int[] empty = {};
        System.out.println("\r\n----Tests for twoDConvert()----\r\n");
// Test #1 
        if (equal(twoDConvert(a), aConverted)) {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01", "FAILED");
// Test #2 
        if (equal(twoDConvert(c), cConverted)) {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02", "FAILED");
// Test #3 
        if (equal(twoDConvert(b), empty)) {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array", "FAILED");
        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all the tests for doubleSquares() method
     *
     * @param outputStream
     * @return
     */
    public static int testDoubleSquares(PrintStream outputStream) {
        int expectedCount = 2;
        int count = 0;
        int pointValue = 15;
        int size = 10;
        Rectangle[] shapes1 = new Rectangle[size];
        for (int i = 0; i < shapes1.length; i++) {
            if (i % 3 == 0 && i != 0) shapes1[i] = new Rectangle(i + 1, i + 1); // building a square
            else shapes1[i] = new Rectangle(i + 2, i + 1); // building a regular rectangle
        }
        Rectangle[] shapes2 = new Rectangle[0];
        System.out.println("\r\n----Tests for doubleSquares()----\r\n");
        // Test #1
        doubleSquares(shapes1);
        boolean passed = true;
        for (int i = 0; (i < shapes1.length) && passed; i++) {
            if (i % 3 == 0 && i != 0) {
                if (shapes1[i].getLength() != (i + 1) * 2 || shapes1[i].getWidth() != (i + 1) * 2) {
                    passed = false;
                }
            } else {
                if (shapes1[i].getLength() != i + 2 || shapes1[i].getWidth() != i + 1) {
                    passed = false;
                }
            }
        }
        if (passed) {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01", "FAILED");
        // Test #2
        doubleSquares(shapes2);
        if (shapes2.length == 0) {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array", "FAILED");
        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all the tests for removeInRange() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testRemoveInRange(PrintStream outputStream) {
        int expectedCount = 5;
        int count = 0;
        int pointValue = 10;

        int[] tmp = {8, 6, 1, 4, 25, 1, 3, 7, 6, 8, 77, 3, 16};
        int[] test01 = {25, 77, 16};
        ArrayList<Integer> listA = new ArrayList();
        ArrayList<Integer> listB = new ArrayList();
        ArrayList<Integer> listTest01 = new ArrayList();
        ArrayList<Integer> listTest04 = new ArrayList();
        for (int i = 0; i < tmp.length; i++) {
            listA.add(tmp[i]);
            listB.add(tmp[i]);
        }
        for (int i = 0; i < test01.length; i++) {
            listTest01.add(test01[i]);
            listTest04.add(test01[i]);
        }
        listTest04.remove(0);
        System.out.println("\r\n----Tests for removeInRange()----\r\n");
// Test #1
        removeInRange(listA, 0, 10);
        if (listA.equals(listTest01)) {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01", "FAILED");
// Test #2
        removeInRange(listB, -1, 100);
        if (listB.isEmpty()) {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02", "FAILED");
// Test #3
        removeInRange(listB, -1, 100);
        if (listB.isEmpty()) {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list", "FAILED");
        // Test #4
        removeInRange(listA, 25, 25);
        if (listA.equals(listTest04)) {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04", "FAILED");

        try {
            removeInRange(listA, 2, 1);
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception", "FAILED");
        } catch (IllegalArgumentException e) {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception", "PASSED");
            count++;
        }
        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Runs all the tests for repeat() method
     *
     * @param outputStream - output stream, used to print into the screen
     * @return number of points the problem is worth if all the tests ran successfully. If any of the tests failed the method returns a 0.
     */
    public static int testRepeat(PrintStream outputStream) {
        int expectedCount = 3;
        int count = 0;
        int pointValue = 15;

        ArrayList<String> listA = new ArrayList();
        listA.add("How");
        listA.add("are");
        listA.add("you?");

        ArrayList<String> listB = new ArrayList();
        String[] tmp = {"How", "How", "How", "are", "are", "are", "you?", "you?", "you?"};
        for (int i = 0; i < tmp.length; i++) {
            listB.add(tmp[i]);
        }
        System.out.println("\r\n----Tests for repeat()----\r\n");
// Test #1
        repeat(listA, 3);

        if (listA.equals(listB)) {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01", "FAILED");

// Test #2
        repeat(listA, 1);

        if (listA.equals(listB)) {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02", "PASSED");
            count++;
        } else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02", "FAILED");
        // Test #3
        try {
            repeat(listA, 0);
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception", "FAILED");
        } catch (IllegalArgumentException e) {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception", "PASSED");
            count++;
        }

        if (count == expectedCount) return pointValue;
        else return 0;
    }

    /**
     * Compares two arrays of integers
     *
     * @param one first array to compare
     * @param two second array to compare
     * @return returns true if arrays are the same, false if not
     */
    public static boolean equal(int[] one, int[] two) {
        if (one.length != two.length) return false;
        for (int i = 0; i < one.length; i++) {
            if (one[i] != two[i]) return false;
        }
        return true;
    }

    /**
     * Outputs into the screen an array of integers
     *
     * @param a an array to print out
     */
    public static void printArray(int[] a) {
        if (a.length == 0) {
            System.out.println("[ ]");
            return;
        }
        System.out.print("[");
        int i;
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[i] + "]\n");
    }


}
