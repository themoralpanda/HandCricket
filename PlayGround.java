package com.HandCricket;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class PlayGround extends CricketFrame{
	static int bowlCounter = 0;
	int comp_score,comp_temp_score,targetScore=0;
	int player_score,player_temp_score;
	String playerName, playerChoice, computerChoice;
	int computerScore=0,computerCurrentScore =0,playerCurrentScore=0, playerScore=0,wickets_count=3;
	int playerGameScore =0, computerGameScore=0;
	int turn =0;
	
	
	//components in first bar
	JLabel fL1,fL2,fL3;
	JLabel target, target_value, team, team_score, wickets, wickets_value; 
	Box fvert1,fvert2,fvert3;
	Box fvert3_hrz1, fvert3_hrz2, fvert3_hrz3, fvert3_hrz4;
	
	//components in the second bar
	JLabel sL1,sL2,sL3;
	JButton hit;
	Box sBox1,sBox2;
	Box s_vert;
	
	//components in the third bar
	JLabel tL1,tL2,tL3;
	
	Box hrz1,hrz2,hrz3;
	Box main_vert;
	
	public PlayGround(String title,String playerName,String playerChoice,String computerChoice){
		super(title);		
		this.playerName = playerName;
		this.playerChoice = playerChoice;
		this.computerChoice = computerChoice;
		Font f1 = new Font("Georgia ",Font.BOLD,25);
		Font f2 = new Font("Comic sans ms",Font.ITALIC,30);
		Font f3 = new Font("Comic sans ms",Font.BOLD,30);
		//first horizontal bar
		fL1 = new JLabel("Computer    VS");
		fL2 = new JLabel(playerName);//inp reqd *
		fL1.setFont(f1);
		fL2.setFont(f2);
		fL1.setForeground(new java.awt.Color(0,0,0));
		fL2.setForeground(new java.awt.Color(250,250,250));
		
		
		
		fL3 = new JLabel("SCOREBOARD");
		target = new JLabel("TARGET"); //inp reqd
		target.setFont(f1);
		target.setForeground(new java.awt.Color(1,1,1));
		target_value = new JLabel("0");//inp reqd
		target_value.setFont(f1);
		target_value.setForeground(new java.awt.Color(250,250,250));
		team = new JLabel("comp/you"); //inp reqd
		team_score = new JLabel("team Score");//inp reqd
		wickets = new JLabel("Wickets Remaining");
		wickets_value = new JLabel("3");//inp reqd
		wickets_value.setFont(f2);
		wickets_value.setForeground(new java.awt.Color(250,250,250));
		
		//crating first horizontal bar
		hrz1 = Box.createHorizontalBox();
		fvert1 = Box.createVerticalBox();
		fvert2 = Box.createVerticalBox();
		fvert3 = Box.createVerticalBox();
		
		fvert3_hrz1 = Box.createHorizontalBox();
		fvert3_hrz2 = Box.createHorizontalBox();
		fvert3_hrz3 = Box.createHorizontalBox();
		fvert3_hrz4 = Box.createHorizontalBox();
		//adding components to first horiz bar
		fvert1.add(fL1);
		fvert2.add(fL2);
		
		
		fL3.setForeground(new java.awt.Color(250,1,0));
		fL3.setFont(f1);
		fvert3_hrz1.add(fL3);
		
		
		
		fvert3_hrz2.add(target);
		fvert3_hrz2.add(Box.createHorizontalStrut(58));
		fvert3_hrz2.add(target_value);
		
		if(this.playerChoice.equalsIgnoreCase("Bat"))
			{team.setText(this.playerName);
			team.setFont(f2);
			team.setForeground(new java.awt.Color(250,250,250));
			}
		else
			{team.setText("Computer");
			team.setFont(f2);
			team.setForeground(new java.awt.Color(0,0,0));}
		
		
		
		fvert3_hrz3.add(team);
		fvert3_hrz3.add(Box.createHorizontalStrut(10));
		
		team_score.setText(String.valueOf(playerScore));
		team_score.setFont(f2);
		team_score.setForeground(new java.awt.Color(1,1,1));
		fvert3_hrz3.add(team_score);
		
		wickets.setFont(new Font("Arial",Font.BOLD,15));
		wickets.setForeground(new java.awt.Color(250,250,250));
		fvert3_hrz4.add(wickets);
		fvert3_hrz4.add(Box.createHorizontalStrut(30));
		fvert3_hrz4.add(wickets_value);
		
	    fvert3.add(fvert3_hrz1);
	    fvert3.add(Box.createVerticalStrut(10));
	    fvert3.add(fvert3_hrz2);
	    fvert3.add(Box.createVerticalStrut(10));
	    fvert3.add(fvert3_hrz3);
	    fvert3.add(Box.createVerticalStrut(10));
	    fvert3.add(fvert3_hrz4);
	    fvert3.setBackground(Color.gray);
	    
	    
	    fvert3.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
	    
	    hrz1.add(fvert1);
	    hrz1.add(Box.createHorizontalStrut(30));
	    hrz1.add(fvert2);
	    hrz1.add(Box.createHorizontalStrut(70));
	    hrz1.add(fvert3);
  
		//second horizontal bar
		sL1 = new JLabel(" Player  ");//inp reqd *
		if(playerChoice.equalsIgnoreCase("Bat"))
			sL2 = new JLabel(playerChoice+"ting");//inp reqd
		else
			sL2 = new JLabel(playerChoice+"ing");//inp reqd
		sL2.setForeground(new java.awt.Color(250,1,0));
		sL2.setFont(f1);
		
		sL3 = new JLabel(" *** ");//inp reqd
		sL3.setFont(f2);
		sL3.setForeground(new java.awt.Color(250,250,250));
		if(sL2.getText().equalsIgnoreCase("Batting"))
			hit = new JButton("Hit"); //inp reqd
		else
			hit = new JButton("Bowl");
		
		sL1.setFont(f3);
		sL1.setForeground(new java.awt.Color(250,250,250));
		
		hit.setFont(f1);
		hit.setForeground(new java.awt.Color(0,0,250));
		
		//creating second horizontal bar
		hrz2 = Box.createHorizontalBox();
		sBox1 = Box.createHorizontalBox();
		sBox2 = Box.createHorizontalBox();
		s_vert = Box.createVerticalBox();
		
		//adding components to second horiz bar
		sBox1.add(sL1);
		sBox1.add(Box.createHorizontalStrut(250));
		sBox1.add(sL2);
		
		sBox2.add(sL3);
		sBox2.add(Box.createHorizontalStrut(190));
		sBox2.add(hit);
		
		s_vert.add(sBox1);
		s_vert.add(Box.createVerticalStrut(58));
		s_vert.add(sBox2);
		
		sBox1.setToolTipText("sbox1 here");//***
		
		
		hrz2.add(s_vert);
		
		//third horizontal bar
		tL1 = new JLabel(" Computer  ");
		tL1.setFont(f3);
		tL1.setForeground(new java.awt.Color(0,0,0));
		
		tL2 = new JLabel("***");//inp reqd
		tL2.setFont(f2);
		tL2.setForeground(new java.awt.Color(0,0,0));
		
		
		if(computerChoice.equalsIgnoreCase("Bat"))
			tL3 = new JLabel(computerChoice+"ting");//inp reqd
		else
			tL3 = new JLabel(computerChoice+"ing");//inp reqd
		
		tL3.setForeground(new java.awt.Color(250,1,0));
		tL3.setFont(f1);
		
		
		//creating third horizontal bar
		hrz3 = Box.createHorizontalBox();
		
		//adding components to third horiz bar
		hrz3.add(Box.createHorizontalStrut(20));
		hrz3.add(tL1);
		hrz3.add(Box.createHorizontalStrut(60));
		hrz3.add(tL2);
		hrz3.add(Box.createHorizontalStrut(80));
		hrz3.add(tL3);
		
		
		hrz1.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		hrz2.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		hrz3.setBorder(javax.swing.border.LineBorder.createBlackLineBorder());
		
		
		main_vert = Box.createVerticalBox();
		main_vert.add(Box.createVerticalStrut(10));
		main_vert.add(hrz1);
		main_vert.add(Box.createVerticalStrut(20));
		main_vert.add(hrz2);
		main_vert.add(Box.createVerticalStrut(20));
		main_vert.add(hrz3);
		main_vert.add(Box.createVerticalStrut(10));
		
		//container settings
		Container c = frame.getContentPane();
		c.setBackground(new java.awt.Color(32,211,14));
		c.add(main_vert);
		frame.setVisible(true);
		
		try {
			java.lang.Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(frame.getContentPane(),"Shall we start playing ?");
		try {
			java.lang.Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(frame.getContentPane(),"Start "+sL2.getText()+" the first ball !");
		
//action listeners for the buttons
		
		//GO button action.
		hit.addActionListener(new ActionListener(){
			Random rand = new Random();

			public void actionPerformed(ActionEvent event){
				Random rand = new Random();	
				try{
					//random number generation
					// rand.nextInt(2);
					
					if(wickets_count!=0){
					  
					  do{
						playerCurrentScore = rand.nextInt(7);
					  }while(playerCurrentScore == 5);
					
					  do{
						computerCurrentScore = rand.nextInt(7);
					  }while(playerCurrentScore == 5);				
					
					sL3.setText(String.valueOf(playerCurrentScore));
					tL2.setText(String.valueOf(computerCurrentScore));
					
					playerScore += playerCurrentScore;
					computerScore += computerCurrentScore;
					
					if (team.getText().equalsIgnoreCase("Player")){
						team_score.setText(String.valueOf(playerScore));
					}
					else
						team_score.setText(String.valueOf(computerScore));
					
					if(computerCurrentScore == playerCurrentScore)
					{	if(sL2.getText().equalsIgnoreCase("Batting"))
						{
							JOptionPane.showMessageDialog(frame.getContentPane(),"Out !!!! You lost a wicket ! Be careful !");
							  playerScore -= playerCurrentScore;
							  team_score.setText(String.valueOf(playerScore));
						}
						else
						{
							JOptionPane.showMessageDialog(frame.getContentPane(),"Ouzzzaaat !!!! Tremendous bowling ! Kudos ! ");
							 computerScore-=computerCurrentScore;
							 team_score.setText(String.valueOf(computerScore));
						}
						
						wickets_count --;
						wickets_value.setText(String.valueOf(wickets_count));
					}
					
					
					bowlCounter++;
					  }
					  
				  
				  else{
					  if(turn<1){
						  turn=1;
						  JOptionPane.showMessageDialog(frame.getContentPane(),"Your "+sL2.getText()+ " is over");
						  JOptionPane.showMessageDialog(frame.getContentPane(),"Please wait while the  net score is being calculated !");
						  
						  computerGameScore = computerScore;
						  playerGameScore = playerScore;
						  
						  playerScore = computerScore = 0;

						  try {
								java.lang.Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(sL2.getText().equalsIgnoreCase("Batting")){
								
								
								JOptionPane.showMessageDialog(frame.getContentPane(),"Your net score is "+String.valueOf(playerGameScore));	
								sL2.setText("Bowling");
								tL3.setText("Batting");
								sL3.setText(String.valueOf(playerScore));
								tL2.setText(String.valueOf(computerScore));
								team.setText("Computer");
								team_score.setText(String.valueOf(computerScore));
								target_value.setText(String.valueOf(playerGameScore+1));
								wickets_count = 3;
								wickets_value.setText(String.valueOf(wickets_count));
							    hit.setText("Bowl");
							    computerScore = 0;
							}
							else{
								JOptionPane.showMessageDialog(frame.getContentPane(),"Computer batting score is "+String.valueOf(computerGameScore));
								sL2.setText("Batting");
								tL3.setText("Bowling");
								sL3.setText(String.valueOf(playerScore));
								tL2.setText(String.valueOf(computerScore));
								team.setText("player");
								team_score.setText(String.valueOf(playerScore));
								target_value.setText(String.valueOf(computerGameScore+1));
								wickets_count = 3;
								wickets_value.setText(String.valueOf(wickets_count));
								 hit.setText("Hit");
								 playerScore =0;
							}
						
							
					  }
					  else{
						  
						  JOptionPane.showMessageDialog(frame.getContentPane(),"Innings is over !");
						  JOptionPane.showMessageDialog(frame.getContentPane(),"Please wait while the games result is being calculated !");
						  
						  if(team.getText().equalsIgnoreCase("Computer")){
							  computerGameScore = computerScore;
							  playerGameScore = Integer.parseInt((target_value.getText())) - 1;;
						  }
						  else
						  {  playerGameScore = playerScore;
						   	 computerGameScore = Integer.parseInt((target_value.getText())) - 1;
						  }
						  try{
						  ResultFrame obj = new ResultFrame("Result" ,computerGameScore,playerGameScore);
						  }
						  catch(Exception e){
							  e.printStackTrace();
						  }
						  
					  }
				  }
				  
				  
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});

	}
}
