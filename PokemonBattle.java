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
                System.out.println("You've chosen the " + stage.getStage() + " stage!");
                break;
            case 2:
                stage = new PokemonBattle("Cave");
                System.out.println("You've chosen the " + stage.getStage() + " stage!");
                break;
            case 3:
                stage = new PokemonBattle("Mountain");
                System.out.println("You've chosen the " + stage.getStage() + " stage!\nThere is a higher chance of meeting a Lucario during battle!");
                break;
        }
    }

    // Other methods related to PokemonBattle can be added here
}