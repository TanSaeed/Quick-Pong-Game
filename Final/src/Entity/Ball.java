package Entity;

import java.awt.Color;
import java.awt.Graphics;

import Main.GamePanel;

public class Ball {
	private int x = 200;
	private int y = 200;
	private int dx = 1;
	private int dy = 1;
	private int radius = 15;
	
	
	
	GamePanel gp;
	Player1 p1;
	Player2 p2;
	
	public Ball(GamePanel gp, Player1 p1, Player2 p2) {
		this.gp = gp;
		this.p1 = p1;
		this.p2 = p2;

	}
	
	private void ball_move() {
		x += dx;
		y += dy;
	}
	
	private void ball_top_bottom_collision() {
		if(y <= 0) {
			dy = -dy;
			//sound
		}else if(y >= (gp.WINDOW_HEIGHT-radius)) {
			dy = -dy;
			//sound
		}
	}
	
	/*private void ball_left_right_collision() {
		if(x <= 0) {
			dx = -dx;
			//sound
		}else if(x >= gp.WINDOW_WIDTH-radius) {
			dx = -dx;
			//sound
		}
	}*/
	
	private void ball_padder1_collision() {
		
		if ((x + radius) >= p1.getX() && x <= p1.getX() + p1.getWidth()) {
			
			if ((y + radius) >= p1.getY() && y <= (p1.getY() + p1.getHeight())) {
				vel();
				dx = -dx;
			}
		}
		
		if ((y + radius) >= p1.getY() && y <= (p1.getY() + p1.getHeight())) {
			if ((x + radius) >= (p1.getX() + 3) && x <= (p1.getX() + p1.getWidth() - 3)) {
				vel();
				dy = -dy;
			}
		}
		
	}
	
	private void ball_padder2_collision() {
		
		if ((x + radius) >= p2.getX() && x <= p2.getX() + p2.getWidth()) {
			if ((y + radius) >= p2.getY() && y <= (p2.getY() + p2.getHeight())) {
				vel();
				dx = -dx;
			}
		}
		
		if ((y + radius) >= p2.getY() && y <= (p2.getY() + p2.getHeight())) {
			if ((x + radius) >= (p2.getX() + 3) && x <= (p2.getX() + p2.getWidth() - 3)) {
				vel();
				dy = -dy;
			}
		}
	}
	
	private void vel() {
		if (dx < 5 && dx >= 0)
			dx++;
		else if (dx > -5 && dx <= 0)
			dx--;
		
		if (dy < 5 && dy > 0)
			dy++;
		else if (dy > -5 && dy <= 0)
			dy--;
	}
		
					
		

	public void update() {
		ball_move();
		ball_top_bottom_collision();
		//ball_left_right_collision();
		ball_padder1_collision();
		ball_padder2_collision();
		/*System.out.println("Dx:" + dx);
		System.out.println("Dy:" + dy);
		System.out.println("X:" + x);*/
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, radius, radius);
	}
	
	public void resetPos() {
		x= 200;
		y = 200;
	}
	
	public void resetVel() {
		if (dx > 0)
			dx = 1;
		else if (dx < 0)
			dx = -1;
		
		if (dy > 0)
			dy = -1;
		else if (dy < 0)
			dy = 1;
	}
	
	////////////////////////////////////////////////////////////////////
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
