import java.util.*;

public class ForestStage extends Stage {
    private List<Pokemon> forestPokemons;

    public ForestStage(Pokemon[] pokemonArray) {
        super("Forest");
        forestPokemons = new ArrayList<>(Arrays.asList(pokemonArray));
        addPokemon("Bulbasaur");
        addPokemon("Pikachu");
        addPokemon("Clefairy");
    }

    @Override
    public Pokemon chooseOpponentPokemon() {
        List<Pokemon> availableOpponents = new ArrayList<>();
        for (Pokemon pokemon : forestPokemons) {
            // Add Bulbasaur, Pikachu, and Geodude to available opponents
            if (pokemon.getName().equals("Bulbasaur") ||
                pokemon.getName().equals("Pikachu") ||
                pokemon.getName().equals("Clefairy")) {
                availableOpponents.add(pokemon);
            }
        }

        if (!availableOpponents.isEmpty()) {
            Collections.shuffle(availableOpponents);
            return availableOpponents.get(0); // Return a random opponent from available ones
        } else {
            // If none of the specific Pokémon are available, return a default Pokémon
            return new Pokemon("Bulbasaur", "Grass/Poison", "Vine Whip", 45.0, 49.0, 49.0, 45.0);
        }
    }

    // Other methods related to ForestStage can be added here
}
