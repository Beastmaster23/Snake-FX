package application.game;

public class Collider2D extends Collider {

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

	private double width, height;
	
	public Collider2D() {
		setPossitionX(0);
		setPossitionY(0);
		width=0;
		height=0;
	}

	@Override
	public boolean collide(Collider collider2) {
		Collider2D object2=(Collider2D) collider2;
		
		if(getPossitionX()+width>object2.getPossitionX()&&getPossitionX()<object2.getPossitionX()+object2.width) {
			if(getPossitionY()+height>object2.getPossitionY()&&getPossitionY()<object2.getPossitionY()+object2.height) {
				return true;
			}
		}
		return false;
	}
}
