package ParticleSimulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.Timer;

import ParticlePackage.particle;

public class PanelOne extends JPanel
{
	
	private static int r = 5;
	private int numberofparticles;
	private int delay = 50;
	private int height;
	private int width;
	private Timer run;
	private Vector<particle> plist = new Vector<particle>();
	private static ActionListener Start;
	private static ActionListener Stop;
	private static ActionListener Increase;
	private static ActionListener Decrease;
	
	public PanelOne()
	{
		super();
		
		this.setBackground(new Color(0,0,0));
		setLayout(new BorderLayout(5,5));
		
		
		
		addMouseListener(new MouseListener() //mouse event
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int a = arg0.getX();
				int b = arg0.getY();
				int c = (int)(Math.random() * 20 - 10);
				int d = (int)(Math.random() * 20 - 10);
				
				plist.add(numberofparticles, new particle(new MathVector.vector(a,b,0), new MathVector.vector(c,d,0)));
				
				numberofparticles++;
				
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
		}
		);
		
		
		
		final ActionListener create = new ActionListener() 
		{												   //IMPORTANT: Increase/decrease only works properly 
			public void actionPerformed(ActionEvent Time)  //if you stop the timer, click increase/decrease, and click start again
			{
				
				for(int i = 0; i < numberofparticles; i++)
				{
					plist.get(i).update(width, height);	
				}
				
				repaint();
			}
		};
			
		
		
		
		
		Start = new ActionListener() //action listeners
		{
			public void actionPerformed(ActionEvent arg0)
			{
				run = new Timer(delay,create);
				run.start();
			}
		};
		
		Stop = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg1)
			{
				run.stop();
			}
		};
		
		Increase = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg2)
			{
				delay = delay - 10;
				
				if (delay < 20)
				{
					delay = 20;
				}
				
			//	run.stop();
			//	run = new Timer(delay,create);
		//		run.start();
				
			}
		};
		
		Decrease = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg3)
			{
				delay = delay + 10;
				
			//	run.stop();
			//	run = new Timer(delay,create);
			//	run.start();
			}
		};
		
	}
		
	public void paint(Graphics g)
	{
		
		super.paint(g);
		
		width = getWidth();
		height = getHeight();
		
		
		for(int i = 0; i < numberofparticles; i++)
		{
			plist.get(i).draw((int)(plist.get(i).getX()),(int)(plist.get(i).getY()),r,g);
		}

		
		
	}
	
	public static ActionListener Begin()
	{
		return Start;
	}
	
	public static ActionListener End()
	{
		return Stop;
	}
	
	public static ActionListener Increase()
	{
		return Increase;
	}
	
	public static ActionListener Decrease()
	{
		return Decrease;
	}
	

	
	
	
}
