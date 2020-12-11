import java.util.*;

public class GameLogic {
    static int score = 0;
    static int cpu_score = 0;
    static String choice;
    static String cpu_choice;
    static int max_score = 5;
    static int cpu_int;
    static boolean running = false;

    public static void CPU(){
        Random rand = new Random();
        cpu_int = rand.nextInt(3)+1;

        switch(cpu_int){
            case 1: cpu_choice = "R"; break;
            case 2: cpu_choice = "P"; break;
            case 3: cpu_choice = "S"; break;
            default: System.out.println("Invalid character"); break;
        }
    }

    static public void check(){
        if(choice.equals(cpu_choice)){
            System.out.println("Draw");
            System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
        }
        else if(cpu_choice == "R"){
            if(choice.equals("P")){
                System.out.println("Paper eats rock. You win!");
                score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
            else if(choice.equals("S")){
                System.out.println("Rock breaks scissors. You lose.");
                cpu_score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
        }
        else if(cpu_choice == "P"){
            if(choice.equals("R")){
                System.out.println("Paper eats rock. You lose.");
                cpu_score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
            else if(choice.equals("S")){
                System.out.println("Scissors cut the paper. You win.");
                score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
        }
        else if(cpu_choice == "S"){
            if(choice.equals("R")){
                System.out.println("Rock breaks scissors. You win!");
                score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
            else if(choice.equals("P")){
                System.out.println("Scissors cut paper. You lose.");
                cpu_score++;
                System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            }
        }
    }

    public static boolean winCondition(){
        if(score >= 5){
            System.out.println("Game Over!");
            System.out.println("You win!");
            running = false;
            System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            return true;
        }
        else if(cpu_score >=5){
            System.out.println("Game Over!");
            System.out.println("You lose.");
            running = false;
            System.out.println("Score: "+score+" CPU score: "+cpu_score+"\n");
            return true;
        }
        return false;
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        choice = sc.next();
        choice = choice.toUpperCase();
    }

    public static void Game(){
        running = true;

        System.out.println("Rock Paper Scissors");
        System.out.println("Rock = R Paper = P Scissors = S");
        if(running) {
            for (int i = 1; i < 100; i++) {
                System.out.println("What do you want to play?");
                input();
                check();
                CPU();
                winCondition();
                new GameLogic();
                if(winCondition() == true){
                    break;
                }
            }
        }
    }
}