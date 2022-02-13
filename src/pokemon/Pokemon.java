package pokemon;

import meta.*;
import moves.Move;

// A class that represents a Pokemon
public abstract class Pokemon
{
	private String name;

	private Type type1;
	private Type type2;

	private int level;

	private int hp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spd;

	private int baseHp;
	private int baseAtk;
	private int baseDef;
	private int baseSpAtk;
	private int baseSpDef;
	private int baseSpd;

	private int hpIV;
	private int atkIV;
	private int defIV;
	private int spAtkIV;
	private int spDefIV;
	private int spdIV;

	private int hpEV;
	private int atkEV;
	private int defEV;
	private int spAtkEV;
	private int spDefEV;
	private int spdEV;

	private int atkStage;
	private int defStage;
	private int spAtkStage;
	private int spDefStage;
	private int spdStage;

	private Move[] moveset;

	public Pokemon(String name, Type type1, Type type2, int level, int baseHp, int baseAtk, int baseDef, int baseSpAtk, int baseSpDef, int baseSpd, int hpIV, int atkIV, int defIV, int spAtkIV, int spDefIV, int spdIV, int hpEV, int atkEV, int defEV, int spAtkEV, int spDefEV, int spdEV)
	{
		this.name = name;

		this.type1 = type1;
		this.type2 = type2;

		this.level = level;

		this.atkStage = 0;
		this.defStage = 0;
		this.spAtkStage = 0;
		this.spDefStage = 0;
		this.spdStage = 0;

		this.baseHp = baseHp;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpAtk = baseSpAtk;
		this.baseSpDef = baseSpDef;
		this.baseSpd = baseSpd;

		this.hpIV = hpIV;
		this.atkIV = atkIV;
		this.defIV = defIV;
		this.spAtkIV = spAtkIV;
		this.spDefIV = spDefIV;
		this.spdIV = spdIV;

		this.hpEV = hpEV;
		this.atkEV = atkEV;
		this.defEV = defEV;
		this.spAtkEV = spAtkEV;
		this.spDefEV = spDefEV;
		this.spdEV = spdEV;

		this.hp = calculateHP(level, baseHp, hpIV, hpEV);
		this.atk = calculateOther(level, baseAtk, atkIV, atkEV, atkStage);
		this.def = calculateOther(level, baseDef, defIV, defEV, defStage);
		this.spAtk = calculateOther(level, baseSpAtk, spAtkIV, spAtkEV, spAtkStage);
		this.spDef = calculateOther(level, baseSpDef, spDefIV, spDefEV, spDefStage);
		this.spd = calculateOther(level, baseSpd, spdIV, spdEV, spdStage);

		moveset = new Move[4];
	}

	/**
	 * Calculates the stat stage multiplier
	 * @param stage the stage
	 */
	public static double statStageMultiplier(int stage)
	{
		if (stage >= 0)
		{
			return (2 + stage) / 2;
		}
		else
		{
			return 2 / (2 - stage);
		}
	}

	/**
	 * Calculates total HP.
	 * @param level the pokemon's level
	 * @param base the base HP
	 * @param iv the HP IV
	 * @param ev the HP EV
	 * @return the total HP
	 */
	public static int calculateHP(int level, int base, int iv, int ev)
	{
		return (int) ((((2 * base + iv + (ev / 4)) * level) / 100) + level + 10);
	}

	/**
	 * Calculates the total of any stat besides HP.
	 * @param level the pokemon's level
	 * @param base the base stat
	 * @param iv the stat iv
	 * @param ev the stat ev
	 * @param stage the stat stage
	 * @return the total stat
	 */
	public static int calculateOther(int level, int base, int iv, int ev, int stage)
	{
		return (int) ((int) ((((2 * base + iv + (ev / 4)) * level) / 100) + 5) * statStageMultiplier(stage));
	}

	/**
	 * The pokemon uses a move from its moveset on the opponent.
	 * @param i the index of the move in the moveset array to use
	 * @param opponent the oppsing pokemon
	 * @return true if the move hits, false otherwise
	 */
	public boolean use(int i, Pokemon opponent)
	{
		return moveset[i].use(this, opponent);
	}

