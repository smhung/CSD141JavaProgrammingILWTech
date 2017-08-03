/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7problem3chargeaccountvalidation;

import java.util.Scanner;
/**
 *
 * @author owner
 */
public class Chapter7Problem3ChargeAccountValidation 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] charge_account_bank = {5658845, 4520125, 7895122, 8777541, 
            8451277, 1302850, 8080152, 4562555, 5552012, 5050552, 7825877, 
            1250255, 1005231, 6545231, 3852085, 7576651, 7881200, 4581002};
        int charge_account_input;
        int results;
        
        //Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Solicit user input for 7 digit charge account number.
        System.out.print("What is your 7 digit charge account number? ");
        charge_account_input = keyboard.nextInt();
        
        //Search the array for the value of user input.
        results = sequentialSearch(charge_account_bank, charge_account_input);
        
        //Determine whether user input charge account number was found 
        //and display appropriate message.
        if (results == -1)
            System.out.println("There was no match.");
 
        else
            System.out.println("There was a match!");
        
    }
        
        /**
         * The sequentialSearch method searches an array for a value.
         * @param array The array to search.
         * @param value The value to search for.
         * @return The value if found in the array, otherwise -1.
         */
    
    public static int sequentialSearch(int[] charge_account_bank, 
            int charge_account_input) 
    {
        int index;                        //Loop control variable
        int element;                      //Element the value is found at
        boolean found;                    //Flag indicating search results
        
        //Element 0 is the starting point of the search.
        index = 0;
        
        //Store the default values element and found.
        element = -1;
        found = false;
        
        //Search the array.
        while (!found && index < charge_account_bank.length)
        {
            if (charge_account_bank[index] == charge_account_input)
            {
                found = true;
                element = charge_account_input;
            }
            index++;
        }
        
        return element;
    }
}
   
