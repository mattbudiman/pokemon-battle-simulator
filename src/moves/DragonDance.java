package moves;

import meta.*;
import pokemon.Pokemon;

public class DragonDance extends Move
{
	public static final String NAME = "Dragon Dance";
	public static final Type TYPE = Type.DRAGON;
	public static final Category CATEGORY = Category.STATUS;
	public static final int POWER = 0;
	public static final double ACCURACY = 1;
	public static final int PP = 20;
	public static final int PRIORITY = 0;

	public DragonDance()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}

	public boolean use(Pokemon attacker, Pokemon defender)
	{
		System.out.println(attacker.getName() + " used " + NAME);
		System.out.println();
		attacker.setAtkStage(attacker.getAtkStage() + 1);
		attacker.setSpdStage(attacker.getSpdStage() + 1);
		return true;
	}
}
