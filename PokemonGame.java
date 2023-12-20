package oopffinal;

import java.util.*;

public class PokemonGame {
    public static void main(String[] args) {
       
    	Pokemon[] pokemonArray = new Pokemon[58];

        
        pokemonArray[0] = new Pokemon("Charmander", "Fire", "Fire Blast", "Fire", 39.0, 52.0, 43.0, 65.0);
        pokemonArray[1] = new Pokemon("Squirtle", "Water", "Hydro Pump", "Water", 44.0, 48.0, 65.0, 43.0);
        pokemonArray[2] = new Pokemon("Bulbasaur", "Grass/Poison", "Vine Whip", "Grass",45.0, 49.0, 49.0, 45.0);
        pokemonArray[3] = new Pokemon("Pikachu", "Electric", "Thunderbolt", "Electric",35.0, 55.0, 40.0, 90.0);
        pokemonArray[4] = new Pokemon("Jigglypuff", "Normal/Fairy", "Sing", "Fairy",115.0, 45.0, 20.0, 20.0);
        pokemonArray[5] = new Pokemon("Geodude", "Rock/Ground", "Rock Throw", "Rock",40.0, 80.0, 100.0, 20.0);
        pokemonArray[6] = new Pokemon("Eevee", "Normal", "Quick Attack", "Normal",55.0, 55.0, 50.0, 55.0);
        pokemonArray[7] = new Pokemon("Gyarados", "Water/Flying", "Hydro Pump", "Water",95.0, 125.0, 79.0, 81.0);
        pokemonArray[8] = new Pokemon("Machop", "Fighting", "Karate Chop", "Fighting",70.0, 80.0, 50.0, 35.0);
        pokemonArray[9] = new Pokemon("Haunter", "Ghost/Poison", "Shadow Ball", "Ghost",45.0, 50.0, 45.0, 95.0);
        pokemonArray[10] = new Pokemon("Alakazam", "Psychic", "Psychic", "Psychic",55.0, 50.0, 45.0, 120.0);
        pokemonArray[11] = new Pokemon("Gengar", "Ghost/Poison", "Shadow Ball", "Ghost",60.0, 65.0, 60.0, 110.0);
        pokemonArray[12] = new Pokemon("Onix", "Rock/Ground", "Rock Throw", "Rock",35.0, 45.0, 160.0, 70.0);
        pokemonArray[13] = new Pokemon("Pidgey", "Normal/Flying", "Gust", "Flying", 40.0, 45.0, 40.0, 56.0);
        pokemonArray[14] = new Pokemon("Rattata", "Normal", "Quick Attack", "Normal", 30.0, 56.0, 35.0, 72.0);
        pokemonArray[15] = new Pokemon("Clefairy", "Normal/Fairy", "Sing", "Fairy", 70.0, 45.0, 48.0, 35.0);
        pokemonArray[16] = new Pokemon("Abra", "Psychic", "Teleport", "Psychic", 25.0, 20.0, 15.0, 90.0);
        pokemonArray[17] = new Pokemon("Diglett", "Ground", "Dig", "Ground", 10.0, 55.0, 25.0, 95.0);
        pokemonArray[18] = new Pokemon("Nidoran", "Poison", "Poison Sting", "Poison", 55.0, 47.0, 52.0, 41.0);
        pokemonArray[19] = new Pokemon("Vulpix", "Fire", "Ember", "Fire", 38.0, 41.0, 40.0, 65.0);
        pokemonArray[20] = new Pokemon("Lucario", "Fighting/Steel", "Aura Sphere", "Fighting", 70.0, 110.0, 70.0, 90.0);
        pokemonArray[21] = new Pokemon("Venusaur", "Grass/Poison", "Solar Beam", "Grass", 80.0, 82.0, 83.0, 80.0);
        pokemonArray[22] = new Pokemon("Charizard", "Fire/Flying", "Flamethrower", "Fire", 78.0, 84.0, 78.0, 100.0);
        pokemonArray[23] = new Pokemon("Snorlax", "Normal", "Hyper Beam", "Normal", 160.0, 110.0, 65.0, 30.0);
        pokemonArray[24] = new Pokemon("Dragonite", "Dragon/Flying", "Dragon Pulse", "Dragon", 91.0, 134.0, 95.0, 80.0);
        pokemonArray[25] = new Pokemon("Garchomp", "Dragon/Ground", "Dragon Claw", "Dragon", 108.0, 130.0, 95.0, 102.0);
        pokemonArray[26] = new Pokemon("Lapras", "Water/Ice", "Ice Beam", "Ice", 130.0, 85.0, 80.0, 60.0);
        pokemonArray[27] = new Pokemon("Arcanine", "Fire", "Flare Blitz", "Fire", 90.0, 110.0, 80.0, 95.0);
        pokemonArray[28] = new Pokemon("Machamp", "Fighting", "Dynamic Punch", "Fighting", 90.0, 130.0, 80.0, 55.0);
        pokemonArray[29] = new Pokemon("Jolteon", "Electric", "Thunderbolt", "Electric", 65.0, 65.0, 60.0, 130.0);
        pokemonArray[30] = new Pokemon("Golem", "Rock/Ground", "Earthquake", "Rock", 80.0, 120.0, 130.0, 45.0);
        pokemonArray[31] = new Pokemon("Lickitung", "Normal", "Hyper Beam", "Normal", 90.0, 55.0, 75.0, 30.0);
        pokemonArray[32] = new Pokemon("Electrode", "Electric", "Thunder", "Electric", 60.0, 50.0, 70.0, 140.0);
        pokemonArray[33] = new Pokemon("Ninetales", "Fire", "Fire Blast", "Fire", 73.0, 76.0, 75.0, 100.0);
        pokemonArray[34] = new Pokemon("Hitmonlee", "Fighting", "High Jump Kick", "Fighting", 50.0, 120.0, 53.0, 87.0);
        pokemonArray[35] = new Pokemon("Hitmonchan", "Fighting", "Thunder Punch", "Fighting", 50.0, 105.0, 79.0, 76.0);
        pokemonArray[36] = new Pokemon("Mr. Mime", "Psychic/Fairy", "Psychic", "Psychic", 40.0, 45.0, 65.0, 90.0);
        pokemonArray[37] = new Pokemon("Vileplume", "Grass/Poison", "Solar Beam", "Grass", 75.0, 80.0, 85.0, 50.0);
        pokemonArray[38] = new Pokemon("Magneton", "Electric/Steel", "Thunderbolt", "Electric", 50.0, 60.0, 95.0, 70.0);
        pokemonArray[39] = new Pokemon("Doduo", "Normal/Flying", "Drill Peck", "Flying", 35.0, 85.0, 45.0, 75.0);
        pokemonArray[40] = new Pokemon("Dewgong", "Water/Ice", "Aurora Beam", "Ice", 90.0, 70.0, 80.0, 70.0);
        pokemonArray[41] = new Pokemon("Cloyster", "Water/Ice", "Ice Beam", "Ice", 50.0, 95.0, 180.0, 70.0);
        pokemonArray[42] = new Pokemon("Pidgeot", "Normal/Flying", "Aerial Ace", "Flying", 83.0, 80.0, 75.0, 101.0);
        pokemonArray[43] = new Pokemon("Raticate", "Normal", "Hyper Fang", "Normal", 55.0, 81.0, 60.0, 97.0);
        pokemonArray[44] = new Pokemon("Clefable", "Normal/Fairy", "Moonblast", "Fairy", 95.0, 70.0, 73.0, 60.0);
        pokemonArray[45] = new Pokemon("Wigglytuff", "Normal/Fairy", "Dazzling Gleam", "Fairy", 140.0, 70.0, 45.0, 45.0);
        pokemonArray[46] = new Pokemon("Goldeen", "Water", "Waterfall", "Water", 45.0, 67.0, 60.0, 63.0);
        pokemonArray[47] = new Pokemon("Seaking", "Water", "Hydro Pump", "Water", 80.0, 92.0, 65.0, 68.0);
        pokemonArray[48] = new Pokemon("Staryu", "Water", "Swift", "Water", 30.0, 45.0, 55.0, 85.0);
        pokemonArray[49] = new Pokemon("Starmie", "Water/Psychic", "Psychic", "Psychic", 60.0, 75.0, 85.0, 115.0);
        pokemonArray[50] = new Pokemon("Jynx", "Ice/Psychic", "Ice Beam", "Ice", 65.0, 50.0, 35.0, 95.0);
        pokemonArray[51] = new Pokemon("Electabuzz", "Electric", "Thunder Punch", "Electric", 65.0, 83.0, 57.0, 105.0);
        pokemonArray[52] = new Pokemon("Magmar", "Fire", "Flamethrower", "Fire", 65.0, 95.0, 57.0, 93.0);
        pokemonArray[53] = new Pokemon("Pinsir", "Bug", "X-Scissor", "Bug", 65.0, 125.0, 100.0, 85.0);
        pokemonArray[54] = new Pokemon("Tauros", "Normal", "Thrash", "Normal", 75.0, 100.0, 95.0, 110.0);
        pokemonArray[55] = new Pokemon("Gyarados", "Water/Flying", "Aqua Tail", "Water", 95.0, 125.0, 79.0, 81.0);
        pokemonArray[56] = new Pokemon("Lapras", "Water/Ice", "Ice Beam", "Ice", 130.0, 85.0, 80.0, 60.0);
        pokemonArray[57] = new Pokemon("Ditto", "Normal", "Transform", "Normal", 48.0, 48.0, 48.0, 48.0);
        

        Scanner scanner = new Scanner(System.in);

        Trainer player = new Trainer();     
        System.out.println("Enter your name Trainer: ");
        String enteredName = scanner.nextLine();    
        player.setName(enteredName);
        System.out.println(""); 
        System.out.println("Welcome Trainer " + player.getName());
        System.out.println("");
        PokemonBattle pokemonBattle = new PokemonBattle();
        Ball trainer = new Ball();
        trainer.setPlayer(player);
        
        
        
        String chosenStage;// Assuming user inputs "forest" or "cave" or "mountain"  
        Stage currentStage = null; // Declare currentStage=null (to match the user chosen stage)


        while (true) {
        	System.out.println("Choose a stage (Forest / Cave / Mountain):");
             chosenStage = scanner.nextLine().toLowerCase();
            if (chosenStage.equals("forest")) {
                currentStage = new ForestStage(pokemonArray);
                break;
            } else if (chosenStage.equals("cave")) {
                currentStage = new CaveStage(pokemonArray);
                break;
            } else if (chosenStage.equals("mountain")) {
                currentStage = new MountainStage(pokemonArray);
                break;
            } else {
                System.out.println("Invalid stage choice. Please choose from Forest, Cave, or Mountain.");
            }
        }

        currentStage.chooseStage(); // Display available Pokémon in the chosen stage
        
        
		
        System.out.println("");
        
        System.out.println("You have encountered 3 wild pokemon!!!");

        System.out.println(".\n\n.\n\n.\n\n");
     
        //Spawning wild Pokemons
        PokemonCatch wp = new PokemonCatch(Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray), Pokemon.getRandomPokemonCatch(pokemonArray));
        PokemonCatch.printPokemonDetails(wp.getWildPoke1(), wp.getWildPoke2(), wp.getWildPoke3());
        
        
        System.out.println("\nChoose A pokemon to catch!\n");
		System.out.println("Enter 1, 2, or 3\n");
		System.out.println("1. " + wp.getWildPoke1().getName()+"\n");
		System.out.println("2. " + wp.getWildPoke2().getName()+"\n");
		System.out.println("3. " + wp.getWildPoke3().getName()+"\n");
		System.out.println("Enter -> ");
		
