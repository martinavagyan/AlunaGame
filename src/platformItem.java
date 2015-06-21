import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class PlatformItem {
	
	protected Rectangle rect;
	
	
	public PlatformItem(Rectangle rect){
		this.rect = rect;
	}
	
	public abstract Rectangle getRect();
	public abstract void draw(Graphics g);
}
