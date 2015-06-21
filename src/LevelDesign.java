import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
	
	private Rectangle  platform = new Rectangle(0,HEIGHT*SCALE-40,WIDTH*SCALE,20);
	private Animation animation = new Animation();
	private Platforms platforms = new Platforms();
	private BufferedImage playerImage;	
	private BufferedImage platformImage;	
	private BufferedImage wallImage;
	
	public Rectangle getPlatform() {
		return platform;
	}
	public Animation getAnimation() {
		return animation;
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
		platformImage =  animation.getPlatformImage();
		wallImage = animation.getWallImage();
		
		//level settings
		generateLevelPlatform();
		
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
	}
	public Platforms getPlatforms(){
		return platforms;
	}
	
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		
		//Draw the Background
		g.setColor(Color.cyan);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(animation.getBackgroundTheme(), 0, 0,WIDTH*SCALE,HEIGHT*SCALE, null);
		
		//Draw the main Platform
		g.setColor(Color.white);
		g.fillRect(platform.x, platform.y, platform.width,platform.height);
				
		//Draw the clouds
	    for (int i = 0; i < platforms.getPlatforms().size(); i++) {	
		    g.fillRect((int)platforms.getPlatforms().get(i).getRect().getX(), (int)platforms.getPlatforms().get(i).getRect().getY(),(int) platforms.getPlatforms().get(i).getRect().getWidth(), (int)platforms.getPlatforms().get(i).getRect().getHeight());		       
		}
		
		//draw the player
		g.drawImage(playerImage,playerHandler.getPlayerHitbox().x - playerHandler.getPlayerSize()/2-playerHandler.getPlayerSize()*20/100,
			     	playerHandler.getPlayerHitbox().y - playerHandler.getPlayerSize(),
			     	playerHandler.getPlayerSize(),playerHandler.getPlayerSize(), null);
		
		//Draw the Player
		g.setColor(Color.red);
		g.fillRect(playerHandler.getPlayerHitbox().x,playerHandler.getPlayerHitbox().y,playerHandler.getPlayerHitbox().width,playerHandler.getPlayerHitbox().height);
		//Cloud Graphics
		//for (int i = 0; i < platforms.getPlatforms().size(); i++) {	
		//	if(platforms.getPlatforms().get(i).width == platforms.getW()){
		//		g.drawImage(platformImage, platforms.getPlatforms().get(i).x-10, platforms.getPlatforms().get(i).y-2, platforms.getPlatforms().get(i).width+20,platforms.getPlatforms().get(i).height + 20, null);	
		//	}else if (platforms.getPlatforms().get(i).width == platforms.getH()){
		//		g.drawImage(wallImage, platforms.getPlatforms().get(i).x-10, platforms.getPlatforms().get(i).y-10, platforms.getPlatforms().get(i).width+20,platforms.getPlatforms().get(i).height+20, null);	
		//	}
		//}		
		//g.dispose();
	}
}
