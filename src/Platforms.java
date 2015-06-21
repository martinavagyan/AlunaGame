import java.awt.Rectangle;
import java.util.ArrayList;


public class Platforms {
	
	private int w = 80,h= 20;
	private final int MAX_COLUMN_PLATFORMS = 9;
	private final int MAX_ROW_PLATFORMS = 7;
	private ArrayList<PlatformItem> platforms;
	private int[][] platformGrid;
	private int index;
	private Animation anim;
	
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	public int getMAX_COLUMN_PLATFORMS(){
		return MAX_COLUMN_PLATFORMS;
	}
	public int getMAX_ROW_PLATFORMS(){
		return MAX_ROW_PLATFORMS;
	}
	
	public Platforms(Animation anim){
		this.anim = anim;
		platforms = new ArrayList<PlatformItem>();
		platformGrid = new int[MAX_COLUMN_PLATFORMS][MAX_ROW_PLATFORMS];
		//initialize the grid with -1s
		for (int i = 0; i < MAX_COLUMN_PLATFORMS; i++) {
			for(int j = 0; j <MAX_ROW_PLATFORMS;j++){
				platformGrid[i][j] = -1;
			}
		}
		index = 0;
	}
	public ArrayList<PlatformItem> getPlatforms(){
		return platforms;
	}
	public int[][]  getPlatformGrid(){
		return platformGrid;
	}
	
	//different types of platforms, each has an argument for placement 
	public void addCloud(int xPlacement, int yPlacement){
		platforms.add(index, new CloudPlatform(new Rectangle(xPlacement*100,yPlacement*100,w,h),anim));
		addToGrid(xPlacement,yPlacement);
	}
	public void addObstacle(int xPlacement, int yPlacement){
		platforms.add(index, new ObstaclePlatform(new Rectangle(xPlacement*100,yPlacement*100,w,h),anim));
		addToGrid(xPlacement,yPlacement);
	}
	public void addWall(int xPlacement, int yPlacement){
		platforms.add( new WallPlatform ( new Rectangle(xPlacement*100 - h,yPlacement*100-w,h,w),anim));		
	}
	
	public void addToGrid(int xPlacement, int yPlacement){
		platformGrid[xPlacement][yPlacement] = index;
		index++;
	}
}
