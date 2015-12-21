import java.util.ArrayList;


public class LevelLoader {
	private Platforms platforms;
	private Item gameItems;
	private int startingX;
	private int startingY;
	private int exitX = 100;
	private int exitY = 100;
	
	public LevelLoader(Platforms platforms, Item gameItems){
		this.platforms = platforms;
		this.gameItems = gameItems;
	}
	
	public int getStartingX() {
		return startingX;
	}

	public int getStartingY() {
		return startingY;
	}

	public int getExitX() {
		return exitX;
	}

	public int getExitY() {
		return exitY;
	}

	public void level1(){
		platforms.setPlatforms(new ArrayList<PlatformItem>());
		
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 5);
		platforms.addObstacle(1, 5);
		platforms.addCloud(2, 5);
		platforms.addCloud(3, 5);
		platforms.addCloud(4, 5);
		platforms.addCloud(5, 5);
		platforms.addCloud(6, 5);
		platforms.addCloud(7, 5);
		platforms.addCloud(8, 5);	
		
		gameItems.addNut(1, 3);
		gameItems.addNut(2, 2); 
		gameItems.addNut(5, 4);
		gameItems.addKey(5,2);
		
		
		 startingX = 1;
		 startingY = 1;
		 exitX = 3;
		 exitY = 3;		
	}
	
	public void level2(){
		
		platforms.addCloud(8, 6);
		platforms.addCloud(0, 5);		
		platforms.addCloud(1, 3);
		platforms.addCloud(2, 4);
		platforms.addCloud(3, 4);	
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
		platforms.addObstacle(3, 5);
		platforms.addObstacle(4, 5);	
		platforms.addObstacle(6, 5);
		
		gameItems.addNut(1, 3);
		gameItems.addNut(2, 2); 
		gameItems.addNut(5, 4);
		gameItems.addKey(5,2);
		
		startingX = 1;
		startingY = 1;
		exitX = 2;
		exitY = 1;
	}
	
	public void level3(){		
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 5);
		platforms.addCloud(2, 4);
		platforms.addCloud(3, 3);
		platforms.addCloud(4, 2);
		platforms.addCloud(5, 1);
		platforms.addCloud(6, 2);
		platforms.addCloud(7, 3);
		platforms.addCloud(8, 4);
		platforms.addCloud(0, 1);
		platforms.addObstacle(3, 3);
		platforms.addObstacle(8, 4);
		platforms.addObstacle(2, 4);
		
		gameItems.addNut(5, 3); 
		gameItems.addNut(0, 1);
		gameItems.addKey(2,2);
		
		startingX = 1;
		startingY = 1;
		exitX = 7;
		exitY = 5;
	}
public void level4(){		
		platforms.addCloud(8, 6);
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 3);
		platforms.addCloud(2, 4);
		platforms.addCloud(3, 4);	
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
		platforms.addObstacle(3, 5);
		
		gameItems.addNut(1, 3);
		gameItems.addNut(2, 2); 
		gameItems.addNut(5, 4);
		gameItems.addKey(5,2);
		
		startingX = 1;
		startingY = 1;
		exitX = 5;
		exitY = 2;
	}	
}
