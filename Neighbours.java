import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.*;

//HEJ DET �R PAINT
//Jag har en Diggus Bickus
/*
 *  Program to simulate segregation.
 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE:
 * - JavaFX first calls method init() and then the method start() far below.
 * - The method updateWorld() is called periodically by a Java timer.
 * - To test uncomment call to test() first in init() method!
 *
 */
// Extends Application because of JavaFX (just accept for now)
public class Neighbours extends Application {
    final static Random rand = new Random();

    // Enumeration type for the Actors
    enum Actor {
        BLUE, RED, NONE   // NONE used for empty locations
    }

    // Enumeration type for the state of an Actor
    enum State {
        UNSATISFIED,
        SATISFIED,
        NA     // Not applicable (NA), used for NONEs
    }

    // Below is the *only* accepted instance variable (i.e. variables outside any method)
    // This variable may *only* be used in methods init() and updateWorld()
    Actor[][] world;              // The world is a square matrix of Actors

    // This is the method called by the timer to update the world
    // (i.e move unsatisfied) approx each 1/60 sec.
    void updateWorld() {
        // % of surrounding neighbours that are like me
        final double threshold = 0.7;

        // TODO Update logical state of world
    }

    // This method initializes the world variable with a random distribution of Actors
    // Method automatically called by JavaFX runtime (before graphics appear)
    // Don't care about "@Override" and "public" (just accept for now)
    @Override
    public void init() {
        //test();    // <---------------- Uncomment to TEST!

        // %-distribution of RED, BLUE and NONE
        double[] dist = {0.25, 0.25, 0.50};
        // Number of locations (places) in world (square)
        int nLocations = 900;
        int row = (int) round(sqrt(nLocations));
        int col = (int) round(sqrt(nLocations));
        world = new Actor[row][col];
        generateSomething(dist[0], dist[1]);

     /*  for(int whOMEGALUL = 0; whOMEGALUL < 3; whOMEGALUL++) {
           for (int i = 0; i < row; i++) {
               for (int j = 0; j < col; j++)
                   if (whOMEGALUL == 2) {
                       world[i][j] = Actor.;
                   }
           }
       }*/

        // TODO Create and populate world


        // Should be last
        fixScreenSize(nLocations);
    }


    //---------------- Methods ----------------------------

    // Check if inside world
    boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size &&
                0 <= col && col < size;
    }

    /*void generateDistribution(int nLocations, double distrBlue, double distrRed) {
        int[] arr = new int[nLocations];
        int qtyRed = (int) Math.round(nLocations * distrRed);
        int qtyBlue = (int) Math.round(nLocations * distrBlue);
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++) {
                if (j < qtyRed) {
                    world[i][j] = Actor.RED;
                } else if ((qtyRed - 1) < i && i < (qtyRed + qtyBlue)) {
                    world[i][j] = Actor.BLUE;
                } else
                    world[i][j] = Actor.NONE;
            }
        }
    }*/

    void generateSomething(double distributionRed, double distributionBlue) {
        //double disttributionNone = 1.0 - distributionRed - distributionBlue;
        double randomType;
        int worldRowLength = world.length;
        int worldColLength = world[0].length;
        for (int row = 0; row < worldRowLength; row++) {
            for (int col = 0; col < worldColLength; col++) {
                randomType = ((double) (rand.nextInt(100)) / 100);
                if (randomType < distributionBlue) {
                    world[row][col] = Actor.BLUE;
                } else if (distributionBlue <= randomType && randomType < (distributionBlue + distributionRed)) {
                    world[row][col] = Actor.RED;
                } else {
                    world[row][col] = Actor.NONE;
                }
            }
        }
        int amountRed, amountBlue, amountNone;
        for (int i = 0; i < worldRowLength; i++) {
            amountRed =+ count(world[i], Actor.RED);
            amountBlue =+ count(world[i], Actor.BLUE);
            amountNone =+ count(world[i], Actor.NONE);
        }
    }

    void Correction(int tooFew, int tooMany) {
        int worldRowLength = world.length;
        int worldColLength = world[0].length;
        for (int row = 0; row < worldRowLength; row++) {
            for (int col = 0; col < worldColLength; col++) {

            }
        }
    }
        void shuffle(){
            int randomRow;
            int randomCol;

        }

        // ------- Testing -------------------------------------

        // Here you run your tests i.e. call your logic methods
        // to see that they really work
        void test () {
            // A small hard coded world for testing
            Actor[][] testWorld = new Actor[][]{
                    {Actor.RED, Actor.RED, Actor.NONE},
                    {Actor.NONE, Actor.BLUE, Actor.NONE},
                    {Actor.RED, Actor.NONE, Actor.BLUE}
            };
            double th = 0.5;   // Simple threshold used for testing

            int size = testWorld.length;
            out.println(isValidLocation(size, 0, 0));
            out.println(!isValidLocation(size, -1, 0));
            out.println(!isValidLocation(size, 0, 3));
            out.println(isValidLocation(size, 2, 2));

            // TODO More tests

            exit(0);
        }

        int[] shuffle ( int[] arr){
            for (int i = arr.length - 1; i > 0; i--) {
                int index = rand.nextInt(i + 1);
                // Simple swap
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
            return arr;

        }

        // Helper method for testing (NOTE: reference equality)
    <T > int count (T[]arr, T toFind){
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == toFind) {
                    count++;
                }
            }
            return count;
        }

        // ###########  NOTHING to do below this row, it's JavaFX stuff  ###########

        double width = 400;   // Size for window
        double height = 400;
        long previousTime = nanoTime();
        final long interval = 450000000;
        double dotSize;
        final double margin = 50;

        void fixScreenSize ( int nLocations){
            // Adjust screen window depending on nLocations
            dotSize = (width - 2 * margin) / sqrt(nLocations);
            if (dotSize < 1) {
                dotSize = 2;
            }
        }

        @Override
        public void start (Stage primaryStage) throws Exception {

            // Build a scene graph
            Group root = new Group();
            Canvas canvas = new Canvas(width, height);
            root.getChildren().addAll(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();

            // Create a timer
            AnimationTimer timer = new AnimationTimer() {
                // This method called by FX, parameter is the current time
                public void handle(long currentNanoTime) {
                    long elapsedNanos = currentNanoTime - previousTime;
                    if (elapsedNanos > interval) {
                        updateWorld();
                        renderWorld(gc, world);
                        previousTime = currentNanoTime;
                    }
                }
            };

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Segregation Simulation");
            primaryStage.show();

            timer.start();  // Start simulation
        }


        // Render the state of the world to the screen
        public void renderWorld (GraphicsContext g, Actor[][]world){
            g.clearRect(0, 0, width, height);
            int size = world.length;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    double x = dotSize * col + margin;
                    double y = dotSize * row + margin;

                    if (world[row][col] == Actor.RED) {
                        g.setFill(Color.RED);
                    } else if (world[row][col] == Actor.BLUE) {
                        g.setFill(Color.BLUE);
                    } else {
                        g.setFill(Color.WHITE);
                    }
                    g.fillOval(x, y, dotSize, dotSize);
                }
            }
        }

        public static void main (String[]args){
            launch(args);
        }

    }
