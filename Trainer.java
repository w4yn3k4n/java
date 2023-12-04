import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Trainer {
    private static String name;
    private static List<Pokemon> caughtPokemons;
    private Scanner scanner;
    
    

    public Trainer(String name) {
        Trainer.name = name;
        Trainer.caughtPokemons = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public Trainer() {
    	this.scanner = new Scanner(System.in);
    }
    
    

    // Getter for the trainer's name
    public static String getName() {
        return name;
    }
    

    // Getter for the list of caught Pokemon
    public static List<Pokemon> getCaughtPokemons() {
        return caughtPokemons;
    }
    
    public static void catchPokemon(Pokemon pokemon) {
        if (caughtPokemons == null) {
            caughtPokemons = new ArrayList<>();
        }

        caughtPokemons.add(pokemon);
        System.out.println(name + " caught a new Pokémon: " + pokemon.getName());
    }

    
    public void enterName() {
		System.out.println("Enter your name Trainer: ");
		String name = scanner.nextLine(); 
		Trainer n = new Trainer(name);
		System.out.println("\nWelcome Trainer " + Trainer.getName());
    }
    
    
}