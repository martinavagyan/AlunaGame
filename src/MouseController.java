import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseController implements MouseListener{
	
	private Menu menu;
	private LevelDesign level;
	
	public MouseController(Menu menu, LevelDesign level){
		this.menu=menu;
		this.level=level;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX=e.getX();
		int mouseY=e.getY();
		
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

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
