// Notes on using this skeleton:
// - The names of variables and functions (both those given in the skeleton and those made by yourself) are up to you, as long as they are sensible.
// - You should document your code well with comments and (as stated above) sensible & logical names.
// - You are free to delete the comments typed in this skeleton.
// - Remember to follow the code specifications given in the project description.


// Replace "xxxxxxxx" below with your student number.  Remember to rename this file accordingly.
public class SUxxxxxxxx {

    // No global variables or constants allowed.

    // For the first hand-in, it is possible and highly recommended to code the entire program within the main function.
    public static void main(String[] args) {
    	StdDraw.setCanvasSize(400,400);
    	
    	StdDraw.setXscale(50,400);
    	StdDraw.setYscale(50,400);
    	
    	
    	for(int i = 100; i< 300 ; i+=50) {
    		for(int j = 100;j<300;j+=50) {
    		StdDraw.square(i, j, 50);}
    	}
    	
    	
    	
    	
    	StdDraw.square(250, 250, 50);
    	
    	
    	
       
    }
    
    // For the second hand-in, you must use functions effectively wherever possible. Put these functions here.


}

