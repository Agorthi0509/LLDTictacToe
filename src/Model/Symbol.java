package Model;

public class Symbol {

    SymbolType symbolType;
    Symbol(SymbolType symbolType){
        this.symbolType=symbolType;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }
}