	/**
	 * The pokemon learns a move.
	 * @param move the move to learn
	 * @param i the index of the location in the moveset array in which to store
	 * the move.
	 */
	public void learn(Move move, int i)
	{
		moveset[i] = move;
	}

	/**
	 * Gets the pokemon's name.
	 * @return the pokemon's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the pokemon's name.
	 * @param name the pokemon's new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the pokemon's first type.
	 * @return the pokemon's first type
	 */
	public Type getType1()
	{
		return type1;
	}

	/**
	 * Gets the pokemon's second type.
	 * @return the pokemon's second type
	 */
	public Type getType2()
	{
		return type2;
	}

	/**
	 * Gets the pokemon's level.
	 * @return the pokemon's level
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * Gets the pokemon's moveset.
	 * @return the pokemon's moveset
	 */
	public Move[] getMoveset()
	{
		return moveset;
	}

	//******************************************************************************

	/**
	 * Gets the pokemon's HP.
	 * @return the pokemon's HP
	 */
	public int getHP()
	{
		return hp;
	}

	/**
	 * Sets the pokemon's HP to some value.
	 * @param value the new HP
	 */
	public void setHP(int value)
	{
		hp = value;
	}

	/**
	 * Gets the pokemon's Attack stat.
	 * @return the pokemon's Attack stat
	 */
	public int getAtk()
	{
		return atk;
	}

	/**
	 * Gets the pokemon's Defense stat.
	 * @return the pokemon's Defense stat
	 */
	public int getDef()
	{
		return def;
	}

	/**
	 * Gets the pokemon's Special Attack stat.
	 * @return the pokemon's Special Attack stat
	 */
	public int getSpAtk()
	{
		return spAtk;
	}

	/**
	 * Gets the pokemon's Special Defense stat.
	 * @return the pokemon's Special Defense stat
	 */
	public int getSpDef()
	{
		return spDef;
	}

	/**
	 * Gets the pokemon's Speed stat.
	 * @return the pokemon's Speed stat
	 */
	public int getSpd()
	{
		return spd;
	}

	//******************************************************************************

	/**
	 * Gets the pokemon's base HP.
	 * @return the pokemon's base HP
	 */
	public int getBaseHP()
	{
		return baseHp;
	}

	/**
	 * Gets the pokemon's base Attack stat.
	 * @return the pokemon's base Attack stat
	 */
	public int getBaseAtk()
	{
		return baseAtk;
	}

	/**
	 * Gets the pokemon's base Defense stat.
	 * @return the pokemon's base Defense stat
	 */
	public int getBaseDef()
	{
		return baseDef;
	}

	/**
	 * Gets the pokemon's base Special Attack stat.
	 * @return the pokemon's base Special Attack stat
	 */
	public int getBaseSpAtk()
	{
		return baseSpAtk;
	}

	/**
	 * Gets the pokemon's base Special Defense stat.
	 * @return the pokemon's base Special Defense stat
	 */
	public int getBaseSpDef()
	{
		return baseSpDef;
	}

	/**
	 * Gets the pokemon's base Speed stat.
	 * @return the pokemon's base Speed stat
	 */
	public int getBaseSpd()
	{
		return baseSpd;
	}

	//******************************************************************************

	/**
	 * Gets the pokemon's HP IV.
	 * @return the pokemon's HP IV
	 */
	public int getHPIV()
	{
		return hpIV;
	}

	/**
	 * Gets the pokemon's Attack IV.
	 * @return the pokemon's Attack IV
	 */
	public int getAtkIV()
	{
		return atkIV;
	}

	/**
	 * Gets the pokemon's Defense IV.
	 * @return the pokemon's Defense IV
	 */
	public int getDefIV()
	{
		return defIV;
	}

	/**
	 * Gets the pokemon's Special Attack IV.
	 * @return the pokemon's Special Attack IV
	 */
	public int getSpAtkIV()
	{
		return spAtkIV;
	}

	/**
	 * Gets the pokemon's Special Defense IV.
	 * @return the pokemon's Special Defense IV
	 */
	public int getSpDefIV()
	{
		return spDefIV;
	}

	/**
	 * Gets the pokemon's Speed IV.
	 * @return the pokemon's Speed IV
	 */
	public int getSpdIV()
	{
		return spdIV;
	}

