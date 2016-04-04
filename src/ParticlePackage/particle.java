package ParticlePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import MathVector.vector;


public class particle extends MathVector.vector
{
	private vector velocity;
	private int lifespan;
	private int age;
	private int size;
	private static boolean life = true;
	public static final vector gravity = new vector (0, -9.8, 0);
	public static vector wind = new vector (0, 0, 0);

	public particle(){};
	
	public particle(vector position, vector velocity)
	{
		x = position.x;
		y = position.y;
		z = position.z;
		this.velocity = velocity;
		lifespan = 10;
		age = 0;
		size = 0;
	}
	

	public void setVelocity(double a, double b, double c)
	{
		velocity = new vector(a,b,c);
	}
	
	vector getVelocity()
	{
		return velocity;
	}
	
	public void setLifespan(int a)
	{
		lifespan = a;
	}
	
	int getLifespan()
	{
		return lifespan;
	}
	
	public void setAge(int a)
	{
		age = a;
	}
	
	int getAge()
	{
		return age;
	}
	
	public void setSize(int a)
	{
		size = a;
	}
	
	int getSize()
	{
		return size;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + "," + z + ") (" + velocity.x + "," + velocity.y + "," + velocity.z + ")"; 
	}
	
	public void update(int width, int height)
	{
		if (x <  0 || x > width)
		{
			setVelocity(velocity.x * -1, velocity.y, 0);
		}
		
		if ( y <  0 || y > height)
		{
			setVelocity(velocity.x,velocity.y * -1,0);
		}
		

		add(velocity);
		
//		velocity.add(gravity);
//		velocity.add(wind);
		
//		age++;
	}
	
	public boolean isalive()
	{
		if (age <= lifespan)
		{
			life = true;
			return life;
		}
		
		else
		{
			life = false;
			return life;
		}
	}
	
	public void draw(int a, int b, int c, Graphics g)
	{
		Graphics2D  graph = (Graphics2D)g;
		if (life = true)
		{	
			graph.setColor(Color.GREEN);
			graph.fillOval(a, b, c, c);
			
		}
		if (life = false)
		{
			
		}
	}

}
