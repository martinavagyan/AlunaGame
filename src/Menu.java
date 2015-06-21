import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Menu {
	
	private Rectangle playButton= new Rectangle(LevelDesign.WIDTH*LevelDesign.SCALE/2-60,300,100,50);
	private Rectangle quitButton= new Rectangle(LevelDesign.WIDTH*LevelDesign.SCALE/2-60,400,100,50);
	
	public Rectangle getPlayButton() {
		return playButton;
	}

	public Rectangle getQuitButton() {
		return quitButton;
	}
	
	public void render(Graphics g){
		Font titleFont = new Font("Sherif", Font.BOLD,60);
		Font menuFont = new Font("Sherif", Font.BOLD,40);
		
		g.setColor(Color.WHITE);
		//Title
		g.setFont(titleFont);
		g.drawString("ALUNA", (LevelDesign.WIDTH*LevelDesign.SCALE)/2-100, 250);
		
		//Menu
		g.setFont(menuFont);
		((Graphics2D)g).draw(playButton);
		((Graphics2D)g).draw(quitButton);
		
		g.drawString("Play",playButton.x+10,playButton.y+40);
		g.drawString("Quit",quitButton.x+10,quitButton.y+40);
	}
}