	//******************************************************************************

	/**
	 * Gets the pokemon's HP EV.
	 * @return the pokemon's HP EV
	 */
	public int getHPEV()
	{
		return hpEV;
	}

	/**
	 * Sets the pokemon's HP EV to some new value.
	 * @param value the new EV
	 */
	public void setHPEV(int value)
	{
		hpEV = value;
		hp = calculateHP(level, baseHp, hpIV, hpEV);
	}

	/**
	 * Gets the pokemon's Attack EV.
	 * @return the pokemon's Attack EV
	 */
	public int getAtkEV()
	{
		return atkEV;
	}

	/**
	 * Sets the pokemon's Attack EV to some new value.
	 * @param value the new EV
	 */
	public void setAtkEV(int value)
	{
		atkEV = value;
		atk = calculateOther(level, baseAtk, atkIV, atkEV, atkStage);
	}

	/**
	 * Gets the pokemon's Defense EV.
	 * @return the pokemon's Defense EV
	 */
	public int getDefEV()
	{
		return defEV;
	}

	/**
	 * Sets the pokemon's Defense EV to some new value.
	 * @param value the new EV
	 */
	public void setDefEV(int value)
	{
		defEV = value;
		def = calculateOther(level, baseDef, defIV, defEV, defStage);
	}

	/**
	 * Gets the pokemon's Special Attack EV.
	 * @return the pokemon's Special Attack EV
	 */
	public int getSpAtkEV()
	{
		return spAtkEV;
	}

	/**
	 * Sets the pokemon's Special Attack EV to some new value.
	 * @param value the new EV
	 */
	public void setSpAtkEV(int value)
	{
		spAtkEV = value;
		spAtk = calculateOther(level, baseSpAtk, spAtkIV, spAtkEV, spAtkStage);
	}

	/**
	 * Gets the pokemon's Special Defense EV.
	 * @return the pokemon's Special Defense EV
	 */
	public int getSpDefEV()
	{
		return spDefEV;
	}

	/**
	 * Sets the pokemon's Special Defense EV to some new value.
	 * @param value the new EV
	 */
	public void setSpDefEV(int value)
	{
		spDefEV = value;
		spDef = calculateOther(level, baseSpDef, spDefIV, spDefEV, spDefStage);
	}

	/**
	 * Gets the pokemon's Speed EV.
	 * @return the pokemon's Speed EV
	 */
	public int getSpdEV()
	{
		return spdEV;
	}

	/**
	 * Sets the pokemon's Speed EV to some new value.
	 * @param value the new EV
	 */
	public void setSpdEV(int value)
	{
		spdEV = value;
		spd = calculateOther(level, baseSpd, spdIV, spdEV, spdStage);
	}

	//******************************************************************************

	/**
	 * Gets the Attack stage.
	 * @return the Attack stage
	 */
	public int getAtkStage()
	{
		return atkStage;
	}

	/**
	 * Sets the Attack stage to some new value
	 * @param value the new attack stage
	 */
	public void setAtkStage(int value)
	{
		int difference = value - atkStage;

		if (difference >= 3)
		{
			System.out.println(name + "'s Attack rose drastically!");
		}
		else if (difference >= 2)
		{
			System.out.println(name + "'s Attack rose sharply!");
		}
		else if (difference >= 1)
		{
			System.out.println(name + "'s Attack rose!");
		}
		else if (difference >= 0)
		{
			System.out.println();
		}
		else if (difference >= -1)
		{
			System.out.println(name + "'s Attack fell!");
		}
		else if (difference >= -2)
		{
			System.out.println(name + "'s Attack harshly fell!");
		}
		else
		{
			System.out.println(name + "'s Attack severely fell!");
		}

		atkStage = value;
		atk = calculateOther(level, baseAtk, atkIV, atkEV, atkStage);
	}

	/**
	 * Gets the Defense stage.
	 * @return the Defense stage
	 */
	public int getDefStage()
	{
		return defStage;
	}

