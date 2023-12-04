import java.util.*;

public class PokemonGame {
    public static void main(String[] args) {
       
        Pokemon[] pokemonArray = new Pokemon[21];

        
        pokemonArray[0] = new Pokemon("Charmander", "Fire", "Fire Blast", 39.0, 52.0, 43.0, 65.0);
        pokemonArray[1] = new Pokemon("Squirtle", "Water", "Hydro Pump", 44.0, 48.0, 65.0, 43.0);
        pokemonArray[2] = new Pokemon("Bulbasaur", "Grass/Poison", "Vine Whip", 45.0, 49.0, 49.0, 45.0);
        pokemonArray[3] = new Pokemon("Pikachu", "Electric", "Thunderbolt", 35.0, 55.0, 40.0, 90.0);
        pokemonArray[4] = new Pokemon("Jigglypuff", "Normal/Fairy", "Sing", 115.0, 45.0, 20.0, 20.0);
        pokemonArray[5] = new Pokemon("Geodude", "Rock/Ground", "Rock Throw", 40.0, 80.0, 100.0, 20.0);
        pokemonArray[6] = new Pokemon("Eevee", "Normal", "Quick Attack", 55.0, 55.0, 50.0, 55.0);
        pokemonArray[7] = new Pokemon("Gyarados", "Water/Flying", "Hydro Pump", 95.0, 125.0, 79.0, 81.0);
        pokemonArray[8] = new Pokemon("Machop", "Fighting", "Karate Chop", 70.0, 80.0, 50.0, 35.0);
        pokemonArray[9] = new Pokemon("Haunter", "Ghost/Poison", "Shadow Ball", 45.0, 50.0, 45.0, 95.0);
        pokemonArray[10] = new Pokemon("Alakazam", "Psychic", "Psychic", 55.0, 50.0, 45.0, 120.0);
        pokemonArray[11] = new Pokemon("Gengar", "Ghost/Poison", "Shadow Ball", 60.0, 65.0, 60.0, 110.0);
        pokemonArray[12] = new Pokemon("Onix", "Rock/Ground", "Rock Throw", 35.0, 45.0, 160.0, 70.0);
        pokemonArray[13] = new Pokemon("Pidgey", "Normal/Flying", "Gust", 40.0, 45.0, 40.0, 56.0);
        pokemonArray[14] = new Pokemon("Rattata", "Normal", "Quick Attack", 30.0, 56.0, 35.0, 72.0);
        pokemonArray[15] = new Pokemon("Clefairy", "Normal/Fairy", "Sing", 70.0, 45.0, 48.0, 35.0);
        pokemonArray[16] = new Pokemon("Abra", "Psychic", "Teleport", 25.0, 20.0, 15.0, 90.0);
        pokemonArray[17] = new Pokemon("Diglett", "Ground", "Dig", 10.0, 55.0, 25.0, 95.0);
        pokemonArray[18] = new Pokemon("Nidoran", "Poison", "Poison Sting", 55.0, 47.0, 52.0, 41.0);
        pokemonArray[19] = new Pokemon("Vulpix", "Fire", "Ember", 38.0, 41.0, 40.0, 65.0);
        pokemonArray[20] = new Pokemon("Lucario", "Fighting/Steel", "Aura Sphere", 70.0, 110.0, 70.0, 90.0);

        Trainer player = new Trainer();
        player.enterName();
        
        System.out.println("");

        PokemonBattle pokemonBattle = new PokemonBattle();
        pokemonBattle.chooseStage();

		
        System.out.println("");
        
        System.out.println("You have encountered 3 wild pokemon!!!");

        System.out.println(".\n\n.\n\n.\n\n");
     
        //Spawning wild Pokemons
        PokemonCatch wp = new PokemonCatch(Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray));
        PokemonCatch.printPokemonDetails(wp.getWildPoke1(), wp.getWildPoke2(), wp.getWildPoke3());
        
        
        
        
        //Catch pokemon
        PokemonCatch c1 = new PokemonCatch();
        c1.catching(wp.getWildPoke1(), wp.getWildPoke2(), wp.getWildPoke3());
        
        
        
        
    }
    
    
    
    
    
}
