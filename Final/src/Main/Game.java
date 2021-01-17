package Main;

import javax.swing.JFrame;

public class Game {
	public static void main(String[] args) {
		//ImageIcon p = new ImageIcon("src/res/...");
		
		JFrame window = new JFrame("Pong");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setContentPane(new GamePanel());
		
		//window.setIconImage(p.getImage());
		window.pack();
		window.setVisible(true);
	}
}
