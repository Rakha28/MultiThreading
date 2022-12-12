/**
 * Kelompok :
 * Mohammad varrel bramasta - 2106733811
 * Rakha argya zahran       - 2106733925
 * Enricco Verindra         - 2106651793
 */

/**
 * this is a class for counting
 * @author Enricco Verindra putra
 * @author Mohammad varrel bramasta
 * @author Rakha argya zahran
 * @version 1.0
 */
class Count extends Thread
{
    /**
     * this is a constructor for Count
     */
    Count()
    {
        super("my extending thread");
        System.out.println("my thread created" + this);
        start();
    }

    /**
     * this is a method for running the thread
     */
    public void run()
    {
        try
        {
            for (int i=0 ;i<10;i++)
            {
                System.out.println("Printing the count " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("my thread interrupted");
        }
        System.out.println("My thread run is over" );
    }
}

/**
 * this is a class for running the program
 * @author Enricco Verindra putra
 * @author Mohammad varrel bramasta
 * @author Rakha argya zahran
 * @version 1.0
 */
class Code1
{
    /**
     * this is a main method for running the program
     * @param args this is a parameter for main method
     */
    public static void main(String args[])
    {
        Count cnt = new Count();
        try
        {
            while(cnt.isAlive())
            {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread's run is over" );
    }
}