import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Animation {
	private BufferedImage playerImageRight;	
	private BufferedImage playerImageLeft;	
	private BufferedImage platformCloudImage;	
	private BufferedImage platformWallImage;	
	private BufferedImage nutImage;
	private BufferedImage keyImage;
	private BufferedImage fireImage;
	private BufferedImage backgroundMenu;
	private BufferedImage backgroundGameOver;
	private ImageIcon gameIcon;
	private String path = "res/";             
	
	private ArrayList<BufferedImage> fireAnim;
	private int animationCounter;
	
	private BufferedImage platfromObstacleImage;	


	private Image backgroundTheme;
	
	public Animation(){
		animationCounter = 0;
		fireAnim = new ArrayList<BufferedImage>();
		//read player image
		try {
			playerImageRight = ImageIO.read(new File(path+"0r.png"));


			playerImageLeft = ImageIO.read(new File(path+"0l.png"));


			backgroundTheme = ImageIO.read(new File(path+"background4.png"));


			platformCloudImage = ImageIO.read(new File(path+"platformCloud.png"));
			
			platfromObstacleImage = ImageIO.read(new File(path+"platformObstacle.png"));
				
		
			platformWallImage = ImageIO.read(new File(path+"platformWall.png"));
			
			nutImage = ImageIO.read(new File(path+"nutIcon.png"));
			
			keyImage = ImageIO.read(new File(path+"keyIcon.png"));
			
			gameIcon = new ImageIcon(path+"nutIcon.png");
			
			backgroundMenu = ImageIO.read(new File(path+"backgroundImageMenu.jpg"));
			
			backgroundGameOver = ImageIO.read(new File(path+"backgroundGameOver.jpg"));
			
			//loadFireAnimation
			
			fireAnim.add(ImageIO.read(new File(path+"fire1.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire2.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire3.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire4.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire5.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire7.png")));
			fireAnim.add(ImageIO.read(new File(path+"fire8.png")));
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public ImageIcon getImageIcon(){
		return gameIcon;
	}
	
	public BufferedImage getAnimationFire(){		
		animationCounter++;	
		if(animationCounter/10 +1>= fireAnim.size()){
			animationCounter = 0;
		}

		return fireAnim.get(animationCounter/10);
		
	}
	
	public BufferedImage getBackgroundMenu(){
		return backgroundMenu;
	}	
	
	public BufferedImage getBackgroundGameOver(){
		return backgroundGameOver;
	}	
	
	public BufferedImage getFireImage(){
		return fireImage;
	}	
	
	public BufferedImage getPlayerImageRight(){
		return playerImageRight;
	}	
	public BufferedImage getPlatformWallImage(){
		return platformWallImage;
	}
	public BufferedImage getPlayerImageLeft(){
		return playerImageLeft;
	}
	public BufferedImage getPlatformCloudImage(){
		return platformCloudImage;
	}
	public BufferedImage getPlatfromObstacleImage(){
		return platfromObstacleImage;
	}
	
	public BufferedImage getNutImage(){
		return nutImage;
	}
	public BufferedImage getKeyImage(){
		return keyImage;
	}
	
	
	public Image getBackgroundTheme(){
		return backgroundTheme;
	}
}
