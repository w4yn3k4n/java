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
        while (true) {
        	try {
        System.out.println("Guess a number between 1 and 4:");
        userGuess = scanner.nextInt();
        boolean miniGameResult = userGuess == randomNumber;
        if(miniGameResult) {
        	System.out.println("Congratulations! You guessed correctly.");
        } 
        else {
        	System.out.println("Oops! You guessed incorrectly. The correct number was: " + randomNumber);
        }
        return miniGameResult;
        	}
        catch (java.util.InputMismatchException e) {
            System.out.println("Invalid Choice, enter a valid integer.");
            scanner.next(); 
        }
        }
    }
   
	public void setUserPokemons(Pokemon[] userPokemon) {

	}
	
	public static void MyTurnChoose (Pokemon pokemon1, Pokemon pokemon2, Pokemon oppoPoke, Pokemon oppoPoke2) {
		int pkchoice;
		Scanner scanner = new Scanner(System.in);
    	while(true) {
    	try {
    	System.out.println("");
    	System.out.println("Choose a pokemon to use. (1 or 2):");
    	pkchoice = scanner.nextInt();
    	if(pkchoice == 1 && pokemon1.getHp() > 0) {
    		PokemonBattle.myTurn(oppoPoke, oppoPoke2, pokemon1);
    		break;
    	}
    	else if (pkchoice == 1 && pokemon1.getHp() <= 0) {
    		System.out.println(pokemon1.getName()+ " has fainted");
    		System.out.println(" Choose another pokemon");
    	}
    	else if (pkchoice == 2 && pokemon2.getHp() > 0) {
    		PokemonBattle.myTurn(oppoPoke, oppoPoke2, pokemon2);
    		break;
    	}
    	else if (pkchoice == 2 && pokemon2.getHp() <= 0) {
    		System.out.println(pokemon2.getName()+ " has fainted");
    		System.out.println(" Choose another pokemon");
    	}

    	else {
    		System.out.println("Invalid Choice, choose again.");
    	}
    		}
    	catch(java.util.InputMismatchException e) {	
    		System.out.println("Invalid Choice, enter a valid integer.");
            scanner.next();
    	}
    	}
	}

	public static void OpponentTurnChoose (Pokemon pokemon1, Pokemon pokemon2, Pokemon oppoPoke, Pokemon oppoPoke2) {
		System.out.println("-------Opponent's turns to attack!-------");
        int twoOne = (Pokemon.generateOneTwo());
        if ((twoOne == 1) && (oppoPoke.getHp() > 0)) {
        	int oneTwo = (Pokemon.generateOneTwo());
        	if ((oneTwo == 1) && (pokemon1.getHp() > 0)) {
        		PokemonBattle.OppoTurn(oppoPoke, pokemon1);
        	}
        	else if ((oneTwo == 1) && (pokemon1.getHp() <= 0)){
        		PokemonBattle.OppoTurn(oppoPoke, pokemon2);
        	}
        	else if ((oneTwo == 2) && (pokemon2.getHp() > 0)){
        		PokemonBattle.OppoTurn(oppoPoke, pokemon2);
        	}
        	else {
        		PokemonBattle.OppoTurn(oppoPoke, pokemon1);
        	}
        }
 
        else if ((twoOne == 1) && (oppoPoke.getHp() <= 0)) {
        	int oneTwo = (Pokemon.generateOneTwo());
        	if ((oneTwo == 1) && (pokemon1.getHp() > 0)) {
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon1);
        	}
        	else if ((oneTwo == 1) && (pokemon1.getHp() <= 0)){
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon2);
        	}
        	else if ((oneTwo == 2) && (pokemon2.getHp() > 0)){
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon2);
        	}
        	else {
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon1);
        	}
        }
        else if ((twoOne == 2) && (oppoPoke2.getHp() > 0)) {
        	int oneTwo = (Pokemon.generateOneTwo());
        	if ((oneTwo == 1) && (pokemon1.getHp() > 0)) {
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon1);
        	}
        	else if ((oneTwo == 1) && (pokemon1.getHp() <= 0)){
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon2);
        	}
        	else if ((oneTwo == 2) && (pokemon2.getHp() > 0)){
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon2);
        	}
        	else {
        		PokemonBattle.OppoTurn(oppoPoke2, pokemon1);
        	}
        }
        else if ((twoOne == 2) && (oppoPoke2.getHp() <= 0)) {
        	int oneTwo = (Pokemon.generateOneTwo());
        	if ((oneTwo == 1) && (pokemon1.getHp() > 0)) {
        		PokemonBattle.OppoTurn(oppoPoke, pokemon1);
        	}
        	else if ((oneTwo == 1) && (pokemon1.getHp() <= 0)){
        		PokemonBattle.OppoTurn(oppoPoke, pokemon2);
        	}
        	else if ((oneTwo == 2) && (pokemon2.getHp() > 0)){
        		PokemonBattle.OppoTurn(oppoPoke, pokemon2);
        	}
        	else {
        		PokemonBattle.OppoTurn(oppoPoke, pokemon1);
        	}
        }
        else {
        	System.out.println("HUH?");
        }
	}

	public static void displayPokemonHealth(Pokemon op1, Pokemon op2) {
	    System.out.println("");
	    System.out.println("----------------------------------------------------------------------------------------");
	    System.out.println(op1.getName() + " has " + op1.getHp() + " HP remaining!");
	    System.out.println(op2.getName() + " has " + op2.getHp() + " HP remaining!");
	    System.out.println("----------------------------------------------------------------------------------------");
	    System.out.println("");	    
	}		
    
    // Method to determine effectiveness based on types
    static double determineEffectiveness(String attackerType, String defenderType) {
        // Default effectiveness
        double effectiveness = 1.0;

        // Super effective interactions
        if (attackerType.contains("Fire") && defenderType.contains("Grass") || 
        	attackerType.contains("Fire") && defenderType.contains("Ice") ||     
        	attackerType.contains("Fire") && defenderType.contains("Bug") ||   
        	attackerType.contains("Fire") && defenderType.contains("Steel") ||    
        	attackerType.contains("Water") && defenderType.contains("Fire") ||    
        	attackerType.contains("Water") && defenderType.contains("Ground") ||   
        	attackerType.contains("Water") && defenderType.contains("Rock") ||   
        	attackerType.contains("Grass") && defenderType.contains("Water") ||  
        	attackerType.contains("Grass") && defenderType.contains("Ground") ||   
        	attackerType.contains("Grass") && defenderType.contains("Rock") ||     
        	attackerType.contains("Electric") && defenderType.contains("Water") || 
        	attackerType.contains("Electric") && defenderType.contains("Flying") ||  
        	attackerType.contains("Ice") && defenderType.contains("Grass") ||    
        	attackerType.contains("Ice") && defenderType.contains("Ground") ||   
        	attackerType.contains("Ice") && defenderType.contains("Flying") ||   
        	attackerType.contains("Ice") && defenderType.contains("Dragon") ||  
        	attackerType.contains("Fighting") && defenderType.contains("Normal") || 
        	attackerType.contains("Fighting") && defenderType.contains("Ice") || 
        	attackerType.contains("Fighting") && defenderType.contains("Rock") ||
        	attackerType.contains("Fighting") && defenderType.contains("Dark") ||  
        	attackerType.contains("Fighting") && defenderType.contains("Steel") || 
        	attackerType.contains("Poison") && defenderType.contains("Fairy") || 
        	attackerType.contains("Poison") && defenderType.contains("Grass") ||   
        	attackerType.contains("Psychic") && defenderType.contains("Fighting") || 
        	attackerType.contains("Psychic") && defenderType.contains("Poison") ||   
        	attackerType.contains("Ground") && defenderType.contains("Rock") || 
        	attackerType.contains("Ground") && defenderType.contains("Fire") || 
        	attackerType.contains("Ground") && defenderType.contains("Electric") || 
        	attackerType.contains("Ground") && defenderType.contains("Poison") ||   
        	attackerType.contains("Ground") && defenderType.contains("Steel") ||  
        	attackerType.contains("Rock") && defenderType.contains("Flying") ||   
        	attackerType.contains("Rock") && defenderType.contains("Fire") ||   
        	attackerType.contains("Rock") && defenderType.contains("Ice") || 
        	attackerType.contains("Rock") && defenderType.contains("Bug") ||   
        	attackerType.contains("Flying") && defenderType.contains("Fighting") || 
        	attackerType.contains("Flying") && defenderType.contains("Grass") ||   
        	attackerType.contains("Flying") && defenderType.contains("Bug") ||    
        	attackerType.contains("Bug") && defenderType.contains("Grass") ||  
        	attackerType.contains("Bug") && defenderType.contains("Psychic") || 
        	attackerType.contains("Bug") && defenderType.contains("Dark") ||     
        	attackerType.contains("Ghost") && defenderType.contains("Ghost") || 
        	attackerType.contains("Ghost") && defenderType.contains("Psychic") || 
        	attackerType.contains("Dragon") && defenderType.contains("Dragon") ||
        	attackerType.contains("Dark") && defenderType.contains("Psychic") ||  
        	attackerType.contains("Dark") && defenderType.contains("Ghost") ||  
        	attackerType.contains("Steel") && defenderType.contains("Fairy") ||  
        	attackerType.contains("Steel") && defenderType.contains("Ice") ||  
        	attackerType.contains("Steel") && defenderType.contains("Rock") || 
        	attackerType.contains("Fairy") && defenderType.contains("Fighting") ||  
        	attackerType.contains("Fairy") && defenderType.contains("Dragon") || 
        	attackerType.contains("Fairy") && defenderType.contains("Dark")) {
        	effectiveness = 2.0;     
            System.out.println("Super Efective!!");
            
        }
        
        // Not very effective interactions
        else if ((defenderType.contains("Grass") && attackerType.contains("Water") ||
        		 defenderType.contains("Water") && attackerType.contains("Water") ||
        		 defenderType.contains("Dragon") && attackerType.contains("Water") ||
        		 defenderType.contains("Fire") && attackerType.contains("Fire") ||
        		 defenderType.contains("Water") && attackerType.contains("Fire") ||
        		 defenderType.contains("Rock") && attackerType.contains("Fire") ||
        		 defenderType.contains("Dragon") && attackerType.contains("Fire") ||
        		 defenderType.contains("Fire") && attackerType.contains("Grass") ||
        		 defenderType.contains("Grass") && attackerType.contains("Grass") ||
        		 defenderType.contains("Poison") && attackerType.contains("Grass") ||
        		 defenderType.contains("Flying") && attackerType.contains("Grass") ||
        		 defenderType.contains("Bug") && attackerType.contains("Grass") ||
        		 defenderType.contains("Dragon") && attackerType.contains("Grass") ||
        		 defenderType.contains("Steel") && attackerType.contains("Grass") ||
        		 defenderType.contains("Electric") && attackerType.contains("Electric") ||
        		 defenderType.contains("Grass") && attackerType.contains("Electric") ||
        		 defenderType.contains("Dragon") && attackerType.contains("Electric") ||
        		 defenderType.contains("Fire") && attackerType.contains("Ice") ||
        		 defenderType.contains("Water") && attackerType.contains("Ice") ||
        		 defenderType.contains("Ice") && attackerType.contains("Ice") ||
        		 defenderType.contains("Steel") && attackerType.contains("Ice") ||
        		 defenderType.contains("Poison") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Flying") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Psychic") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Bug") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Fairy") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Poison") && attackerType.contains("Poison") ||
        		 defenderType.contains("Ground") && attackerType.contains("Poison") ||
        		 defenderType.contains("Rock") && attackerType.contains("Poison") ||
        		 defenderType.contains("Ghost") && attackerType.contains("Poison") ||
        		 defenderType.contains("Grass") && attackerType.contains("Ground") ||
        		 defenderType.contains("Bug") && attackerType.contains("Ground") ||
        		 defenderType.contains("Electric") && attackerType.contains("Flying") ||
        		 defenderType.contains("Rock") && attackerType.contains("Flying") ||
        		 defenderType.contains("Steel") && attackerType.contains("Flying") ||
        		 defenderType.contains("Psychic") && attackerType.contains("Psychic") ||
        		 defenderType.contains("Steel") && attackerType.contains("Psychic") ||
        		 defenderType.contains("Fire") && attackerType.contains("Bug") ||
        		 defenderType.contains("Fighting") && attackerType.contains("Bug") ||
        		 defenderType.contains("Poison") && attackerType.contains("Bug") ||
        		 defenderType.contains("Flying") && attackerType.contains("Bug") ||
        		 defenderType.contains("Ghost") && attackerType.contains("Bug") ||
        		 defenderType.contains("Steel") && attackerType.contains("Bug") ||
        		 defenderType.contains("Fairy") && attackerType.contains("Bug") ||
        		 defenderType.contains("Rock") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Ground") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Steel") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Dark") && attackerType.contains("Fighting") ||
        		 defenderType.contains("Dark") && attackerType.contains("Dark") ||
        		 defenderType.contains("Fairy") && attackerType.contains("Dark") ||
        		 defenderType.contains("Fire") && attackerType.contains("Steel") ||
        		 defenderType.contains("Watter") && attackerType.contains("Steel") ||
        		 defenderType.contains("Electric") && attackerType.contains("Steel") ||
        		 defenderType.contains("Steel") && attackerType.contains("Steel") ||
        		 defenderType.contains("Fairy") && attackerType.contains("Fire") ||
        		 defenderType.contains("Poison") && attackerType.contains("Fire") ||
        		 defenderType.contains("Steel") && attackerType.contains("Fire") ||
        		 defenderType.contains("Dark") && attackerType.contains("Ghost") ||
        		 defenderType.contains("Steel") && attackerType.contains("Dragon") ||
        		 defenderType.contains("Rock") && attackerType.contains("Normal") ||
        		 defenderType.contains("Steel") && attackerType.contains("Normal")) ) {
        		     effectiveness = 0.5;
        		     System.out.println("Not very Effective");}
        
        // No effect interactions
        else if ((attackerType.contains("Electric") && defenderType.contains("Ground") ||
        		 attackerType.contains("Fighting") && defenderType.contains("Ghost") ||
        		 attackerType.contains("Poison") && defenderType.contains("Steel") ||
        		 attackerType.contains("Dark") && defenderType.contains("Psychic") ||
        		 attackerType.contains("Flying") && defenderType.contains("Ground") ||
        		 attackerType.contains("Normal") && defenderType.contains("Ghost") ||
        		 attackerType.contains("Dragon") && defenderType.contains("Fairy") || 
        		 attackerType.contains("Rock") && defenderType.contains("Normal"))){ 
        		effectiveness = 0.0; 
			System.out.println("No Effect");}
        
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

	public static void myTurn(Pokemon oppoPoke1, Pokemon oppoPoke2, Pokemon pk) {
        Scanner input = new Scanner(System.in);
        Pokemon.checkhp(oppoPoke1, oppoPoke2);
 
        while (true) {
            try {
            	double newhp;
            	double newhp2;
                System.out.println("Choose a pokemon to attack (1 or 2):");
                int opkchoice = input.nextInt();
 
                if (opkchoice == 1 && oppoPoke1.getHp() > 0) {
                	boolean miniGameResult = playMiniGame();
                	if (miniGameResult) {
                        System.out.println("Congratulations! You won the mini-game. Your attack damage increases!");
                        System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke1.getType());
	                    int playerDamage = (int) (30.0 * (pk.getAtk() / oppoPoke1.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp = Math.max(oppoPoke1.getHp() - playerDamage,0);
	                    oppoPoke1.setHp(newhp);
                    } 
                	else {
                    	System.out.println("You lost the mini-game. Proceeding with the attack.");
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke1.getType());
	                    int playerDamage = (int) (20.0 * (pk.getAtk() / oppoPoke1.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp = Math.max(oppoPoke1.getHp() - playerDamage,0);
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
	                    newhp2 = Math.max(oppoPoke2.getHp() - playerDamage,0);
	                    oppoPoke2.setHp(newhp2);
                	}
                	else {
                    	System.out.println("You lost the mini-game. Proceeding with the attack.");
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke2.getType());
	                    int playerDamage = (int) (20.0 * (pk.getAtk() / oppoPoke2.getDef()) * playerEffectiveness);
	                    System.out.println("ATTACK POWER: -" + playerDamage + " HP");
	                    newhp2 = Math.max(oppoPoke2.getHp() - playerDamage,0);
	                    oppoPoke2.setHp(newhp2);
                    }
                    break;
                } 
                else if (opkchoice == 1 && oppoPoke1.getHp() <= 0) {
                    System.out.println(oppoPoke1.getName()+" has already fainted\nChoose again");
                } 
                else if (opkchoice == 2 && oppoPoke2.getHp() <= 0) {
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
	public static void OppoTurn(Pokemon oppoPoke, Pokemon pk1) {
		double newhp;
		boolean miniGameResult = playMiniGame();
		if (miniGameResult) {
            System.out.println("Congratulations! You won the mini-game. Your defence stat temporary increases!");
	        System.out.println("\n" + oppoPoke.getName() + " attacks " + pk1.getName());
	        double opponentEffectiveness = PokemonBattle.determineEffectiveness(oppoPoke.getMoveType(), pk1.getType());
	        int opponentDamage = (int) (5.0 * (oppoPoke.getAtk() / pk1.getDef()) * opponentEffectiveness);
	        System.out.println("ATTACK POWER: -" + opponentDamage + " HP");
	        newhp = Math.max(pk1.getHp() - opponentDamage,0);
	        pk1.setHp(newhp);
		}
		else {
			System.out.println("Oops! You lost the mini-game. No increase in defence.");
	        System.out.println("\n" + oppoPoke.getName() + " attacks " + pk1.getName());
	        double opponentEffectiveness = PokemonBattle.determineEffectiveness(oppoPoke.getMoveType(), pk1.getType());
	        int opponentDamage = (int) (10.0 * (oppoPoke.getAtk() / pk1.getDef()) * opponentEffectiveness);
	        System.out.println("ATTACK POWER: -" + opponentDamage + " HP");
	        newhp = Math.max(pk1.getHp() - opponentDamage,0);
	        pk1.setHp(newhp);
		}
	}
	
	
}
