import java.awt.Graphics;
import java.awt.Rectangle;


public class CloudPlatform extends PlatformItem{

	public CloudPlatform(Rectangle rect) {
		super(rect);
	}	
	
	public Rectangle getRect() {
		return rect;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


	public void draw(Graphics g) {

	}
}