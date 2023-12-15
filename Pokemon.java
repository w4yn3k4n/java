import java.util.Random;


public class Pokemon{
    private String name;
    private String type;
    private String moveType;
    private double hp;
    private double atk;
    private double def;	
    private double spd;
    

    public Pokemon(String name, String type, String moveType, double hp, double atk, double def, double spd) {
		super();
		this.name = name;
		this.type = type;
		this.moveType = moveType;
		this.hp = hp * 1.5;
		this.atk = atk * 0.7;
		this.def = def * 0.9;
		this.spd = spd;
	}


	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	public String getMoveType() {
		return moveType;
	}


	public double getHp() {
		return hp;
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
	


	 public double attack(Pokemon target) {
		 if (target == null) {
		        System.out.println("Target Pokemon is null. Cannot perform attack.");
		        return 0.0; // Return 0 damage or handle the situation accordingly
		    }
	        double effectiveness = getEffectiveness(this.moveType, target.type);
	        double damage = this.atk * effectiveness - target.def;

	        if (damage < 0) {
	            damage = 0; // Ensuring damage is non-negative
	        }

	        target.hp -= damage;

	        System.out.println(this.name + " attacks " + target.name + " for " + damage + " damage!");

	        return damage;
	    }

	    private double getEffectiveness(String moveType, String targetType) {
	        double effectiveness = 1.0; // Default effectiveness

	        // Implement type effectiveness logic based on moveType and targetType
	        // Modify this logic as per the Pokémon type chart
	        if (moveType.equals("Fire") && (targetType.equals("Grass") || targetType.equals("Ice"))) {
	            effectiveness = 2.0; // Fire is super effective against Grass and Ice
	        } else if (moveType.equals("Water") && (targetType.equals("Fire") || targetType.equals("Rock"))) {
	            effectiveness = 2.0; // Water is super effective against Fire and Rock
	        } else if (moveType.equals("Grass") && (targetType.equals("Poison") || targetType.equals("Flying"))) {
	            effectiveness = 2.0;
	        }

	        return effectiveness;
	    }
    public void defend() {
        // Implement defensive action logic if needed
        // This can involve reducing damage taken or increasing defense temporarily
        System.out.println(this.name + " defends!");
    }

    
}
    
    
