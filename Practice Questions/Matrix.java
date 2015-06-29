// This class defines a square matrix and provides the
// following methods:
//  - operate(operation, type): to perform the respective operation
//  - rotate(deg): to rotate the matrix clockwise 
//  - reflectX() : to reflect the matrix across the x-axis
//  - reflectY() : to reflect the matrix across the y-axis
//  - toString() : to return String representation of the matrix
// You are not to add other methods to this class.

class Matrix {
   // Data attributes
   int size;
   int[][] matrix;
   
   // Constructors
   // Default constructor creates a 1x1 matrix
   public Matrix() {
      matrix = new int[1][1];  
   }
   
   // To construct a size x size matrix
   public Matrix(int size) {
      this.size = size;
      matrix = new int[size][size];
   }
   
   // Perform operation
   //  - operation refers to "Rotate" or "Reflect" 
   //  - type refers to "x" or "y"
   public void operate(String operation, String type) {
      if(operation.equals("Rotate")){
         int degree = Integer.valueOf(type);
         this.rotate(degree);
      }else if(operation.equals("Reflect") && type.equals("x")){
         this.reflectX();
      }else
         this.reflectY();
   }
   
   // Rotate the matrix by 'degree' clockwise
   // Note that this is a private method
   private void rotate(int degree) {
      
      int numRotate = 0;
      
      if(degree == 270){
         numRotate = 3;
      }else if(degree == 180){
         numRotate = 2;
      }else 
         numRotate = 1;
      
      int[][] temp = new int[size][size];
      
      for(int flip = 0; flip < numRotate ; flip++){
         
         temp = new int[size][size];
         
         int i = 0;
         int j = 0;
         
         for(int col = 0; col < size ; col++){
            
            for(int row = size -1; row >=0 ; row--){
               temp[i][j] =  matrix[row][col];
               j++;
            }
            j=0;
            i++;
         }
         matrix = temp;
      }
      
      
      
   }
   
   // Reflect the matrix across x-axis
   // Note that this is a private method
   private void reflectX() {
      // Fill in the code
      
      int temp;
      
      for(int row = 0;row<size/2;row++){
         for(int col=0;col<size;col++){
            temp = matrix[row][col];
            matrix[row][col] = matrix[size - row - 1][col];
            matrix[size-row-1][col] = temp;
         }
      }
      
      
   }
   
   // Reflect the matrix across y-axis
   // Note that this is a private method
   private void reflectY() {
      // Fill in the code
      int temp;
      
      for(int col = 0;col<size/2;col++){
         for(int row=0;row<size;row++){
            temp = matrix[row][col];
            //matrix[row][col] = matrix[size - col - 1][col];
            matrix[row][col] = matrix[row][size-col-1];
            matrix[row][size-col-1] = temp;
         }
      }
      
   }
   
   // String representation of matric
   public String toString() {
      String output = "";
      
      for (int r = 0; r < size; r++) {
         for (int c = 0; c < size; c++) {
            if (c > 0)
               output += " ";
            output += matrix[r][c];
         }
         output += "\n";
      }
      return output;
   }
}

