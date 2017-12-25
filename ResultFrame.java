package com.HandCricket;
import java.awt.Container;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class ResultFrame extends CricketFrame{

	
	
	//components in the vertical bar
	JLabel title;
	JLabel player,player_score,computer,computer_score,result;
	JButton retry,quit,credits;
	
	Box hrz1,hrz2,hrz3,second_vert_hrz1,second_vert_hrz2;
	Box main_vert,second_vert;
	JScrollPane jP;
	JTextArea jT;
	int playerGameScore = 0, computerGameScore =0;
	
	public ResultFrame(String title,int cGS, int pGS) throws InterruptedException{
		super(title);
		
		
			
		//first horizontal bar
		
		this.title = new JLabel("Result");
		Font f = new Font("Comic sans ms",Font.BOLD,65);
		this.title.setFont(f);
		this.title.setBackground(new java.awt.Color(255,23,0));
		this.title.setForeground(new java.awt.Color(0,0,250));
	    
	   
		Font f2 = new Font("Comic sans ms",Font.ITALIC,30);
		//crating first horizontal bar
		hrz1 = Box.createHorizontalBox();
		//adding components to first horiz bar
		hrz1.add(Box.createHorizontalStrut(50));
		hrz1.add(this.title);
		hrz1.add(Box.createHorizontalStrut(50));
		
	    
		
		
		//second horizontal bar components
		
		Font f1 = new Font("Comic sans ms",Font.ITALIC,30);
		player = new JLabel("You");
		player_score = new JLabel(String.valueOf(pGS));
		computer = new JLabel("Computer");
		computer_score = new JLabel(String.valueOf(cGS));
		
		player.setFont(f2);
		player.setForeground(new java.awt.Color(0,0,0));
		computer.setFont(f2);
		computer.setForeground(new java.awt.Color(0,0,0));
		player_score.setFont(f1);
		player_score.setForeground(new java.awt.Color(250,250,250));
		computer_score.setFont(f1);
		computer_score.setForeground(new java.awt.Color(250,250,250));
		
		
		
		hrz2 = Box.createHorizontalBox();
		second_vert = Box.createVerticalBox();
		second_vert_hrz1 = Box.createHorizontalBox();
		second_vert_hrz2 = Box.createHorizontalBox();

		second_vert_hrz1.add(Box.createHorizontalStrut(50));
		second_vert_hrz1.add(player);
		second_vert_hrz1.add(Box.createHorizontalStrut(30));
		second_vert_hrz1.add(player_score);
		second_vert_hrz1.add(Box.createHorizontalStrut(50));
		
		second_vert_hrz2.add(Box.createHorizontalStrut(50));
		second_vert_hrz2.add(computer);
		second_vert_hrz2.add(Box.createHorizontalStrut(30));
		second_vert_hrz2.add(computer_score);
		second_vert_hrz2.add(Box.createHorizontalStrut(50));
		
		
		second_vert.add(second_vert_hrz1);
		//second_vert_hrz2.add(Box.createVerticalStrut(70));
		second_vert.add(second_vert_hrz2);
		
		hrz2.add(second_vert);
		hrz2.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		//adding components to third horiz bar
		hrz3 = Box.createHorizontalBox();
		
		retry = new JButton("Retry");
		retry.setFont(f2);
		retry.setForeground(new java.awt.Color(250,0,0));
		
		quit = new JButton("Quit");
		quit.setFont(f2);
		quit.setForeground(new java.awt.Color(250,0,0));
		
		credits = new JButton("Credits");
		credits.setFont(f2);
		credits.setForeground(new java.awt.Color(250,0,0));
	
		
		hrz3.add(Box.createHorizontalStrut(30));
		hrz3.add(retry);
		hrz3.add(Box.createHorizontalStrut(30));
		hrz3.add(quit);
		hrz3.add(Box.createHorizontalStrut(30));
		hrz3.add(credits);
		
		
		hrz3.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		
		
		
		//vertical box in the outer layer
		main_vert = Box.createVerticalBox();
		main_vert.add(Box.createVerticalStrut(10));
		main_vert.add(hrz1);
		main_vert.add(Box.createVerticalStrut(40));
		main_vert.add(hrz2);
		main_vert.add(Box.createVerticalStrut(40));
		main_vert.add(hrz3);
		main_vert.add(Box.createVerticalStrut(10));
		
		//action listeners for the buttons
		
		//retry button action.
		retry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try{
					StartFrame obj = new StartFrame("HandCricket");
					frame.setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//quit button action.
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try{
					JOptionPane.showMessageDialog(frame.getContentPane(),"Thanks for playing.");
					java.lang.Thread.sleep(2000);
					System.exit(0);
					
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//credits button action.
		credits.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try{
					CreditsFrame obj = new CreditsFrame();
					
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//container settings
		Container c = frame.getContentPane();
		c.setBackground(new java.awt.Color(32,211,14));
		c.add(main_vert);
		frame.setVisible(true);
		
		if(pGS > cGS){
			JOptionPane.showMessageDialog(frame.getContentPane(),"Player Wins !");
			java.lang.Thread.sleep(2000);
			JOptionPane.showMessageDialog(frame.getContentPane(),"Great game ! Kudos !");
		}
		else{
		JOptionPane.showMessageDialog(frame.getContentPane(),"Computer Wins !");
		java.lang.Thread.sleep(2000);
		JOptionPane.showMessageDialog(frame.getContentPane(),"Work hard next time");
		}
		
		
		
		
		
	}
}
