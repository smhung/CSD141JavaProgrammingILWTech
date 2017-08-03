/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7problem19loshumagicsquaremethodfinal;

import java.util.Scanner;
/**
 * This program determines whether the inputted square is 'magic' or not.
 * @author s-shine.hung
 */
public class Chapter7Problem19LoShuMagicSquareMethodFinal 
{
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final int rows = 3;              //Three rows in the square
        final int cols = 3;              //Three columns in the square
        
        int[] magic_array = new int[8];            //Array of 'magic numbers'
        
        //Create an array to hold the contents of the square.
        int[][] magic_square = new int[rows][cols];
        
        //Create Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Display an introduction.
        System.out.println("This program will determined whether "
                + "the inputted square is 'magic' or not. ");
        
        //Display whether this is magic square or not in words.
        boolean check = magic_check(magic_square);
        
        if (check == true)
            System.out.println("This is a Lu Shu Magic Square! ");
        else
            System.out.println("This is not a Lu Shu Magic Square! ");
            
    } 
        /**
         * The magic_check method accepts a 2D array as an argument and determines 
         * whether the array is a magic square.
         * @param magic_square The 2D array accepted as argument.
         */
       
    
        public static boolean magic_check(int[][] magic_square) 
        {
            int[] magic_array = new int[8];            //Array of 'magic numbers'
            final int rows = 3;
            final int cols = 3;
            
            //Create Scanner object for keyboard input.
            Scanner keyboard = new Scanner(System.in);
            
            //Nested loops to fill the 3 by 3 array with integer numbers.
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c < cols; c++)
                {
                System.out.print("Row " + r + ", Column " + c + ": ");
                magic_square[r][c] = keyboard.nextInt();            
                }
            System.out.println();           //Print blank line.
            }
            
            //Nested loops to sum all rows of square.
            for (int r = 0; r < rows; r++)
            {
                 //Sum a row.
                for (int c = 0; c < rows ; c++)
                    magic_array[r] += magic_square[r][c];
                 
                //Display the row's total.
                System.out.println("Total of row " + r + " is " + magic_array[r]);
            }    
        
        
        //Nested loops to sum all columns of square.
        for (int c = 0; c < rows; c++)
        {
            //Sum a column.
            for (int r = 0; r < cols ; r++)
                magic_array[c + cols] += magic_square[r][c];
            
            //Display the columns' total.
            System.out.println("Total of column " + c + " is " + magic_array[c + cols]);
        }
        
        //Sum both diagonals to see if there is magic number.
        //Test one diagonal.
        int r = 0, c = 0;
        for ( r = 0 ; r < rows ; r++)
     
            //Sum a diagonal.
            magic_array[rows + cols] += magic_square[r][r];
             
    
        //Display the diagonal's total.
            System.out.println("Total of one diagonal is " 
                    + magic_array[rows + cols]);
            
        //Test other diagonal.
        for (r = 0 ; r < rows ; r++)
             
                magic_array[rows + cols + 1] += magic_square[r][rows - 1 - r];
            
        //Display second diagonal's total.
        System.out.println("Total of other diagonal is " + magic_array[rows + cols + 1]);
        
        //Test equality amongst all elements of magic_array.
        int i;
        boolean valid_square = true;
        for (i = 1 ; i < magic_array.length ; i++)
        {
            if (magic_array[i] != magic_array[0])
            valid_square = false;
        }
        
       return valid_square;
        }
    }   