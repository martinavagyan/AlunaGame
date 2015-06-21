import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class LevelDesign extends JPanel{
	
	private JFrame frame;
	private PlayerController playerHandler;
	
	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE = 6;//W = 960, H = 720.
	public static final String NAME = "Game";
	
	//private Rectangle  platform = new Rectangle(0,HEIGHT*SCALE-40,WIDTH*SCALE,20);
	private Animation animation = new Animation();
	private Platforms platforms = new Platforms(animation);
	private Item gameItems = new Item(animation);
	private BufferedImage playerImage;	
	private BufferedImage platformImage;	
	private BufferedImage wallImage;
	
	
	public Animation getAnimation() {
		return animation;
	}
	public Item getGameItems() {
		return gameItems;
	}
	public void setPlayerImage(BufferedImage image){
		playerImage = image;
	}
	
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
		
		//JPanel settings
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(playerHandler);
		playerImage = animation.getPlayerImageRight();
		
		//level settings
		generateLevelPlatform();
		generateItems();
	}	
	
	public void generateLevelPlatform(){
		
		platforms.addCloud(8, 6);
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 3);
		platforms.addCloud(2, 4);
		platforms.addCloud(3, 4);
		platforms.addWall(4, 1);
		platforms.addWall(4, 2);
		platforms.addWall(4, 3);
		platforms.addWall(4, 4);		
		platforms.addCloud(4, 2);
		platforms.addCloud(4, 4);
		platforms.addCloud(4, 5);
		platforms.addCloud(5, 2);
		platforms.addCloud(5, 4);
		platforms.addCloud(5, 5);
		platforms.addCloud(6, 2);
		platforms.addCloud(7, 2);
		platforms.addCloud(8, 1);
		platforms.addCloud(8, 3);	
		platforms.addObstacle(8, 5);	
	}
	
	public void generateItems(){
		gameItems.addNut(2, 2); 
		gameItems.addNut(1, 3);
		gameItems.addNut(4, 4);
		gameItems.addKey(4,2);
	}
	public Platforms getPlatforms(){
		return platforms;
	}
	
	public void paintComponent(Graphics g){	
		int size;
		//Draw the Background
		g.drawImage(animation.getBackgroundTheme(), 0, 0,WIDTH*SCALE,HEIGHT*SCALE, null);
						
		//Draw the clouds
		size = platforms.getPlatforms().size();
	    for (int i = 0; i < size; i++) {		    	
	      platforms.getPlatforms().get(i).draw(g);
    	}
	    
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
		//g.dispose();
	}
}
