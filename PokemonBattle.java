package oopffinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


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
	
	public void MyTurnChoose(Pokemon pokemon1, Pokemon pokemon2, Pokemon oppoPoke, Pokemon oppoPoke2) {
	    int pkchoice;
	    Scanner scanner = new Scanner(System.in);
	    PokemonBattle mt = new PokemonBattle(); // Create an instance of PokemonBattle

	    while (true) {
	        try {
	            System.out.println("");
	            System.out.println("Choose a pokemon to use. (1 or 2):");

	            pkchoice = scanner.nextInt();

	            if (pkchoice == 1 && pokemon1.getHp() > 0) {
	                mt.myTurn(oppoPoke, oppoPoke2, pokemon1);
	                break;
	            } else if (pkchoice == 1 && pokemon1.getHp() <= 0) {
	                System.out.println(pokemon1.getName() + " has fainted");
	                System.out.println("Choose another pokemon");
	            } else if (pkchoice == 2 && pokemon2.getHp() > 0) {
	                mt.myTurn(oppoPoke, oppoPoke2, pokemon2);
	                break;
	            } else if (pkchoice == 2 && pokemon2.getHp() <= 0) {
	                System.out.println(pokemon2.getName() + " has fainted");
	                System.out.println("Choose another pokemon");
	            } else {
	                System.out.println("Invalid Choice, choose again.");
	            }
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Invalid Choice, enter a valid integer.");
	            scanner.next();
	        }
	    }
	}
	
	public void TurnOppo(Pokemon pokemon1, Pokemon pokemon2, Pokemon oppoPoke) {
		PokemonBattle mt = new PokemonBattle();
		int oneTwo = (Pokemon.generateOneTwo());
    	if ((oneTwo == 1) && (pokemon1.getHp() > 0)) {
    		mt.OppoTurn(oppoPoke, pokemon1);
    	}
    	else if ((oneTwo == 1) && (pokemon1.getHp() <= 0)){
    		mt.OppoTurn(oppoPoke, pokemon2);
    	}
    	else if ((oneTwo == 2) && (pokemon2.getHp() > 0)){
    		mt.OppoTurn(oppoPoke, pokemon2);
    	}
    	else {
    		mt.OppoTurn(oppoPoke, pokemon1);
    	}
	}

	public void OpponentTurnChoose (Pokemon pokemon1, Pokemon pokemon2, Pokemon oppoPoke, Pokemon oppoPoke2) {
		System.out.println("-------Opponent's turns to attack!-------");
		PokemonBattle ot = new PokemonBattle();
        int twoOne = (Pokemon.generateOneTwo());
        if ((twoOne == 1) && (oppoPoke.getHp() > 0)) {
        	ot.TurnOppo(pokemon1, pokemon2, oppoPoke);
        }
        else if ((twoOne == 1) && (oppoPoke.getHp() <= 0)) {
        	ot.TurnOppo(pokemon1, pokemon2, oppoPoke2);
        }
        else if ((twoOne == 2) && (oppoPoke2.getHp() > 0)) {
        	ot.TurnOppo(pokemon1, pokemon2, oppoPoke2);
        }
        else if ((twoOne == 2) && (oppoPoke2.getHp() <= 0)) {
        	ot.TurnOppo(pokemon1, pokemon2, oppoPoke);
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
	
	
	public void MyTurnCalDMG (double stat, double newhp, Pokemon oppoPoke, Pokemon pk) {
        double playerEffectiveness = PokemonBattle.determineEffectiveness(pk.getMoveType(), oppoPoke.getType());
        int playerDamage = (int) (stat* (pk.getAtk() / oppoPoke.getDef()) * playerEffectiveness);
        System.out.println("ATTACK POWER: -" + playerDamage + " HP");
        newhp = Math.max(oppoPoke.getHp() - playerDamage,0);
        oppoPoke.setHp(newhp);
    }
	
	
	public void myTurn(Pokemon oppoPoke1, Pokemon oppoPoke2, Pokemon pk) {
        Scanner input = new Scanner(System.in);
        Pokemon.checkhp(oppoPoke1, oppoPoke2);

        while (true) {
            try {
            	double newhp = 0;
            	double newhp2 = 0;
                System.out.println("Choose a pokemon to attack (1 or 2):");
                int opkchoice = input.nextInt();

                if (opkchoice == 1 && oppoPoke1.getHp() > 0) {
                	boolean miniGameResult = playMiniGame();
                	if (miniGameResult) {
                		
                        System.out.println("Congratulations! You won the mini-game. Your attack damage increases!");
                        PokemonBattle mt = new PokemonBattle();
                        System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        mt.MyTurnCalDMG(30.0, newhp, oppoPoke1, pk);
                    
                    } 
                	else {
                    	System.out.println("You lost the mini-game. Proceeding with the attack.");
                    	PokemonBattle mt = new PokemonBattle();
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        mt.MyTurnCalDMG(20.0, newhp, oppoPoke1, pk);
                    }
                    
                    break;
                } 
                else if (opkchoice == 2 && oppoPoke2.getHp() > 0) {
                	boolean miniGameResult = playMiniGame();
                	if (miniGameResult) {
                        System.out.println("Congratulations! You won the mini-game. Your attack stat temporary increases!");
                        PokemonBattle mt = new PokemonBattle();
                        System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        mt.MyTurnCalDMG(30.0, newhp2, oppoPoke2, pk);
                	}
                	else {
                    	System.out.println("You lost the mini-game. Proceeding with the attack.");
                    	PokemonBattle mt = new PokemonBattle();
                    	System.out.println("\nGo " + pk.getName() + "! Use " + pk.getMoveName() + "\n");
                        mt.MyTurnCalDMG(20.0, newhp2, oppoPoke2, pk);
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
	
	
	public void OppoTurn(Pokemon oppoPoke, Pokemon pk) {
		double newhp = 0;
		
		boolean miniGameResult = playMiniGame();
		if (miniGameResult) {
            System.out.println("Congratulations! You won the mini-game. Your defence stat temporary increases!");
            System.out.println("\n" + oppoPoke.getName() + " attacks " + pk.getName() + "\n");
            PokemonBattle mt = new PokemonBattle();
            mt.MyTurnCalDMG(5.0, newhp,  pk, oppoPoke);
		}
		else {
			System.out.println("You lost the mini-game. No increase in defence.");
			PokemonBattle mt = new PokemonBattle();
            System.out.println("\n" + oppoPoke.getName() + " attacks " + pk.getName() + "\n");
            mt.MyTurnCalDMG(10.0, newhp,  pk, oppoPoke);
		}
	}
	
	
	public int points(int point) {
		return point;
	}
	 
	public int calculateBattleScore(int point) {
		Pokemon playerPokemon1 = getOppoPoke1();
	    Pokemon playerPokemon2 = getOppoPoke2();
        PokemonBattle pt = new PokemonBattle();
	    
	    
	    
	    double totalRemainingHP = playerPokemon1.getHp() + playerPokemon2.getHp();
	    
	    int score = (int) totalRemainingHP;
	    
	    if(totalRemainingHP >= 100) {
	    	score = 100000;
	    } else if (totalRemainingHP >= 90) {
	    	score = 90000;
	    } else if (totalRemainingHP >= 80) {
	    	score = 80000;
	    } else if (totalRemainingHP >= 70) {
	    	score = 70000;
	    } else if (totalRemainingHP >= 60) {
	    	score = 60000;
	    } else if (totalRemainingHP >= 50) {
	    	score = 55000;
	    } else if (totalRemainingHP >= 40) {
	    	score = 50000;
	    } else if (totalRemainingHP >= 30) {
	    	score = 30000;
	    } else if (totalRemainingHP >= 20) {
	    	score = 20000;
	    } else if (totalRemainingHP >= 10) {
	    	score = 10000;
	    } else if (totalRemainingHP >= 5) {
	    	score = 8000;
	    }
	    
	    score = score + (pt.points(point)*1000);
	    
	    saveTopScore(score);
	    return score;
	}
	
	public void displayTopScores() {
        try {
            File file = new File("top_scores.txt");
            if (!file.exists()) {
                System.out.println("Top scores file doesn't exist yet.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            List<Integer> topScores = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                topScores.add(Integer.parseInt(line));
            }

            reader.close();

            // Sort the scores in descending order
            topScores.sort(Collections.reverseOrder());

            System.out.println("Top 5 Scores:");
            for (int i = 0; i < Math.min(5, topScores.size()); i++) {
                System.out.println((i + 1) + ". " + topScores.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveTopScore(int score) {
        try {
            File file = new File("top_scores.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<Integer> topScores = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                topScores.add(Integer.parseInt(line));
            }
            reader.close();

            topScores.add(score);
            topScores.sort(Collections.reverseOrder());

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < Math.min(5, topScores.size()); i++) {
                writer.write(topScores.get(i) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
