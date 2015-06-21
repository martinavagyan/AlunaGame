import java.awt.Rectangle;
import java.util.ArrayList;


public class Item {

	private int w = 25,h= 35;					//width, height of a nut
	private ArrayList<GameItem> items;	//array containing all the nuts
	private int[][] nutGrid;					//placement grid 
	private int index;
	private final int MAX_COLUMN= 9,MAX_ROW= 7;//limits
	private Animation anim;
	
	public Item(){
		anim = new Animation();
		items = new ArrayList<GameItem>();
		nutGrid = new int[MAX_COLUMN][MAX_ROW];
	
		//initialize the grid with -1s
		for (int i = 0; i < MAX_COLUMN; i++) {
			for(int j = 0; j <MAX_ROW;j++){
				nutGrid[i][j] = -1;
			}
		}
		index = 0;
	}
	
	//Getters
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	
	public ArrayList<GameItem> getItems(){
		return items;
	}
	
	public void setItems(ArrayList<GameItem> items) {
		this.items = items;
	}
	
	public int[][]  getNutGrid(){
		return nutGrid;
	}
	
	//Methods
	//Removes the element at index i and returns the arraylist
	public ArrayList<GameItem> newNutsHitbox(int i,  ArrayList<GameItem> items) {
		items.remove(i);
		return items;
	}
	
	public void addKey(int xPlacement, int yPlacement){
		//Place the keys and compensate for the size of the platform 
		items.add(index, new KeyItem(new Rectangle(xPlacement*100+40,yPlacement*100-18,w+10,h),anim)); 
		addToGrid(xPlacement,yPlacement);
	}
	
	public void addNut(int xPlacement, int yPlacement){
		//Place the nuts and compensate for the size of the platform 
		items.add(index, new NutItem( new Rectangle(xPlacement*100+40,yPlacement*100-18,w,h),anim)); 
		addToGrid(xPlacement,yPlacement);
	}

	public void addToGrid(int xPlacement, int yPlacement){
		nutGrid[xPlacement][yPlacement] = index;
		index++;
	}
}