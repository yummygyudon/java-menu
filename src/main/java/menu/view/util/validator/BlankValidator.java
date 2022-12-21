package menu.view.util.validator;

import menu.view.constant.HeadSymbol;

public class BlankValidator implements Validator{
    private static final String BLANK_ERROR = "빈 칸은 입력할 수 없습니다.";
    @Override
    public void validate(String inputValue) {
        validateBlank(inputValue);
    }
    private void validateBlank(String inputValue){
        if(inputValue.isBlank()){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(BLANK_ERROR));
        }
    }
}
