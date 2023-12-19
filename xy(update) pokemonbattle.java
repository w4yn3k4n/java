package oopffinal;

import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    private Pokemon oppoPoke1;
    private Pokemon oppoPoke2;
    private String stage;
    private static Scanner scanner1;
    private Scanner scanner;
    public String player_command;
    private Random random;
    
    // constructors
    public PokemonBattle(Pokemon oppoPoke1, Pokemon oppoPoke2) {
        this.oppoPoke1 = oppoPoke1;
        this.oppoPoke2 = oppoPoke2;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public PokemonBattle(String stage) {
		this.stage = stage;
		this.scanner = new Scanner(System.in);
        this.random = new Random();
		
	}
    
    public PokemonBattle() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    

    //set get
    public Pokemon getOppoPoke1() {
        return oppoPoke1;
    }

    public Pokemon getOppoPoke2() {
        return oppoPoke2;
    }

	public String getStage() {
        return stage;
    }

	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	//method for getting pokemon details during battle
	public static void printPokemonDetails(Pokemon oppoPoke1, Pokemon oppoPoke2) {
        System.out.println("Opponent Pokemon 1 Details:");
        System.out.println("Name: " + oppoPoke1.getName());
        System.out.println("Type: " + oppoPoke1.getType());
        System.out.println("Move Type: " + oppoPoke1.getMoveType());
        System.out.println("HP: " + oppoPoke1.getHp());
        System.out.println("Attack: " + oppoPoke1.getAtk());
        System.out.println("Defense: " + oppoPoke1.getDef());
        System.out.println("Speed: " + oppoPoke1.getSpd());

        System.out.println("\nOpponent Pokemon 2 Details:");
        System.out.println("Name: " + oppoPoke2.getName());
        System.out.println("Type: " + oppoPoke2.getType());
        System.out.println("Move Type: " + oppoPoke2.getMoveType());
        System.out.println("HP: " + oppoPoke2.getHp());
        System.out.println("Attack: " + oppoPoke2.getAtk());
        System.out.println("Defense: " + oppoPoke2.getDef());
        System.out.println("Speed: " + oppoPoke2.getSpd());
    }

    //method for generating pokemon during battle
    public static Pokemon getRandomPokemonBattle(Pokemon[] pokemonArray, String stage) {
        Random random = new Random();
        int randomIndex = random.nextInt(pokemonArray.length);
        return pokemonArray[randomIndex];
    }
    


    
    public static boolean playMiniGame() {
    	Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userGuess;
        int randomNumber = random.nextInt(4) + 1;
        System.out.println("Welcome to the mini-game! Let's see if you can win and boost your stats!");
        System.out.println("Guess a number between 1 and 4:");
        userGuess = scanner.nextInt();
        
        boolean miniGameResult = userGuess == randomNumber;
        
        if(miniGameResult) {
        	System.out.println("Congratulations! You guessed correctly.");
        } else {
        	System.out.println("Oops! You guessed incorrectly. The correct number was: " + randomNumber);
        }
        return miniGameResult;
    }
    

    
	public void setUserPokemons(Pokemon[] userPokemon) {

	}
    
    // Method to determine effectiveness based on types
    static double determineEffectiveness(String attackerType, String defenderType) {
        // Default effectiveness
        double effectiveness = 1.0;

        // Super effective interactions
        if (attackerType.equals("Fire") && defenderType.contains("Grass") ||
            attackerType.equals("Water") && defenderType.contains("Fire") ||
            attackerType.equals("Electric") && defenderType.contains("Water") ||
            attackerType.equals("Poison") && defenderType.contains("Fairy") ||
            attackerType.equals("Rock") && defenderType.contains("Flying") ||
            attackerType.equals("Ground") && defenderType.contains("Rock") ||
            attackerType.equals("Flying") && defenderType.contains("Fighting") ||
        	attackerType.equals("Ghost") && (defenderType.contains("Psychic"))) {
            effectiveness = 2.0;
            System.out.println("Super Efective!!");
        }
        
        // Not very effective interactions
        else if (attackerType.equals("Water") && defenderType.contains("Grass") ||
                 attackerType.equals("Grass") && defenderType.contains("Water") ||
                 attackerType.equals("Fairy") && defenderType.contains("Poison") ||
                 attackerType.equals("Flying") && defenderType.contains("Electric") ||
                 attackerType.equals("Electric") && defenderType.contains("Rock") ||
                 attackerType.equals("Fighting") && defenderType.contains("Flying")) {
            effectiveness = 0.5;
            System.out.println("Not very Efective.");
        }
        
        // No effect interactions
        else if (attackerType.equals("Normal") && defenderType.contains("Ghost") ||
                 attackerType.equals("Electric") && defenderType.contains("Ground") ||
                 attackerType.equals("Ground") && defenderType.contains("Flying")) {
            effectiveness = 0.0;
            System.out.println("No Effect");
        }
        
        else {
        	System.out.println("Effective");
        }
        return effectiveness;
    }
    
    private void displayPokemonDetails(Pokemon pokemon) {
        System.out.println("Type: " + pokemon.getType());
        System.out.println("Move Type: " + pokemon.getMoveType());
        System.out.println("HP: " + pokemon.getHp());
        System.out.println("Attack: " + pokemon.getAtk());
        System.out.println("Defense: " + pokemon.getDef());
        System.out.println("Speed: " + pokemon.getSpd());
    }

	public void setOppoPoke1(Pokemon chooseOpponentPokemon) {
		this.oppoPoke1 = chooseOpponentPokemon;
	}

	public void setOppoPoke2(Pokemon chooseOpponentPokemon) {
		this.oppoPoke2 = chooseOpponentPokemon;
	}

	public static void myTurn(double newhp, double newhp2, Pokemon oppoPoke1, Pokemon oppoPoke2, Pokemon pk) {
        Scanner input = new Scanner(System.in);
        PokemonBattle.printPokemonDetails(oppoPoke1, oppoPoke2);

        while (true) {
            try {
                System.out.println("Choose a pokemon to damage (1 or 2):");
                int opkchoice = input.nextInt();

                if (opkchoice == 1 && oppoPoke1.getHp() > 0) {
                	boolean miniGameResult = playMiniGame();
                	if (miniGameResult) {
                        System.out.println("Congratulations! You won the mini-game. Your attack damage increases!");
                        System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke1.getType());
	                    int playerDamage = (int) (30.0 * (pk.getAtk() / oppoPoke1.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp = oppoPoke1.getHp() - playerDamage;
	                    oppoPoke1.setHp(newhp);
                    
                    } 
                	else {
                    	System.out.println("Oops! You lost the mini-game. Proceeding with the attack.");
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke1.getType());
	                    int playerDamage = (int) (20.0 * (pk.getAtk() / oppoPoke1.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp = oppoPoke1.getHp() - playerDamage;
	                    oppoPoke1.setHp(newhp);
                    }
                    
                    break;
                } 
                else if (opkchoice == 2 && oppoPoke2.getHp() > 0) {
                	boolean miniGameResult = playMiniGame();
                	if (miniGameResult) {
                        System.out.println("Congratulations! You won the mini-game. Your attack stat temporary increases!");
	                    System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
	                    double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke2.getType());
	                    int playerDamage = (int) (30.0 * (pk.getAtk() / oppoPoke2.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp2 = oppoPoke2.getHp() - playerDamage;
	                    oppoPoke2.setHp(newhp2);
                	}
                	else {
                    	System.out.println("Oops! You lost the mini-game. Proceeding with the attack.");
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke2.getType());
	                    int playerDamage = (int) (20.0 * (pk.getAtk() / oppoPoke2.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp = oppoPoke2.getHp() - playerDamage;
	                    oppoPoke2.setHp(newhp);
                    }
                    break;
                } 
                else if (opkchoice == 1 && oppoPoke1.getHp() < 0) {
                    System.out.println(oppoPoke1.getName()+" has already fainted\nChoose again");
                } 
                else if (opkchoice == 2 && oppoPoke2.getHp() < 0) {
                	System.out.println(oppoPoke2.getName()+" has already fainted\nChoose again");
                } 
                else {
                    System.out.println("Invalid Choice, choose again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid Choice, enter a valid integer.");
                input.next(); 
            }
        }
        
    }
	
	
	
	public static void OppoTurn(double newhp,Pokemon oppoPoke, Pokemon pk1) {
		System.out.println("\n" + oppoPoke.getName() + " attacks!\n" + pk1.getName());
		boolean miniGameResult = playMiniGame();
		if (miniGameResult) {
            System.out.println("Congratulations! You won the mini-game. Your defence stat temporary increases!");
	        double opponentEffectiveness = PokemonBattle.determineEffectiveness(oppoPoke.getMoveType(), pk1.getType());
	        int opponentDamage = (int) (5.0 * (oppoPoke.getAtk() / pk1.getDef()) * opponentEffectiveness);
	        System.out.println("ATTACK POWER: -" + opponentDamage + " HP");
	        newhp = pk1.getHp() - opponentDamage;
	        pk1.setHp(newhp);
		}
		else {
			System.out.println("Oops! You lost the mini-game. No increase in defence.");
	        double opponentEffectiveness = PokemonBattle.determineEffectiveness(oppoPoke.getMoveType(), pk1.getType());
	        int opponentDamage = (int) (10.0 * (oppoPoke.getAtk() / pk1.getDef()) * opponentEffectiveness);
	        System.out.println("ATTACK POWER: -" + opponentDamage + " HP");
	        newhp = pk1.getHp() - opponentDamage;
	        pk1.setHp(newhp);
		}
	}
	public static int awardPokeballs(boolean playerWins, Pokemon pokemon1, Pokemon pokemon2) {
        int pokeballsWon;
        if (playerWins) {
            pokeballsWon = 2; // If the player wins, award 2 pokeballs
            System.out.println("Congratulations! You win the battle and you get 2 mystery Poké Balls!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nDo you want to reveal the pokeball? (yes/no) \nYou will lose your chance to catch pokemon, once you had enter [NO] :(");
            String reveal = scanner.nextLine();
            if (reveal.equalsIgnoreCase("yes")) {
                revealPokeball(); // Call method to reveal pokeball
            } else {
            	System.out.println("Maybe next time !");
            	System.out.println("\nShow BATTLE RESULTS...");
            }
            // Now, if the user wants to reveal the pokeball, call revealPokeball() method
        } else {
            pokeballsWon = 1; // If the player loses, award 1 pokeball
            System.out.println("Oh no... You lost the battle but obtained 1 mystery Poké Ball!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nDo you want to reveal the pokeball? You will lose your chance to catch pokemon, once you had enter [NO] (yes/no)");
            String reveal = scanner.nextLine();
            if (reveal.equalsIgnoreCase("yes")) {
                revealPokeball(); // Call method to reveal pokeball
            	System.out.println("\nShow BATTLE RESULTS...");

            } else {
            	System.out.println("Maybe next time !");
            	System.out.println("\nShow BATTLE RESULTS...");
            }
        }
        return pokeballsWon;
    }
    
    private static void revealPokeball() {
    	System.out.println("\nLet's discover which kind of Poké Ball you'll receive...\n . \n . \n . \nGatcha! \n ");
        Random random = new Random();
        int pokeballNumber = random.nextInt(3) + 1; // Randomly select a pokeball number between 1 and 5

        // Simulating the reveal of the pokeball and its associated category
        switch (pokeballNumber) {
	        case 1:
	            System.out.println("You revealed a {Pokeball} !");
	            //catchCommonPokemon(pokemon);
	            break;
	        case 2:
	            System.out.println("You revealed a {Great Ball} !");
	            //catchUncommonPokemon(pokemon);
	            break;
	        case 3:
	            System.out.println("You revealed an {Ultra Ball} !");
	            //catchRarePokemon(pokemon);
	            break;
            default:
                System.out.println("Oops! Something went wrong while revealing the pokeball.");
                break;
        }
    }
	
}
