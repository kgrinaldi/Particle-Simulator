package ParticleSimulator;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import ParticleSimulator.PanelOne;
import ParticleSimulator.PanelTwo;




public class Frame extends JFrame
{
	public Frame(int height, int width)
	{
		super();
	
	
		this.setLayout(new BorderLayout(10,2));

		this.add(new PanelOne(), BorderLayout.CENTER);
		this.add(new PanelTwo(), BorderLayout.EAST);

/*		BufferedImage bi = null;		
		File inputfile = new File("./MegaMan.png");
		try 
		{
			bi = ImageIO.read(inputfile);
		} 
		catch (IOException e) 
		{
			System.out.println("read error, exiting");
			System.exit(0);
		}
*/

		this.setTitle("Bounce");
		this.setSize(400, 500);                           
		this.setLocationRelativeTo(null);					
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		
		Frame f = new Frame(300, 500);

	}

}
