package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Bored extends JPanel{
	public void paint(Graphics g) {
		System.out.println(WIDTH);
		for(int i = 0; i < WIDTH/8; i++) {
			if(i%2==0) {
				//g.fillRect(WIDTH/8*i, 0, WIDTH/8, WIDTH/8);
				System.out.println("once");
			}
		}
		
		
	}
	public Bored() {
		setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.GRAY));
	}
        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(640, 640);
        }
}	

	

