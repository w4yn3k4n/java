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
    
}
