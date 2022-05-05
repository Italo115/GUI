class GuiExample {

    public static void main(String[] args) {

        // set up values to capture which cell the user is currently highlighting.
        int currCol = 0;
        int currRow = 0;

        // call the canvas setup function
        initCanvas();

        // lets draw the highlight around the cell 0,0
        drawHighlight(currRow, currCol);

        boolean gameIsOver = false;
        /**
         * While the game is not over, continue waiting for the next keyboard input.
         * If you the state of this boolean to false, the interface will not be drawn (the game will exit)
         */
        while (!gameIsOver) {

            /**
             * Wait for the next key to be pressed. The semi-colon here is very important. 
             * While the user has not pressed any keys, we sit in the while loop indefinitely.
             * Once a key is pressed, we can exit the loop, and capture the key.
             */
            while (!StdDraw.hasNextKeyTyped());

            /**
             * Once a key has been pressed, process it as below, and then return to waiting above.
             */
            char pressed =  StdDraw.nextKeyTyped();
            /**
             * This StdDraw.pause() statement is also very important.
             *  The computer is so fast that after you capture and parse a keystroke, the outer for loop prompts the next iteration while the key is still being pressed.
             * This leads to duplicate parse attempts of the same key.
             * If you are getting a NoSuchElementException, it is likely because you are trying to call StdDraw.nextKeyTyped() to parse a NEW keystroke, when in reality the loops caused you to parse the same keystroke twice.
             */
            StdDraw.pause(100);
            /**
             * A switch statement is simply a glorified if-else statement.
             * It is convenient in this case, but if you are more confident with if-else chains, that is fine.
             */
            switch (pressed) {

                case 'w':
                    // W pressed implies moving up.
                    if (currRow > 0) currRow--;
                    break;
                case 'a':
                    // A pressed involves moving left.
                    if (currCol > 0) currCol--;
                    break;
                case 's':
                    // S pressed implies moving down.
                    if (currRow < 8) currRow++;
                    break;
                case 'd':
                    // D pressed implies moving right.
                    if (currCol < 8) currCol++;
                    break;
                // How would you implement quitting?

                // if they didnt press 'w'  'a'  's'  'd' keys, the default condition will be called
                default:
                    System.out.printf("The key: %s is not recognized\n", pressed);
                    break;
            }

            // once currRow and currCol have been updated accordingly, draw the highlight.
            drawHighlight(currRow, currCol);

        }

    }

    /**
     * This function is used to initialize the Standard Draw canvas. The intention is for this function
     * to be called only once, at the start of the program.
     * 
     * The first line of the function sets up the canvas size (a width and heigh in pixels)
     *     800 X 800 is chosen arbitrarily, you can make the canvas window larger or smaller as you choose
     * 
     * The second and third lines define the basis scale of the canvas.
     * This means -- when you specify coordinates to place components later, the coordinate location is specified with respect to the basis defined here.
     */
    public static void initCanvas() {

        // Double buffering only displays the canvas when a call to StdDraw.show() is made.
        // Enabling this allows for smoother canvas rendering.
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800,1000);
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(1000,0);

        /**
         * If you want to design the background of your app in some way, this is probably
         * where you should do that.
         * Note -- in StdDraw, you cannot delete canvas elements once they have been drawn.
         * If you want to give the appearance that something has been deleted, simply draw over the element you'd like to delete.
         * As a result, it may be desirable to write a function that draws your background for you, so it can be called repeatedly as desired. An example could be:
         */

         drawBackground();

         // This function call will display the canvas when double buffering is enabled.
         StdDraw.show();
         
    }

    /**
     * Draw the blue background, and the 4 squares. 
     */
    public static void drawBackground() {
        /**
         * Color is specified as RGB.
         * Each color can be split into 3 components:  a red, blue and green component.
         * If you dont like this -- you can do something like
         *    StdDraw.setPenColor(StdDraw.BLUE);
         */
        StdDraw.setPenColor(0,0,0);
        /** 
         * Draw a filled rectance centered at 400,400 with half-width 400 and half-height 400.
         * Note these values are not chosen randomly! Our canvas is 800x800.
         * For us to fill the canvas, we should draw a rectangle centered at the MIDDLE of the 800x800 canvas, where the width of the rectangle is 800 and the height 800 (implies half the width is 400.)
         */ 
        StdDraw.filledRectangle(400, 600, 400, 600);

        /**
         * Using similar logic, lets draw the 4 other squares.
         * Lets keep the CENTERS of these 4 squares in mind -- they will be important for later..
         */

         // color of the inner squares
         StdDraw.setPenColor(255,255,255);

         // The inner-square centers are (200,200) ... (200,600) ... (600,200) ... (600,600)
         for(int i = 50; i< 800;i+=100){
             for(int j = 50; j<800;j+=100){
             StdDraw.filledRectangle(j,i,40,40);

             }
         }
         /*StdDraw.filledRectangle(100, 100, 40, 40);
         StdDraw.filledRectangle(300, 300, 40, 50);
         StdDraw.filledRectangle(500, 500, 40, 40);
         StdDraw.filledRectangle(700, 700, 40, 40);*/

        StdDraw.show();
    }

    /**
     * Draws the yellow highlighting around the square specified by the arguments.
     * If the arguments are not within the 2x2 grid, then simply don't do anything.
     * @param row a value in the set (0,1) representing the row number to draw the highlight.
     * @param col a value in the set (0,1) retpresenting the col number to draw the highlight.
     */
    public static void drawHighlight(int row, int col) {
        // Arguments out of bounds?  quit the function.
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            System.out.println("Highlight is out of range");
            return;
        }

        // We would like to redraw the background to remove the highlight aroundt he previously highlighted cell
        drawBackground();

        /**
         * Here we are going to convert the "row" and "col" arguments into center coordinates of the relevant cell.
         * For larger boards, you should not do this using explicit checks like in this tutorial.
         * Consider making a function which maps (row,col) arguments to cell coordinates using a mathematical relationship.
         * We are doing an explicit check here for simplicity sake.
         */
        int centerRowCoord = 50;
        int centerColCoord = 50;
        
      
        
     switch(row) {
     case 0:
    	 centerRowCoord = 50;
         break;
         case 1:
        	 centerRowCoord = 150;
         break;
         case 2:
        	 centerRowCoord = 250;
         break;
         case 3:
        	 centerRowCoord = 350;
         break;
         case 4:
        	 centerRowCoord = 450;
         break;
         case 5:
        	 centerRowCoord = 550;
         break;
         case 6:
        	 centerRowCoord = 650;
         break;
         case 7:
        	 centerRowCoord = 750;
         break;
         case 8:
        	 centerRowCoord = 850;
         break;
     }
     
     switch(col) {
     case 0:
    	 centerColCoord = 50;
         break;
         case 1:
        	 centerColCoord = 150;
         break;
         case 2:
        	 centerColCoord = 250;
         break;
         case 3:
        	 centerColCoord = 350;
         break;
         case 4:
        	 centerColCoord = 450;
         break;
         case 5:
        	 centerColCoord = 550;
         break;
         case 6:
        	 centerColCoord = 650;
         break;
         case 7:
        	 centerColCoord = 750;
         break;
         case 8:
        	 centerColCoord = 850;
         break;
     }
     
     

        /**
         * Now that we have our cell centers sawved in centerRowCoord and centerColCoord,
         * we can draw the highlight.
         */

        // This integer will represent how much the highlight will extend beyond the perimeter of the cell.
        int halfGlowWidth = 20;

        // Set the pen color to the glow-color
        StdDraw.setPenColor(0,255,0);

        // Draw the rectangle for the glow.. draw it the same size as the cell itself, with the glow width added additionally
        StdDraw.filledRectangle(centerColCoord, centerRowCoord,  halfGlowWidth+40,  halfGlowWidth+40);

        /**
         * Now we have a yellow rectangle in place of the cell.
         * We want the highlight to be around the border only.
         * Therefore, we can redraw the cell over the highlight, at the original size.
         */

        // color of the inner squares
        StdDraw.setPenColor(255,97,139);
        // location of the inner cell
        StdDraw.filledRectangle(centerColCoord, centerRowCoord, 40, 40);
        StdDraw.filledRectangle(50,50,40,40);
        StdDraw.show();

    }


}
