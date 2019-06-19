package application.game;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PowerUp extends GameObject {
	private boolean eaten;
	private Random random;
	
	public PowerUp() {
		setEaten(false);
		random=new Random();
		Collider2D collider=new Collider2D();
		collider.setPossitionX(getPossitionX());
		collider.setPossitionY(getPossitionY());
		collider.setWidth(getWidth());
		collider.setHeight(getHeight());
		
		setCollider(collider);
	}
	
	public void spawn() {
		
		setPossitionX((random.nextDouble()*(Game.width-getWidth())));
		setPossitionY((random.nextDouble()*(Game.height-getHeight())));
	}
	
	public void draw(GraphicsContext context) {
		Paint prev=context.getFill();
		context.setFill(Color.BLUE);
		context.fillRect(getPossitionX(), getPossitionY(), getWidth(), getHeight());
		context.setFill(prev);
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setEaten(boolean eaten) {
		this.eaten = eaten;
	}
}
