package budiman.matt.pokemon_simulator.meta;

/**
 * An enum type consisting of the pokemon types.
 */
public enum Type
{
	BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS, GROUND,
	ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER;
	
	public static final double[][] TYPE_CHART = new double[][]{
		{  1,  2,  1,  1, .5, .5, .5, .5, .5,  2,  1,  1,  1, .5,  2,  1, .5,  1},
		{  1, .5,  1,  1, .5, .5,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1,  1},
		{  1,  1,  2,  1,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, .5,  1},
		{  1,  1, .5, .5,  1,  1,  1,  2,  1, .5,  0,  1,  1,  1,  1,  1,  1,  2},
		{  1,  2,  2,  1,  1,  2, .5,  1,  1,  1,  1,  1,  1, .5,  1,  1, .5,  1},
		{ .5,  2,  1,  1, .5,  1,  1, .5,  0,  1,  1,  2,  2, .5, .5,  2,  2,  1},
		{  2,  1, .5,  1,  1,  1, .5,  1,  1,  2,  1,  2,  1,  1,  1, .5,  2, .5},
		{  2,  1,  1, .5,  1,  2,  1,  1,  1,  2,  1,  1,  1,  1,  1, .5, .5,  1},
		{  1, .5,  1,  1,  1,  1,  1,  1,  2,  1,  1,  1,  0,  1,  2,  1,  1,  1},
		{ .5,  1, .5,  1,  1,  1, .5, .5,  1, .5,  2,  1,  1, .5,  1,  2, .5,  2},
		{ .5,  1,  1,  2,  1,  1,  2,  0,  1, .5,  1,  1,  1,  2,  1,  2,  2,  1},
		{  1,  1,  2,  1,  1,  1, .5,  2,  1,  2,  2, .5,  1,  1,  1,  1, .5, .5},
		{  1,  1,  1,  1,  1,  1,  1,  1,  0,  1,  1,  1,  1,  1,  1, .5, .5,  1},
		{  1,  1,  1,  1,  2,  1,  1,  1, .5,  2, .5,  1,  1, .5,  1, .5,  0,  1},
		{  1,  0,  1,  1,  1,  2,  1,  1,  1,  1,  1,  1,  1,  2, .5,  1, .5,  1},
		{  2,  1,  1,  1,  1, .5,  2,  2,  1,  1, .5,  2,  1,  1,  1,  1, .5,  1},
		{  1,  1,  1, .5,  2,  1, .5,  1,  1,  1,  1,  2,  1,  1,  1,  2, .5, .5},
		{  1,  1, .5,  1,  1,  1,  2,  1,  1, .5,  2,  1,  1,  1,  1,  2,  1, .5}
	};
	
	/**
	 * Determines how effective an attacking type is against a defending type.
	 * @param attacking the attacking type
	 * @param defending the defending type
	 * @return 0 if the attacking type doesn't affect the defending type, .5 if the
	 * attacking type is not very effective against the defending type, 1 if the
	 * attacking type is normally effetive against the defending type, and 2 if the
	 * attacking type is super effective against the defending type.
	 */
	public static double compare(Type attacking, Type defending)
	{
		int a = 0;
		int d = 0;
		for (int i = 0; i < Type.values().length; i++)
		{
			if (Type.values()[i] == attacking)
			{
				a = i;
			}
			if (Type.values()[i] == defending)
			{
				d = i;
			}
		}
		return TYPE_CHART[a][d];
	}
}
