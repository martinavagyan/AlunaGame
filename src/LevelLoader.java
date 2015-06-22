
public class LevelLoader {
	Platforms platforms;
	
	public LevelLoader(Platforms platforms){
		this.platforms = platforms;
	}
	
	public void level1(){
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 5);
		platforms.addCloud(2, 5);
		platforms.addCloud(3, 5);
		platforms.addCloud(4, 5);
		platforms.addCloud(5, 5);
		platforms.addCloud(6, 5);
		platforms.addCloud(7, 5);
		platforms.addCloud(8, 5);		
		
	}
	
	public void level2(){
		platforms.addCloud(8, 6);
		platforms.addCloud(0, 5);
		platforms.addCloud(1, 3);
		platforms.addCloud(2, 4);
		platforms.addCloud(3, 4);
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
		platforms.addObstacle(3, 5);
	}
	
	
}
