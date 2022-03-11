package Coaches;

import Game.CoachesBattle;

public class Coach1 implements Runnable{
    @Override
    public void run() {
        // this method coordinates the thread that represents the first coach
        // the coach must give an action to its pokemon, so the thread will return
        // a random number between 0 and 2 and after the action is analysed and
        // completed, it gives another action (another command)
        while((CoachesBattle.firstHP > 0) && (CoachesBattle.secondHP > 0)) {
            if(!CoachesBattle.command) {    // if command is false, it will give another command
                CoachesFight.giveFirstCommand();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
