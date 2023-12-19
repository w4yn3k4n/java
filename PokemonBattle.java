import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    private Pokemon oppoPoke1;
    private Pokemon oppoPoke2;
    private String stage;
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
    


    public void startBattle(Pokemon playerPoke, Pokemon opponentPoke) {
        System.out.println("\n----------Battle Start!----------\n");
        System.out.println("Player sends out " + playerPoke.getName() + "!\n");
        displayPokemonDetails(playerPoke);
        System.out.println("\nOpponent sends out " + opponentPoke.getName() + "!\n");
        displayPokemonDetails(opponentPoke);
        
       
        while (true) {
            // Player's turn to attack
            System.out.println("\n-------Your turns!-------");
            System.out.println("\nGo, " + playerPoke.getName() + "!\n");
            
            System.out.println("Enter '1' to attack or '2' to defend:");
            String player_command = "";
            while (!(player_command.equals("1") || player_command.equals("2"))) {
            	 player_command = scanner.next();
            }
           
            //player attack
            if(player_command.equals("1")) {
            	   boolean miniGameResult = playMiniGame();
            	   int playerDamage = calculateRandomDamage(playerPoke.getAtk(), 0.5, 0.8, determineEffectiveness(playerPoke.getType(), opponentPoke.getType()));
            	    
                   if (miniGameResult) {
                       System.out.println("Congratulations! You won the mini-game. Your attack damage increases!");
                       int increasedAttack = increaseAttackDamage(playerDamage);
                       performPlayerAttack(playerPoke, opponentPoke, increasedAttack);
                   } else {
                   	System.out.println("Oops! You lost the mini-game. Proceeding with the attack.");
                    performPlayerAttack(playerPoke, opponentPoke,0);
                   }
                  
            }
            else if(player_command.equals("2")) {
            	 boolean miniGameResult = playMiniGame();
            	 int opponentDamage = calculateRandomDamage(opponentPoke.getAtk(), 0.2, 0.5,determineEffectiveness(opponentPoke.getType(), playerPoke.getType()));
            	
            	 
            	 if(miniGameResult) {
            		 System.out.println("Congratulations! You won the mini-game. Your defense increases!");
            		 int increasedDefense = increaseDefense(opponentDamage);
            		 performPlayerDefend(playerPoke, opponentPoke,increasedDefense);		 
            	 }else {
            		 System.out.println("Oops! You lost the mini-game. Proceeding with the defend.");
            		 performPlayerDefend(playerPoke, opponentPoke,0);	
            	 }
            }
            
            if (opponentPoke.getHp() <= 0) {
                System.out.println( opponentPoke.getName() +" is fainted...!");
                System.out.println("\n\n----------Battle End-----------");
                break;
            }
            
            if (!player_command.equals("2")) {
                System.out.println("\n-------Opponent's turns!-------");
                System.out.println("\n" + opponentPoke.getName() + " attacks!\n");

                performOpponentAttack(playerPoke, opponentPoke);

                // Check if player is defeated
                if (playerPoke.getHp() <= 0) {
                	System.out.println(playerPoke.getName() + "is fainted...!");
                    System.out.println("You are defeated......");
                    System.out.println("----------Battle End-----------");
                    break;
                }  
            }
        }
    }
    
	//Random damage
    private int calculateRandomDamage(double damage, double minMultiplier, double maxMultiplier, double effectiveness) {
        Random random = new Random();
        double randomMultiplier = minMultiplier + (maxMultiplier - minMultiplier) * random.nextDouble();
        return (int) (damage * randomMultiplier * effectiveness);
    }
    
    private void performPlayerAttack(Pokemon playerPoke, Pokemon opponentPoke,int increasedAttack ) {
        double playerEffectiveness = determineEffectiveness(playerPoke.getType(), opponentPoke.getType());
        int playerDamage = calculateRandomDamage(playerPoke.getAtk(), 0.5, 0.8, playerEffectiveness);

        if (increasedAttack > 0) {
            System.out.println("Increased Attack Power: -" + (int) increasedAttack + " HP");

            // Update opponent's HP again using the increased attack value
            double newOpponentHpWithIncreasedAttack = Math.max(opponentPoke.getHp() - increasedAttack, 0);
            opponentPoke.setHp(newOpponentHpWithIncreasedAttack);

            System.out.println(opponentPoke.getName() + " has " + opponentPoke.getHp() + " HP remaining!");
        }
        else {
        	System.out.println("ATTACK POWER: -" + playerDamage + " HP");
            
            // Update opponent's HP after player's attack
            double newOpponentHp =Math.max(opponentPoke.getHp() - playerDamage,0);
            opponentPoke.setHp(newOpponentHp);

            System.out.println(opponentPoke.getName() + " has " + opponentPoke.getHp() + " HP remaining!");
        }
    }

    private void performPlayerDefend(Pokemon playerPoke, Pokemon opponentPoke,int increasedDefense) {
        double opponentEffectiveness = determineEffectiveness(opponentPoke.getType(), playerPoke.getType());
        int opponentDamage = calculateDamage(opponentPoke, playerPoke, opponentEffectiveness);
        
        if(increasedDefense > 0) {
        	System.out.println("Attack Power: -" + (int) increasedDefense + "HP");
        	
        	double newPlayerHpWithIncreasedDefense = Math.max(playerPoke.getHp() - increasedDefense, 0);
            playerPoke.setHp(newPlayerHpWithIncreasedDefense);
        }
        
        else {
        	opponentDamage = (int) (opponentDamage * 0.5);
            
            System.out.println(playerPoke.getName() + " defends!");

            // Display opponent's attack
            System.out.println("\n-------Opponent's turns!-------");
            System.out.println("\n" + opponentPoke.getName() + " attacks!\n");
            System.out.println("ATTACK POWER: -" + opponentDamage + " HP");

            playerPoke.setHp(playerPoke.getHp() - opponentDamage);
        }

        System.out.println(playerPoke.getName() + " defends and has " + playerPoke.getHp() + " HP remaining!");
    }

    private void performOpponentAttack(Pokemon playerPoke, Pokemon opponentPoke) {
        double opponentEffectiveness = determineEffectiveness(opponentPoke.getType(), playerPoke.getType());
        int opponentDamage = calculateRandomDamage(opponentPoke.getAtk(), 0.2, 0.5, opponentEffectiveness);

        System.out.println("ATTACK POWER: -" + opponentDamage + " HP");
        // Update player's HP after opponent's attack
        double newPlayerHp = Math.max(playerPoke.getHp() - opponentDamage, 0); // Ensure HP is not negative
        playerPoke.setHp(newPlayerHp);

        System.out.println(playerPoke.getName() + " has " + playerPoke.getHp() + " HP remaining!");
    }

    private int calculateDamage(Pokemon attacker, Pokemon defender, double effectiveness) {
        return (int) (15.0 * (attacker.getAtk() / defender.getDef()) * effectiveness);
    }
    
    public boolean playMiniGame() {
      
        Random random = new Random();
        int userGuess;
        int randomNumber = random.nextInt(4) + 1;
        System.out.println("Welcome to the mini-game! Let's see if you can win and boost your attack damage!");
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
    
    private int increaseAttackDamage(int playerDamage) {
    	double increasedAttack = playerDamage * 2; 
    	return (int) increasedAttack;
    }
    
    private int increaseDefense(int opponentDamage) {
    	double increasedDefense = opponentDamage * 0.3;
    	return (int) increasedDefense;
    }
    
	public void setUserPokemons(Pokemon[] userPokemon) {

	}
    
    
    // Method to determine effectiveness based on types
    private double determineEffectiveness(String attackerType, String defenderType) {
        // Default effectiveness
        double effectiveness = 1.0;

        // Super effective interactions
        if (attackerType.equals("Fire") && defenderType.equals("Grass") ||
            attackerType.equals("Water") && defenderType.equals("Fire") ||
            attackerType.equals("Electric") && defenderType.equals("Water") ||
            attackerType.equals("Poison") && defenderType.equals("Fairy") ||
            attackerType.equals("Rock") && defenderType.equals("Flying") ||
            attackerType.equals("Ground") && defenderType.equals("Rock") ||
            attackerType.equals("Flying") && defenderType.equals("Fighting")) {
            effectiveness = 2.0;
        }
        
        // Not very effective interactions
        else if (attackerType.equals("Water") && defenderType.equals("Grass") ||
                 attackerType.equals("Grass") && defenderType.equals("Water") ||
                 attackerType.equals("Fairy") && defenderType.equals("Poison") ||
                 attackerType.equals("Flying") && defenderType.equals("Electric") ||
                 attackerType.equals("Electric") && defenderType.equals("Rock") ||
                 attackerType.equals("Fighting") && defenderType.equals("Flying")) {
            effectiveness = 0.5;
        }
        
        // No effect interactions
        else if (attackerType.equals("Normal") && defenderType.equals("Ghost") ||
                 attackerType.equals("Electric") && defenderType.equals("Ground") ||
                 attackerType.equals("Ground") && defenderType.equals("Flying")) {
            effectiveness = 0.0;
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

    // Other methods related to PokemonBattle can be added here
}
