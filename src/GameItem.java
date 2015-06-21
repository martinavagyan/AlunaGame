import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameItem {
	
	protected Rectangle rect;
	protected Animation anim;
	
	public GameItem(Rectangle rect, Animation anim){
		this.rect = rect;
		this.anim = anim;
	}
	
	public abstract Rectangle getRect();
	public abstract void draw(Graphics g);
	public abstract void drawItemImage(Graphics g);
}
