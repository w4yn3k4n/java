package oopffinal;

import java.util.Random;
import java.util.Scanner;

public class Ball {
    private static int revealCounter = 0;

    public static void generateMysteryBalls(boolean isPlayerWinner, Pokemon oppoPoke1, Pokemon oppoPoke2) {
        Random rand = new Random();
        int numBalls = isPlayerWinner ? 2 : 1; // Generate 2 balls if the player wins, else 1 ball

        if (isPlayerWinner) {
            System.out.println("Congratulations! You won ! You got 2 mystery balls. ");
            // Generate 2 balls for the winner
            numBalls = 2;
        } else {
            System.out.println("You lost.. But you still You got 1 mystery balls.");
            // Generate 1 ball for the loser
            numBalls = 1;
        }


        // Ask user to reveal the mystery ball
        System.out.println("\nPress [ Enter ] to reveal the mystery ball...");
        Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
        
        for (int i = 0; i < numBalls; i++) {

	        // Generate a random number to determine the mystery ball type
	        int ballType = rand.nextInt(3); // 0, 1, or 2
	
	        // Convert the random number to ball type
	        String ballName;
	        double catchProbability; 
	        switch (ballType) {
	            case 0:
	                ballName = "Pokeball";
	                catchProbability = 0.7;
	                break;
	            case 1:
	                ballName = "Great Ball";
	                catchProbability = 0.8;
	                break;
	            case 2:
	                ballName = "Ultra Ball";
	                catchProbability = 0.9;
	                break;
	            default:
	                ballName = "Pokeball"; // Default to Pokeball
	                catchProbability = 0.7;
	                break;
	        }
	        System.out.println("----------------------------------------------------------------");
	        System.out.println("Let's see which kind of Poké Ball you'll receive...\n .\n .\n .\n");
	        System.out.println("Gatcha! You received a {" + ballName + "} !\n");
	        if (revealCounter % 2 == 0) {
                displayPokemonDetails1(oppoPoke1);
            } else {
                displayPokemonDetails2(oppoPoke2);
            }
            revealCounter++;
            
            String userChoice;
			do {
                System.out.println("\nDo you want to try catching this Pokémon? (yes/no)");
                userChoice = scanner.nextLine().toLowerCase();

                if (!userChoice.equals("yes") && !userChoice.equals("no")) {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            } while (!userChoice.equals("yes") && !userChoice.equals("no"));
            
            if (userChoice.equals("yes")) {
                System.out.println("\nYou throw the ball to catch the Pokémon......\n .\n .\n .\n");
                double randomProbability = rand.nextDouble();
                if (randomProbability <= catchProbability) {
                	System.out.println("You caught { " + (revealCounter % 2 == 0 ? oppoPoke1.getName() : oppoPoke2.getName()) + " } !");                    // Add logic here to display opponent Pokémon details and add to trainer list
                } else {
                    System.out.println("You failed to catch { " + (revealCounter % 2 == 0 ? oppoPoke1.getName() : oppoPoke2.getName()) + " }...");
                }
            } else {
                System.out.println("You chose not to catch the Pokémon, maybe next time!");
            }
	
        }

    }
    private static void displayPokemonDetails1(Pokemon oppoPoke1) {
    	System.out.println("Pokemon: "+ oppoPoke1.getName());

		
	}
    private static void displayPokemonDetails2(Pokemon oppoPoke2) {
    	System.out.println("Pokemon: " + oppoPoke2.getName());
	
	}

}
