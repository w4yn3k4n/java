import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Trainer {
    private String name;
    private List<Pokemon> caughtPokemons;
    private Scanner scanner;
    
    public Trainer() {
    	
    }

    public Trainer(String name) {
        this.name = name;
        this.caughtPokemons = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getCaughtPokemons() {
        return caughtPokemons;
    }

    public void catchPokemon(Pokemon pokemon) {
        if (caughtPokemons == null) {
            caughtPokemons = new ArrayList<>();
        }

        caughtPokemons.add(pokemon);
        System.out.println(name + " caught a new Pokémon: " + pokemon.getName());
    }

    public String lastCaughtPokemonName() {
        int lastIndex = caughtPokemons.size() - 1;
        if (lastIndex >= 0) {
            Pokemon lastCaughtPokemon = caughtPokemons.get(lastIndex);
            return lastCaughtPokemon.getName();
        } else {
            return "No Pokémon caught yet.";
        }
    }

    public void displayCaughtPokemons() {
        System.out.println("\nPokémon caught by " + name + ":");
        for (Pokemon pokemon : caughtPokemons) {
            System.out.println(pokemon.getName());
        }
    

	}
}