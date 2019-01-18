package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Piece extends JPanel{
	private Type type;
	private int player;
   private Icon pic;
   private BufferedImage image;
   private String path;
   private boolean isNothing;
   public Piece() {
	   isNothing = true;
	   
   }
	public Piece(Type t, int plyr) {
		type = t;
		player = plyr;
		setPath(t, plyr);
		try {
		    image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPath(Type ty, int plr) {
		if(plr == 0) {
			 
			if(ty== Type.king) path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\king_w.png";
			if(ty== Type.queen) path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\queen_w.png";
			if(ty== Type.bishop) path= "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\bishiop_w.png";
			if(ty== Type.knight) path= "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\knight_w.png";
			if(ty== Type.pawn)path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\pawn_w.png";
			if(ty== Type.rook)path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\rook_w.png";
			
			}
			
		
		if(plr == 1) {
			if(ty== Type.rook)path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\rook_b.png";
			if(ty== Type.king) path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\king_b.png";
			if(ty== Type.queen) path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\queen_b.png";
			if(ty== Type.bishop) path= "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\bishop_b.png";
			if(ty== Type.knight) path= "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\knight_b.png";
			if(ty== Type.pawn)path = "C:\\Users\\jacob-laptop\\eclipse-workspace\\ChessAI\\res\\pawn_b.png";


			
		}
		
	}
	public String toString() {
		return""+type;
	}	
	
	public Type getType() {
		
		return type;
	}
	public int getPlayer() {
		
		return player;
	}
	public BufferedImage getImg() {

		return image;
	}
	public void repaintImg() {
		
	}
	public boolean getIsNothing() {
		return isNothing;
		
	}
	
}
