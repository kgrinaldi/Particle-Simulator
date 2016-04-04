package MathVector;

import java.awt.Graphics;

public class vector 
{
	public double x,y,z;

	public vector(){};
	
	public vector(double a, double b, double c)
	{
		x = a;
		y = b;
		z = c;
	}
	
	public void setX (double a)
	{ 
		x = a; 
	}
	
	public double getX ()
	{
		return x;
	}
	
	public void setY (double a)
	{
		y = a;
	}
	
	public double getY ()
	{
		return y;
	}
	
	public void setZ (double a)
	{
		z = a;
	}
	
	public double getZ()
	{
		return z;
	}
	
	public String toString()        //toString method
	{
		return "(" + x + "," + y + "," + z + ")";
	}
	
	public boolean equals (vector rhs)
	{
		if ( getX() == rhs.getX() && getY() == rhs.getY() && getZ() == rhs.getZ())
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public static boolean equals (vector lhs, vector rhs)
	{
		if (lhs.getX() == rhs.getX() && lhs.getY() == rhs.getY() && lhs.getZ() == rhs.getZ())
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	public void add (vector rhs)
	{
		x = getX() + rhs.getX();
		y = getY() + rhs.getY();
		z = getZ() + rhs.getZ();
		
	}
	
	public static vector add (vector lhs, vector rhs)
	{
		double a,b,c;
		
		a = lhs.getX() + rhs.getX();
		b = lhs.getY() + rhs.getY();
		c = lhs.getZ() + rhs.getZ();
		
		vector v = new vector(a, b, c);
		
		return v;
		
	}
	
	public void subtract (vector rhs)
	{
		
		x = getX() - rhs.getX();
		y = getY() - rhs.getY();
		z = getZ() - rhs.getZ();
		
	}
	
	public static vector subtract (vector lhs, vector rhs)
	{
		double a,b,c;
		
		a = lhs.getX() - rhs.getX();
		b = lhs.getY() - rhs.getY();
		c = lhs.getZ() - rhs.getZ();
		
		vector v = new vector(a, b, c);
		
		return v;
	}
	
	public double Magnitude ()
	{
		return Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) );
	}
	
	public static double Magnitude (vector v)
	{
		return Math.sqrt( Math.pow(v.getX(), 2) + Math.pow(v.getY(), 2) + Math.pow(v.getZ(), 2) );
	}
	
	public double DotProduct (vector rhs)
	{
		double a,b,c;
		
		a = getX() * rhs.getX();
		b = getY() * rhs.getY();
		c = getZ() * rhs.getZ();
		
		return a + b + c;
	}
	
	public static double DotProduct (vector lhs, vector rhs)
	{
		double a,b,c;
		
		a = lhs.getX() * rhs.getX();
		b = lhs.getY() * rhs.getY();
		c = lhs.getZ() * rhs.getZ();
		
		return a + b + c;
	}
	
	public vector CrossProduct (vector rhs)
	{
		double a,b,c;
		
		a = getY() * rhs.getZ() - getZ() * rhs.getY();
		b = getZ() * rhs.getX() - getX() * rhs.getZ();
		c = getX() * rhs.getY() - getY() * rhs.getX();
		
		vector v = new vector (a,b,c);
		
		return v;
	}
	
	public static vector CrossProduct (vector lhs, vector rhs)
	{
		double a,b,c;
		
		a = lhs.getY() * rhs.getZ() - lhs.getZ() * rhs.getY(); //this got the right answer
		b = lhs.getZ() * rhs.getX() - lhs.getX() * rhs.getZ(); //this didnt
		c = lhs.getX() * rhs.getY() - lhs.getY() * rhs.getX();
		
		vector v = new vector (a,b,c);
		
		return v;
	}
	
	public vector ScaleMultiply (double s)
	{
		double a,b,c;
		
		a = getX() * s;
		b = getY() * s;
		c = getZ() * s;
		
		vector v = new vector(a, b, c);
		
		return v;
	}
	
	public static vector ScaleMultiply (double s, vector rhs)
	{
		double a,b,c;
		
		a = rhs.getX() * s;
		b = rhs.getY() * s;
		c = rhs.getZ() * s;
		
		vector v = new vector(a, b, c);
		
		return v;
	}
	
	public vector Projection(vector basis)
	{
		vector first = new vector(x,y,z);
		
		double a = DotProduct(first,basis); //dot product on top
		double b = DotProduct(basis,basis); //dot product on bottom
		double c = Magnitude() * b;         //multiplying magnitude w/ dot product on bottom
		double d = a / c;                   //creates double needed to use scale multiply
		
		return ScaleMultiply(d, basis);
	}
	
	public static vector Projection(vector v, vector basis)
	{
		double a = DotProduct(v,basis); //dot product on top
		double b = DotProduct(basis,basis); //dot product on bottom
		double c = v.Magnitude() * b;         //multiplying magnitude w/ dot product on bottom
		double d = a / c;                   //creates double needed to use scale multiply
		
		return ScaleMultiply(d, basis);
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	
}
