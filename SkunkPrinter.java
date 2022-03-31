package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 */
public class SkunkPrinter
{

	private static final int MAX_WIDTH = 6;
	public static final int ONE = 1;
	public static final int TWO = 2;

	/**
	 * this method prints the cell on the console
	 * 
	 * @param o the object
	 */
	public void printCell(Object o)
	{
		int spaceCount = MAX_WIDTH - ONE - o.toString().length();

		String spaces = "";
		for (int i = 0; i < spaceCount / TWO; i++)
		{
			spaces += " ";
		}

		String output = "|" + spaces + o.toString() + spaces;

		if (spaceCount % TWO == ONE)
		{
			output += " ";
		}

		System.out.print(output);
	}

	/**
	 * this method print each line
	 * 
	 * @param cols the number of columns
	 */
	public void printLine(int cols)
	{
		String line = "|";
		while (cols-- > 0)
		{
			for (int i = 0; i < MAX_WIDTH; i++)
			{
				line += "-";
			}
		}

		line = line.substring(0, line.length() - ONE);

		System.out.print(line);
	}

	/**
	 * this method print | to for new line
	 */
	public void newLine()
	{
		System.out.println("|");
	}

}
