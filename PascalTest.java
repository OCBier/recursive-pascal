//*******************************************************************************************************************************************************************************************
// PascalTest.java
//
// 
// tests the PascalTriangle class by creating a few Pascal's Triangles of different size as PascalTriangle objects. then calls the getLine method of PascalTriangle class to print some of the lines
// of the Triangles. tests include printing lines in the Triangle, as well as Trying to print the first line and non-existent lines of some Triangles.
// Anticipated exception (ArrayIndexOutOfBounds exception), occurring if line (row) outside of array is attempted to be accesed, is handled.
//
//
//
//*******************************************************************************************************************************************************************************************


public class PascalTest


{

	public static void main (String[] args)
	{
			
		try
		{
			PascalTriangle t1 = new PascalTriangle(1, "Triangle 1");		//Triangle with only one line created (so not a Triangle); test for condition size == 1.
			PascalTriangle t2 = new PascalTriangle(9, "Triangle 2");
			PascalTriangle t3 = new PascalTriangle(3, "Triangle 3");
			PascalTriangle t4 = new PascalTriangle(5, "Triangle 4");			
			PascalTriangle t5 = new PascalTriangle(14, "Triangle 5");		//test for larger Triangle.
							
			
			t1.getLine(1);					//test for first line.
			t2.getLine(4);
			t2.getLine(9);					//test for last line.
			t3.getLine(1);					//test for first line.
			t3.getLine(2);
			t3.getLine(3);
			t4.getLine(4);
			t4.getLine(1);					//test for first line.
			t5.getLine(13);
			t5.getLine(15);					//test for out of bounds exception.
		
		}
		
		
		catch(ArrayIndexOutOfBoundsException exception)
		{	System.out.println();
			
			System.out.println("Tried to access values beyond the bounds of a triangle's array. Stack Trace: " +exception.getMessage());
			exception.printStackTrace();
			
		}
	}	
	

		
}