package application.game;

public abstract class Collider {
	private int colliderLayer;
	private double possitionX, possitionY;
	
	abstract public boolean collide(Collider collider2);
	
	public double getPossitionX() {
		return possitionX;
	}

	public void setPossitionX(double possitionX) {
		this.possitionX = possitionX;
	}

	public double getPossitionY() {
		return possitionY;
	}

	public void setPossitionY(double possitionY) {
		this.possitionY = possitionY;
	}
	public int getColliderLayer() {
		return colliderLayer;
	}

	public void setColliderLayer(int colliderLayer) {
		this.colliderLayer = colliderLayer;
	}
}
