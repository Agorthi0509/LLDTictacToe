package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public Symbol[][] getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbol[][] symbols) {
        this.symbols = symbols;
    }

    int dimensions;
    Symbol [][]symbols;
    public Board(int dimensions){
        this.dimensions =dimensions;
        symbols= new Symbol[3][3];

    }


    public boolean checkBoard() {
        for(int i=0;i<dimensions;i++){
            for(int j=0;j<dimensions;j++){
                if(symbols[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addSymbol(int rowInput, int columnInput, Player player) {
        if(symbols[rowInput][columnInput]!=null){
            return false;
        }
        symbols[rowInput][columnInput]=player.getSymbol();
        return  true;
    }

    public void printBoard() {

        for(int i=0;i<dimensions;i++){
            System.out.print("|");
            for(int j=0;j<dimensions;j++) {

                if(symbols[i][j]==null){
                    System.out.print(" |");
                }
                else{
                    System.out.print(symbols[i][j].getSymbolType()+"|");
                }
            }
            System.out.println("");
            }
    }
}
