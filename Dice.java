package ca.bcit.comp1409.game;

/**
 * @author Jaspreet Sidhu
 * @version 1.1
 */
import java.util.Random;

public class Dice
{

	private Random random;
	public static final int MAX_NUMBER = 6;
	public static final int MIN_NUMBER = 1;
	public static final int SINGLE = 1;

	/**
	 * this is dice constructor
	 */
	public Dice()
	{
		random = new Random();
	}

	/**
	 * @return the random number on dice when it rolled.
	 */
	public int roll()
	{
		int number = random.nextInt(MAX_NUMBER - MIN_NUMBER + SINGLE) + MIN_NUMBER;
		System.out.println("Dice Rolled: " + number);

		return number;
	}

}
