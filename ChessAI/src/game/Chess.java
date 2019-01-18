package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chess extends Canvas implements MouseListener{
	private Piece[][] peaces = new Piece[8][8];
	private final static int WIDTH = 640;
	private final int SIZE = WIDTH*WIDTH;
	private boolean pieceSelected;
	private int xSelected;
	private int ySelected;
	private JFrame frame;
	JPanel panel = new JPanel();
	public Chess() {
		frame = new JFrame("Chess");
		peaces[0][0] = new Piece(Type.rook, 1); 
		peaces[0][1] = new Piece(Type.knight, 1); 
		peaces[0][2] = new Piece(Type.bishop, 1); 
		peaces[0][3] = new Piece(Type.king, 1); 
		peaces[0][4] = new Piece(Type.queen, 1); 
		peaces[0][5] = new Piece(Type.bishop, 1); 
		peaces[0][6] = new Piece(Type.knight, 1); 
		peaces[0][7] = new Piece(Type.rook, 1); 
		
		peaces[1][0] = new Piece(Type.pawn, 1); 
		peaces[1][1] = new Piece(Type.pawn, 1); 
		peaces[1][2] = new Piece(Type.pawn, 1); 
		peaces[1][3] = new Piece(Type.pawn, 1); 
		peaces[1][4] = new Piece(Type.pawn, 1); 
		peaces[1][5] = new Piece(Type.pawn, 1); 
		peaces[1][6] = new Piece(Type.pawn, 1); 
		peaces[1][7] = new Piece(Type.pawn, 1); 
		
		
		
		peaces[7][0] = new Piece(Type.rook, 0); 
		peaces[7][1] = new Piece(Type.knight, 0); 
		peaces[7][2] = new Piece(Type.bishop, 0); 
		peaces[7][3] = new Piece(Type.queen, 0); 
		peaces[7][4] = new Piece(Type.king, 0); 
		peaces[7][5] = new Piece(Type.bishop, 0); 
		peaces[7][6] = new Piece(Type.knight, 0); 
		peaces[7][7] = new Piece(Type.rook, 0); 
		
		peaces[6][0] = new Piece(Type.pawn, 0); 
		peaces[6][1] = new Piece(Type.pawn, 0); 
		peaces[6][2] = new Piece(Type.pawn, 0); 
		peaces[6][3] = new Piece(Type.pawn, 0); 
		peaces[6][4] = new Piece(Type.pawn, 0); 
		peaces[6][5] = new Piece(Type.pawn, 0); 
		peaces[6][6] = new Piece(Type.pawn, 0); 
		peaces[6][7] = new Piece(Type.pawn, 0); 
		for(int i = 2; i< 6; i++) {
			for(int j = 0; j<8; j++) {
				peaces[i][j] = new Piece();
				
			}
			
		}
		
	}
	

	public boolean isLegal(Type ty, Piece[][] board, int startX, int startY, int destinationX, int destinationY, int player ) {
		if(ty==Type.pawn) {

			if(board[destinationY][destinationX].getIsNothing()) {
			
				if(player == 0) {
					
					if(startY==6) {
						if(startY==destinationY+2&&startX==destinationX) return true;
					}
					if(startY==destinationY+1&&startX==destinationX) { 
						return true;
					}

				}
				else if(player == 1) {
					if(startY==1) {
						
						if(startY==destinationY-2&&startX==destinationX) return true;
					}
					if(startY==destinationY-1&&startX==destinationX) { 

						return true;
				
					}
				}
			
			}
			if(player == 0) {
				if(startY==destinationY+1&&Math.abs(startX-destinationX)==1) { 
					return true;
				}
				
			}
			if(player == 1) {
				if(startY==destinationY-1&&Math.abs(startX-destinationX)==1) { 
					return true;
				}
				
			}
			
			
			
			
			
		}
		if(ty!= Type.pawn)return true;
		
		return false;
	}

	

	 public void mousePressed(MouseEvent e) {
	       int x =e.getX()/(WIDTH/8);
	       int y =e.getY()/(WIDTH/8);
	      
	       if(pieceSelected) {
	    		   if(isLegal(peaces[ySelected][xSelected].getType(),peaces, xSelected, ySelected, x, y, peaces[ySelected][xSelected].getPlayer())) {
	    			   if(x!=xSelected||y!=ySelected) {
	    		   peaces[y][x]=peaces[ySelected][xSelected];
	    	   peaces[ySelected][xSelected] = new Piece();
	    	  repaint();
	    		   }
	    			   }


	    	   
	    	   pieceSelected = false;

	       }
	       else if(!pieceSelected) {
	    	   if(!peaces[y][x].getIsNothing()) {
	    	   pieceSelected = true;
	    	   xSelected = x;
	    	   ySelected = y;
	    	   }
	       }
	    	  

	    }
	 
	 
	 

	public void paint(Graphics g) {
		int count = 0;
	for(int j = 0; j< 8; j++) {
		for(int i = 0; i < 8; i++) {
			if(count%2==1) {
				g.fillRect(WIDTH/8*i, WIDTH/8*j, WIDTH/8, WIDTH/8);
			
			}
			count++;
		}
		count++;
	}
	for(int i = 0; i< peaces.length; i++) {
		for(int j = 0; j <peaces[i].length; j++) {
			if(!peaces[i][j].getIsNothing()) {
				g.drawImage(peaces[i][j].getImg(), j*WIDTH/8, i*WIDTH/8, null );
				
			}
		}
		
	}
	
		
	}

	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.addMouseListener(chess);
		chess.frame.getContentPane().setPreferredSize(new Dimension(WIDTH, WIDTH));

		chess.frame.getContentPane().add(chess);
		


		chess.frame.setResizable(false);
		
		chess.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chess.frame.pack();
		chess.frame.setVisible(true);
		
		chess.frame.setLocationRelativeTo(null);

	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
