/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7problem8gradebookfinal;

import java.util.Scanner;                        //Needed for Scanner class
/**
 * This program stores in a StringArray names of five students and in two 2D 
 * arrays grades on each of four exams per student and numeric scores on each 
 * of four exams per student.  The user inputs name and numeric score for each 
 * of four exams and methods return a specific student's name, average test 
 * score,, and a letter grade based on the average.
 * @author s-shine.hung
 */
public class Chapter7Problem8GradeBookFinal 
{
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final int number_of_students = 5;             //total number of students
        final int number_of_tests = 4;                //total num tests per student
        int test_number = 0;                          //number of test (1-4)
        int student_number = 0;                       //number of student (1-5)
        int request_number = 0;                       //student number for info request
        
        //Create an array to hold student names.
        String[] names = new String[number_of_students];
        
        //Create Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Create a 2D array to hold four numeric test scores for each of five students.
        int[][] scores = new int[number_of_students][number_of_tests];
        
        //Create a 2D array to hold four letter test scores for each of five students.
        String[][] test_letter_grades = new String[number_of_students][number_of_tests];
        
        //Display an introduction.
        System.out.println("This program will calculate the test average and "
                + "final letter grade of each of five students.");
        System.out.println("Please enter the name of student "
                + "and the four associated numeric test scores below: ");
        
        //Nested loops to input (five times) student name 
        //and four associated test scores for each student.
        for (student_number = 0; student_number < number_of_students; student_number++)
        {
            System.out.println("What is the name of student " + (student_number + 1) + " ?");
            names[student_number] = keyboard.nextLine();
        }
         
        for (student_number = 0; student_number < number_of_students; student_number++)
        {
           for (test_number = 0; test_number < number_of_tests; test_number++)
           {
               System.out.printf("Student %d, Test %d: ", (student_number + 1), (test_number + 1));
               scores[student_number][test_number] = keyboard.nextInt();
               
           }
           System.out.println();                       //Print blank line.
        }
        
        //Convert to grades for each of four tests for user/student.
        //Nested loops to convert all elements of scores array to letter grades.
        for (student_number = 0; student_number < number_of_students; student_number++)
        {
            for (test_number = 0; test_number < number_of_tests; test_number++)
            {
                if (scores[student_number][test_number] >= 90)
                {
                    
                    test_letter_grades[student_number][test_number] = String.valueOf('A');
                    
                }
                    
                else if (scores[student_number][test_number] >= 80)
                    test_letter_grades[student_number][test_number] = String.valueOf('B');
                else if (scores[student_number][test_number] >= 70)
                    test_letter_grades[student_number][test_number] = String.valueOf('C');
                else if (scores[student_number][test_number] >= 60)
                    test_letter_grades[student_number][test_number] = String.valueOf('D');
                else
                    test_letter_grades[student_number][test_number] = String.valueOf('F');
            }
        }
        
        
        //Return specific student's name, average test score, and letter grade based
        //on average test score.
        
        //Ask which student number name is requested for
        System.out.println("For which student (enter a number 1 - 5) "
                + "is the information requested? ");
        request_number = keyboard.nextInt();
        request_number--;
        
        //Return specific student's name.
        System.out.println("Student " + (request_number + 1) + ": " +
                 Return_info(request_number, names));
        System.out.println(Return_analysis(request_number, scores));
                 
        
    }
        /**
         * This method return_info returns a specific student's name.
         * @param request_number number of student information is requested for
         * @param names String array of names to be recalled
         * @return names name of requested student number
         */
        
        //First method returns student name.
        public static String Return_info(int request_number, String[] names)
        {
            return names[request_number];
        }
        
        /**
         * Second method Return_analysis returns numerical test score average
         * and final letter grade.
         * @param request_number
         * @return average, final_letter_grade 
         */
        public static String Return_analysis(int request_number, int[][] scores)
        {
            final int number_of_students = 5;
            final int number_of_tests = 4;
            int average = 0;                           //Average of four test scores
            String final_letter_grade;
            String results;
            
            //Calculate average of four numerical scores.
            
            average = (scores[request_number][0] + scores[request_number][1] 
                + scores[request_number][2] + scores[request_number][3])/(number_of_tests);
            
               
            
            //Convert average to letter grade.
            if (average >= 90)
                final_letter_grade = String.valueOf('A');
            else if (average >= 80)
                final_letter_grade = String.valueOf('B');
            else if (average >= 70)
                final_letter_grade = String.valueOf('C');
            else if (average >= 60)
                final_letter_grade = String.valueOf('D');
            else
                final_letter_grade = String.valueOf('F');
            
            //Return average numeric score and final letter grade.
            results = "Your average test score is " + average + " and your final "
                    + "letter grade is " + final_letter_grade;
            return results;
        }
}
 