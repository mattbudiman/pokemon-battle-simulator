/**
 * Models a pokemon move.
 */
public class Move
{
	private String name;
	private Type type;
	private Category category;
	private int power;
	private double accuracy;
	private int pp;
	private int priority;

	public Move(String name, Type type, Category category, int power, double accuracy, int pp, int priority)
	{
		this.name = name;
		this.type = type;
		this.category = category;
		this.power = power;
		this.accuracy = accuracy;
		this.pp = pp;
		this.priority = priority;
	}

	/**
	 * The attacker uses the move on the defender.
	 * @param attacker the pokemon using the move
	 * @param defender the opposing pokemon
	 * @return true if the attack hits, false otherwise
	 */
	public boolean use(Pokemon attacker, Pokemon defender)
	{
		System.out.println(attacker.getName() + " used " + this.name + ".");
		System.out.println();

		double random = Math.random() * .15 + .85;
		double stab = 1;
		if (attacker.getType1() == this.type || attacker.getType2() == this.type)
		{
			stab = 1.5;
		}
		double type1 = 1;
		double type2 = 1;
		if (defender.getType1() != null)
		{
			type1 = Type.compare(this.type, defender.getType1());
		}
		if (defender.getType2() != null)
		{
			type2 = Type.compare(this.type, defender.getType2());
		}
		if (type1 * type2 == 0)
		{
			System.out.println("It doesn't affect " + defender.getName());
			System.out.println();
			return false;
		}
		//The move misses.
		if (Math.random() > accuracy)
		{
			System.out.println(defender.getName() + " avoided the attack.");
			System.out.println();
			return false;
		}
		double modifier = random * stab * type1 * type2;
		int a = 0;
		int d = 0;
		if (this.category == Category.PHYSICAL)
		{
			a = attacker.getAtk();
			d = defender.getDef();
		}
		if (this.category == Category.SPECIAL)
		{
			a = attacker.getSpAtk();
			d = defender.getSpDef();
		}
		int damage = (int) ((((int) ((int) (((int) (.4 * attacker.getLevel()) + 2) * this.power * (a / d))) / 50) + 2) * modifier);
		if (damage == 0)
		{
			damage = 1;
		}
		defender.setHP(defender.getHP() - damage);
		if (type1 * type2 <= .5)
		{
			System.out.println("It's not very effective.");
			System.out.println();
		}
		if (type1 * type2 >= 2)
		{
			System.out.println("It's super effective!");
			System.out.println();
		}
		this.pp = this.pp - 1;
		return true;
	}

	/**
	 * Gets the name of the move.
	 * @return the move name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the type of the move.
	 * @return the move type
	 */
	public Type getType()
	{
		return type;
	}

	/**
	 * Gets the category of the move.
	 * @return the move category
	 */
	public Category getCategory()
	{
		return category;
	}

	/**
	 * Gets the power of the move.
	 * @return the move power
	 */
	public int getPower()
	{
		return power;
	}

	/**
	 * Sets the power of the move.
	 * @param value the new power
	 */
	public void setPower(int value)
	{
		this.power = value;
	}

	/**
	 * Gets the accuracy of the move.
	 * @return the move accuracy
	 */
	public double getAccuracy()
	{
		return accuracy;
	}

	/**
	 * Gets the pp of the move.
	 * @return the move pp
	 */
	public int getPP()
	{
		return pp;
	}

	/**
	 * Sets the pp of the move to some new value.
	 * @param value the new pp value
	 */
	public void setPP(int value)
	{
		this.pp = value;
	}

	/**
	 * Gets the priority of the move.
	 * @return the priority of the move
	 */
	public int getPriority()
	{
		return priority;
	}
}
