import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CACTUS extends GAMEOBJECT {
	BufferedImage cactus1;
	BufferedImage white;
	int dx;
	boolean reset;

	public CACTUS(int x, int y, int width, int height, int dx) {

		cactus1 = addImage("cactus.png");
		white = addImage("white.png");
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		reset = false;
		this.dx = dx;
	}

	public void moveAndDraw(Graphics2D win) {
		reset = false;
		Random r1 = new Random();

		win.drawImage(cactus1, null, this.x - 5, this.y - 30);
		this.translate(dx, 0);
		if (this.x <= 80) {
			win.drawImage(white, null, this.x - 250, this.y - 20);
			if (this.x <= 160 - r1.nextInt(100)) {
				this.setLocation(MAIN.floor.width + 200 + r1.nextInt(600), GLOBAL.HEIGHT / 3 - 25);
				reset = true;
			}
		}
	}

}