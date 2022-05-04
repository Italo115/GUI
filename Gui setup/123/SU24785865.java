// Notes on using this skeleton:
// - The names of variables and functions (both those given in the skeleton and those made by yourself) are up to you, as long as they are sensible.
// - You should document your code well with comments and (as stated above) sensible & logical names.
// - You are free to delete the comments typed in this skeleton.
// - Remember to follow the code specifications given in the project description.

import java.io.*;
import java.lang.*;

// Replace "xxxxxxxx" below with your student number.  Remember to rename this file accordingly.
public class SU24785865 {

    // No global variables or constants allowed.

    // For the first hand-in, it is possible and highly recommended to code the entire program within the main function.
    public static void main(String[] args) {

// 0 0 2 3
    
    	if(args.length<4) {
    		StdOut.println("Not enough arguments.");
    		System.exit(0);
    	}
    	else if(args.length>4) {StdOut.println("Too many arguments.");
    	System.exit(0);}
    	
    	
        int gamemode = Integer.parseInt(args[0]);
        
        int GUI = Integer.parseInt(args[1]);
       
       int n = Integer.parseInt(args[2]);//colours
       
        int k = Integer.parseInt(args[3]);//length of blockades
        
        int m = 0;
        int endgame = 0;
        
        int conditioncounter = 0;
        int losecounter = 1;
        
        
        
        int ColorInt;
        int moveInt;
        int ColumnInt;
        int RowInt;
        char color = '\0';
        
       
        //formula for calculating m 
        for(int counter = 0 ;counter <= n;counter++){
            m = (m+2)*counter;     

        }
        int wincondition = m*m;
        // Checking for functionality, will remove after first hand in
        if((gamemode == 1)||(gamemode == 2)||(GUI == 1)||(n == 4))
        {
        	StdOut.println("Functionality currently not supported"); 
        // Add something that imediately kills program
        System.exit(0);
    
    }


        //Initialization arguments
        while(((gamemode <0)||(gamemode >2))||((GUI < 0 )||(GUI > 1))||((n<2)||(n>4))||((k<3)||(k>m)) ){
            
        	
        	
        	
        	
        	
        	
        	
        	
            if((gamemode <0)||(gamemode >2)){
            	StdOut.print("First/");
                gamemode = 0;
            }
                if((GUI < 0 )||(GUI > 1)){
                	StdOut.print("Second/");
                    GUI = 0;
                }
                if((n<2)||(n>4)){
                	StdOut.print("Third/");
                    n = 2;
                }
                if((k<3)||(k>m)){
                	StdOut.print("Fourth");
                    k = 3;
                }
                StdOut.println(" input reset to default.");
        }
    // Just information about game
        StdOut.println("The Dimension of your board is: "+m +"x"+m);
        StdOut.println("The length of the blockade is: "+k);
        StdOut.println();

    //Game board initialization 
    char[][] gameBoard = new char[m][m];
    //filling row and columns out
   for(int rows = 0; rows < m;rows++){
        for(int columns = 0; columns < m; columns++){
            if(columns == 0){
                gameBoard[rows][columns] = '.';
            }else{
                gameBoard[rows][columns] = '*';

            }
        }
        

   }
  
    
    

while(endgame == 0){
	if(conditioncounter == wincondition) { StdOut.print("Termination: You have won!\n"+"Score: "+((100*conditioncounter)/wincondition)+"%"+"\nMoves: "+conditioncounter+"\nGame ended!");
		endgame = 1;}//Win condition checker
	 
	//lose condition checker comes here!!!!
	 if(conditioncounter != wincondition) {
		 //blockade checker comes here
		 
				 
				 
				 
				 char col = ' ';
				 for (int c = 0; c < 3; c++) {
					 switch (c) {
					 case 0:
						 col = 'G';
						 break;
					 case 1:
						 col = 'Y';
						 break;
					 case 2 :
						 col = 'R';
						 break;
					 }
				 for(int i = 0 ; i < m-1 ;i++) {
					 int count = 1;
					 for(int j = 0; j < m-1;j++) {
						if(gameBoard[i][j] == col){  
							count++;
						} else {
							count = 1;
							}
						
						if (count >= k + 1) {
							StdOut.print("Termination: Blockade!\n\n");
							break;
						}
						}
							
					 }
				 
				 for(int i = 0 ; i < m-1 ;i++) {
					 int count = 1;
					 for(int j = 0; j < m-1;j++) {
						if(gameBoard[j][i] == col){  
							count++;
						} else {
							count = 1;
							}
						
						if (count >= k + 1) {
							StdOut.print("Termination: Blockade!\n\n");
							break;
						}
						}
							
					 }
						
					
				 
				 }//for loop
				 }
				
			
				
				
		 
	 
	 
	//printing out the board
	 for(int rows = 0; rows <m;rows++){
		    for(int columns = 0; columns < m; columns++){
		    	StdOut.print(gameBoard[rows][columns]);
		    }
		    StdOut.println();}
	
    do{StdOut.println("Move: // 0=delete, 1=place block, 2=quit");
   
    moveInt = StdIn.readInt();
   
    switch(moveInt){
    case 0://delete block
    
    	do{//Row picker
        	StdOut.println("Row Number: // start from index 0");
            
           
          RowInt = StdIn.readInt();
           
            if(RowInt>m ||RowInt <0){System.out.println("Invalid move:\nOutside of board!\n");}
        }while(RowInt>m || RowInt<0);

        do{//Column picker
        	StdOut.println("Column Number: // start from index 0");
        
            
           ColumnInt = StdIn.readInt();

        if(ColumnInt>m || ColumnInt<0){StdOut.println("Invalid move:\nOutside of board!");}
        }while(ColumnInt>m || ColumnInt<0);
        
    	if(gameBoard[RowInt][ColumnInt] == '.'||gameBoard[RowInt][ColumnInt] == '*') {
    		StdOut.println("Invalid move:\nNothing to delete!");}
    	else {
    		gameBoard[RowInt][ColumnInt] = '.';
    		gameBoard[RowInt][ColumnInt+1] = '*';
    				conditioncounter = conditioncounter-1;
    	}
    	
    	break;

    case 1://placing block

    do{//Row picker
    	StdOut.println("Row Number: // start from index 0");
        
       
      RowInt = StdIn.readInt();
        
        if(RowInt>m ||RowInt <0){System.out.println("Invalid move:\nOutside of board!");}
    }while(RowInt>m || RowInt<0);

    do{//Column picker
    	StdOut.println("Column Number: // start from index 0");
    
        
       ColumnInt = StdIn.readInt();

    if(ColumnInt>m || ColumnInt<0){StdOut.println("Invalid move:\nOutside of board!");}
    }while(ColumnInt>m || ColumnInt<0);

    do{//Color picker
    if(n == 2){StdOut.println("Color: //0=G, 1=Y");}
    if(n == 3){StdOut.println("Color: //0=G, 1=Y, 2=R");}     
    
    
    ColorInt = StdIn.readInt();
    if(ColorInt>n ||ColorInt<0){StdOut.println("Invalid move: \nUnknown Color!");}
    switch(ColorInt) {
    case 0:
    	color = 'G';
    	break;
    case 1:
    	color = 'Y';
    	break;
    case 2:
    	color = 'R';
    	break;
    }
   
    
    
   }while(ColorInt>m ||ColorInt < 0);
    //Placing block in array
    //validation of proper placement
    if(ColumnInt == 0) {
    gameBoard[RowInt][ColumnInt] = color;
    gameBoard[RowInt][ColumnInt+1] = '.';
    conditioncounter++;}
    else  if(ColumnInt == m) {gameBoard[RowInt][ColumnInt] = color;
    conditioncounter++;
    }
    
    else { 
    	if(gameBoard[RowInt][ColumnInt -1] == '.'||gameBoard[RowInt][ColumnInt] == '*'||gameBoard[RowInt][ColumnInt ] == 'Y'||gameBoard[RowInt][ColumnInt ] == 'G'||gameBoard[RowInt][ColumnInt ] == 'R') {StdOut.print("Invalid move:\nCell is not open\n");}
    	else {gameBoard[RowInt][ColumnInt] = color; gameBoard[RowInt][ColumnInt+1] = '.';
    	conditioncounter = conditioncounter+1;
    	}
    }
    break;


    case 2://end program
    	StdOut.print("Termination: User terminated game!\n"+"Score: "+((100*conditioncounter)/wincondition)+"%"+"\nMoves: "+conditioncounter+"\nGame ended!");
    	System.exit(0);
    break;
    
    
    // check for early game termination
    
    }}while(moveInt>2 || moveInt<0);
    if(losecounter >= k) {
    	StdOut.println(losecounter); //will remove
    	for(int rows = 0; rows <m;rows++){
		    for(int columns = 0; columns < m; columns++){
		    	StdOut.print(gameBoard[rows][columns]);
		    }
		    StdOut.println();}
    	StdOut.println("Termination: Blockade!"+"\nScore: "+((100*conditioncounter)/wincondition)+"%"+"\nMoves: "+conditioncounter+"\nGame ended!");
    
    System.exit(0);}
}//end of while loop
    
    
}//end of main
























}// end of public













        // Handle program arguments (with validation). Arguments can be referenced through the "args" parameter above.
        // The arguments appear in "args" in the order that they were passed into the program on execution.

        // Setup game state variables. Important considerations: How will you store your board? How will you reference the currently selected square?
    

        //boolean gameIsRunning = true;


        // "gameIsRunning" is an example of a game state variable. Add more as you see fit.

        // Enter the game loop. What will happen if you initialize gameIsRunning to false?

        // while (gameIsRunning) {
        //     StdOut.println("We have entered the Game Loop!");
        //     gameIsRunning = false;
        //}

        // What will happen if you remove the "gameIsRunning = false" statement inside the While loop? 

        // After the game is concluded, report the score by printing the state of the game to the terminal. 

        // StdOut.println("Game ended!");
    //}
    
    // For the second hand-in, you must use functions effectively wherever possible. Put these functions here.




