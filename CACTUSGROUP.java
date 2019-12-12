import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CACTUSGROUP extends GAMEOBJECT {
	
	BufferedImage cactus2;
	BufferedImage white;
	int dx;
	boolean reset;

	
public CACTUSGROUP(int x, int y, int width, int height, int dx) {
		
		cactus2 = addImage("cactus2.png");
		white = addImage("white.png");
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		reset= false;
		this.dx = dx;
	}	
		
	public void moveAndDraw(Graphics2D win) {
		//super.moveAndDraw(win);
		Random r1 = new Random();
		reset = false;
		
		win.drawImage(cactus2, null, this.x-25, this.y-55);
		this.translate(dx, 0);
		if(this.x <= 50) { 
			win.drawImage(white, null, this.x-250, this.y-20);
			if(this.x <= 160 - r1.nextInt(100)) {
				this.setLocation(MAIN.floor.width + 100 + r1.nextInt(400), y);
				reset = true;
			}
		}
	}
}
