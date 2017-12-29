package budiman.matt.pokemon_simulator.moves;

import budiman.matt.pokemon_simulator.meta.Category;
import budiman.matt.pokemon_simulator.meta.Type;
import budiman.matt.pokemon_simulator.pokemon.Pokemon;

/**
 * Always does 40 HP of damage.
 */
public class DragonRage extends Move
{
	public static final String NAME = "Dragon Rage";
	public static final Type TYPE = Type.DRAGON;
	public static final Category CATEGORY = Category.SPECIAL;
	public static final int POWER = 0;
	public static final double ACCURACY = 1;
	public static final int PP = 10;
	public static final int PRIORITY = 0;
	
	public DragonRage()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}
	
	public boolean use(Pokemon attacker, Pokemon defender)
	{
		System.out.println(attacker.getName() + " used " + NAME);
		defender.setHP(defender.getHP() - 40);
		System.out.println();
		return true;
	}
}
