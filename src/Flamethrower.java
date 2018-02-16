public class Flamethrower extends Move
{
	public static final String NAME = "Flamethrower";
	public static final Type TYPE = Type.FIRE;
	public static final Category CATEGORY = Category.SPECIAL;
	public static final int POWER = 90;
	public static final double ACCURACY = 1;
	public static final int PP = 15;
	public static final int PRIORITY = 0;

	public Flamethrower()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}
}
