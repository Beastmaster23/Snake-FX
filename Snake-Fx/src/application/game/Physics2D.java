package application.game;

public class Physics2D {
	/**
	 * @return the velocityY
	 */
	public double getVelocityX() {
		return velocityX;
	}

	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	/**
	 * @return the velocityY
	 */
	public double getVelocityY() {
		return velocityY;
	}

	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * @return the accelerationX
	 */
	public double getAccelerationX() {
		return accelerationX;
	}

	/**
	 * @param accelerationX the accelerationX to set
	 */
	public void setAccelerationX(double accelerationX) {
		this.accelerationX = accelerationX;
	}

	/**
	 * @return the accelerationY
	 */
	public double getAccelerationY() {
		return accelerationY;
	}

	/**
	 * @param accelerationY the accelerationY to set
	 */
	public void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}

	private double velocityX, velocityY, accelerationX, accelerationY;
	private double speedX, speedY;
	public Physics2D() {
		velocityX=0;
		velocityY=0;
		accelerationX=0;
		accelerationY=0;
	}

	public void update() {
		velocityX+=velocityX*accelerationX;
		velocityY+=velocityY*accelerationY;		
	}
	
	public void update(double elapsed) {
		velocityX+=accelerationX*elapsed;
		velocityY+=accelerationY*elapsed;		
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
}
