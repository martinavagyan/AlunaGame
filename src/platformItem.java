import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class PlatformItem {
	
	protected Rectangle rect;
	protected Animation anim;
	
	public PlatformItem(Rectangle rect, Animation anim){
		this.rect = rect;
		this.anim = anim;
	}
	
	public abstract Rectangle getRect();
	public abstract void draw(Graphics g);
	public abstract void drawPlatformImage(Graphics g);
}
