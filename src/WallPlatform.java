
import java.awt.Graphics;
import java.awt.Rectangle;


public class WallPlatform extends PlatformItem{

	public WallPlatform(Rectangle rect,Animation anim) {
		super(rect,anim);
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
	@Override
	public void drawPlatformImage(Graphics g) {
		g.drawImage(anim.getPlatformWallImage(),(int)rect.getX() - 10 ,(int)rect.getY() - 2,(int)rect.getWidth() + 20,(int)rect.getHeight() + 20,null);
	}
}