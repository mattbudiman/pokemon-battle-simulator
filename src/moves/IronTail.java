package moves;

import meta.*;
import pokemon.Pokemon;

public class IronTail extends Move
{
	public static final String NAME = "Iron Tail";
	public static final Type TYPE = Type.STEEL;
	public static final Category CATEGORY = Category.PHYSICAL;
	public static final int POWER = 100;
	public static final double ACCURACY = .75;
	public static final int PP = 15;
	public static final int PRIORITY = 0;

	public IronTail()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}

	public boolean use(Pokemon attacker, Pokemon defender)
	{
		boolean success = super.use(attacker, defender);
		if (success == false)
		{
			return false;
		}
		if (Math.random() < .3)
		{
			defender.setDefStage(defender.getDefStage() - 1);
		}
		return success;
	}
}
