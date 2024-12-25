import Controller.TictactoeGame;

public class Main {
    public static void main(String[] args) {
        TictactoeGame tictactoeGame= new TictactoeGame();
        tictactoeGame.initializeGame();
        System.out.println("The winner is"+tictactoeGame.startGame());
    }
}