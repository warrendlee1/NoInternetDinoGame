import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class CLOUD extends GAMEOBJECT{
	int dx, xloc, yloc, limit;
	BufferedImage cloud;
	public CLOUD(int xloc, int yloc) {
		cloud = addImage("cloud.png");
		this.x = xloc;
		this.y = yloc;
	}
	
	public void moveAndDraw(Graphics2D win) {
		Random r1 = new Random();
		win.drawImage(cloud, null, this.x, this.y);
		//System.out.println(this.getX() + " " + this.getY());
		if(this.x < 50) {
			this.x = 750 + r1.nextInt(50);
			this.y = 50 + r1.nextInt(50);
		}
		this.x -= 0.5;
	}

	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}
}
