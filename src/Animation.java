import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Animation {
	private BufferedImage playerImageRight;	
	private BufferedImage playerImageLeft;	
	private BufferedImage platformCloudImage;	
	private BufferedImage platformWallImage;	
	private BufferedImage nutImage;
	private BufferedImage keyImage;
	private BufferedImage fireImage;
	
	private ArrayList<BufferedImage> fireAnim;
	private int animationCounter;
	
	private BufferedImage platfromObstacleImage;
	
	private Image backgroundTheme;
	
	public Animation(){
		animationCounter = 0;
		fireAnim = new ArrayList<BufferedImage>();
		//read player image
		try {
			playerImageRight = ImageIO.read(new File("res/0r.png"));


			playerImageLeft = ImageIO.read(new File("res/0l.png"));


			backgroundTheme = ImageIO.read(new File("res/background4.png"));


			platformCloudImage = ImageIO.read(new File("res/platformCloud.png"));
			
			platfromObstacleImage = ImageIO.read(new File("res/platformObstacle.png"));
				
		
			platformWallImage = ImageIO.read(new File("res/platformWall.png"));
			
			nutImage = ImageIO.read(new File("res/nut2.png"));
			
			keyImage = ImageIO.read(new File("res/key.png"));
			
			
			//loadFireAnimation
			
			fireAnim.add(ImageIO.read(new File("res/fire1.png")));
			fireAnim.add(ImageIO.read(new File("res/fire2.png")));
			fireAnim.add(ImageIO.read(new File("res/fire3.png")));
			fireAnim.add(ImageIO.read(new File("res/fire4.png")));
			fireAnim.add(ImageIO.read(new File("res/fire5.png")));
			fireAnim.add(ImageIO.read(new File("res/fire7.png")));
			fireAnim.add(ImageIO.read(new File("res/fire8.png")));
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage getAnimationFire(){		
		animationCounter++;	
		if(animationCounter/10 +1>= fireAnim.size()){
			animationCounter = 0;
		}

		return fireAnim.get(animationCounter/10);
		
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
