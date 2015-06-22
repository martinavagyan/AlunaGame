import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class PlayerController implements KeyListener{
	
	
	private   int playerSize, x,y,w,h;
	protected int xD=0; 							//Direction of movement on x axis
	private double predictedX,predictedY;			//predicted coordinates of the HitBox
	private Rectangle playerHitbox;
	
	private PlayerObject player;
	
	public PlayerObject getPlayer() {
		return player;
	}



	public void setPlayer(PlayerObject player) {
		this.player = player;
	}

	private final double startingGravity = 1;
	private final double gravityAcceleration = 1.09;//The constant gravity acceleration
	private double pseudoGravity = startingGravity;		        //Pseudo-gravity on y axis
	protected final int maxGravityVelocity = 19;	//The max speed the acceleration can have
	private final int jumpAcceleration = 5;			//Jump acceleration
	private  int objectScaleConstant;	//The general grid constant

	
	
	//Switches 
	protected boolean jump = true;					//Jump possible when true
	protected boolean leftKey = true;				//Left key possible when true
	protected boolean rightKey = true;				//Right key possible when true
	private boolean jumpReleased = false;			//Jump is only allowed from platform
	
	
	public PlayerController(PlayerObject player){
		this.player = player;	
		initPlayer();
	}
	
	public void initPlayer(){
		predictedX = 0;
		predictedY = 0;
		this.x =  player.getX();
		this.y =  player.getY();
		this.w =  player.getW();
		this.h =  player.getH();
		this.playerSize =  player.getPLAYER_SIZE();
		this.playerHitbox = player.getPlayerHitbox();
		this.objectScaleConstant = player.getOBJECT_SCALE();
	}
	
	
	
	//Getters & Setters
	public int getPlayerSize(){
		return playerSize;
	}
	
	public double getPredictedX() {
		return predictedX;
	}

	public double getPredictedY() {
		return predictedY;
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

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getxD() {
		return xD;
	}
	
	public Rectangle getPlayerHitbox() {
		return playerHitbox;
	}

	public double getPseudoGravity() {
		return pseudoGravity;
	}
	
	public void setXD(int xD) {
		this.xD = xD;
	}
	
	
	
	public void setPlayerHitbox(Rectangle hitbox){
		this.playerHitbox = hitbox;
	}
	

	public void setPseudoGravity(double pseudoGravity) {
		this.pseudoGravity = pseudoGravity;
	}
	
	public void setJumpReleased(boolean jumpReleased) {
		this.jumpReleased = jumpReleased;
	}	
	
	public void setJump(boolean jump){
		this.jump=jump;
	}
	
	
	
	//Movement function of the game
	public void move(){
		playerHitbox.x +=xD; 
		xD = 0;
		if(pseudoGravity*gravityAcceleration <= maxGravityVelocity){
			playerHitbox.y +=pseudoGravity*gravityAcceleration;
			pseudoGravity*=gravityAcceleration;
		}else{
			playerHitbox.y +=pseudoGravity;
		}		
	}
	
	public void predictMove(){
		predictedX = playerHitbox.x +xD;
		if(pseudoGravity*gravityAcceleration <= maxGravityVelocity){
			predictedY = playerHitbox.y + pseudoGravity*gravityAcceleration;
		}else{
			predictedY = playerHitbox.y +pseudoGravity;
		}		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();		
		if(keyCode==KeyEvent.VK_A && leftKey ){
			setXD(-objectScaleConstant);
			leftKey = false;
			jump = false;
		}
		if(keyCode==KeyEvent.VK_D && rightKey){
			setXD(objectScaleConstant);
			rightKey = false;
			jump = true;
		}		
		if(keyCode==KeyEvent.VK_SPACE && jump==false){
			pseudoGravity = -jumpAcceleration;
			jump = true;
			jumpReleased = true;
		}
	}

	@Override          
	public void keyReleased(KeyEvent e) {
		setXD(0);
		//When the space bar is released set gravity to 1, jumpReleased become stay false
		if(e.getKeyCode() == KeyEvent.VK_SPACE && jumpReleased == true){
			pseudoGravity = startingGravity;
			jumpReleased = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			leftKey = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			rightKey = true;
		}
	}	
}