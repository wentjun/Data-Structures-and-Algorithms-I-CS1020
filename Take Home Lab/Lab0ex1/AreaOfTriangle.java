// CS1020 (AY2014/5 Semester 2)
// Name: CHAN WEN TJUN
// Matric. No.: A0121262
// Lab group: (unallocated as of now)
/* Calculates area of a triangle using Heron's formula by reading 3 positive 
real numbers which are the lengths of a triangle. The program will check if
the input values can represent the length of 3 sides of a triangle. The area
will be calculated if it is a valid triangle.
*/

import java.util.*;
  
public class AreaOfTriangle {
 
     //class method for area of triangle by Heron's formula
    public static double area(double a, double  b, double c) {
        //p represents half the perimeter of a triangle
        double p = (a + b + c) / 2;
        // represents area of triangle
        return  Math.sqrt(p*(p - a)*(p - b)*(p- c));
    }
	
	//class method to test if triangle is valid  
    public static boolean validTriangle(double a, double b, double c) {
        return (((a + b) > c) && ((a + c) > b) && ((b + c) >a));
    }   
	
	public static void main(String[] args) {
        double sideA, sideB, sideC; 
        boolean valid = true;
  
        Scanner sc = new Scanner(System.in);
        
		//input to ask for the 3 lengths of the supposed triangle
        System.out.print("Enter 3 lengths: ");
		sideA = sc.nextDouble(); 
        sideB = sc.nextDouble();
        sideC = sc.nextDouble();
  
        valid = validTriangle(sideA, sideB, sideC);
  		
		//only prints out the area of the triangle if triangle is valid
        if (valid) {
            System.out.printf("Area = %.2f\n",
                              area(sideA, sideB, sideC));
        } else {
            System.out.println("Invalid triangle!");
        }
    }    
}
