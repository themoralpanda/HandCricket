package com.HandCricket;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class RulesFrame extends CricketFrame{

	Box b;
	JPanel panel;
	JButton back;
	JTextField j;
	JTextArea jT;
	 RulesFrame(String title){
		 	super(title);
			 b = Box.createVerticalBox();
			
			panel = new JPanel();
			
			
			back = new JButton("Back");
			back.setBackground(Color.yellow);
			Font f = new Font("georgia",Font.ITALIC,20);
			Font f2 = new Font("comic sans ms",Font.HANGING_BASELINE,40);
			j = new JTextField();
			j.setBackground(new java.awt.Color(32,211,14));
			j.setForeground(Color.white);
			j.setText("GUIDANCE:");
			j.setFont(f2);
			j.setEditable(false);
		
			jT = new JTextArea();
			jT.setPreferredSize(new Dimension(450,560));
			jT.setLineWrap(true);
			jT.setWrapStyleWord(true);
			//jT.setBackground(new java.awt.Color(32,211,14));
			jT.setForeground(Color.RED);
			jT.setFont(f);
			jT.setText("\n\n\n\n* Random runs will be generated for each ball to both bowling & batting team\n\n* If the runs coincide,then the batting team loses a wicket.Else,   runs will be added to the batting team's scorecard.\n\n* A team has a total of 3 wickets\n\n* Once the 3 wickets fell,the fielding team has to chase the target");
			jT.setEditable(false);
			
			b.add(j);
			b.add(jT);
			
			panel.add(back);
			panel.setBackground(new java.awt.Color(32,211,14));
			b.add(panel);
			
			
			//action listeners for the buttons
			
			//Back button action.
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					try{
					  frame.setVisible(false);					
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			});		
			//frame.add(panel);
			Container c = frame.getContentPane();
			c.add(b);
			frame.setVisible(true);
			
	 }
}
