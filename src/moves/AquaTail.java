package moves;

import meta.*;

public class AquaTail extends Move
{
	public static final String NAME = "Aqua Tail";
	public static final Type TYPE = Type.WATER;
	public static final Category CATEGORY = Category.PHYSICAL;
	public static final int POWER = 90;
	public static final double ACCURACY = .9;
	public static final int PP = 10;
	public static final int PRIORITY = 0;

	public AquaTail()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}
}
