package menu.view.util.validator;

import menu.view.constant.HeadSymbol;
import menu.view.constant.MenuInputError;

import java.util.Arrays;
import java.util.List;

public class MenuInputValidator implements Validator{
    private final static String COMMA = ",";
    private final static int MAX_QUANTITY = 2;
    private final SeparatorValidator separatorValidator = new SeparatorValidator();

    @Override
    public void validate(String inputValue){
        separatorValidator.validate(inputValue);
        List<String> names = Arrays.asList(inputValue.split(COMMA));
        validateQuantity(names);
    }
    private void validateQuantity(List<String> menus){
        if(menus.size() > MAX_QUANTITY){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(MenuInputError.OVER_TWO));
        }
    }
}
