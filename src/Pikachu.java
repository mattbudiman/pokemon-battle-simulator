public class Pikachu extends Pokemon
{
	public static final String NAME = "Pikachu";

	public static final Type TYPE1 = Type.ELECTRIC;
	public static final Type TYPE2 = null;

	public static final int BASE_HP = 35;
	public static final int BASE_ATK = 55;
	public static final int BASE_DEF = 40;
	public static final int BASE_SP_ATK = 50;
	public static final int BASE_SP_DEF = 50;
	public static final int BASE_SPEED = 90;

	public Pikachu(int level, int hpIV, int atkIV, int defIV, int spAtkIV, int spDefIV, int spdIV, int hpEV, int atkEV, int defEV, int spAtkEV, int spDefEV, int spdEV)
	{
		super(NAME, TYPE1, TYPE2, level, BASE_HP, BASE_ATK, BASE_DEF, BASE_SP_ATK, BASE_SP_DEF, BASE_SPEED, hpIV, atkIV, defIV, spAtkIV, spDefIV, spdIV, hpEV, atkEV, defEV, spAtkEV, spDefEV, spdEV);
	}
}
