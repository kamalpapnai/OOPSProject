import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

         int randomNo,lb=0,ub;
         ArrayList<String> moviesInFile =  new ArrayList<>();
         Scanner inGuesses = new Scanner(System.in);

         File file = new File("C:\\Users\\KAMAL\\Desktop\\oopsFolder\\oopstxt.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String input = sc.nextLine();
                moviesInFile.add(input);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ub = moviesInFile.size();
        int range = (ub-lb);
        randomNo = (int)(Math.random()*range);


        GameManager gameManager = new GameManager(moviesInFile.get(randomNo),moviesInFile.get(randomNo).length());

        System.out.print("You are guessing movie:");
        gameManager.displayInitialMovie();


        while(gameManager.getPoints()>0) {
            System.out.println("You have guessed (" + (10-gameManager.getPoints()) + ") wrong letters.");
            System.out.print("Guess a letter:");
            String input = inGuesses.next();
            gameManager.matchCharWithMovie(input.charAt(0));
            gameManager.displayInitialMovie();
            if(gameManager.matchForSuccess()){
                System.out.println("\n*************Yipee You seems like expert!*************");
            }
        }

        if(gameManager.getPoints()==0){
            System.out.println("\n*************Opps! You Lost , Try Again*************");
        }


    }
}
