package Model;

public class Symbol {

   public SymbolType symbolType;


   Symbol(SymbolType symbolType){
       this.symbolType= symbolType;
   }

    public SymbolType getSymbolType() {
       return symbolType;
    }
}
