import java.awt.Graphics2D;

public class WORLD extends GameDriverV4{
	CLOUD[] sky = new CLOUD[4];
	int[] x = {700, 1100, 1400, 1730};
	int[] y = {20,70,110,160,190};
	
	public WORLD() {
		for(int i = 0; i< sky.length; i++) {
			sky[i] = new CLOUD(x[i],y[i]);
		}
	}
	
	public void moveAndDraw(Graphics2D win) {
		for(CLOUD c : sky) { //for all clouds inside sky
			c.moveAndDraw(win);
			
		}
		
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}

}
