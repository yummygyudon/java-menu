package menu.view.util.validator;

import menu.view.constant.HeadSymbol;
import menu.view.constant.NameInputError;

import java.util.Arrays;
import java.util.List;

public class NameInputValidator extends BlankValidator{
    private final static String COMMA = ",";
    private final static int MAX_PERSON = 5;
    private final static int MIN_PERSON = 2;
    private final static int MAX_NAME = 4;
    private final static int MIN_NAME = 2;
    private final SeparatorValidator separatorValidator = new SeparatorValidator();

    @Override
    public void validate(String inputValue) {
        super.validate(inputValue);
        separatorValidator.validate(inputValue);
        List<String> names = Arrays.asList(inputValue.split(COMMA));
        validatePersonnel(names);
        for(String name : names){
            validateLength(name.trim());
        }
    }
    private void validatePersonnel(List<String> names){
        if(names.size() < MIN_PERSON){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(NameInputError.LACK_PERSON));
        }
        if (names.size() > MAX_PERSON){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(NameInputError.OVER_PERSON));
        }
    }
    private void validateLength(String name){
        if (name.length() > MAX_NAME){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(NameInputError.OVER_LENGTH));
        }
        if(name.length() < MIN_NAME) {
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(NameInputError.LACK_LENGTH));
        }
    }
}

