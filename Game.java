package ca.bcit.comp1409.game;

/**
 * @author Jaspreet
 * @version 1.1
 */
import java.util.Random;

public class Game
{

	private Questioner questioner;
	private Player player1, bot;
	private Dice dice1;
	private Dice dice2;
	public static final int DICE_STOP_NUM = 1;
	public static final int TWO = 2;

	/**
	 * this is game constructor in which all the the other make objects from
	 * other classes
	 */
	public Game()
	{
		bot = new Player("Sandy");
		questioner = new Questioner();
		dice1 = new Dice();
		dice2 = new Dice();
	}

	/**
	 * @return this method tells if we are moving to next round or finsihing the
	 *         game
	 */
	public boolean playRound()
	{
		int v1 = dice1.roll();
		int v2 = dice2.roll();

		processPoints(player1, v1, v2);
		processPoints(bot, v1, v2);

		if (v1 != DICE_STOP_NUM && v2 != DICE_STOP_NUM)
		{
			if (player1.isStanding())
			{
				askPosition(player1);
			}

			if (bot.isStanding())
			{
				automaticallySetPosition(bot);
			}
		}

		if (v1 == DICE_STOP_NUM || v2 == DICE_STOP_NUM || !(player1.isStanding() || bot.isStanding()))
		{

			if (player1.isLastRound())
			{
				return false;
			}

			moveToNextRound();
		}

		return true;

	}

	/*
	 * this method process the points according to the game rules
	 */
	private void processPoints(Player player, int v1, int v2)
	{
		if (player.isStanding())
		{
			if (v1 == DICE_STOP_NUM && v2 == DICE_STOP_NUM)
			{
				player.resetTotalPoints();

			} else if (v1 == DICE_STOP_NUM || v2 == DICE_STOP_NUM)
			{
				player.resetColumnPoints();
			} else
			{
				player.incrementColumnPoints(v1 + v2);
			}
		}

		player.printBoard();
	}

	/*
	 * this method set the positons of the player for next round and tell them
	 * to get ready for next round
	 */
	private void moveToNextRound()
	{
		System.out.println("Get ready for the Next Round!");
		player1.moveToNextColumn();
		player1.setStanding(true);

		bot.moveToNextColumn();
		bot.setStanding(true);
	}

	/*
	 * in this method get the player input if he wants to keep playing
	 */
	private void askPosition(Player player)
	{
		boolean correct = false;

		while (!correct)
		{
			String answer = questioner.ask("Do you want to remaining standing? Y/N");
			if (answer.toLowerCase().equals("y"))
			{
				player.setStanding(true);
				correct = true;
			} else if (answer.toLowerCase().equals("n"))
			{
				player.setStanding(false);
				correct = true;
			} else
			{
				System.out.println("Invalid Input. Please try again");
			}
		}
	}

	/*
	 * this method gives the random position to bot
	 */
	private void automaticallySetPosition(Player player)
	{
		Random r = new Random();
		boolean position = r.nextInt() % TWO == 0;

		player.setStanding(position);
	}

	/**
	 * this method starts the game by asking players name after that decides to
	 * go to next round and gives results of the game
	 */
	public void play()
	{

		String name = questioner.ask("What is your name?");
		player1 = new Player(name);

		player1.printBoard();
		bot.printBoard();

		boolean playNextRound = true;
		while (playNextRound)
		{
			playNextRound = playRound();
		}

		player1.printTotal();
		bot.printTotal();

		if (player1.getTotal() > bot.getTotal())
		{
			player1.congrats();
		} else
		{
			bot.congrats();
		}

	}

	/**
	 * @param args is the game
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		game.play();
	}

}
