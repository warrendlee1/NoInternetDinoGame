import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SPLASHPAGE {
	int gamestate, points, level, highscore;
	Font title, subtitle, dir, bottom, play, gg, stats, e;
	Color fontCol;
	
	public SPLASHPAGE() {
		gamestate = 0;
		points = 0;
		level = 1;
		
		title = new Font("arial", Font.BOLD, 28);
		subtitle = new Font("PT Sans", Font.BOLD, 18);
		dir = new Font("arial", Font.PLAIN, 20);
		bottom = new Font("arial", Font.PLAIN, 14);
		stats = new Font("courier", Font.PLAIN, 16);
		gg = new Font("courier", Font.PLAIN, 22);
		e = new Font("courier", Font.PLAIN, 10);
	}
	public void backdrop(Graphics g) {
		g.setFont(title);
		g.setColor(Color.BLACK);
		g.drawString("No internet", 160, 290);
		g.setFont(subtitle);
		g.drawString("Try:", 160, 335);
		g.setFont(dir);
		g.drawString("• This is a 1-player game. Hold down space to begin game", 185, 375);
		g.drawString("• Jump over all cacti using space-key", 185, 405);
		g.setColor(Color.DARK_GRAY);
		g.setFont(bottom); 
		g.drawString("ERR_WARRENLEE_MADETHISGAME", 160, 450);
		
		g.setFont(stats);
		g.drawString("" + points, 640, 50);
		g.drawString("HI " + highscore, 500, 50);
	}
	
	public void gameover(Graphics g) {
		g.setFont(gg);
		g.drawString("G A M E   O V E R", 300, 100);
		g.setFont(e);
		g.drawString("press ENTER to play again", 340, 130);
		
	}
}
