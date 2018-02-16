public class Gyarados extends Pokemon
{
	public static final String NAME = "Gyarados";

	public static final Type TYPE1 = Type.FLYING;
	public static final Type TYPE2 = Type.WATER;

	public static final int BASE_HP = 95;
	public static final int BASE_ATK = 125;
	public static final int BASE_DEF = 79;
	public static final int BASE_SP_ATK = 60;
	public static final int BASE_SP_DEF = 100;
	public static final int BASE_SPEED = 81;

	public Gyarados(int level, int hpIV, int atkIV, int defIV, int spAtkIV, int spDefIV, int spdIV, int hpEV, int atkEV, int defEV, int spAtkEV, int spDefEV, int spdEV)
	{
		super(NAME, TYPE1, TYPE2, level, BASE_HP, BASE_ATK, BASE_DEF, BASE_SP_ATK, BASE_SP_DEF, BASE_SPEED, hpIV, atkIV, defIV, spAtkIV, spDefIV, spdIV, hpEV, atkEV, defEV, spAtkEV, spDefEV, spdEV);
	}
}
