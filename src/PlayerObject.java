import java.awt.Rectangle;


public class PlayerObject {
	private final int  MAX_HEALTH = 100;
	private final int PLAYER_SIZE = 70;
	private final int OBJECT_SCALE = 100;
	
	private ScorePanel playerScore;
	private Rectangle playerHitbox;
	
	private static final int playerSize = 70;
	private int x=0,y=500;						//Coordinates of the starting position
	private int w=1,h=1;							//Dimensions of the object HitBox
	private int xD=0; 							//Direction of movement on x axis
	private int playerHealth = MAX_HEALTH;
	
	

	PlayerObject(){
		playerScore = new ScorePanel(this);
		playerHitbox = new Rectangle(x+OBJECT_SCALE/2,y,w,h);
	}
	
	
	public ScorePanel getPlayerScore() {
		return playerScore;
	}
	
	public int getPlayerHealth(){
		return playerHealth;
	}

	public void setPlayerScore(ScorePanel playerScore) {
		this.playerScore = playerScore;
	}

	public Rectangle getPlayerHitbox() {
		return playerHitbox;
	}

	public void setPlayerHitbox(Rectangle playerHitbox) {
		this.playerHitbox = playerHitbox;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getxD() {
		return xD;
	}

	public void setxD(int xD) {
		this.xD = xD;
	}

	public double getPredictedX() {
		return predictedX;
	}

	public void setPredictedX(double predictedX) {
		this.predictedX = predictedX;
	}

	public double getPredictedY() {
		return predictedY;
	}

	public void setPredictedY(double predictedY) {
		this.predictedY = predictedY;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

	public int getPLAYER_SIZE() {
		return PLAYER_SIZE;
	}

	public int getOBJECT_SCALE() {
		return OBJECT_SCALE;
	}

	public static int getPlayersize() {
		return playerSize;
	}

	private double predictedX,predictedY;			//predicted coordinates of the HitBox
	

}
