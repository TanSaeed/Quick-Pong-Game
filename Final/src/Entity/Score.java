package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Main.GamePanel;

public class Score {
	
	final int point = 1;
	
	GamePanel gp;
	Ball b;
	Player1 p1;
	Player2 p2;
	
	
	public Score(GamePanel gp, Ball b, Player1 p1, Player2 p2) {
		this.gp = gp;
		this.b = b;
		this.p1 = p1;
		this.p2 = p2;
	}
		
	private void scoreCalc() {
		
		if (b.getX() <= 0) {
			p2.addPoint();
			b.resetPos();
			b.resetVel();
		}

		if ((b.getX() +  b.getRadius()) >= gp.WINDOW_WIDTH) {
			p1.addPoint();
			b.resetPos();
			b.resetVel();
		}
		
	}
		
	public void update() {
		scoreCalc();	
	}
		
	public void draw(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.BOLD, 50)); 
		
		g.setColor(Color.RED);
		g.drawString(Integer.toString(p1.getScore()), 100, 75);
		
		g.setColor(Color.BLUE);
		g.drawString(Integer.toString(p2.getScore()), 300 - 40, 75);
			
	}
		
}
	

