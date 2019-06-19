package application.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GameObject {
	public double getPossitionX() {
		return possitionX;
	}

	public void setPossitionX(double possitionX) {
		this.possitionX = possitionX;
		this.collider.setPossitionX(possitionX);
	}

	public double getPossitionY() {
		return possitionY;
	}

	public void setPossitionY(double possitionY) {
		this.possitionY = possitionY;
		this.collider.setPossitionY(possitionY);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * @return the collider
	 */
	public Collider getCollider() {
		return collider;
	}

	/**
	 * @param collider the collider to set
	 */
	public void setCollider(Collider collider) {
		this.collider = collider;
	}

	/**
	 * @return the physics
	 */
	public Physics2D getPhysics() {
		return physics;
	}

	/**
	 * @param physics the physics to set
	 */
	public void setPhysics(Physics2D physics) {
		this.physics = physics;
	}

	private double possitionX, possitionY, width, height;
	
	private Collider collider;
	private Physics2D physics;
	
	public GameObject() {
		setCollider(null);
		physics=null;
		possitionX=0;
		possitionY=0;
		width=0;
		height=0;
	}
	
	public void draw() {
		
	}
	
	public void draw(GraphicsContext context) {
		Paint prev=context.getFill();
		context.setFill(Color.RED);
		context.fillRect(possitionX, possitionY, width, height);
		context.setFill(prev);
	}
	
	public void constrict() {
		if(possitionX+width>Game.width) {
			possitionX=Game.width-width;
		}
		if(possitionX<0) {
			possitionX=0;
		}
		if(possitionY+height>Game.height) {
			possitionY=Game.height-height;
		}
		if(possitionY<0) {
			possitionY=0;
		}
	}
}
