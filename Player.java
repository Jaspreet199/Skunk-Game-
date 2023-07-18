package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 * 
 */
public class Player
{

	private String name;
	private boolean standing;
	private SkunkBoard board;

	/**
	 * this is player constructor
	 * 
	 * @param name the name of the player
	 */
	public Player(String name)
	{
		board = new SkunkBoard();
		this.standing = true;
		this.name = name;
	}

	/**
	 * this method increment the points.
	 * 
	 * @param points the points need to increase
	 */
	public void incrementColumnPoints(int points)
	{
		System.out.println(name + " gained " + points + " points in column " + board.getCurrentCol().getName());
		board.addPoints(points);
	}

	/**
	 * @return the position of the player for every round
	 */
	public boolean isStanding()
	{
		return standing;
	}

	/**
	 * this one print the score board on console
	 */
	public void printBoard()
	{
		System.out.println("\n    " + this.name + " Score Board");
		board.print();
		System.out.println("");
	}

	/**
	 * this method prints the player position on to console
	 * 
	 * @param b the b is whether person wants to stand or not
	 */
	public void setStanding(boolean b)
	{
		standing = b;
		System.out.println(this.name + " chose to " + (standing ? "stand" : "sit"));
	}

	/**
	 * this method reset all the points to zero
	 */
	public void resetTotalPoints()
	{
		System.out.println(name + " lost all points so far!");
		board.strikeAll();
	}

	/**
	 * this method move the board to next column
	 */
	public void moveToNextColumn()
	{
		board.moveToNextColumn();

	}

	/**
	 * this method reset just current column points to zero
	 */
	public void resetColumnPoints()
	{
		System.out.println(name + " lost all points in column " + board.getCurrentCol().getName());
		board.strikeCurrent();
	}

	/**
	 * @return whether it is last round or not
	 */
	public boolean isLastRound()
	{

		return board.isLastColumn();
	}

	/**
	 * @return the total points of the player after game finishes
	 */
	public int getTotal()
	{
		return board.total();
	}

	/**
	 * this method prints the total points of each player on console
	 */
	public void printTotal()
	{
		System.out.println(name + " has score = " + getTotal());

	}

	/**
	 * this method prints congrats to the winner on console
	 */
	public void congrats()
	{
		System.out.println("Congratulations " + name + "!!");
	}

}
