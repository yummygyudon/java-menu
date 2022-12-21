package menu.view.constant;

public enum HeadSymbol {
    ERROR("[ERROR] ");

    private final String symbol;

    HeadSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolMerged(String message) {
        return symbol + message;
    }
}
