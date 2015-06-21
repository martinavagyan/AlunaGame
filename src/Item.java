import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;


public class Item {

	private int w = 25,h= 35;					//width, height of a nut
	private ArrayList<GameItem> items;	//array containing all the nuts
	private int[][] itemGrid;					//placement grid 
	private int index;
	private final int MAX_COLUMN= 9,MAX_ROW= 7;//limits
	private Animation anim;
	
	public Item(Animation anim){
		this.anim = anim;
		items = new ArrayList<GameItem>();
		itemGrid = new int[MAX_COLUMN][MAX_ROW];
	
		//initialize the grid with -1s
		for (int i = 0; i < MAX_COLUMN; i++) {
			for(int j = 0; j <MAX_ROW;j++){
				itemGrid[i][j] = -1;
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
	
	public int[][]  getItemGrid(){
		return itemGrid;
	}
	
	//Methods
	//Removes the element at index i and returns the arraylist
	public void removeItem(int i,int x, int y) {
		itemGrid[x][y] = -1;		
		items.set(i,null);
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
		itemGrid[xPlacement][yPlacement] = index;
		index++;
	}
}