import java.awt.Rectangle;

public class GameEngine {

	private final double FPS = 60D;
	private PlayerController playerHandler;
	private LevelDesign level;
	private boolean running = true;
	private PlayerObject player;

	public GameEngine() {
		player = new PlayerObject();		
		playerHandler = new PlayerController(player);
		level = new LevelDesign(playerHandler);
		
		while(true){
			try {
			    Thread.sleep(16);                 //1000 milliseconds is one second.
			} catch(InterruptedException e) {	    
				e.printStackTrace();
			}
			if(level.isRunning()){
				render();
				updateGame();
			}
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
		int predictedGridCell = getPredictedGridCell();
		int predictedGridWall = getPredictedGridWall();
		insideWindow();					//Check for player to be in game.	
		wallCollision(predictedGridWall);
		underPlatform(predictedGridCell);				//Check if its about to hit a platform
		onPlatform(predictedGridCell); 					//Check if player is on platform.
		itemCollision();		
		isGameOver();
	}
	public int getPredictedGridCell(){
		if(isLegalGrid()){
			return -1;
		}
		return level.getPlatforms().getPlatformGrid()[(int)(playerHandler.getPredictedX()/100)][(int)(playerHandler.getPredictedY()/100)];		
	}
	
	public int getPredictedGridWall(){
		if(isLegalGrid()){
			return -1;
		}
		return level.getPlatforms().getWallGrid()[(int)(playerHandler.getPredictedX()/100)][(int)(playerHandler.getPredictedY()/100)];	
	}
	
	private void itemCollision(){
		if(isLegalItemGrid()){
			return;
		}
		int gridCell = level.getGameItems().getItemGrid()[(int)(playerHandler.getPlayerHitbox().getX()/100)][(int)(playerHandler.getPlayerHitbox().getY()/100)];

		if(gridCell !=-1){
			collectItem(gridCell);		
		}
	}
	public void collectItem(int gridCell){
		if(level.getGameItems().getItems().get(gridCell) instanceof  NutItem){
			playerHandler.getPlayer().getPlayerScore().iterNutCount();
		}
		else if (level.getGameItems().getItems().get(gridCell) instanceof  KeyItem){
			playerHandler.getPlayer().getPlayerScore().iterLevelKey();
		}
		level.getGameItems().removeItem(gridCell,(int)(playerHandler.getPlayerHitbox().getX()/100),(int)(playerHandler.getPlayerHitbox().getY()/100));		
	}
	public void wallCollision(int predictedGridWall){
		if(predictedGridWall !=-1){
			playerHandler.setJump(false);
			playerHandler.setXD(0);
			freeFall();
		}
	}
	
	public void onPlatform(int predictedGridCell){
		if(playerHandler.getPseudoGravity() <= 1){
			return;
		}
		if(predictedGridCell !=-1){
			
			playerHandler.getPlayerHitbox().y = (int)level.getPlatforms().getPlatforms().get(predictedGridCell).getRect().getY();
			playerHandler.setJump(false);
			freeFall();
			if(level.getPlatforms().getPlatforms().get(predictedGridCell) instanceof ObstaclePlatform){
				playerHandler.getPlayer().decrimPlayerHealth(1);
			}
		}
	}
	public void underPlatform(int predictedGridCell){	
		if(playerHandler.getPseudoGravity() < 0){
			if(predictedGridCell !=-1){
				freeFall();
			}			
		}		
	}	
	public boolean isLegalGrid(){
		return (level.getPlatforms().getMAX_COLUMN_PLATFORMS() <= (int)(playerHandler.getPredictedX()/100)|| 
				level.getPlatforms().getMAX_ROW_PLATFORMS()    <= (int)playerHandler.getPredictedY()/100);
	}
	
	
	public boolean isLegalItemGrid(){
		return (level.getGameItems().getMAX_COLUMN() <= (int)(playerHandler.getPlayerHitbox().getX()/100)|| 
				level.getGameItems().getMAX_ROW()    <= (int)playerHandler.getPlayerHitbox().getY()/100);
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
	public void isGameOver(){
		if(playerHandler.getPlayer().getPlayerHealth()<=0){
			gameOver();
		}
		if(player.getPlayerScore().getLevelKey() !=0){
			if((int)(playerHandler.getPlayerHitbox().getX()/100) == level.getLevelLoad().getExitX() &&
			   (int)(playerHandler.getPlayerHitbox().getY()/100) == level.getLevelLoad().getExitY()){
				playerHandler.getPlayer().getPlayerScore().setHighScore(playerHandler.getPlayer().getPlayerScore().getHighScore()+
						playerHandler.getPlayer().getPlayerScore().getNutCount());
				gameOver();
			}
		}
	}
	
	public void gameOver(){
		level.setRunning(false);
		level.setActiveSelectLevel(true);
		level.getPlatforms().reset();
		level.getGameItems().reset();
		playerHandler.setPlayerHitbox(new Rectangle(playerHandler.getX(),playerHandler.getY(),playerHandler.getW(),playerHandler.getH()));
		playerHandler.getPlayer().reset();
		playerHandler.getPlayer().getPlayerScore().reset();
	}
	public void freeFall(){
		playerHandler.setPseudoGravity(1);
		playerHandler.setJumpReleased(false);
	}
}
