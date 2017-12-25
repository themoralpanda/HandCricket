package com.HandCricket;
import java.awt.Container;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class StartFrame extends CricketFrame{

	
	
	//components in the vertical bar
	JLabel title;
	JButton instructions,start,credits;
	
	Box hrz1,hrz2;
	Box main_vert;
	JScrollPane jP;
	JTextArea jT;
	public StartFrame(String title){
		super(title);
	
		
		
		//first horizontal bar
		
		this.title = new JLabel("Hand Cricket ");
	
		Font f = new Font("Comic sans ms",Font.BOLD,65);
		this.title.setFont(f);
		this.title.setBackground(new java.awt.Color(255,23,0));
		this.title.setForeground(new java.awt.Color(255	,0,0));
	    
	   
		
		//crating first horizontal bar
		hrz1 = Box.createHorizontalBox();
		//adding components to first horiz bar
		hrz1.add(Box.createHorizontalStrut(50));
		hrz1.add(this.title);
		hrz1.add(Box.createHorizontalStrut(50));
		
	    
		//second horizontal bar components
		
		Font f1 = new Font("Comic sans ms",Font.ITALIC,30);
		instructions = new JButton("Instructions"); 
		instructions.setFont(f1);
		instructions.setForeground(new java.awt.Color(0,0,0));
		start = new JButton("Start");
		start.setFont(f1);
		start.setForeground(new java.awt.Color(250,0,0));
		credits = new JButton("Credits");
		credits.setFont(f1);
		credits.setForeground(new java.awt.Color(0,0,0));
		//creat ing second horizontal bar
		hrz2 = Box.createHorizontalBox();
		//adding components to second horiz bar
		hrz2.add(Box.createHorizontalStrut(30));
		hrz2.add(instructions);
		hrz2.add(Box.createHorizontalStrut(50));
		hrz2.add(start);
		hrz2.add(Box.createHorizontalStrut(50));
		hrz2.add(credits);
		hrz2.add(Box.createHorizontalStrut(30));
		
		hrz2.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		//vertical box in the outer layer
		main_vert = Box.createVerticalBox();
		main_vert.add(Box.createVerticalStrut(10));
		main_vert.add(hrz1);
		main_vert.add(Box.createVerticalStrut(100));
		main_vert.add(hrz2);
		main_vert.add(Box.createVerticalStrut(10));
		
		//action listeners for the buttons
		
		//Instruction button action.
		instructions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try{
					
					RulesFrame obj = new RulesFrame("Instructions");
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//Toss button action.
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try{
					TossFrame obj = new TossFrame("TOSS");
					
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
		
		
		
		
		
		
		
	}
}
