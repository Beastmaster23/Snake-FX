package application.game;

public class Player extends GameObject {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerInput getInput() {
		return input;
	}

	public void setInput(PlayerInput input) {
		this.input = input;
	}

	private int id;
	private String name;
	private PlayerInput input;
	
	public Player() {
		input=null;
		id=0;
	}
	
	public Player(int id) {
		input=null;
		this.id=id;
	}
	
	public Player(String name) {
		input=null;
		this.id=0;
		this.name=name;
	}
}
