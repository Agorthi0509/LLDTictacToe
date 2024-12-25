package Controller;

import Model.*;

import java.util.*;

public class TictactoeGame {

    Deque<Player> players;
    Board gameBoard;
    int dimensions;
    public void initializeGame(){
        Symbol symbolx= new SymbolX();
        Player player1= new Player("Aditya",symbolx);
        Symbol symbolo= new SymbolO();
        Player player2= new Player("Pritesh",symbolo);
        players= new ArrayDeque<>();
        players.add(player1);
        players.add(player2);
        dimensions=3;
        gameBoard= new Board(dimensions);


    }

    public String startGame(){
        //purpose to start the game
        boolean noWinner = true;
        while(noWinner){
            Player player= players.removeLast();
            //Need to make the move but first need to check if the board has empty cells
            boolean freeBoard= gameBoard.checkBoard();
            if(!freeBoard){
                break;
            }

            //if the cells are empty , player should make a move
            System.out.println(player.getName()+ " enter row and column in the format - x,y :");
            Scanner sc= new Scanner(System.in);
            String s= sc.nextLine();
            String x[]= s.split(",");
            int rowInput=Integer.parseInt(x[0]);
            int columnInput=Integer.parseInt(x[1]);
            boolean addingsymbol = gameBoard.addSymbol(rowInput,columnInput,player);
            if(!addingsymbol){
                System.out.println("Wrong row and column , please select another");
                players.addLast(player);

            }

            gameBoard.printBoard();
            if(checkWinner(rowInput,columnInput,player)){
                return player.getName();

            }
            players.addFirst(player);


        }
        return "tie";

    }

    private boolean checkWinner(int rowInput, int columnInput, Player player) {

        boolean rowSide= true;
        boolean columnSide=true;
        boolean leftDiagonal=true;
        boolean rightDiagonal=true;
        Symbol[][] symbols = gameBoard.getSymbols();
        for(int j=0;j<dimensions;j++){
            if(symbols[rowInput][j]==null || symbols[rowInput][j]!=player.getSymbol()){
                rowSide= false;
            }

        }
        for(int j=0;j<dimensions;j++){
            if(symbols[j][columnInput]==null || symbols[j][columnInput]!=player.getSymbol()){
                columnSide= false;
            }

        }

        for(int i=0;i<dimensions;i++){
            if(symbols[i][i]==null || symbols[i][i]!=player.getSymbol()){
                leftDiagonal =false;
            }
        }
        for(int i=dimensions-1;i>=0;i--){
            for(int j=0;j<dimensions;j++){
                if(symbols[i][j]==null || symbols[i][j]!=player.getSymbol()) {
                    rightDiagonal=false;
                }
                }
            }
        return rowSide || columnSide || leftDiagonal || rightDiagonal ;
        }
    }

