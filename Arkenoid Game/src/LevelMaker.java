
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class LevelMaker {
	
	public int layout[][];
	public int brickRange;
	public int brickHeight;
	public int level_count;
	public int xSize=70;
	public int ySize=50;
	
	
	public LevelMaker(int row,int col,int level) {
		
		level_count=level;
		layout = new int[row][col];
		
		for(int i=0;i<layout.length;i++) {
			for(int j=0;j<layout[0].length;j++) {
				
				if(level==1) {//Just Red bricks with 1 hitpoint.
					layout[i][j]=1;
				}
				else if (level ==2) {
					if(i==1) 
					{
					layout[i][j]=2;//Orange Brick with 2 hitpoint
					}
					else {
					layout[i][j]=1;	//Red Brick with 1 hitpoint.
					}
					
				}
				else if(level==3) {
					if(i==0) 
					{
					layout[i][j]=3;//Black bricks with 3 hitpoint.
					}
					else if(i==1) {
					layout[i][j]=2;//Orange Brick with 2 hitpoint	
					}
					else {
					layout[i][j]=1;//Red Brick with 1 hitpoint.
					}
					
				}
				
			}
			
		}
		brickRange=550/col;
		brickHeight=150/row;
	}
	
	public void setHitpoint(int health,int row,int col) {
		layout[row][col]=health;
		
	}

	public void draw(Graphics2D g) {

		if(level_count==1) {
			
			for(int i=0;i<layout.length;i++) {//3
				for(int j=0;j<layout[0].length;j++) {//9
					if(layout[i][j]>0 ) {
							
						g.setColor(Color.red);
						g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
						
					

						g.setStroke(new BasicStroke(4));
						g.setColor(Color.black);
						g.drawRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
					}
				}
			}
			
			
		}
		else if(level_count==2) {
			for(int i=0;i<layout.length;i++) {//3
				for(int j=0;j<layout[0].length;j++) {//9
					if(layout[i][j]>0 ) {
						
						if(i==1) {
							g.setColor(Color.orange);
							g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
							
						}
						else {
							g.setColor(Color.red);
							g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
							
						}
						
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.black);
						g.drawRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
					}
				}
			}
			
			
			
		}
		else if(level_count==3) {
			for(int i=0;i<layout.length;i++) {//3
				for(int j=0;j<layout[0].length;j++) {//9
					if(layout[i][j]>0 ) {
						
						if(i==0) {
							g.setColor(Color.black);
							g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
							
						}
						
						else if(i==1) {
							g.setColor(Color.orange);
							g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
							
						}
						else {
							g.setColor(Color.red);
							g.fillRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
							
						}
						
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.GRAY);
						g.drawRect(j*brickRange+xSize, i*brickHeight+ySize, brickRange, brickHeight);
					}
				}
			}
			
			
			
		}
		
		
		
	}
	
		
}

