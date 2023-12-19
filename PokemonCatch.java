import java.util.List;
import java.util.Scanner;

public class PokemonCatch {
	private Pokemon WildPoke1;
    private Pokemon WildPoke2;
    private Pokemon WildPoke3;
    private Scanner scanner;
    
    
	public PokemonCatch(Pokemon wildPoke1, Pokemon wildPoke2, Pokemon wildPoke3) {
		WildPoke1 = wildPoke1;
		WildPoke2 = wildPoke2;
		WildPoke3 = wildPoke3;
	}
	
	public PokemonCatch() {
		this.scanner = new Scanner(System.in);
	}

	

	public Pokemon getWildPoke1() {
		return WildPoke1;
	}


	public Pokemon getWildPoke2() {
		return WildPoke2;
	}


	public Pokemon getWildPoke3() {
		return WildPoke3;
	}
	


	public static void printPokemonDetails(Pokemon wildPoke1, Pokemon wildPoke2, Pokemon wildPoke3) {
	    System.out.println("Wild Pokemon 1 Details:");
	    System.out.println("Name: " + wildPoke1.getName());
	    System.out.println("Type: " + wildPoke1.getType());
	    System.out.println("Move Type: " + wildPoke1.getMoveType());
	    System.out.println("HP: " + wildPoke1.getHp());
	    System.out.println("Attack: " + wildPoke1.getAtk());
	    System.out.println("Defense: " + wildPoke1.getDef());
	    System.out.println("Speed: " + wildPoke1.getSpd());
	
	    System.out.println("\nWild Pokemon 2 Details:");
	    System.out.println("Name: " + wildPoke2.getName());
	    System.out.println("Type: " + wildPoke2.getType());
	    System.out.println("Move Type: " + wildPoke2.getMoveType());
	    System.out.println("HP: " + wildPoke2.getHp());
	    System.out.println("Attack: " + wildPoke2.getAtk());
	    System.out.println("Defense: " + wildPoke2.getDef());
	    System.out.println("Speed: " + wildPoke2.getSpd());
	    
	    System.out.println("\nWild Pokemon 3 Details:");
	    System.out.println("Name: " + wildPoke3.getName());
	    System.out.println("Type: " + wildPoke3.getType());
	    System.out.println("Move Type: " + wildPoke3.getMoveType());
	    System.out.println("HP: " + wildPoke3.getHp());
	    System.out.println("Attack: " + wildPoke3.getAtk());
	    System.out.println("Defense: " + wildPoke3.getDef());
	    System.out.println("Speed: " + wildPoke3.getSpd());
	}
	
	
	public String toString() {
		return "Choose ONE pokemon to catch!\n";
	}
	    
	
	public void catching(Pokemon wildPoke1, Pokemon wildPoke2, Pokemon wildPoke3) {
		System.out.println("Choose ONE pokemon to catch!\n");
		System.out.println("Enter 1, 2, or 3\n");
		System.out.println("1. " + wildPoke1.getName()+"\n");
		System.out.println("2. " + wildPoke2.getName()+"\n");
		System.out.println("3. " + wildPoke3.getName()+"\n");
		System.out.println("Enter -> ");
		
		int userChoice;
		
		while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice >= 1 && userChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
		
		switch (userChoice) {
        case 1:
            Pokemon wildPokemon = new Pokemon(wildPoke1.getName(), wildPoke1.getType(), wildPoke1.getMoveType(), wildPoke1.getHp(), wildPoke1.getAtk(), wildPoke1.getDef(), wildPoke1.getSpd());
            Trainer.catchPokemon(wildPokemon);
            break;
        case 2:
            Pokemon wildPokemon2 = new Pokemon(wildPoke2.getName(), wildPoke2.getType(), wildPoke2.getMoveType(), wildPoke2.getHp(), wildPoke2.getAtk(), wildPoke2.getDef(), wildPoke2.getSpd());
            Trainer.catchPokemon(wildPokemon2);
            break;
        case 3:
            Pokemon wildPokemon3 = new Pokemon(wildPoke3.getName(), wildPoke3.getType(), wildPoke3.getMoveType(), wildPoke3.getHp(), wildPoke3.getAtk(), wildPoke3.getDef(), wildPoke3.getSpd());
            Trainer.catchPokemon(wildPokemon3);
            break;
    }

    // Accessing caught Pokémon
    List<Pokemon> caughtPokemons = Trainer.getCaughtPokemons();
    for (Pokemon caughtPokemon : caughtPokemons) {
        System.out.println(Trainer.getName() + "'s Pokémon: " + caughtPokemon.getName());
    }
	}
	
}