	/**
	 * Sets the Defense stage to some new value.
	 * @param value the new defense stage
	 */
	public void setDefStage(int value)
	{
		int difference = value - defStage;

		if (difference >= 3)
		{
			System.out.println(name + "'s Defense rose drastically!");
		}
		else if (difference >= 2)
		{
			System.out.println(name + "'s Defense rose sharply!");
		}
		else if (difference >= 1)
		{
			System.out.println(name + "'s Defense rose!");
		}
		else if (difference >= 0)
		{
			System.out.println();
		}
		else if (difference >= -1)
		{
			System.out.println(name + "'s Defense fell!");
		}
		else if (difference >= -2)
		{
			System.out.println(name + "'s Defense harshly fell!");
		}
		else
		{
			System.out.println(name + "'s Defense severely fell!");
		}

		defStage = value;
		def = calculateOther(level, baseDef, defIV, defEV, defStage);
	}

	/**
	 * Gets the Special Attack stage.
	 * @return the Special Attack stage
	 */
	public int getSpAtkStage()
	{
		return spAtkStage;
	}

	/**
	 * Sets the Special Attack stage to some new value.
	 * @param value the new special attack stage
	 */
	public void setSpAtkStage(int value)
	{
		int difference = value - spAtkStage;

		if (difference >= 3)
		{
			System.out.println(name + "'s Special Attack rose drastically!");
		}
		else if (difference >= 2)
		{
			System.out.println(name + "'s Special Attack rose sharply!");
		}
		else if (difference >= 1)
		{
			System.out.println(name + "'s Special Attack rose!");
		}
		else if (difference >= 0)
		{
			System.out.println();
		}
		else if (difference >= -1)
		{
			System.out.println(name + "'s Special Attack fell!");
		}
		else if (difference >= -2)
		{
			System.out.println(name + "'s Special Attack harshly fell!");
		}
		else
		{
			System.out.println(name + "'s Special Attack severely fell!");
		}

		spAtkStage = value;
		spAtk = calculateOther(level, baseSpAtk, spAtkIV, spAtkEV, spAtkStage);
	}

	/**
	 * Gets the Special Defense stage.
	 * @return the Special Defense stage
	 */
	public int getSpDefStage()
	{
		return spDefStage;
	}

	/**
	 * Sets the Special Defense stage to some new value.
	 * @param value the new special defense stage
	 */
	public void setSpDefStage(int value)
	{
		int difference = value - spDefStage;

		if (difference >= 3)
		{
			System.out.println(name + "'s Special Defense rose drastically!");
		}
		else if (difference >= 2)
		{
			System.out.println(name + "'s Special Defense rose sharply!");
		}
		else if (difference >= 1)
		{
			System.out.println(name + "'s Special Defense rose!");
		}
		else if (difference >= 0)
		{
			System.out.println();
		}
		else if (difference >= -1)
		{
			System.out.println(name + "'s Special Defense fell!");
		}
		else if (difference >= -2)
		{
			System.out.println(name + "'s Special Defense harshly fell!");
		}
		else
		{
			System.out.println(name + "'s Special Defense severely fell!");
		}

		spDefStage = value;
		spDef = calculateOther(level, baseSpDef, spDefIV, spDefEV, spDefStage);
	}

	/**
	 * Gets the Speed stage.
	 * @return the speed stage
	 */
	public int getSpdStage()
	{
		return spdStage;
	}

	/**
	 * Sets the Speed stage to some new value.
	 * @param value the new speed stage
	 */
	public void setSpdStage(int value)
	{
		int difference = value - spdStage;

		if (difference >= 3)
		{
			System.out.println(name + "'s Speed rose drastically!");
		}
		else if (difference >= 2)
		{
			System.out.println(name + "'s Speed rose sharply!");
		}
		else if (difference >= 1)
		{
			System.out.println(name + "'s Speed rose!");
		}
		else if (difference >= 0)
		{
			System.out.println();
		}
		else if (difference >= -1)
		{
			System.out.println(name + "'s Speed fell!");
		}
		else if (difference >= -2)
		{
			System.out.println(name + "'s Speed harshly fell!");
		}
		else
		{
			System.out.println(name + "'s Speed severely fell!");
		}

		spdStage = value;
		spd = calculateOther(level, baseSpd, spdIV, spdEV, spdStage);
	}
}
