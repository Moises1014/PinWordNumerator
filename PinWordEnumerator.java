/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pinwordenumerator;
import java.util.Scanner;

/**
 * Title: Assignment 8- PinWordEnumerator.java 
 * Semester: COP3337 – Summer 2019
 *
 * @author Moises Feliz
 *
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 *
 * This program takes the number sequence the user gives and shows the word 
 * combination that it could be. Its does this by getting the user's number
 * sequence then it checks the array to check which letters each number could
 * be. Then it gives back all the possible sequence of letters by the numbers
 * given, it does this in the for loop.
 * 
 */


/**
 * Converts a numeric pin to an equivalent word using the digit to letter
 * mapping on a standard telephone keypad.
 */
public class PinWordEnumerator {

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a pin number: ");
        String num = in.nextLine();
        System.out.println();//for a line of space
        System.out.printf("All possible spellings are:%n", num);
        enumerateWords(num);
    }

    /**
     *
     * method to return a character array containing all possible keypad
     * encodings for a digit in a standard phone
     *
     */
    static char[] Keysforbuttonsnumbers(int n) 
    {
        switch (n) 
        {
            case 0:
                return new char[]{' '}; //returning only space
            case 1:
                return new char[]{'.'}; //returning only dot
            case 2:
                //button 2 contains A, B and C keys
                return new char[]{'A', 'B', 'C'};
            case 3:
                return new char[]{'D', 'E', 'F'};
            case 4:
                return new char[]{'G', 'H', 'I'};
            case 5:
                return new char[]{'J', 'K', 'L'};
            case 6:
                return new char[]{'M', 'N', 'O'};
            case 7:
                return new char[]{'P', 'Q', 'R', 'S'};
            case 8:
                return new char[]{'T', 'U', 'V'};
            case 9:
                return new char[]{'W', 'X', 'Y', 'Z'};
        }
        return null;
    }

    /**
     * A wrapper for a recursive method that enumerates all the phone keypad
     * encodings for a number.
     *
     * @param num a string representing the number
     */
    public static void enumerateWords(String num)
    {
          if (num != null)                                 
              enumerateWords(num, "");
    }
    

    /**
     * the method which performs the recursion, it uses current number and 
     * the strings from the case
     * 
     * @param num, text
     */
    static void enumerateWords(String num, String text)
    {
        if (num.length() == 0) 
        {
            // base case, displaying the text
            System.out.println(text);
        } else 
        {
            // finding the digit at the position
            int digit = num.charAt(0) - '0';
            // finding possible phone keys for this digit
            char letters[] = Keysforbuttonsnumbers(digit);
            if (letters != null) 
            {
                // looping through all possible keys
                for (int i = 0; i < letters.length; i++) 
                {
                    enumerateWords(num.substring(1), text + letters[i]);
                }
            }
        }
    }
}
