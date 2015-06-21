import java.awt.Rectangle;
import java.util.Timer;

public class GameEngine {

	private final double FPS = 60D;
	private PlayerController playerHandler;
	private LevelDesign level;
	private boolean running = true;
	private int count = 0;
	private 
	Timer t = new Timer();
	Timer t2 = new Timer();

	public GameEngine() {
		playerHandler = new PlayerController();
		level = new LevelDesign(playerHandler);

		while(running){
			try {
			    Thread.sleep(16);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {	    
				
			}
			render();
			updateGame();
		}
		
		//run();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / FPS;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;

			while (delta >= 1) {
				updateGame();
				delta -= 1;
				shouldRender = true;
			}
			if (shouldRender) {
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
			}
		}
	}

	public void render() {
		level.repaint();
	}

	public void updateGame() {
		boundarySensor();
		currentGraphics();
		playerHandler.move();
	}
	public void currentGraphics(){
		if(playerHandler.getxD() < 0){
			level.setPlayerImage( level.getAnimation().getPlayerImageLeft());
		}else if(playerHandler.getxD() > 0){
			level.setPlayerImage( level.getAnimation().getPlayerImageRight());
		}
	}

	public void boundarySensor() {		
		playerHandler.predictMove();	// Predict the position of the player for the next tick.			
		insideWindow();					//Check for player to be in game.	
		underPlatform();				//Check if its about to hit a platform
		onPlatform(); 					//Check if player is on platform.
		itemCollision();
		
	}
	
	private void itemCollision(){
		if(isLegalGrid()){
			return;
		}
		int gridCell = level.getGameItems().getItemGrid()[(int)(playerHandler.getPlayerHitbox().getX()/100)][(int)(playerHandler.getPlayerHitbox().getY()/100)];

		if(gridCell !=-1){
			collectItem(gridCell);			
			
		}
	}
	public void collectItem(int predictedGridCell){
		//TODO add item to squrrel item bag
		//level.getGameItems().getItems().get(predictedGridCell);
		level.getGameItems().removeItem(predictedGridCell,(int)(playerHandler.getPredictedY()/100),(int)(playerHandler.getPredictedY()/100));
		
	}
	
	public void onPlatform(){
		if(playerHandler.getPseudoGravity() <= 1){
			return;
		}
		if(isLegalGrid()){
			return;
		}
		int predictedGridCell = level.getPlatforms().getPlatformGrid()[(int)(playerHandler.getPredictedX()/100)][(int)(playerHandler.getPredictedY()/100)];
		if(predictedGridCell !=-1){
			playerHandler.getPlayerHitbox().y = (int)level.getPlatforms().getPlatforms().get(predictedGridCell).getRect().getY();
			playerHandler.setJump(false);
			freeFall();
		}
	}
	public void underPlatform(){	
		if(playerHandler.getPseudoGravity() < 0){
			if(isLegalGrid()){
				System.out.println("legal grid: false");
				return;
			}
			if(level.getPlatforms().getPlatformGrid()[(int)(playerHandler.getPredictedX()/100)][(int)(playerHandler.getPredictedY()/100)] !=-1){
				freeFall();
			}			
		}		
	}
	
	public boolean isLegalGrid(){
		return (level.getPlatforms().getMAX_COLUMN_PLATFORMS() <= (int)(playerHandler.getPredictedX()/100)|| 
				level.getPlatforms().getMAX_ROW_PLATFORMS()    <= (int)playerHandler.getPredictedY()/100);
	}
	public void insideWindow(){
		// Check according to prediction for x and y coordinates
		if (playerHandler.getPredictedY() - playerHandler.getPlayerSize() + 10 < 0) {
			freeFall();
		}
		else if (playerHandler.getPredictedY() > level.HEIGHT * level.SCALE ){
			//TODO player dead
			gameOver();
		}
		if (playerHandler.getPredictedX() > level.WIDTH * level.SCALE || playerHandler.getPredictedX() < 0) {
			playerHandler.setXD(0);
		}
	}
	public void gameOver(){
		running = false;
	}
	public void freeFall(){
		playerHandler.setPseudoGravity(1);
		playerHandler.setJumpReleased(false);
	}
}
