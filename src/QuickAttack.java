public class QuickAttack extends Move
{
	public static final String NAME = "Quick Attack";
	public static final Type TYPE = Type.NORMAL;
	public static final Category CATEGORY = Category.PHYSICAL;
	public static final int POWER = 40;
	public static final double ACCURACY = 1;
	public static final int PP = 30;
	public static final int PRIORITY = 1;

	public QuickAttack()
	{
		super(NAME, TYPE, CATEGORY, POWER, ACCURACY, PP, PRIORITY);
	}
}
