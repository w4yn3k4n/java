import java.util.*;

public class PokemonGame {
    public static void main(String[] args) {
       
        Pokemon[] pokemonArray = new Pokemon[21];

        
        pokemonArray[0] = new Pokemon("Charmander", "Fire", "Fire Blast", 139.0, 52.0, 43.0, 65.0);
        pokemonArray[1] = new Pokemon("Squirtle", "Water", "Hydro Pump", 120.0, 48.0, 65.0, 43.0);
        pokemonArray[2] = new Pokemon("Bulbasaur", "Grass/Poison", "Vine Whip", 45.0, 49.0, 49.0, 45.0);
        pokemonArray[3] = new Pokemon("Pikachu", "Electric", "Thunderbolt", 135.0, 55.0, 40.0, 90.0);
        pokemonArray[4] = new Pokemon("Jigglypuff", "Normal/Fairy", "Sing", 115.0, 45.0, 20.0, 20.0);
        pokemonArray[5] = new Pokemon("Geodude", "Rock/Ground", "Rock Throw", 140.0, 80.0, 100.0, 20.0);
        pokemonArray[6] = new Pokemon("Eevee", "Normal", "Quick Attack", 155.0, 55.0, 50.0, 55.0);
        pokemonArray[7] = new Pokemon("Gyarados", "Water/Flying", "Hydro Pump", 195.0, 125.0, 79.0, 81.0);
        pokemonArray[8] = new Pokemon("Machop", "Fighting", "Karate Chop", 170.0, 80.0, 50.0, 35.0);
        pokemonArray[9] = new Pokemon("Haunter", "Ghost/Poison", "Shadow Ball", 145.0, 50.0, 45.0, 95.0);
        pokemonArray[10] = new Pokemon("Alakazam", "Psychic", "Psychic", 155.0, 50.0, 45.0, 120.0);
        pokemonArray[11] = new Pokemon("Gengar", "Ghost/Poison", "Shadow Ball", 160.0, 65.0, 60.0, 110.0);
        pokemonArray[12] = new Pokemon("Onix", "Rock/Ground", "Rock Throw", 135.0, 45.0, 160.0, 70.0);
        pokemonArray[13] = new Pokemon("Pidgey", "Normal/Flying", "Gust", 140.0, 45.0, 40.0, 56.0);
        pokemonArray[14] = new Pokemon("Rattata", "Normal", "Quick Attack", 130.0, 56.0, 35.0, 72.0);
        pokemonArray[15] = new Pokemon("Clefairy", "Normal/Fairy", "Sing", 170.0, 45.0, 48.0, 35.0);
        pokemonArray[16] = new Pokemon("Abra", "Psychic", "Teleport", 125.0, 20.0, 15.0, 90.0);
        pokemonArray[17] = new Pokemon("Diglett", "Ground", "Dig", 110.0, 55.0, 25.0, 95.0);
        pokemonArray[18] = new Pokemon("Nidoran", "Poison", "Poison Sting", 155.0, 47.0, 52.0, 41.0);
        pokemonArray[19] = new Pokemon("Vulpix", "Fire", "Ember", 138.0, 41.0, 40.0, 65.0);
        pokemonArray[20] = new Pokemon("Lucario", "Fighting/Steel", "Aura Sphere", 170.0, 110.0, 70.0, 90.0);

        Trainer player = new Trainer();
        player.enterName();
        
        System.out.println("");

        PokemonBattle pokemonBattle = new PokemonBattle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a stage (Forest / Cave / Mountain):");
        String chosenStage = scanner.nextLine().toLowerCase(); // Assuming user inputs "forest" or "cave" or "mountain"
        
        Stage currentStage = null; // Declare currentStage=null (to match the user chosen stage)


        if (chosenStage.equals("forest")) {
        	currentStage = new ForestStage(pokemonArray);
        } else if (chosenStage.equals("cave")) {
        	currentStage = new CaveStage(pokemonArray);
        } else if (chosenStage.equals("mountain")) {
        	currentStage = new MountainStage(pokemonArray);
        } else {
            System.out.println("Invalid stage choice. Exiting.");
            return;
        }

        currentStage.chooseStage(); // Display available Pokémon in the chosen stage
		
        System.out.println("");
        
        System.out.println("You have encountered 3 wild pokemon!!!");

        System.out.println(".\n\n.\n\n.\n\n");
     
        //Spawning wild Pokemons
        PokemonCatch wp = new PokemonCatch(Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray));
        PokemonCatch.printPokemonDetails(wp.getWildPoke1(), wp.getWildPoke2(), wp.getWildPoke3());
        
        //Catch pokemon
        PokemonCatch c1 = new PokemonCatch();
        c1.catching(wp.getWildPoke1(), wp.getWildPoke2(), wp.getWildPoke3());
        
        // Assuming you have the player's Pokémon ready, for instance, pokemonArray[0]
        Pokemon playerPokemon = pokemonArray[0];  // Replace this with the player's chosen Pokémon

        // Assuming you have wild Pokémon ready for battle
        Pokemon wildPokemon = Pokemon.getRandomPokemonBattle(pokemonArray);

        PokemonBattle Battle = new PokemonBattle();  // Create an instance of PokemonBattle

        // Start the battle between player's Pokémon and the wild Pokémon
        pokemonBattle.startBattle(playerPokemon, wildPokemon);

    }
}