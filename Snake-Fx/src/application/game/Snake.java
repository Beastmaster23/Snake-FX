package application.game;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Snake extends GameObject {
	private ArrayList<GameObject> tail;
	private PlayerInput input;
	private boolean grow;
	private double directionX, directionY;
	
	public boolean getGrow() {
		return grow;
	}
	
	public void setGrow(boolean grow) {
		this.grow=grow;
	}
	
	public PlayerInput getInput() {
		return input;
	}

	public void setInput(PlayerInput input) {
		this.input = input;
	}

	public Snake() {
		tail=new ArrayList<GameObject>();
		setInput(new PlayerInput());
		setDirectionX(0);
		setDirectionY(0);
		grow=false;
		setPhysics(new Physics2D());
	}
	
	public void update() {
		getPhysics().update();
		setPossitionX(getPossitionX()+getPhysics().getVelocityX());
		setPossitionY(getPossitionY()+getPhysics().getVelocityY());
	}
	
	public void updateTail() {
		tail.remove(0);
		addTail();
	}
	
	public void update(double elapsed) {
		if(grow) {
			addTail();
			grow=false;
		}
		if(tail.size()>0) {
			updateTail();
		}
		getPhysics().update(elapsed);
		setPossitionX(getPossitionX()+getPhysics().getSpeedX()*directionX);
		setPossitionY(getPossitionY()+getPhysics().getSpeedX()*directionY);
		
	}
	
	public void draw(GraphicsContext context) {
		Paint prev=context.getFill();
		context.setFill(Color.RED);
		context.fillRect(getPossitionX(), getPossitionY(), getWidth(), getHeight());
		for(GameObject object:tail)
			object.draw(context);
		context.setFill(prev);
	}
	
	public void addTail() {
		double endX, endY;
		GameObject endOfTail=getEndOfTail();
		endX=endOfTail.getPossitionX();
		endY=endOfTail.getPossitionY();
		
		GameObject object=new GameObject();
		Collider2D collider=new Collider2D();
		object.setCollider(collider);
		
		object.setPossitionX(getPossitionX());
		object.setPossitionY(getPossitionY());
		object.setWidth(getWidth());
		object.setHeight(getHeight());
		tail.add(object);
		
	}
	
	public GameObject getEndOfTail() {
		if(tail.size()==0)
			return this;
		return tail.get(tail.size()-1);
	}

	public double getDirectionX() {
		return directionX;
	}

	public void setDirectionX(double directionX) {
		this.directionX = directionX;
	}

	public double getDirectionY() {
		return directionY;
	}

	public void setDirectionY(double directionY) {
		this.directionY = directionY;
	}
}
