/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7problem6driverslicenseexam;

import java.util.Scanner;

/**
 * This program takes twenty answers as input and outputs analysis of performance 
 * in four methods: whether student passed or not, total correct, total incorrect,
 * and the individual question numbers of questions missed.
 * @author s-shine.hung
 */
public class Chapter7Problem6DriversLicenseExam 
{

    
    public static void main(String[] args) 
    {
        final int number_of_questions = 20;      //Number of elements
        
        //Create an array to hold the answer bank.
        char[] answer_bank = new char[number_of_questions];
                
               answer_bank[0] = 'B';
               answer_bank[1] = 'D';
               answer_bank[2] = 'A';
               answer_bank[3] = 'A';
               answer_bank[4] = 'C';
               answer_bank[5] = 'A';
               answer_bank[6] = 'B';
               answer_bank[7] = 'A';
               answer_bank[8] = 'C';
               answer_bank[9] = 'D';
               answer_bank[10] = 'B';
               answer_bank[11] = 'C';
               answer_bank[12] = 'D';
               answer_bank[13] = 'A';       
               answer_bank[14] = 'D';
               answer_bank[15] = 'C';
               answer_bank[16] = 'C';
               answer_bank[17] = 'B';
               answer_bank[18] = 'D';
               answer_bank[19] = 'A';
               
        //Create an array to hold user input for twenty multiple choice questions.
        char[] answers = new char[number_of_questions];
        
        //Get the user's answers.
        answers = getAnswers(answers);
        
        //Match user answers with answer bank to return whether the user passed or not.
        System.out.println(passed(answers, answer_bank));
        
        //Returns total number of correctly answered questions.
        System.out.println(totalCorrect(answers, answer_bank));
        
        //Returns the total number of incoorectly answered questions.
        System.out.println(totalIncorrect(answers, answer_bank));
        
        //Returns an int array containing the question numbers of questions missed.
        int[] missed_questions = questionsMissed(answers, answer_bank);
        
        for (int index = 0; index < missed_questions.length; index++)
         
            System.out.print("You missed Q " + missed_questions[index] + ";\n");
                       
    }
    /**
     * The getAnswers method asks the user to enter answers for each element of
     * an array.
     * @param answers The array to store the values in.
     */
    
    private static char[] getAnswers(char[] answers)
    {
        char input;                   //To hold user input.
        final int number_of_questions = 20;
        
        //Create Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Get answer for each question of twenty question quiz.
        for (int i = 0; i < number_of_questions; i++)
        {
            System.out.println("Enter your answer (upper case letter)"
                    + " for Question " + (i + 1) + ":");
            input = keyboard.next().charAt(0);
            answers[i] = input;
        }
        return answers;
    }
    
    /**
     * The passed method returns true if the student passed the exam, 
     * or false if the student failed.
     * 
     */
    
    private static String passed(char[] answers, char[] answer_bank)
    {
        int index = 0;                       //Counter for loop
        int number_correct = 0;              
        final int number_of_questions = 20;
       
               
        //Determine whether the elements contain at least 15 of the same data.
        while (index < answers.length)
        {
            if (answer_bank[index] == answers[index])
                number_correct++;
            index++;
        }
        
        if (number_correct >= 15)
            return "You passed! ";
        else 
            return "You failed! ";
       
    }
    
    /**
     * The totalCorrect method returns the total number of correctly 
     * answered questions.
     * 
     */
    
    private static String totalCorrect(char[] answers, char[] answer_bank)
    {
        int index = 0;                       //Counter for indexing array
        int number_incorrect = 0;
        final int number_of_questions = 20;
        
               
        //Determine whether the elements contain at least 15 of the same data.
        while (index < answers.length)
        {
            if (answer_bank[index] != answers[index])
                number_incorrect++;
            index++;
        }
        
          
        return "You answered " + (number_of_questions - number_incorrect) + 
                   " questions correctly.";
         
    }
    
    /**
     * The passed method returns true if the student passed the exam, 
     * or false if the student failed.
     * 
     */
    
    private static String totalIncorrect(char[] answers, char[] answer_bank)
    {
        int index = 0;                       //Counter for indexing through questions
        int number_incorrect = 0;
        final int number_of_questions = 20;
        
               
        //Determine whether the elements contain at least 15 of the same data.
        while (index < answers.length)
        {
            if (answer_bank[index] != answers[index])
                number_incorrect++;
            index++;
        }
        
         
        return "You answered " + number_incorrect + " questions incorrectly. ";
         
    }
    /**
     * The questionsMissed method returns the numbers of the questions that 
     * the user missed on the exam.
     * 
     */
    
    private static int[] questionsMissed(char[] answers, char[] answer_bank)
    {
        int index;                                  //Loop control variable
        int[] elements = new int[14];               //Element match is found at
        int number_of_Q_missed = 0;
        boolean incorrect;                          //Flag indicating matching results
        final int number_of_questions = 20;
        
               
        //Element 0 or Question 1 is the starting point of the search
        index = 0;
        
        //Store the default values element and matched.
        incorrect = true;
        
        //Match the arrays and return question numbers of missed questions.
        for (index = 0; index < number_of_questions; index++) 
        {
            if (answers[index] != answer_bank[index])
            {
                number_of_Q_missed++;
            }
        }
        
        int[] questions_missed = new int[number_of_Q_missed];
        int index_qm = 0;
        
        for (index = 0; index < number_of_questions; index++) 
        {
            if (answers[index] != answer_bank[index])
            {
                questions_missed[index_qm] = index + 1;
                index_qm++;
            }
            
        }
        //return an array called questions_missed
        return questions_missed;
    }
    
}
  