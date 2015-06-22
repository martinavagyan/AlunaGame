import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class LevelDesign extends JPanel{
	
	
	private JFrame frame;
	private PlayerController playerHandler;
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 6;//W = 960, H = 720.
	public static final String NAME = "Aluna";
	
	//private Rectangle  platform = new Rectangle(0,HEIGHT*SCALE-40,WIDTH*SCALE,20);
	private Animation animation = new Animation();
	private Platforms platforms = new Platforms(animation);
	private Item gameItems = new Item(animation);
	private Menu menu = new Menu(animation);
	private SelectLevel gameLevels = new SelectLevel(animation);
	private LevelLoader levelLoad = new LevelLoader(platforms,gameItems);
	
	
	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static int getSCALE() {
		return SCALE;
	}

	public LevelLoader getLevelLoad() {
		return levelLoad;
	}

	public void setLevelLoad(LevelLoader levelLoad) {
		this.levelLoad = levelLoad;
	}

	private BufferedImage playerImage;	
	private ImageIcon newNodeIcon = new ImageIcon("res/nutIcon.png");
	
	//Control variable for the state of the game:
	private boolean running = false;
	private boolean activeMenu = true;
	private boolean activeSelectLevel = false;
	private boolean gameOver = false;
	
	
	
	public LevelDesign(PlayerController playerHandler){
		this.playerHandler=playerHandler;
		//Dimensions of the frame
		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		//Properties of the frame
		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.setSize(WIDTH*SCALE,HEIGHT*SCALE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		frame.setIconImage(newNodeIcon.getImage());
		
		//JPanel settings
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(playerHandler);
		playerImage = animation.getPlayerImageRight();
		addMouseListener(new MouseController(menu,this,gameLevels));
		
		//level settings
		//generateLevelPlatform();
		//generateItems();
	}	
	
	public void setLevel(int i){
		switch(i){
			case 0:
				levelLoad.level1();
				break;
			case 1:
				levelLoad.level2();
				break;
			case 2:
				levelLoad.level3();
				break;
			case 3:
				levelLoad.level2();
				break;
			case 4:
				levelLoad.level2();
				break;
			case 5:
				levelLoad.level2();
				break;
			case 6:
				levelLoad.level2();
				break;
			default:
				levelLoad.level2();
				break;				
		}
	}
	
	public Platforms getPlatforms(){
		return platforms;
	}
	
	public void paintComponent(Graphics g){	
	    if(running == true){
			//Draw the Background	
	    	g.drawImage(animation.getBackgroundTheme(), 0, 0,WIDTH*SCALE,HEIGHT*SCALE, null);
		    //Draw the items	
		    ArrayList<GameItem> items =  gameItems.getItems();
		    for (int i = 0; i < items.size(); i++) {	
		    	GameItem currentItem = items.get(i);
	    		if(currentItem != null)
	    			currentItem.drawItemImage(g);
			}
		    
			//Draw the player
			g.drawImage(playerImage,playerHandler.getPlayerHitbox().x - playerHandler.getPlayerSize()/2-playerHandler.getPlayerSize()*20/100,
				     	playerHandler.getPlayerHitbox().y - playerHandler.getPlayerSize(),
				     	playerHandler.getPlayerSize(),playerHandler.getPlayerSize(), null);
			
			//Cloud Graphics
			for (int i = 0; i < platforms.getPlatforms().size(); i++) {	
				platforms.getPlatforms().get(i).drawPlatformImage(g);
			}
			//Draw the Score Panel
			playerHandler.getPlayer().getPlayerScore().draw(g);
			
			
				
			
			if(playerHandler.getPlayer().getPlayerScore().getLevelKey() != 0){
				g.drawString("EXIT", levelLoad.getExitX()*100,levelLoad.getExitX()*100);
			}
	    }
	    else if (activeSelectLevel){
	    	revalidate();
	    	repaint();
	    	gameLevels.render(g);
	    }
	    else if(activeMenu){
	    	menu.render(g);
	    }
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	
	public boolean isActiveMenu(){
		return activeMenu;
	}
	
	public boolean isActiveSelectLevel(){
		return activeSelectLevel;
	}
	
	public  void setActiveSelectLevel(boolean i){
		activeSelectLevel= i;
	}
	
	public  void setActiveMenu(boolean i){
		activeMenu= i;
	}
	
	
	public Animation getAnimation() {
		return animation;
	}
	public Item getGameItems() {
		return gameItems;
	}
	public void setPlayerImage(BufferedImage image){
		playerImage = image;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
