import java.awt.Graphics;
import java.awt.Rectangle;

public class KeyItem extends GameItem{

	public KeyItem(Rectangle rect, Animation anim) {
		super(rect, anim);
		// TODO Auto-generated constructor stub
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
	public void drawItemImage(Graphics g) {
		g.drawImage(anim.getKeyImage(),(int)rect.getX(),(int)rect.getY()-(int)rect.getHeight(),(int)rect.getWidth(),(int)rect.getHeight(),null);
	}
}