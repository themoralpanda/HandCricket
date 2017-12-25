package com.HandCricket;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.*;

import org.omg.PortableInterceptor.USER_EXCEPTION;

class TossFrame extends CricketFrame{
	
	//components in the vertical bar
	JLabel title , result, result_value , toss_label;
	JRadioButton heads, tails;
	JButton go,start;
	ButtonGroup bg;
	String choice[] ={"Heads","Toss"}; 
	String toss_result[] = {"Bat","Bowl"};
	String users_choice, toss_value, users_ultimate_choice;
	Random rand ;
	JOptionPane dialog_box;
	String comp_ultimate_choice;
	
	Box hrz1,hrz2,hrz3;
	Box main_vert;
	public TossFrame(String title){
		super(title);
	
		
		
		//first horizontal bar
		
		this.title = new JLabel(" TOSS ");
	
		Font f = new Font("Comic sans ms",Font.BOLD,50);
		this.title.setFont(f);
		this.title.setBackground(new java.awt.Color(255,23,0));
		this.title.setForeground(new java.awt.Color(255	,0,0));
	    
		rand = new Random();
		
		//crating first horizontal bar
		hrz1 = Box.createHorizontalBox();
		//adding components to first horiz bar
		hrz1.add(Box.createHorizontalStrut(50));
		hrz1.add(this.title);
		hrz1.add(Box.createHorizontalStrut(50));
		
	    
		//second horizontal bar components
		
		Font f1 = new Font("Comic sans ms",Font.ITALIC,30);
		toss_label = new JLabel("Choose your option"); 
		toss_label.setFont(f1);
		toss_label.setForeground(new java.awt.Color(0,0,0));
		bg = new ButtonGroup();
		
		heads = new JRadioButton("Heads",false);
		tails = new JRadioButton("tails",false);
		
		
		bg.add(heads);
		bg.add(tails);
		
		go = new JButton("GO");
		go.setFont(f1);
		go.setForeground(new java.awt.Color(250,0,0));

		
		//creating second horizontal bar
		hrz2 = Box.createHorizontalBox();
		//adding components to second horiz bar
		hrz2.add(Box.createHorizontalStrut(30));
		hrz2.add(toss_label);
		hrz2.add(Box.createHorizontalStrut(25));
		hrz2.add(heads);
		hrz2.add(Box.createHorizontalStrut(15));
		hrz2.add(tails);
		
		hrz2.add(Box.createHorizontalStrut(50));
		hrz2.add(go);
		hrz2.add(Box.createHorizontalStrut(30));
		
		hrz2.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		
		//third horizontal bar components
		
		
		result = new JLabel("Toss won by --> "); 
		result_value = new JLabel(" **** ");
		result.setFont(f1);
		result.setForeground(new java.awt.Color(0,0,0));
		result_value.setFont(f1);
		result_value.setForeground(new java.awt.Color(250,0,0));
				
		//creating second horizontal bar
		hrz3 = Box.createHorizontalBox();
		//adding components to second horiz bar
		hrz3.add(Box.createHorizontalStrut(30));
		hrz3.add(result);
		hrz3.add(Box.createHorizontalStrut(50));
		hrz3.add(result_value);
		hrz3.add(Box.createHorizontalStrut(15));
		
		
		hrz3.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		
		//vertical box in the outer layer
		main_vert = Box.createVerticalBox();
		main_vert.add(Box.createVerticalStrut(10));
		main_vert.add(hrz1);
		main_vert.add(Box.createVerticalStrut(40));
		main_vert.add(hrz2);
		main_vert.add(Box.createVerticalStrut(40));
		main_vert.add(hrz3);
		
		
		
		//container settings
		Container c = frame.getContentPane();
		c.setBackground(new java.awt.Color(32,211,14));
		c.add(main_vert);
		
		
		//action listeners for the buttons
		
		//GO button action.
		go.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent event){
				int temp=555;
				try{
					//users choice specification
					if(heads.isSelected()){
						users_choice = "Heads";
					}
					else if(tails.isSelected()){
						users_choice = "tails";
					}
					
					//Toss random generation
					temp = rand.nextInt(2);
					
					dialog_box.showMessageDialog(frame.getContentPane(),"Play the Toss ??? ");
					java.lang.Thread.sleep(3000);
					if(users_choice.equalsIgnoreCase(choice[temp]))
					{	
						dialog_box.showMessageDialog(frame.getContentPane(),"CONGRATS ! You have won the toss !");
						result_value.setText("Yourself");
						int a = JOptionPane.showConfirmDialog(frame.getContentPane(),"You wanna BAT first ?","Batting or Bowling",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(a==0)
						{	users_ultimate_choice = "Bat"; 
							comp_ultimate_choice = "Bowl";
						}
						else
							{
							users_ultimate_choice = "Bowl";
							comp_ultimate_choice = "Bat";
							}
						
					
					}
					else
					{
						dialog_box.showMessageDialog(frame.getContentPane(),"SORRY ! You have lost the toss !");
						result_value.setText("Computer");
						temp = rand.nextInt(2);
						comp_ultimate_choice = toss_result[temp];
						if(comp_ultimate_choice.equalsIgnoreCase("Bat"))
							users_ultimate_choice = "Bowl";
						else
							users_ultimate_choice = "Bat";
						
						dialog_box.showMessageDialog(frame.getContentPane(),"Computer chose to "+comp_ultimate_choice+"!");
					}
					
					PlayGround playGround = new PlayGround("PLAY-GROUND","Player",users_ultimate_choice,comp_ultimate_choice);
					frame.setVisible(false);
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});

		frame.setVisible(true);
		
		
		
	}
}
