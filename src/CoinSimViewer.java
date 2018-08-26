// Name: LIN,SHIH YAO
// USC NetId: 7208835144
// CSCI 455 PA1
// Spring 2018
import javax.swing.JFrame;
import java.util.Scanner;

/**
 * class CoinSimViewer
 *
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * How to run : First, enter the number of trails, if you enter a number which is less than one,
 *              you will need to re-enter a new number until you enter a number greater than zero.
 *              Then the result of the simulation will show on a new 800*500 pixels screen.
 *              You can adjust the size of the screen.
 *              Finally, you can reset the number of trials and/or re-do a simulation.
 *              If you don't reset simulator, the simulator will add up the current number of trials and
 *              the new number you enter for next simulator, update the result on the screen.
 *              The largest value of the trials is 2,147,483,647.
 *
 * CoinSimViewer class has the following name constants:
 *           int FRAME_WIDTH : the width of the result screen
 *           int FRAME_HEIGHT : the height of the result screen
 *
 * CoinSimViewer class has the following instance variable:
 *          trialsNumbers : the total number of trials
 *
 */
public class CoinSimViewer {
    public static void main(String[] args){

        //Name constants
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 500;

        //Instance variable
        int trialsNumbers;
        Scanner in = new Scanner(System.in);

        // Enter number of trials
        do {
            System.out.println("Enter number of trials(should be greater than zero):");
            trialsNumbers = in.nextInt();
            if (trialsNumbers < 1) {
                System.out.println("ERROR !! You entered a number less than one");
            }
            if(trialsNumbers > 500000000){
                System.out.println("Whaaaat?! It will take a very long time to run!!");
            }
        } while (trialsNumbers < 1);

        //run the first simulation and create the result screen
        JFrame CoinFrame = new JFrame();
        CoinFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        CoinFrame.setTitle("CoinSim");
        CoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CoinSimComponent component = new CoinSimComponent(trialsNumbers);
        CoinFrame.add(component);
        CoinFrame.setVisible(true);

        //reset and/or run a new simulation
        do {
            System.out.println("Enter \"y\" to reset, others to skip");
            if(in.next().equals("y")) {
                component.resetSimulator();
            }
            System.out.println("Enter \"y\" to continue, others to end");
            if(in.next().equals("y")) {
                do {
                    System.out.println("Enter number of trials(should be greater than zero):");
                    trialsNumbers = in.nextInt();
                    if (trialsNumbers < 1) {
                        System.out.println("ERROR !! You entered a number smaller than zero");
                    }
                    if(trialsNumbers > 500000000) {
                        System.out.println("Whaaaat?! It will take a very long time to run!!");
                    }
                } while (trialsNumbers < 1);
                component.runSimulator(trialsNumbers);
                CoinFrame.repaint();
            }else {
                break;
            }
        }while(true);

        CoinFrame.setVisible(false);
        CoinFrame.dispose();
    }
}
