import java.util.Random;


public class Pokemon{
	private String name;
    private String type;
    private String moveName;
    private String moveType;
    private double hp;
    private double atk;
    private double def;	
    private double spd;
    

    public Pokemon(String name, String type, String moveName,String moveType, double hp, double atk, double def, double spd) {
		super();
		this.name = name;
		this.type = type;
		this.moveName = moveName;
		this.moveType = moveType;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spd = spd;
	}


	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}

	public String getMoveName() {
		return moveName;
	}
	
	
	public String getMoveType() {
		return moveType;
	}


	public double getHp() {
		return hp;
	}
	
	

	public void setAtk(double atk) {
		this.atk = atk;
	}


	public double getAtk() {
		return atk;
	}


	public double getDef() {
		return def;
	}


	public double getSpd() {
		return spd;
	}
	
	
	public static Pokemon getRandomPokemonCatch(Pokemon[] pokemonArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(pokemonArray.length);
        return pokemonArray[randomIndex];
    }
	
	public static Pokemon getRandomPokemonBattle(Pokemon[] pokemonArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(pokemonArray.length);
        return pokemonArray[randomIndex];
    }

    public void setHp(double newHp) {
        this.hp = newHp;	
    }
    
    public static int generateRandomNumber() {
	    Random random = new Random();
	    return random.nextInt(10) + 1;
	}
	
	public static String flipCoin() {
        
        Random random = new Random();     
        boolean isHeads = random.nextBoolean();
        
        
        if (isHeads) {
            return "Heads";
        } else {
            return "Tails";
        }
    }
	
	public void displayPokemonDetails(Pokemon pokemon) {
		System.out.println("Name: " + pokemon.getName());
        System.out.println("Type: " + pokemon.getType());
        System.out.println("Move Type: " + pokemon.getMoveType());
        System.out.println("HP: " + pokemon.getHp());
        System.out.println("Attack: " + pokemon.getAtk());
        System.out.println("Defense: " + pokemon.getDef());
        System.out.println("Speed: " + pokemon.getSpd());
    }
	
	public static void checkhp (Pokemon pokemon1, Pokemon pokemon2) {
		if (pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
			System.out.println("Pokemon 1:");
			pokemon1.displayPokemonDetails(pokemon1);
			System.out.println("");
        	System.out.println("Pokemon 2:");
        	pokemon2.displayPokemonDetails(pokemon2);
		}
		
		else if (pokemon1.getHp() > 0 && pokemon2.getHp() <= 0) {
			System.out.println("Pokemon 1:");
			pokemon1.displayPokemonDetails(pokemon1);
			System.out.println("");
		}
		
		else if (pokemon1.getHp() <= 0 && pokemon2.getHp() > 0) {
			System.out.println("");
        	System.out.println("Pokemon 2:");
        	pokemon2.displayPokemonDetails(pokemon2);
		}
		else if(pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0) {
			System.out.println(pokemon1.getName() + "has fainted");
			System.out.println(pokemon2.getName() + "has fainted");
		}
	}

	public static int generateOneTwo() {
	    Random random = new Random();
	    return random.nextInt(2) + 1;
	}

	
    
}
    
