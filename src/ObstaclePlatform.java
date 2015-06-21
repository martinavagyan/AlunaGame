import java.awt.Graphics;
import java.awt.Rectangle;


public class ObstaclePlatform extends PlatformItem{

	public ObstaclePlatform(Rectangle rect) {
		super(rect);
	}
	
	public Rectangle getRect() {
		return rect;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


	@Override
	public void draw(Graphics g) {
		g.fillRect((int)rect.getX(),(int)rect.getY(),(int)rect.getWidth(),(int)rect.getHeight());
	}
}