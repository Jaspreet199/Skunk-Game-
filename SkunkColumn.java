package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 */
import java.util.ArrayList;
import java.util.List;

public class SkunkColumn
{
	private String name;
	private List<Integer> points;
	private boolean striked;

	/**
	 * this is constructor of column in game
	 * 
	 * @param name the name of the column
	 */
	public SkunkColumn(String name)
	{
		striked = false;
		this.name = name;
		points = new ArrayList<>();
	}

	/**
	 * @param points the points to add to the existing points in column
	 */
	public void addPoints(int points)
	{
		this.points.add(points);
	}

	/**
	 * @return if there is 1 came on any dice
	 */
	public boolean isStriked()
	{
		return striked;
	}

	/**
	 * this method tells if it strike(if one came on any dice) or not
	 */
	public void strike()
	{
		striked = true;
	}

	/**
	 * @param index the index of the point list
	 * @return the points on the specific index in list
	 */
	public int getPointAt(int index)
	{
		return points.get(index);
	}

	/**
	 * @return the size of the points list
	 */
	public int count()
	{
		return points.size();
	}

	/**
	 * @return the name of the column
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return the total of the points in one column
	 */
	public int total()
	{
		int sum = 0;
		for (int i : points)
		{
			sum += i;
		}
		return sum;
	}

}
