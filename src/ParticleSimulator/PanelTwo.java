package ParticleSimulator;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ParticleSimulator.PanelOne;

public class PanelTwo extends JPanel
{
	
	public PanelTwo()
	{
		setLayout( new GridLayout(15,1,10,2));
		
		
		JButton Start = new JButton("Start");
		JButton Stop = new JButton("Stop");
		JButton Increase = new JButton("Increase");
		JButton Decrease = new JButton("Decrease");

		
		Start.addActionListener(PanelOne.Begin());
		Stop.addActionListener(PanelOne.End());
		Increase.addActionListener(PanelOne.Increase());
		Decrease.addActionListener(PanelOne.Decrease());
		
		
		add(Start);
		add(Stop);
		add(Increase);
		add(Decrease);
	}
		

}
