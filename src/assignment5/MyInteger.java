package assignment5;

/**
 * The type My integer.
 */
public class MyInteger {
    private int myInt;

    /**
     * Instantiates a new integer.
     *
     * @param value content
     */
    public MyInteger(int value) {
        this.myInt = value;
    }

    /**
     * Get Value as Int
     *
     * @return value as int
     */
    public int toInteger() {
        return myInt;
    }

    /**
     * Is even
     *
     * @param i integer
     * @return true if i is even
     */
    public static boolean isEven(int i) {
        MyInteger integer = new MyInteger(i);
        return integer.isEven();
    }

    /**
     * Is odd
     *
     * @param i integer
     * @return true if i is odd
     */
    public static boolean isOdd(int i) {
        MyInteger integer = new MyInteger(i);
        return integer.isOdd();
    }

    /**
     * Is prime
     *
     * @param i integer
     * @return true if i is prime
     */
    public static boolean isPrime(int i) {
        MyInteger integer = new MyInteger(i);
        return integer.isPrime();
    }

    /**
     * Is even
     *
     * @return true if this is even
     */
    public boolean isEven() {
        int i = this.myInt;
        return ((i % 2) == 0);
    }

    /**
     * Is odd
     *
     * @return true if this is odd
     */
    public boolean isOdd() {
        return !(this.isEven());
    }

    /**
     * Is prime
     *
     * @return true if this is prime
     */
    public boolean isPrime() {
        int i = this.myInt;
        if (i < 2) // If i<=1 it is not prime
            return false;
        int limit = (((int) Math.sqrt((double) i)) + 1);    // Limit of testing,
        // since factor of a pos. int. that is larger than 1
        // would be less than sqrt of it
        int checking = 2; //Since 1 make no sense to check
        while (checking <= limit) {
            if ((i % checking) == 0) // If i can be divided by any number smaller than itself
                return false;
            checking++;
        }
        return true;
    }

    /**
     * Equals
     *
     * @param i integer
     * @return true if i equals this
     */
    public boolean equals(int i) {
        return (i == myInt);
    }

    /**
     * Equals
     *
     * @param i integer
     * @return true if i equals this
     */
    public boolean equals(MyInteger i) {
        return (this.myInt == i.toInteger());
    }

    /**
     * Parse a string to a int
     *
     * @param s a string
     * @return parsed int
     * @throws IllegalArgumentException if the string is not a int
     * @remark a string is not a int if
     * - A string contains non-digit characters (other than '-' as the very first character of the sting).
     * - A string has only '-' and no digits.
     * - A string represents a number that is too large to be stored as integer and produces overflow
     * - A string represents a number that is too small to be stored as integer and produces underflow
     */
    public static int parseInt(String s) throws IllegalArgumentException {
        int pointer = 0;
        boolean negative_flag = false;
        if (s.charAt(0) == '-') {
            negative_flag = true;
            pointer++;
        }
        while (s.charAt(pointer)=='0'){
            pointer++;
        }
        if (s.length() - pointer == 0)
            throw new IllegalArgumentException("blank string");
        int buffer = 0;
        if ((s.length() - pointer)>10){
            throw new IllegalArgumentException("overflow/underflow");
        } else if ((s.length() - pointer)==10){
            switch (s.charAt(pointer)){
                case '1':
                    break;
                case '2':
                    switch (s.charAt(pointer+1)){
                        case '0':
                            break;
                        case '1':
                            switch (s.charAt(pointer+2)){
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                    break;
                                case '4':
                                    switch (s.charAt(pointer+3)){
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                            break;
                                        case '7':
                                            switch (s.charAt(pointer+4)){
                                                case '0':
                                                case '1':
                                                case '2':
                                                case '3':
                                                    break;
                                                case '4':
                                                    switch (s.charAt(pointer+5)){
                                                        case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                            break;
                                                        case '8':
                                                            switch (s.charAt(pointer+6)){
                                                                case '0':
                                                                case '1':
                                                                case '2':
                                                                    break;
                                                                case '3':
                                                                    switch (s.charAt(pointer+7)){
                                                                        case '0':
                                                                        case '1':
                                                                        case '2':
                                                                        case '3':
                                                                        case '4':
                                                                        case '5':
                                                                            break;
                                                                        case '6':
                                                                            switch (s.charAt(pointer+8)){
                                                                                case '0':
                                                                                case '1':
                                                                                case '2':
                                                                                case '3':
                                                                                    break;
                                                                                case '4':
                                                                                    switch (s.charAt(pointer+9)){
                                                                                        case '0':
                                                                                        case '1':
                                                                                        case '2':
                                                                                        case '3':
                                                                                        case '4':
                                                                                        case '5':
                                                                                        case '6':
                                                                                        case '7':
                                                                                            break;
                                                                                        case '8':
                                                                                            if (!negative_flag)
                                                                                                throw new IllegalArgumentException("overflow/underflow");
                                                                                            break;
                                                                                        default:
                                                                                            throw new IllegalArgumentException("overflow/underflow");
                                                                                    }
                                                                                    break;
                                                                                default:
                                                                                    throw new IllegalArgumentException("overflow/underflow");
                                                                            }
                                                                            break;
                                                                        default:
                                                                            throw new IllegalArgumentException("overflow/underflow");
                                                                    }
                                                                    break;
                                                                default:
                                                                    throw new IllegalArgumentException("overflow/underflow");
                                                            }
                                                            break;
                                                        default:
                                                            throw new IllegalArgumentException("overflow/underflow");
                                                    }
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException("overflow/underflow");
                                            }
                                            break;
                                        default:
                                            throw new IllegalArgumentException("overflow/underflow");
                                    }
                                    break;
                                default:
                                    throw new IllegalArgumentException("overflow/underflow");
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("overflow/underflow");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("overflow/underflow");
            }
        }
        while (pointer < s.length()) {
            int nextDigit = -1;
            switch (s.charAt(pointer)) {
                default:
                    throw new IllegalArgumentException("illegal char at position " + pointer);
                    // An list of switch-case without break to tally up value.
                case '9':
                    nextDigit++;
                case '8':
                    nextDigit++;
                case '7':
                    nextDigit++;
                case '6':
                    nextDigit++;
                case '5':
                    nextDigit++;
                case '4':
                    nextDigit++;
                case '3':
                    nextDigit++;
                case '2':
                    nextDigit++;
                case '1':
                    nextDigit++;
                case '0':
                    nextDigit++;
            }
            buffer *= 10; //Shift Existing Digit
            buffer += nextDigit;
            pointer++;
        }
        return (buffer * (negative_flag ? -1 : 1));// Resolve negative value
    }
}















