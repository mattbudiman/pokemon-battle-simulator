package pokemon;

import java.util.Scanner;

import budiman.matt.pokemon_simulator.pokemon.Pokemon;

/**
 * A pokemon battle.
 */
public class Battle
{
	private Pokemon pokemon1;
	private int hpMax1;
	private Pokemon pokemon2;
	private int hpMax2;
	private int turns;
	private Scanner in;
	private boolean active;
	
	public Battle(Pokemon a, Pokemon b)
	{
		pokemon1 = a;
		pokemon2 = b;
		turns = 0;
		in = new Scanner(System.in);
		active = true;
		hpMax1 = a.getHP();
		hpMax2 = b.getHP();
	}
	
	/**
	 * Determines whether the battle is still ongoing.
	 * @return true if ongoing, false otherwise
	 */
	public boolean isActive()
	{
		return active;
	}
	
	/**
	 * The next turn of the battle.
	 */
	public void nextTurn()
	{
		System.out.println();
		System.out.println("                   " + pokemon2.getName() + "  Lv. " + pokemon2.getLevel());
		System.out.println("                   HP: " + pokemon2.getHP() + "/" + hpMax2);
		System.out.println();
		System.out.println(pokemon1.getName() + "  Lv. " + pokemon1.getLevel());
		System.out.println("HP: " + pokemon1.getHP() + "/" + hpMax1);
		System.out.println();
		System.out.println("*MOVE*");
		for (int i = 0; i < pokemon1.getMoveset().length; i++)
		{
			System.out.println((i + 1) + ". " + pokemon1.getMoveset()[i].getName());
		}
		int i = in.nextInt() - 1;
		System.out.println();
		int j = (int) Math.round(Math.random() * 3);
		if (pokemon1.getMoveset()[i].getPriority() > pokemon2.getMoveset()[j].getPriority())
		{
			move(pokemon1, i, pokemon2, j);
		}
		else if (pokemon2.getMoveset()[i].getPriority() > pokemon1.getMoveset()[j].getPriority())
		{
			move(pokemon2, j, pokemon1, i);
		}
		else if (pokemon1.getSpd() > pokemon2.getSpd())
		{
			move(pokemon1, i, pokemon2, j);
		}
		else if (pokemon2.getSpd() > pokemon1.getSpd())
		{
			move(pokemon2, j, pokemon1, i);
		}
		else if (Math.random() >= .5)
		{
			move(pokemon1, i, pokemon2, j);
		}
		else
		{
			move(pokemon2, j, pokemon1, i);
		}
	}
	
	/**
	 * The two pokemon make their moves.
	 * @param first the first pokemon to move
	 * @param i the index of the chosen move for the first pokemon
	 * @param second the second pokemon to move
	 * @param j the index of the chosen move for the second pokemon
	 */
	public void move(Pokemon first, int i,  Pokemon second, int j)
	{
		first.use(i, second);
		if (second.getHP() < 0)
		{
			System.out.println(second.getName() + " fainted.");
			System.out.println();
			System.out.println(first.getName() + " wins!");
			active = false;
			System.out.println("                   " + pokemon2.getName() + "  Lv. " + pokemon2.getLevel());
			System.out.println("                   HP: 0/" + hpMax2);
			System.out.println();
			System.out.println(pokemon1.getName() + "  Lv. " + pokemon1.getLevel());
			System.out.println("HP: " + first.getHP() + "/" + hpMax1);
			System.out.println();
			return;
		}
		second.use(j, first);
		if (first.getHP() < 0)
		{
			System.out.println(first.getName() + " fainted.");
			System.out.println();
			System.out.println(second.getName() + " wins!");
			active = false;
			System.out.println("                   " + pokemon2.getName() + "  Lv. " + pokemon2.getLevel());
			System.out.println("                   HP: " + second.getHP() + "/" + hpMax2);
			System.out.println();
			System.out.println(pokemon1.getName() + "  Lv. " + pokemon1.getLevel());
			System.out.println("HP: 0/" + hpMax1);
			System.out.println();
			return;
		}
	}
}
