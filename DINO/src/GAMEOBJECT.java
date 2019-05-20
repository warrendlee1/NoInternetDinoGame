import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GAMEOBJECT extends Rectangle {

	int dx, dy;
	Color col;
	
	
	
	public GAMEOBJECT() {
		col = Color.BLACK;
	
	}
	
	public void moveAndDraw(Graphics2D win) {
		win.setColor(col);
		win.draw(this);
		
	}
	
	public BufferedImage addImage(String name)  {

		BufferedImage img = null;
		try {
		
			img = ImageIO.read(this.getClass().getResource(name));
			
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return img;

	}
}
