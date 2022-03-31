package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 */
import java.util.Scanner;

public class Questioner
{
	private Scanner scan;

	/**
	 * this is the constructor for questionare to take input from user
	 */
	public Questioner()
	{
		scan = new Scanner(System.in);

	}

	/**
	 * @param ques the ques is the string of the question we need to ask user
	 * @return this return the user input or answer
	 */
	public String ask(String ques)
	{
		System.out.println(ques);

		return scan.nextLine().trim();
	}
}