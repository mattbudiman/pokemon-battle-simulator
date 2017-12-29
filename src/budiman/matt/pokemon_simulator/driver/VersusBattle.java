package budiman.matt.pokemon_simulator.driver;

import budiman.matt.pokemon_simulator.moves.AquaTail;
import budiman.matt.pokemon_simulator.moves.DragonDance;
import budiman.matt.pokemon_simulator.moves.DragonRage;
import budiman.matt.pokemon_simulator.moves.ElectroBall;
import budiman.matt.pokemon_simulator.moves.Flamethrower;
import budiman.matt.pokemon_simulator.moves.IronTail;
import budiman.matt.pokemon_simulator.moves.QuickAttack;
import budiman.matt.pokemon_simulator.moves.Thunderbolt;
import budiman.matt.pokemon_simulator.pokemon.Gyarados;
import budiman.matt.pokemon_simulator.pokemon.Pikachu;
import budiman.matt.pokemon_simulator.pokemon.Pokemon;
import pokemon.Battle;

public class VersusBattle
{
	public static void main(String[] args)
	{
		Pokemon yours = new Pikachu(50, 31, 31, 31, 31, 31, 31, 0, 0, 4, 252, 0, 252);
		Pokemon cpu = new Gyarados(50, 31, 31, 31, 31, 31, 31, 0, 252, 4, 0, 0, 252);
		
		yours.learn(new Thunderbolt(), 0);
		yours.learn(new QuickAttack(), 1);
		yours.learn(new IronTail(), 2);
		yours.learn(new ElectroBall(), 3);
		
		cpu.learn(new DragonDance(), 0);
		cpu.learn(new Flamethrower(), 1);
		cpu.learn(new AquaTail(), 2);
		cpu.learn(new DragonRage(), 3);
		
		Battle battle = new Battle(yours, cpu);
		System.out.println("A wild " + cpu.getName() + " appeared!");
		System.out.println();
		while (battle.isActive())
		{
			battle.nextTurn();
		}
	}
}