		int Choice;
		
		while (true) {
            try {
                Choice = Integer.parseInt(scanner.nextLine());
                if (Choice >= 1 && Choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
		
		switch (Choice) {
        case 1:
            player.catchPokemon(wp.getWildPoke1());
            break;
        case 2:
        	player.catchPokemon(wp.getWildPoke2());
            break;
        case 3:
        	player.catchPokemon(wp.getWildPoke3());
            break;
    }
		
        
        System.out.println(".\n\n.\n\n.\n\n");
        
        while (true) {
            System.out.println("Enter \"Roar\" to roar and attract Pokemon!");

            String roar = scanner.nextLine();

            if ("Roar".equalsIgnoreCase(roar)) {
                String lastCaughtPokemon = player.lastCaughtPokemonName();
                System.out.println(lastCaughtPokemon + " roared loudly! Wild Pokemon are approaching...");

                break; 
            } else {
                
            }
        
        }
        
        PokemonBattle op = new PokemonBattle();
        
        op.setOppoPoke1(currentStage.chooseOpponentPokemon());
        op.setOppoPoke2(Pokemon.getRandomPokemonCatch(pokemonArray));
        
        
        System.out.println("");
        System.out.println("\n--------------------------------------\n");
        System.out.println(op.getOppoPoke1().getName() + " appeared");
        System.out.println(op.getOppoPoke2().getName() + " appeared");
        System.out.println("\n--------------------------------------\n");
        
       	System.out.println("");
        player.displayCaughtPokemons();
        while (player.getCaughtPokemons().size() < 2) {
            System.out.println("You need at least 2 Pokémon to start a battle.");
            while (player.getCaughtPokemons().size() < 2) {         
                while (true) {      	
                System.out.println("Borrow a Pokémon from the game? (yes/no):"); 
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("yes")) {
                    System.out.println("Giving you a random pokemon in\n3.\n2.\n1.\n:");
                	player.catchPokemon(Pokemon.getRandomPokemonCatch(pokemonArray));  
                	break;
                }
                else if(ans.equalsIgnoreCase("no")) {
                    System.out.println("\nYou can't play without 2 pokemon!");
                    
                }
                
                else {
                	System.out.println("Invalid answer!");
                }
                
                }
            }
        }

        int choice1 = 0, choice2 = 0;
        
       
        System.out.println("Choose your pokemon to battle");
        player.displayCaughtPokemons();
 
        
       
        while (!(choice1 >= 1 && choice1 <= player.getCaughtPokemons().size()
                && choice2 >= 1 && choice2 <= player.getCaughtPokemons().size()
                && choice1 != choice2)) {
        try {
            System.out.println("Choose 2 Pokémon for battle (enter the corresponding numbers):");
            choice1 = scanner.nextInt();
            choice2 = scanner.nextInt();

            // Validate choices
            if (!(choice1 >= 1 && choice1 <= player.getCaughtPokemons().size()
                    && choice2 >= 1 && choice2 <= player.getCaughtPokemons().size()
                    && choice1 != choice2)) {
                System.out.println("Invalid choices. Please choose different Pokémon for battle.");
            }

        }	
        catch (InputMismatchException e) {
            System.out.println("Invalid Choice, enter a valid integer.");
            scanner.next(); // consume the invalid input to avoid an infinite loop
        }
        }

        Pokemon pokemon1 = player.getCaughtPokemons().get(choice1 - 1);
        Pokemon pokemon2 = player.getCaughtPokemons().get(choice2 - 1);


        System.out.println("You have sent out " + pokemon1.getName() + " and " + pokemon2.getName()+" to battle!");        
        System.out.println(".\n\n.\n\n.\n\n");      
        System.out.println("\n----------Battle Start!----------\n");     
        System.out.println("");   
        scanner.nextLine();  
        while(true) { 
        System.out.println("Choose Heads or Tails: ");
        String coinSide = scanner.nextLine();
        String coinResult = Pokemon.flipCoin();
        

        boolean isPlayerWinner = false;
        	
        if(!coinSide.equalsIgnoreCase("Heads") && !coinSide.equalsIgnoreCase("Tails")){
        	System.out.println("Invalid Choice, choose again.");
        }
        	
        	
        	
        else if (coinSide.equalsIgnoreCase(coinResult)) {
        	System.out.println("");
        	System.out.println("-------YOU START!-------");
        	System.out.println("");
        	while(true) {
	        	System.out.println("-------Your turn to attack!-------");
	        	Pokemon.checkhp(pokemon1, pokemon2);
	        	

	        	PokemonBattle mt = new PokemonBattle();
	        	mt.MyTurnChoose(pokemon1, pokemon2, op.getOppoPoke1(), op.getOppoPoke2());
	        	
	       
            
            if ((op.getOppoPoke1().getHp() <= 0) && (op.getOppoPoke2().getHp() <= 0)) {
            	PokemonBattle.displayPokemonHealth(op.getOppoPoke1(), op.getOppoPoke2());
                System.out.println("You defeated " + op.getOppoPoke1().getName() + " and "+ op.getOppoPoke2().getName());
                System.out.println("----------Battle End-----------");
                isPlayerWinner=true;
                break;
            } 
            
            
            else {
            	PokemonBattle.displayPokemonHealth(op.getOppoPoke1(), op.getOppoPoke2());
            }
            
        
            PokemonBattle ot = new PokemonBattle();
            ot.OpponentTurnChoose(pokemon1, pokemon2, op.getOppoPoke1(), op.getOppoPoke2());
            
            
            
            if (pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0) {
                System.out.println("You are defeated......");
                PokemonBattle.displayPokemonHealth(pokemon1, pokemon2);
                System.out.println("----------Battle End-----------");
                isPlayerWinner=false;
                break;
            } 
            else {
            	PokemonBattle.displayPokemonHealth(pokemon1, pokemon2);
            }
            
        	}
        	if (isPlayerWinner) {
        		Ball.generateMysteryBalls(true,op.getOppoPoke1(), op.getOppoPoke2()); // Pass true for player wins

        	} else {
        		Ball.generateMysteryBalls(false,op.getOppoPoke1(), op.getOppoPoke2()); // Pass false for player loses
        	}        	
        	break;
        }
        
        
        else if (!coinSide.equalsIgnoreCase(coinResult)) {
        	System.out.println("");
        	System.out.println("-------OPPONENT START!-------");
        	System.out.println("");
        	while(true) {
        		
        		
        		PokemonBattle ot = new PokemonBattle();
                ot.OpponentTurnChoose(pokemon1, pokemon2, op.getOppoPoke1(), op.getOppoPoke2());


                if (pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0) {
                	PokemonBattle.displayPokemonHealth(pokemon1, pokemon2);
                    System.out.println("You are defeated......");
                    System.out.println("----------Battle End-----------");
                    isPlayerWinner=false;
                    break;
                } 
                else {
                	PokemonBattle.displayPokemonHealth(pokemon1, pokemon2);
                }
            
            
            System.out.println("-------Your turn to attack!-------");
            Pokemon.checkhp(pokemon1, pokemon2);
        	
            PokemonBattle mt = new PokemonBattle();
        	mt.MyTurnChoose(pokemon1, pokemon2, op.getOppoPoke1(), op.getOppoPoke2());

        	if ((op.getOppoPoke1().getHp() <= 0) && (op.getOppoPoke2().getHp() <= 0)) {
        		PokemonBattle.displayPokemonHealth(op.getOppoPoke1(), op.getOppoPoke2());
                System.out.println("You defeated " + op.getOppoPoke1().getName() + " and "+ op.getOppoPoke2().getName());
                System.out.println("----------Battle End-----------");
                isPlayerWinner = true;
                break;
            } 
            
            
            else {
            	PokemonBattle.displayPokemonHealth(op.getOppoPoke1(), op.getOppoPoke2());

            }
        }
        	if (isPlayerWinner) {
        		Ball.generateMysteryBalls(true,op.getOppoPoke1(), op.getOppoPoke2()); // Pass true for player wins

        	} else {
        		Ball.generateMysteryBalls(false,op.getOppoPoke1(), op.getOppoPoke2()); // Pass false for player loses
        	}
        	break;
        }
        else {
        	System.out.println("Invalid side!");
        }
        }

        pokemonBattle.setOppoPoke1(pokemon1);
        pokemonBattle.setOppoPoke2(pokemon2);
        
        player.displayCaughtPokemons();
       
        PokemonBattle points = new PokemonBattle();
       int battleScore = pokemonBattle.calculateBattleScore(player.getCaughtPokemons().size());
       System.out.println("\nBattle Score: " + battleScore);
       
       pokemonBattle.displayTopScores();
       
    }
}
