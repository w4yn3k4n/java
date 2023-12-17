
import java.util.*;

public class CaveStage extends Stage{
    private List<Pokemon> cavePokemons;

    public CaveStage(Pokemon[] pokemonArray) {
        super("Cave");
        cavePokemons = new ArrayList<>(Arrays.asList(pokemonArray));
        addPokemon("Haunter");
        addPokemon("Onix");
        addPokemon("Diglett");
    }
    @Override
    public Pokemon chooseOpponentPokemon() {
        List<Pokemon> availableOpponents = new ArrayList<>();
        for (Pokemon pokemon : cavePokemons) {
            if (pokemon.getName().equals("Haunter") ||
                pokemon.getName().equals("Onix") ||
                pokemon.getName().equals("Diglett")) {
                availableOpponents.add(pokemon);
            }
        }
        if (!availableOpponents.isEmpty()) {
            Collections.shuffle(availableOpponents);
            return availableOpponents.get(0); // Return a random opponent from available ones
        } else {
            // If none of the specific Pokémon are available, return a default Pokémon
            return new Pokemon("Haunter", "Ghost/Poison", "Shadow Ball", 45.0, 50.0, 45.0, 95.0);
        }
    }

    // Other methods related to caveStage can be added here
}
