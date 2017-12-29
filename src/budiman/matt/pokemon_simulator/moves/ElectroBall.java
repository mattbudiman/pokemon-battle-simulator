package budiman.matt.pokemon_simulator.moves;

import budiman.matt.pokemon_simulator.meta.Category;
import budiman.matt.pokemon_simulator.meta.Type;
import budiman.matt.pokemon_simulator.pokemon.Pokemon;

public class ElectroBall extends Move
{
	public static final String NAME = "Electro Ball";
	public static final Type TYPE = Type.ELECTRIC;
	public static final Category CATEGORY = Category.SPECIAL;
	public static final int POWER = 40;
	public static final double ACCURACY = 1;
	public static final int PP = 10;
	public static final int PRIORITY = 0;
	
	public ElectroBall()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}
	
	public boolean use(Pokemon attacker, Pokemon defender)
	{
		double spdRatio = defender.getSpd() / attacker.getSpd();
		if (spdRatio > 1)
		{
			this.setPower(40);
		}
		else if (spdRatio > .5)
		{
			this.setPower(60);
		}
		else if (spdRatio > .3334)
		{
			this.setPower(80);
		}
		else if (spdRatio > 25)
		{
			this.setPower(120);
		}
		else
		{
			this.setPower(150);
		}
		return super.use(attacker, defender);
	}
}
