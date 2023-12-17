
import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    private Pokemon oppoPoke1;
    private Pokemon oppoPoke2;
    private String stage;
    private Scanner scanner;
    
    
    
    // constructors
    public PokemonBattle(Pokemon oppoPoke1, Pokemon oppoPoke2) {
        this.oppoPoke1 = oppoPoke1;
        this.oppoPoke2 = oppoPoke2;
    }

    public PokemonBattle(String stage) {
		this.stage = stage;
	}
    
    public PokemonBattle() {
        this.scanner = new Scanner(System.in);
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
            System.out.println("\n-------Your turns to attack!-------");
            System.out.println("\nGo, " + playerPoke.getName() + "!\n");

            // Determine effectiveness based on types
            double playerEffectiveness = determineEffectiveness(playerPoke.getType(), opponentPoke.getType());

            // Calculate damage based on effectiveness for player's attack
            int playerDamage = (int) (20.0 * (playerPoke.getAtk() / opponentPoke.getDef()) * playerEffectiveness);

            System.out.println("ATTACK POWER: -" + playerDamage + " HP");
            // Update opponent's HP after player's attack
            double newOpponentHp = opponentPoke.getHp() - playerDamage;
            opponentPoke.setHp(newOpponentHp);

            // Check if opponent is defeated
            if (newOpponentHp <= 0) {
                System.out.println("You defeated " + opponentPoke.getName() + "!");
                System.out.println("\n\n----------Battle End-----------");
                break;
            } else {
                System.out.println(opponentPoke.getName() + " has " + opponentPoke.getHp() + " HP remaining!");
            }

            // Opponent's turn to attack
            System.out.println("\n-------Opponent's turns to attack!-------");
            System.out.println("\n" + opponentPoke.getName() + " attacks!\n");

            // Determine effectiveness based on types for opponent's attack
            double opponentEffectiveness = determineEffectiveness(opponentPoke.getType(), playerPoke.getType());

            // Calculate damage based on effectiveness for opponent's attack
            int opponentDamage = (int) (15.0 * (opponentPoke.getAtk() / playerPoke.getDef()) * opponentEffectiveness);

            System.out.println("ATTACK POWER: -" + opponentDamage + " HP");

            // Update player's HP after opponent's attack
            double newPlayerHp = playerPoke.getHp() - opponentDamage;
            playerPoke.setHp(newPlayerHp);

            // Check if player is defeated
            if (newPlayerHp <= 0) {
            	System.out.println("You are defeated......");
                System.out.println("----------Battle End-----------");
                break;
            } else {
                System.out.println(playerPoke.getName() + " has " + playerPoke.getHp() + " HP remaining!");
            }
        }
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
