package Tests;

import Game.ReadFromFile;
import Loggers.FileLogger;
import Loggers.MyLogger;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("==========POKEMONS==========");
        System.out.println("Let's play this game!");
        System.out.println();
        System.out.println("First, you have to choose where to display " +
                            "the details about each duel between pokemons.");
        System.out.println("Press <S> if you want the results to be displayed at stdout.");
        System.out.println("Press <F> if you want the results to be stored in a file.");
        System.out.println();
        System.out.println("The key you pressed is:");

        Scanner scanner = new Scanner(System.in);
        String myOutputChoice = scanner.findInLine("S");
        System.out.println("Please be patient for just a few seconds!");

        FileLogger myFileLogger;
        MyLogger myLogger;
        if(myOutputChoice == null) {
            myFileLogger = new FileLogger("src/Tests/outputFile/Tests.out");
            ReadFromFile.read(myFileLogger.logger);
        } else {
            myLogger = new MyLogger();
            ReadFromFile.read(myLogger.logger);
        }

        System.out.println();
        System.out.println("Thank you for playing! We hope you enjoyed it!");
        System.out.println("==========THE END==========");
        System.exit(0);
    }
}
