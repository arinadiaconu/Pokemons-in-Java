package Coaches;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoachesFight {
    public static int firstCommand;     //the command received from the first coach
    public static int secondCommand;    //the command received from the second coach
    static Lock lock = new ReentrantLock();

    static void giveFirstCommand() {
        lock.lock();
        try {
            Random rand = new Random();
            firstCommand = rand.nextInt(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static void giveSecondCommand() {
        lock.lock();
        try {
            Random rand = new Random();
            secondCommand = rand.nextInt(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
