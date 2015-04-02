/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_management;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike
 */

    public class  Process_management extends Frame implements ActionListener
	{
        Open op = new Open();
        FCFS fc;
        SJN sj;
        Robin RR;
		
	
		
		MenuItem miAbout, miOpen, First, Shortest, Round, RunA;
		
		
		String command = "";
			
		public static void main(String[] args) throws FileNotFoundException
		{
			Frame frame = new  Process_management();
			
			frame.setResizable(true);
			frame.setSize(1140,650);
			frame.setVisible(true);
			
		}
		
		public  Process_management()
		{
			setTitle("Process Management");
			
			
			// Create Menu Bar
			   			
			MenuBar mb = new MenuBar();
			setMenuBar(mb);
						
			Menu menu = new Menu("Operations");
			
			// Add it to Menu Bar
						
			mb.add(menu);
			
			// Create Menu Items
			// Add action Listener 
			// Add to "File" Menu Group
			
			miAbout = new MenuItem("About");
			miAbout.addActionListener(this);
			menu.add(miAbout);
                        
                        miOpen = new MenuItem("Open");
			miOpen.addActionListener(this);
			menu.add(miOpen);
                        
                        
                        
                        First = new MenuItem("First-Come First-Served");
			First.addActionListener(this);
			menu.add(First);
                        
                        Shortest = new MenuItem("Shortest Job Next");
			Shortest.addActionListener(this);
			menu.add(Shortest);
                        
                        Round = new MenuItem("Round-Robin");
			Round.addActionListener(this);
			menu.add(Round);
                        
                        RunA = new MenuItem("Run All");
			RunA.addActionListener(this);
			menu.add(RunA);
                        
                        
		    
			
			MenuItem miExit = new MenuItem("Exit");
			miExit.addActionListener(this);
			menu.add(miExit);
				
			// End program when window is closed
			
			WindowListener l = new WindowAdapter()
			{
							
				public void windowClosing(WindowEvent ev)
				{
					System.exit(0);
				}
				
				public void windowActivated(WindowEvent ev)
				{
					repaint();
				}
				
				public void windowStateChanged(WindowEvent ev)
				{
					repaint();
				}
			
			};
			
			ComponentListener k = new ComponentAdapter()
			{
				public void componentResized(ComponentEvent e) 
				{
	        		repaint();           
	    		}
			};
			
			// register listeners
				
			this.addWindowListener(l);
			this.addComponentListener(k);

		}
		
	//******************************************************************************
	//  called by windows manager whenever the application window performs an action
	//  (select a menu item, close, resize, ....
	//******************************************************************************

		public void actionPerformed (ActionEvent ev) 
			{
				// figure out which command was issued
				
				command = ev.getActionCommand();
				
				// take action accordingly
				
				
				if("About".equals(command))
				{
					
					repaint();
				}
                                else
					if("Open".equals(command))
					{
                                    try {
                                        this.op.rpen();
                                        this.fc = new FCFS();
                                        this.sj = new SJN();
                                        this.RR = new Robin();
                                        repaint();
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(Process_management.class.getName()).log(Level.SEVERE, null, ex);
                                    }
						
					}
                                else
					if("First-Come First-Served".equals(command))
					{
						repaint();
					}
                                        else
					if("Shortest Job Next".equals(command))
					{
						repaint();
					}
                                        else
					if("Round-Robin".equals(command))
					{
						repaint();
					}
                                        else
					if("Run All".equals(command))
					{
						repaint();
					}
				
				else
					if("Exit".equals(command))
					{
						System.exit(0);
					}

			}
	//********************************************************
	// called by repaint() to redraw the screen
	//********************************************************
			
			public void paint(Graphics g)
			{
				
				
				if("Open".equals(command))
				{
					g.drawString("Opened",       200, 200);
					g.drawLine(200,210,600,210);
					
					
					
					
					
					
				}	
				
				else	
				if("About".equals(command))
				{
					int x = 200;
					int y = 200;
					g.drawString("This Program Demonstrates different Schedulers", x,y);
                                        
				}else if("First-Come First-Served".equals(command))
				{
					int x = 50;
					int y = 150;
                                        g.drawString("Total Number of Processes: 90", 430, 70);
                                        g.drawString("Total period of evaluation: " + fc.res, 430, 85);
                                        g.drawString("Scheduling Policy: FCFS", 430, 100);
                                        
					for(int i = 0; i < 90; i++){
                                            if(i == 0 || i == 30 || i == 60){
                                            g.drawString("Processor ID", x - 30, y-15);
                                            g.drawString("Processor Time", x+50, y-15);
                                            g.drawString("Wait Time", x+150, y-15);
                                            g.drawString("Trurnaround Time", x+ 220, y-15);
                                            }
						g.drawString(Integer.toString(i), x, y);
                                                g.drawString(Integer.toString(op.arrayWor(i)), x+80, y);
                                                g.drawString(Integer.toString(fc.wait[i]), x + 160, y);
                                                g.drawString(Integer.toString(fc.turn[i]), x + 240, y);
                                                y = y + 15;
                                                if(i == 29 || i == 59){
                                                    y = 150;
                                                    x = x + 380;
                                                    
                                                }
                                        }
                                        x = 430;
                                        y = 600;
                                        g.drawLine(x - 20, 603, x +280, 603);
                                        for(int i = 0; i < 2; i++){
                                        if(i == 1){    
                                        g.drawString("Average Wait Time", x, y);
                                        g.drawString(Integer.toString(fc.returnWait()), x + 20, y + 15);
                                        }
                                        else {
                                        g.drawString("Average Turnaround Time", x, y);
                                        g.drawString(Integer.toString(fc.returnTurn()), x + 20, y + 15);}
                                        x = x + 160;
                                        }
						
					
                                }
                                else if("Shortest Job Next".equals(command))
				{
					int x = 50;
					int y = 150;
                                        g.drawString("Total Number of Processes: 90", 430, 70);
                                        g.drawString("Total period of evaluation: " + sj.res, 430, 85);
                                        g.drawString("Scheduling Policy: SJN", 430, 100);
					for(int i = 0; i < 90; i++){
                                            if(i == 0 || i == 30 || i == 60){
                                            g.drawString("Processor ID", x - 30, y-15);
                                            g.drawString("Processor Time", x+50, y-15);
                                            g.drawString("Wait Time", x+150, y-15);
                                            g.drawString("Trurnaround Time", x+ 220, y-15);
                                            }
						g.drawString(Integer.toString(i), x, y);
                                                g.drawString(Integer.toString(op.arrayWor(i)), x+80, y);
                                                g.drawString(Integer.toString(sj.wait[i]), x + 160, y);
                                                g.drawString(Integer.toString(sj.turn[i]), x + 240, y);
                                                y = y + 15;
                                                if(i == 29 || i == 59){
                                                    y = 150;
                                                    x = x + 380;
                                                    
                                                }
                                        }
                                        x = 430;
                                        y = 600;
                                        g.drawLine(x - 20, 603, x +280, 603);
                                        for(int i = 0; i < 2; i++){
                                        if(i == 1){    
                                        g.drawString("Average Wait Time", x, y);
                                        g.drawString(Integer.toString(sj.returnWait()), x + 20, y + 15);
                                        }
                                        else {
                                        g.drawString("Average Turnaround Time", x, y);
                                        g.drawString(Integer.toString(sj.returnTurn()), x + 20, y + 15);}
                                        x = x + 160;
                                        }
						
					
                                }
                                else if("Round-Robin".equals(command))
				{
					int x = 50;
					int y = 150;
                                        g.drawString("Total Number of Processes: 90", 430, 70);
                                        g.drawString("Total period of evaluation: " + RR.tturn, 430, 85);
                                        g.drawString("Scheduling Policy: RR", 430, 100);
					for(int i = 0; i < 90; i++){
                                            if(i == 0 || i == 30 || i == 60){
                                            g.drawString("Processor ID", x - 30, y-15);
                                            g.drawString("Processor Time", x+50, y-15);
                                            g.drawString("Wait Time", x+150, y-15);
                                            g.drawString("Trurnaround Time", x+ 220, y-15);
                                            }
						g.drawString(Integer.toString(i), x, y);
                                                g.drawString(Integer.toString(op.arrayWor(i)), x+80, y);
                                                g.drawString(Integer.toString(RR.wait[i]), x + 160, y);
                                                g.drawString(Integer.toString(RR.turn[i]), x + 240, y);
                                                y = y + 15;
                                                if(i == 29 || i == 59){
                                                    y = 150;
                                                    x = x + 380;
                                                    
                                                }
                                        }
                                        x = 430;
                                        y = 600;
                                        g.drawLine(x - 20, 603, x +280, 603);
                                        for(int i = 0; i < 2; i++){
                                        if(i == 1){    
                                        g.drawString("Average Wait Time", x, y);
                                        g.drawString(Integer.toString(RR.returnWait()), x + 20, y + 15);
                                        }
                                        else {
                                        g.drawString("Average Turnaround Time", x, y);
                                        g.drawString(Integer.toString(RR.returnTurn()), x + 20, y + 15);}
                                        x = x + 160;
                                        }
						
					
                                }
                                
				else
					if("Run All".equals(command))
					{
						g.drawString("Scheduling Policy",200, 200);
                                                g.drawString("Average Wait Time", 320, 200);
                                                g.drawString("Average Turnaround", 440, 200);
					       g.drawLine(200,205,600,205);
                                               g.drawString("FCFS", 230, 220);
                                                g.drawString(Integer.toString(fc.returnWait()), 350, 220);
                                                 g.drawString(Integer.toString(fc.returnTurn()), 460, 220);
                                               g.drawString("SJN", 230, 235);
                                                g.drawString(Integer.toString(sj.returnWait()), 350, 235);
                                                 g.drawString(Integer.toString(sj.returnTurn()), 460, 235);
                                               g.drawString("RR", 230, 250);
                                                g.drawString(Integer.toString(RR.returnWait()), 350, 250);
                                                 g.drawString(Integer.toString(RR.returnTurn()), 460, 250);
					}	
			}

}
    

