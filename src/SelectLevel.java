import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class SelectLevel {
	
	private static final int NUMBEROF_LEVELS = 5;
	
	public static int getNumberofLevels() {
		return NUMBEROF_LEVELS;
	}

	private ArrayList<Rectangle> levels;
	private Animation anim;
	
	public SelectLevel(Animation anim){
		levels = new ArrayList<Rectangle>();
		this.anim = anim;
		generateLevelButtons();
	}
	
	public void generateLevelButtons(){
		for(int i=0;i<NUMBEROF_LEVELS;i++){
			levels.add(new Rectangle(i*100,100,80,80));
		}
	}

	public ArrayList<Rectangle> getLevelButtons() {
		return levels;
	}
	
	public void render(Graphics g){

		g.setFont(new Font("Sherif", Font.BOLD,60));	
		g.setColor(Color.WHITE);
		for(int i=0;i<levels.size();i++){
			g.drawRect((int)levels.get(i).getX(),(int)levels.get(i).getY(),(int)levels.get(i).getWidth(),(int)levels.get(i).getHeight());
			g.drawString("Level"+i, (int)levels.get(i).getX(),(int)levels.get(i).getY());
		}
	}
}
