import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class ScorePanel {
	private int highScore;
	private int nutCount;
	private int levelKey;
	private int h = 100;
	private int w = 350;
    private int x = LevelDesign.SCALE*LevelDesign.WIDTH -  w;
    private int y = 0;
	private Rectangle rect;
	private PlayerObject player;
	
	public ScorePanel(PlayerObject player){
		this.player = player;
		levelKey = 0;
		highScore = 0;
		nutCount = 0;
		rect = new Rectangle(x,y,w,h);
	}
	
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	public void iterNutCount(){
		nutCount++;
	}
	public void iterLevelKey(){
		levelKey=1;
	}
	public void setHighScore(int newScore){
		highScore = newScore;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Sherif", Font.BOLD,15));
		//g.drawRect((int)rect.getX(),(int)rect.getY(),(int)rect.getWidth(),(int)rect.getHeight());
		g.drawString("Health: "+ player.getPlayerHealth() + "  Nuts: "+nutCount + "  Key: " + levelKey + "  High Score: "+highScore, x+20,y+20);
	}
}
