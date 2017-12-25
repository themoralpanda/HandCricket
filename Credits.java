package com.HandCricket;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
 
	
	class Temp 
	{
		Box main_vert;
		Box hrz1,hrz2,hrz3,hrz4;
		Font f1,f2,f3;
		JFrame frame;
		JLabel handCricket;
		JLabel email_1,email_2;
		public Temp()
		{
			//frame creation
			frame = new JFrame("About");
			frame.setSize(630,600);
			frame.setLocation(30,30 );
			frame.setResizable(false);
			
			
			//box creation
			main_vert = Box.createVerticalBox();
			hrz1 = Box.createHorizontalBox();
			hrz2 = Box.createHorizontalBox();
			hrz3 = Box.createHorizontalBox();
			hrz4 = Box.createHorizontalBox();
			
			//font declarations
			f1 = new Font("Comic sans ms",Font.BOLD,40);
			f3 = new Font("Comic sans ms",Font.BOLD,30);
			f2 = new Font("Georgia",Font.CENTER_BASELINE,20);
			
			//horizontal bar 1
			handCricket = new JLabel("Hand  Cricket");
			handCricket.setFont(f1);
			handCricket.setForeground(new java.awt.Color(250,0,0));
			hrz1.add(handCricket);
			
			//horizontal bar 2
			JTextArea aboutTheGame = new JTextArea("         Hand-Cricket is a popular game among school students where runs will be scored through random hand gestures!");
			aboutTheGame.setFont(f2);
			aboutTheGame.setForeground(Color.BLACK);
			aboutTheGame.setWrapStyleWord(true);
			aboutTheGame.setLineWrap(true);
			aboutTheGame.setEditable(false);
			aboutTheGame.setPreferredSize(new Dimension(600,100));
			
			aboutTheGame.setMaximumSize(new Dimension(600,300));
			hrz2.add(aboutTheGame);
			//horizontal bar 4
			email_1 = new JLabel("Ajeeth");
			email_2 = new JLabel("Vicky");
			
			main_vert.add(hrz1);
			main_vert.add(Box.createVerticalStrut(30));
			main_vert.add(hrz2);
			Credits d =new Credits();
			hrz3.add(d);
			
			email_1.setFont(f3);
			email_2.setFont(f3);
			main_vert.add(hrz3);
			hrz4.add(email_1);
			hrz4.add(Box.createHorizontalStrut(220));
			
			hrz4.add(email_2);
			main_vert.add(hrz4);
			//main_vert.add(hrz4);
			frame.add(main_vert);
			
			frame.setVisible(true);
		}
		
	}	
		
	

	 public class Credits extends JComponent{
		
		Image image_1,image_2;
		String ajeeth,vicky;
		Credits()
		{
			
			//image codings
			ajeeth = "C:\\Users\\Vigneshwar_V\\Desktop\\HandCricket\\src\\com\\HandCricket\\ajeeth.jpg";
			vicky = "C:\\Users\\Vigneshwar_V\\Desktop\\HandCricket\\src\\com\\HandCricket\\vicky.jpg";
			//reading images
			try {
				image_1 = ImageIO.read(new File(ajeeth));
				} 
			catch (IOException e)
				{
				
				e.printStackTrace();
				} 
			try {
				image_2 = ImageIO.read(new File(vicky));
				} 
			catch (IOException e)
			{
				e.printStackTrace();
			} 
			
			
			
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image_1,100,30,null);
			g.drawImage(image_2,430,30,null);
			
		}
		
			
		
	}
	 class CreditsFrame{
		CreditsFrame(){
			Temp t = new Temp();
		}
	}



