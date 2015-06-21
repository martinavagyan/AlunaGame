
import java.awt.Graphics;
import java.awt.Rectangle;


public class WallPlatform extends PlatformItem{

	public WallPlatform(Rectangle rect) {
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
		
	}
}