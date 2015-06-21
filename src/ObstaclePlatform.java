import java.awt.Graphics;
import java.awt.Rectangle;


public class ObstaclePlatform extends PlatformItem{

	public ObstaclePlatform(Rectangle rect,Animation anim) {
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
		g.drawImage(anim.getPlatformCloudImage(),(int)rect.getX() - 10 ,(int)rect.getY() - 2,(int)rect.getWidth() + 20,(int)rect.getHeight() + 20,null);
		g.drawImage(anim.getAnimationFire(),(int)rect.getX() - 25 ,(int)rect.getY() - (int)rect.getHeight()-30,(int)rect.getWidth() + 50,(int)rect.getHeight() + 50,null);
	}
}