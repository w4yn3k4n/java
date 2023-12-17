import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    private Pokemon oppoPoke1;
    private Pokemon oppoPoke2;
    private Pokemon userPoke1;
    private Pokemon userPoke2;
    private String stage;
    private Scanner scanner;
    private Random random;
    
    
    // constructors
    public PokemonBattle(Pokemon oppoPoke1, Pokemon oppoPoke2, Pokemon userPoke1, Pokemon userPoke2) {
        this.oppoPoke1 = oppoPoke1;
        this.oppoPoke2 = oppoPoke2;
        this.userPoke1 = userPoke1;
        this.userPoke2 = userPoke2;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public PokemonBattle(String stage) {
		this.stage = stage;
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
    
    public void setOppoPoke1(Pokemon oppoPoke1) {
		this.oppoPoke1 = oppoPoke1;
	}

    public void setOppoPoke2(Pokemon oppoPoke2) {
		this.oppoPoke2 = oppoPoke2;
	}
    public Pokemon getUserPokemon1() {
    	return userPoke1;
    }
    
    public Pokemon getUserPokemon2() {
    	return userPoke2;
    }
    
    public void setUserPoke1(Pokemon userPoke1) {
		this.userPoke1 = userPoke1;
	}

    public void setUserPoke2(Pokemon userPoke2) {
		this.userPoke2 = userPoke2;
	}
    
	public String getStage() {
        return stage;
    }

	public void setStage(String stage) {
		this.stage = stage;
	}
	
	
	public static void printUserPokemonDetails(Pokemon userPoke1, Pokemon userPoke2) {
		 System.out.println("User Pokemon 1 Details:");
	        System.out.println("Name: " + userPoke1.getName());
	        System.out.println("Type: " + userPoke1.getType());
	        System.out.println("Move Type: " + userPoke1.getMoveType());
	        System.out.println("HP: " + userPoke1.getHp());
	        System.out.println("Attack: " + userPoke1.getAtk());
	        System.out.println("Defense: " + userPoke1.getDef());
	        System.out.println("Speed: " + userPoke1.getSpd());

	        System.out.println("\nUser Pokemon 2 Details:");
	        System.out.println("Name: " + userPoke2.getName());
	        System.out.println("Type: " + userPoke2.getType());
	        System.out.println("Move Type: " + userPoke2.getMoveType());
	        System.out.println("HP: " +userPoke2.getHp());
	        System.out.println("Attack: " + userPoke2.getAtk());
	        System.out.println("Defense: " + userPoke2.getDef());
	        System.out.println("Speed: " + userPoke2.getSpd() + "\n");
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
	
	
	public void startBattle() {
	    System.out.println("Get ready for battle!");
	    printPokemonDetails(oppoPoke1, oppoPoke2);
	    System.out.println("Battle starts!");

	    while (oppoPoke1.getHp() > 0 && oppoPoke2.getHp() > 0 && userPoke1.getHp() > 0 && userPoke2.getHp() > 0) {
	        attack();
	    }

	    if (oppoPoke1.getHp() <= 0) {
	        System.out.println(oppoPoke1.getName() + " fainted! " + oppoPoke2.getName() + " wins!");
	    } else {
	        System.out.println(oppoPoke2.getName() + " fainted! " + oppoPoke1.getName() + " wins!");
	    }
	}
	
	


	//method for generating pokemon during battle
    public static Pokemon getRandomPokemonBattle(Pokemon[] pokemonArray, String stage) {
        Random random = new Random();
        int randomIndex = random.nextInt(pokemonArray.length);
        return pokemonArray[randomIndex];
    }
    
    
    
    
    // method for choosing stage
    public void chooseStage() {
        System.out.println("Choose a stage (1, 2, or 3):");
        System.out.println("1. Forest (Lugia)");
        System.out.println("2. Cave (Charizard)");
        System.out.println("3. Mountain (Lucario)");
        System.out.print("Enter the stage number: ");

        int userChoice;
        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice >= 1 && userChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }

        PokemonBattle stage = null;

        switch (userChoice) {
            case 1:
                stage = new PokemonBattle("Forest");
                System.out.println("You've chosen the " + stage.getStage() + " stage!\nThere is a higher chance of meeting a Lugia during battle!");
                break;
            case 2:
                stage = new PokemonBattle("Cave");
                System.out.println("You've chosen the " + stage.getStage() + " stage!\nThere is a higher chance of meeting a Charizard during battle!");
                break;
            case 3:
                stage = new PokemonBattle("Mountain");
                System.out.println("You've chosen the " + stage.getStage() + " stage!\nThere is a higher chance of meeting a Lucario during battle!");
                break;
        }
    }

    
    public void attack() {
        System.out.println("Choose 1 or 2 to either attack or defend: ");

        int userChoice;
        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice == 1 || userChoice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2 to either attack or defend.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2 to either attack or defend.");
            }
        }

        int randomNumber = random.nextInt(2) + 1; 

        if (userChoice == randomNumber) {
        	
            System.out.println("You attack!");
            
            boolean miniGameResult = playMiniGame();

            if (miniGameResult) {
                System.out.println("Congratulations! You won the mini-game. Your attack damage increases!");
                increaseAttackDamage();
            } else {
            	System.out.println("Oops! You lost the mini-game. Proceeding with the attack.");
            }

            System.out.println("Now, you attack!");
            userPoke1.attack(oppoPoke2); // Replace with actual logic
        } else {
            System.out.println("You defend!");
            oppoPoke2.defend();
        }
    }
    
    public boolean playMiniGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userGuess;
        int randomNumber = random.nextInt(5) + 1;
        System.out.println("Welcome to the mini-game! Let's see if you can win and boost your attack damage!");
        System.out.println("Guess a number between 1 and 5:");
        userGuess = scanner.nextInt();
        
        boolean miniGameResult = userGuess == randomNumber;
        
        if(miniGameResult) {
        	System.out.println("Congratulations! You guessed correctly.");
        } else {
        	System.out.println("Oops! You guessed incorrectly. The correct number was: " + randomNumber);
        }
        
        return miniGameResult;
    }
    
    private void increaseAttackDamage() {
    	double increasedAttack = userPoke1.getAtk() * 1.2; // Increase attack by 20%
        userPoke1.setAtk(increasedAttack);
    }
	public void setUserPokemons(Pokemon[] userPokemon) {

		
	}

	
}
