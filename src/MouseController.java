import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseController implements MouseListener{
	
	private Menu menu;
	private LevelDesign level;
	private SelectLevel gameLevels;
	
	
	public MouseController(Menu menu, LevelDesign level,SelectLevel gameLevels){
		this.menu=menu;
		this.level=level;
		this.gameLevels = gameLevels;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX=e.getX();
		int mouseY=e.getY();
		
		if(level.isActiveSelectLevel()){
			for(int i = 0;i<gameLevels.getNumberofLevels();i++){
				if((mouseX >= gameLevels.getLevelButtons().get(i).getX()) && (mouseX <= (gameLevels.getLevelButtons().get(i).getX() + gameLevels.getLevelButtons().get(i).getWidth()))){
					if((mouseY >= gameLevels.getLevelButtons().get(i).getY()) && (mouseY <= (gameLevels.getLevelButtons().get(i).getY() + gameLevels.getLevelButtons().get(i).getHeight()))){
						//The Play button was pressed
						level.setLevel(i);
						level.setRunning(true);
					}
				}
			}
		}		
		
		if(level.isActiveMenu()){
			if((mouseX >= menu.getPlayButton().x) && (mouseX <= (menu.getPlayButton().x+menu.getPlayButton().width))){
				if((mouseY >= menu.getPlayButton().y) && (mouseY <= (menu.getPlayButton().y + menu.getPlayButton().height))){
					//The Play button was pressed
					level.setRunning(true);
				}
			}
			
			if((mouseX >= menu.getQuitButton().x) && (mouseX <= (menu.getQuitButton().x+menu.getQuitButton().width))){
				if((mouseY >= menu.getQuitButton().y) && (mouseY <= (menu.getQuitButton().y+menu.getQuitButton().height))){
					//The Quit button was pressed
					System.exit(1);
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}

}
