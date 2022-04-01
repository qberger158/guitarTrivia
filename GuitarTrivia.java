/* 
   Author: Quentin Bergeron
   File: GuitarTrivia.java
   Date started: July 2021
   Description: this code will create a multiple choice quiz. The questions are based on different guitar facts.
   The quiz gives the user a percentage score of how many questions they answered
   correctly.
*/

import javax.swing.JOptionPane;

public class GuitarTrivia {
	
	private static boolean checkAnswer(String lower)
	{
      lower = lower.toLowerCase();
		if(lower.equals("a") || lower.equals("b") || lower.equals("c") || lower.equals("d"))
		{
			return true;
		} 
		else
		{
			JOptionPane.showMessageDialog(null, "Please choose option A, B, C or D");
			return false;
		}
	}
	
	private static String showQuestion(String[] question) 
	{
		String question_number = "";
		String answer = "";
		
		for(int i = 0; i < question.length; i++)
			question_number += question[i] + "\n";
			
		do 
		{
			answer = JOptionPane.showInputDialog(null, question_number);
			if(answer == null)
			{
				int exit = JOptionPane.showConfirmDialog(null, "Do you wish to stop now and leave the quiz?", "Stop and Exit", JOptionPane.YES_NO_OPTION);
				if(exit == 0)
					return "Exit";
				else
					continue;
			}
		} while (answer == null || !(checkAnswer(answer)));
		
		return answer;
	}
	
	private static boolean isCorrect(String correctAnswer, String userAnswer) 
	{
		userAnswer = userAnswer.toUpperCase();
		if(correctAnswer.equals(userAnswer)) 
		{
			JOptionPane.showMessageDialog(null, "Fantastic! That is the correct answer! \u263A");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry, this is not the correct answer \u2639: \n" + correctAnswer);
			return false;
		}
	}
	
	public static void displayScore(int correctSum, int incorrectSum)
	{
		int totalQuestions = correctSum + incorrectSum;
		String showScore = "";
		int questionValue = 100 / totalQuestions;
		int score = correctSum * questionValue;
		
		showScore += "You answered " + correctSum + " correctly and " + incorrectSum + " incorrectly";
		showScore += "\nYour score is: " + score + "%";
		
		JOptionPane.showMessageDialog(null, showScore);
	}

	public static void main(String[] args)
	{
		int incorrectSum = 0; 
		int correctAnswer = 0; 
		int wrong = 0; 
		String response = ""; 
		
		String[][] questionChoice = new String[5][5]; 
		String[] correctChoice = new String[5]; 
		
		questionChoice[0][0] = "What year was the Fender Stratocaster introduced?";
		questionChoice[0][1] = "A) 1941";
		questionChoice[0][2] = "B) 1954";
		questionChoice[0][3] = "C) 1967";
        questionChoice[0][4] = "D) 1952";
		correctChoice[0] = "B";
		
		questionChoice[1][0] = "What year was the Gibson ES-335 invented?";
		questionChoice[1][1] = "A) 1939";
		questionChoice[1][2] = "B) 1966";
		questionChoice[1][3] = "C) 1958";
        questionChoice[1][4] = "D) 1972";
		correctChoice[1] = "C";
		
		questionChoice[2][0] = "What guitar did George Harrison use during The Beatles' rooftop concert?";
		questionChoice[2][1] = "A) 1968 Fender Custom Rosewood Telecaster";
		questionChoice[2][2] = "B) 1962 Rickenbacker 425";
		questionChoice[2][3] = "C) 1957 Gretsch Duo Jet";
        questionChoice[2][4] = "D) 1957 Gibson Les Paul Standard";
		correctChoice[2] = "A";
		
		questionChoice[3][0] = "Duane Allman played this guitar during the recording of Layla by Derek and the Dominos:";
		questionChoice[3][1] = "A) 1964 Fender Jaguar";
		questionChoice[3][2] = "B) 1954 Gibson Les Paul Junior Sunburst";
		questionChoice[3][3] = "C) 1957 Gibson Les Paul Goldtop";
        questionChoice[3][4] = "D) 1963 Gibson Firebird";
		correctChoice[3] = "C";
		
		questionChoice[4][0] = "What year did C.F. Martin begin the production of Martin Guitars?";
		questionChoice[4][1] = "A) 1927";
		questionChoice[4][2] = "B) 1897";
		questionChoice[4][3] = "C) 1948";
        questionChoice[4][4] = "D) 1833";
		correctChoice[4] = "D";
		
		do 
		{
			response = showQuestion(questionChoice[incorrectSum]);
			if(response.equals("Exit"))
				return;
			if(isCorrect(correctChoice[incorrectSum], response))
				correctAnswer += 1;
			else
				wrong += 1;
			
			incorrectSum++;
		} while(incorrectSum < questionChoice.length);
		
		displayScore(correctAnswer, wrong);
	}
}