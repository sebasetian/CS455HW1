// Name: LIN,SHIH YAO
// USC NetId: 7208835144
// CSCI 455 PA1
// Spring 2018
import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * How to run : Call CoinTossSimulator constructor to create a new simulator
 *              , and call run(numTrials) method to start a simulation.
 *              Call reset to reset() to reset simulator.
 *
 *  CoinTossSimulator class has the following instance variable:
 *          TwoHeads : the number of two-head tosses trails
 *          TwoTails : the number of two-tail tosses trails
 *          HeadTails : the number of one-head-one-tail tosses trails
 *
 *  CoinTossSimulator class supports the following methods:
 *      public methods:
 *          void run(numTrials) // run a simulation
 *          void reset() // reset the simulator
 *          int getNumTrials()
 *          int getTwoHeads()
 *          int getTwoTails()
 *          int getHeadTails()
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
    private int twoHeads;
    private int twoTails;
    private int headTails;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
       twoHeads = 0;
       twoTails = 0;
       headTails = 0;
   }


   /**
    Runs the simulation for numTrials more trials. Multiple calls to this method
    without a reset() between them *add* these trials to the current simulation.

    *How to create a two-tosses trail:
        Uses nextInt(2) method in Random class, 0 means a head and 1 means a tail in
        any single toss, and pluses two Random number to get the result of a single trail.

      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
       Random Die = new Random(); // create a random number seed

       //please see "How to create a two-tosses trail"
       while(numTrials-- > 0) {
           int Result = Die.nextInt(2) + Die.nextInt(2);
            switch(Result) {
                case 0: {
                    twoHeads++;
                    break;
                }
                case 1: {
                    headTails++;
                    break;
                }
                case 2: {
                    twoTails++;
                    break;
                }
            }
       }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return getHeadTails() + getTwoHeads() + getTwoTails();
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
       twoHeads = 0;
       twoTails = 0;
       headTails = 0;
   }

}
