//*********************************************************************************************************************************
// PascalTriangle.java
//
// 
// Represents Pascals's triangle. Recursively calculates the values on any given line of the triangle, 
// given that each value on the inside of the triangle is the sum of the two values above it.
// 
//
//
//*********************************************************************************************************************************


public class PascalTriangle
{

	private String name;
	private int size, row, col;													//Represents the number of lines the triangle has.
	
	private int [][] pTriangle;													//2-D array (matrix) to hold int values of triangle
	
	
	
	
	/** 
	*		
	*	Ctor creates a 2D array to hold the Pascales triangle. Note the number of numbers on each line is the same as the number of lines in
	*	the triangle, so size can be used for both values. Calls populateT method to populate the triangle.
	*		
	**/
	public PascalTriangle(int size, String name)
	{
		this.size = size;
		this.name = name;
		
		pTriangle = new int[size][size];
		
		this.populateT(0, 0);
	}		
		
	
	/** 
	 *	Populates the Pascal's Triangle recursively. Note case where size = 1, recursion does not occur since only 1 integer can be added
	 *	to array.
	 *	Also note base case where base of triangle is reached and recursion stops.
	 **/						
	private void populateT(int row, int col)
	{
		if(size > 0 && size == 1)													//Base case when size is 1 and greater than 0.
		{
			pTriangle[0][0] = 1;
		}
		
		
		else if(size > 1)															//Else if size > 1, recursion can occur.
		{
			if (col==0 && row == 0)													//First value.		
			{
				pTriangle[row][col] = 1;
			}
			
			else if (row != 0 && col == 0 || col == row)
			{
				pTriangle [row][col] = 1;									       //1 Set for first value in each line and last value in each line.
			}
			
			else if(row > 1 && col != 0 && col != row) 					      	//Values in between first and last calculated from the two above them, to left and just above.
			{
				pTriangle[row][col] = (pTriangle[row-1][col-1]) + (pTriangle[row-1][col]);
			}
			
			if (col < row)						                              //Move over and give values to indexes recursively until number of columns will match row number. 	
			{
				populateT(row, col+1);			                             //Recursive call here.
			}
		
			else if(col >= row && row < pTriangle.length-1)		//If number of columns is greater than or equal to number or rows and number of rows is not exceeded.
			{	
				col = 0;										//Col reset.
				populateT(row+1, col);							//Move to next row as long as base of triangle is not exceeded, recursive call again here.
			}
				
		}
		
		
	}
	
	
	
	/**
	 *	 Prints a string containing the values on a given line of the PascalTriangle. Note 1 is subtracted from lineNumber to get correct index.
	 **/
	public String getLine(int lineNumber)
	{
		lineNumber = lineNumber - 1;
		int baz;
		String result = "";
		
		for(int biz = 0; biz < pTriangle[lineNumber].length; biz++)
		{	
			baz = pTriangle[lineNumber][biz];
			if (baz == 0)
			{
				result += " - ";
			}
			
			else
			{
			      result += Integer.toString(baz)+" ";
		    }
				
		}   //End-for
		
		System.out.println(name+", Line number "+ (lineNumber+1) +": "+result);
		
		return result;
	}
	

}