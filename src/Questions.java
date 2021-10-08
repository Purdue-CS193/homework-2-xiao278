/*
* CS 193 Homework 3
*
* TODO: READ THESE INSTRUCTIONS!
*
* The comments in the methods are for clarification. No tricks or riddles.
*
* The overall algorithm should not change. Don't focus on improving the runtime. 
*
* Debug in whichever way you feel is best.
*
* IT WILL BE AN AUTOMATIC 0, IF YOU MAKE CHANGES TO TESTCASES.JAVA
*
* Bonus: Understand these methods! They are helpful in interviews :)
* 
*/
import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Questions {

    // Task 1
    public static int findMax(int[] input) {
        // find the max in the input array
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max,input[i]);
        }
        return max;
    }

    // Task 2
    public static int findMin(int[] input) {
        // find the smallest element in the array
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            min = Math.min(min, input[i]);
        }
        return min;
    }

    // Task 3
    public static int findSum(int[] input) {
        // find the sum of all the elements in the array
        int sum = 0;
        for (int j : input) {
            sum = sum + j;
        }
        return sum;
    }

    // Task 4
    public static int findAverage(int[] input) {
        // find the average of the input
        int sum = 0;
        for (int j : input) {
            sum += j;
        }
        return sum / (input.length);
    }

    // Task 5
    public static ArrayList<String> fizzBuzz(int n) {
        // EXPLANATION: RETURN A LIST 1 TO n BUT
        // Multiples OF 3 ARE REPLACED BY "fizz"
        // Multiples OF 5 ARE REPLACED BY "buzz"
        // Multiples OF 3 AND 5 ARE REPLACED BY "fizzbuzz"
        //
        // FROM 1 TO 15 THE LIST WOULD LOOK LIKE
        // {"1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"}
        // Note: In java an array is different from a list
        // The data structure we will be using is an ArrayList

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean replaced = false;
            String buffer = "";
            if (i % 3 == 0) {
                buffer += "fizz";
                replaced = true;
            }
            if (i % 5 == 0) {
                buffer += "buzz";
                replaced = true;
            }
            if (!replaced){
                buffer += i;
            }
            answer.add(buffer);
        }
        return answer;
    }
    
    // Task 6
    public static int reverseNumber(int input) {
        // reverse the number
        // 12345 should become 54321
        // Hint: How would you turn 9 into 95? Not by adding 86
        String temp = input + "";
        String temp2 = "";
        for(int i = temp.length()-1; i >= 0; i--) {
            temp2 += temp.charAt(i);
        }
        return Integer.parseInt(temp2);
    }
    
    //EXTRA CREDIT BELOW HERE
    
    // Task 7
    // Look for a specific element in sorted array
    // keep in mind for this algorithm to work, array HAS to be sorted
    public static int binarySearch(int[] input, int target) {
        return binarySearch(input, target, 0, input.length-1);
    }

    public static int binarySearch(int[] input, int target, int low, int high) {
        // look for the index of target in input
        int mid = (high + low)/2;
        if(input[mid] == target) return mid;
        else if(input.length == 1 && input[0] != target) return -1;
        else if(target > input[mid]) {
            //raise lower
            return binarySearch(input,target,mid + 1,high);
        }
        else {
            return binarySearch(input,target,low,mid - 1);
        }
    }
    
    // Task 8
    public static int countDuplicates(String input) {
        // Count the number of letters that are duplicated
        // The input string will always be lower case and contain no numbers
        // Example: Input: This is homework, Return: 3 (letters i, s, and o occur more than once

        input = input.toLowerCase().replace(" ",""); // ensuring string is lower case
        int[] alphabetTemplate = new int[26];
        for (int i = 0; i < input.length(); i++) {// iterate over the string
            int index = input.charAt(i) - 'a'; // Math in ASCII tables.
            alphabetTemplate[index] ++;
        }
        int counter = 0;
        for (int j : alphabetTemplate) {
            if (j > 1) {
                counter++;
            }
        }
        return counter;
    }

    // Task 9
    public static int sumBetween193(int[] input) {
        // Sum up numbers between the first 193 and the next 193 non-inclusive
        int sum = 0;
        boolean startCounting = false;
        for (int i = 0; i < input.length; i++) {
            if (startCounting) {
                if (input[i] == 193) {
                    startCounting = false;
                    break;
                }
                sum = sum + input[i];
            } else {
                if(input[i] == 193) {
                    startCounting = true;
                }
            }
        }
        return sum;
    }

    // Task 10
    public static boolean findSubstring(String theBigOne, String sub) {
        // checks to see if variable sub appears in theBigOne
        // highly recommended to write this one out on a notebook
        int counter = 0;
        for (int i = 0; i < theBigOne.length() - sub.length() + 1; i++) {
            String str = theBigOne.substring(i, i + sub.length());
            if(str.equals(sub)) return true;
        }
        return false;
    }
    // Main method is used for testing purposes
    public static void main(String[] args) {
        // Example given below
        // Run reverseNumber with your own input
        System.out.println(reverseNumber(1882834));
    }
}
