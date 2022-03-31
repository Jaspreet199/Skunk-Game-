package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 */
public class SkunkBoard
{

	private SkunkColumn[] columns;
	private int currentColumnIndex;
	public static final int NUM_OF_COL = 5;
	public static final int ONE = 1;

	private SkunkPrinter printer;

	/**
	 * this constructor populates the array of the board columns
	 */
	public SkunkBoard()
	{
		printer = new SkunkPrinter();
		currentColumnIndex = 0;
		columns = new SkunkColumn[NUM_OF_COL];

		columns[0] = new SkunkColumn("S");
		columns[1] = new SkunkColumn("K");
		columns[2] = new SkunkColumn("U");
		columns[3] = new SkunkColumn("N");
		columns[4] = new SkunkColumn("K");

	}

	/**
	 * @param points the points needs to add to the current column
	 */
	public void addPoints(int points)
	{
		columns[currentColumnIndex].addPoints(points);
	}

	/**
	 * this method strike all the columns when 1-1 comes on both dice
	 */
	public void strikeAll()
	{
		for (int i = 0; i <= currentColumnIndex; i++)
		{
			columns[i].strike();
		}
	}

	/**
	 * this method move the game to next column
	 */
	public void moveToNextColumn()
	{
		currentColumnIndex++;
	}

	/**
	 * this method strike the current column when 1 comes on one dice
	 */
	public void strikeCurrent()
	{
		columns[currentColumnIndex].strike();
	}

	/**
	 * @return the current column of the game
	 */
	public SkunkColumn getCurrentCol()
	{
		return columns[currentColumnIndex];
	}

	/**
	 * this method print the column on the console according to the points for
	 * each player
	 */
	public void print()
	{
		printer.printLine(columns.length);
		printer.newLine();
		for (int i = 0; i < columns.length; i++)
		{
			printer.printCell(columns[i].getName());
		}
		printer.newLine();
		printer.printLine(columns.length);
		printer.newLine();

		final int MIN_HEIGHT = NUM_OF_COL;
		int maxHeight = MIN_HEIGHT;

		for (int i = 0; i < columns.length; i++)
		{
			int height = columns[i].count();
			if (height > maxHeight)
			{
				maxHeight = height;
			}
		}

		for (int i = 0; i < maxHeight; i++)
		{
			for (int j = 0; j < columns.length; j++)
			{
				String value = columns[j].count() > i ? columns[j].getPointAt(i) + "" : "";
				if (columns[j].isStriked())
				{
					value = "-" + (value.equals("") ? "X" : value) + "-";
				}
				printer.printCell(value);
			}
			printer.newLine();
		}

		printer.printLine(columns.length);
		printer.newLine();
	}

	/**
	 * @return this method tells whether the column is last column or not
	 */
	public boolean isLastColumn()
	{

		return currentColumnIndex == columns.length - ONE;

	}

	/**
	 * @return the total points of the player in all the column
	 */
	public int total()
	{
		int sum = 0;
		for (int i = 0; i < columns.length; i++)
		{
			if (!columns[i].isStriked())
			{
				sum += columns[i].total();
			}

		}
		return sum;
	}

}
