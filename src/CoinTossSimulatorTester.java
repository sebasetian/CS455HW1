// Name: LIN,SHIH YAO
// USC NetId: 7208835144
// CSCI 455 PA1
// Spring 2018
/**
 * CoinTossSimulatorTester class
 * Test the CoinTossSimulator class
 *
 * CoinTossSimulatorTester class test the following methods and constructor:
 *      CoinTossSimulator Simulator = new CoinTossSimulator();     // has empty variable
 *      Simulator.run();
 *      Simulator.reset();
 *
 */
public class CoinTossSimulatorTester {
    public static void main(String[] args){

        // the number of trials which will be used for test, test these one by one
        final int[] NUMBER_OF_TRIALS = {1,2,6,100,214748,2343,33,55,6666,3234234,
                123,232,2342,454,67,345,345345,76,867,234};

        // initializes the total number of trials. It is the expected number of trials.
        int totalOfTrials = 0;

        // tests that default constructor correctly creates Simulator
        CoinTossSimulator Simulator = new CoinTossSimulator();
        System.out.println("After constructor: ");
        System.out.println("Number of trials [exp:0]: " + Simulator.getNumTrials());
        System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                Simulator.getTwoTails() + Simulator.getHeadTails()));

        // tests adding one trial
        totalOfTrials += 1;
        Simulator.run(1);
        System.out.println("After run(" + 1 + "):");
        System.out.println("Number of trials [exp:" + totalOfTrials + "]: " + Simulator.getNumTrials());
        System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                Simulator.getTwoTails() + Simulator.getHeadTails()));

        // tests resetting the Simulator
            Simulator.reset();
            totalOfTrials = 0;
            System.out.println("After reset:");
            System.out.println("Number of trials [exp:" + totalOfTrials + "]: " + Simulator.getNumTrials());
            System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
            System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
            System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
            System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                    Simulator.getTwoTails() + Simulator.getHeadTails()));

        // tests the largest value and reset
        System.out.println("Warning : now tests run(214783647), which would take a very long~~~ time");
        totalOfTrials += 2147483647;
        Simulator.run(2147483647);
        System.out.println("After run(" + 2147483647 + "):");
        System.out.println("Number of trials [exp:" + totalOfTrials + "]: " + Simulator.getNumTrials());
        System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
        System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
        System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                Simulator.getTwoTails() + Simulator.getHeadTails()));
        Simulator.reset();
        totalOfTrials = 0;

        // tests adding multiple trials and resetting the Simulator several times,
        // resets Simulator every 5 toss tests
        for(int i = 0; i < 20;i++) {
            totalOfTrials += NUMBER_OF_TRIALS[i];
            Simulator.run(NUMBER_OF_TRIALS[i]);
            System.out.println("After run(" + NUMBER_OF_TRIALS[i] + "):");
            System.out.println("Number of trials [exp:" + totalOfTrials + "]: " + Simulator.getNumTrials());
            System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
            System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
            System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
            System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                    Simulator.getTwoTails() + Simulator.getHeadTails()));
            if(i > 5 && i % 5 == 1){
                Simulator.reset();
                totalOfTrials = 0;
                System.out.println("After reset:");
                System.out.println("Number of trials [exp:" + totalOfTrials + "]: " + Simulator.getNumTrials());
                System.out.println("Two-head tosses: " + Simulator.getTwoHeads());
                System.out.println("Two-tail tosses: " + Simulator.getTwoTails());
                System.out.println("One-head one-tail tosses: " + Simulator.getHeadTails());
                System.out.println("Tosses add up correctly? " + (totalOfTrials == Simulator.getTwoHeads() +
                        Simulator.getTwoTails() + Simulator.getHeadTails()));
            }
        }

    }
}
