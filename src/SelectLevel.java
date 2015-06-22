import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class SelectLevel {
	
	private static final int NUMBEROF_LEVELS = 9;
	
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
			levels.add(new Rectangle(i*100+20,100,80,80));
		}
	}

	public ArrayList<Rectangle> getLevelButtons() {
		return levels;
	}
	
	public void render(Graphics g){
		g.drawImage(anim.getBackgroundMenu(), 0, 0,LevelDesign.WIDTH*LevelDesign.SCALE,LevelDesign.HEIGHT*LevelDesign.SCALE, null);
		g.setFont(new Font("Sherif", Font.BOLD,20));	
		g.setColor(Color.WHITE);
		for(int i=0;i<levels.size();i++){
			g.setColor(new Color(97,197,222));
			g.fillRect((int)levels.get(i).getX(),(int)levels.get(i).getY(),(int)levels.get(i).getWidth(),(int)levels.get(i).getHeight());
			
			g.setColor(Color.black);
			g.drawString("Level"+(i+1), (int)levels.get(i).getX()+2,(int)levels.get(i).getCenterY()+2);
			g.setColor(Color.white);
			g.drawString("Level "+(i+1), (int)levels.get(i).getX(),(int)levels.get(i).getCenterY());
		}
	}
}
