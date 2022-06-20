import java.util.Random;
import java.util.Scanner;
public class GameRPC {
    private boolean endGame = false;
    private String symbolCPU = "";
    private String symbolPlayer = "";
    private int randomSymbolIndex = 0;
    private int pointsCPU;
    private int pointsPlayer;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public void winPlayer() {
        pointsPlayer++;
        System.out.println("Player points: " + pointsPlayer);
        System.out.println("CPU points: " + pointsCPU + "\n");
    }
    public void winCPU() {
        pointsCPU++;
        System.out.println("Player points: " + pointsPlayer);
        System.out.println("CPU points: " + pointsCPU + "\n");
    }
    public void tie() {
        System.out.println("It's a TIE!");
        System.out.println("Player points: " + pointsPlayer);
        System.out.println("CPU points: " + pointsCPU + "\n");
    }
    public void randomSymbolCPU() {
        if (randomSymbolIndex == 1)
            this.symbolCPU = "rock";
        else if (randomSymbolIndex == 2)
            this.symbolCPU = "paper";
        else
            this.symbolCPU = "scissors";
    }
    public void game() {
        while (!endGame) {
            System.out.print("Enter option (rock, paper, scissors): ");

            symbolPlayer = scanner.nextLine();
            randomSymbolIndex = random.nextInt(3) + 1;

            randomSymbolCPU();

            if (symbolPlayer.equals("rock") || symbolPlayer.equals("paper") || symbolPlayer.equals("scissors"))
                System.out.println("CPU option: " + symbolCPU);

            switch (symbolPlayer) {
                case "rock":
                    if (this.symbolCPU.equals("rock"))
                        tie();
                    else if (this.symbolCPU.equals("paper"))
                        winCPU();
                    else
                        winPlayer();
                    break;

                case "paper":
                    if (this.symbolCPU.equals("rock"))
                        winPlayer();
                    else if (this.symbolCPU.equals("paper"))
                        tie();
                    else
                        winCPU();
                    break;

                case "scissors":
                    if (this.symbolCPU.equals("rock"))
                        winCPU();
                    else if (this.symbolCPU.equals("paper"))
                        winPlayer();
                    else
                        tie();
                    break;

                default:
                    System.out.println("Wrong string! \n");
            }

            if (pointsPlayer == 3) {
                System.out.println("GJ Bro, you won!");
                endGame = true;
            } else if (pointsCPU == 3) {
                System.out.println("Sorry Bro :(");
                endGame = true;
            }
        }
    }
}






