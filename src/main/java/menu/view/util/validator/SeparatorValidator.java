package menu.view.util.validator;

import menu.view.constant.HeadSymbol;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorValidator implements Validator{
    private static final String REGEX = "[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9, ]";
    private static final String SEP_ERROR = "쉼표(,)로 구분해서 입력해야 합니다.";
    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public void validate(String input){
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            throw new IllegalArgumentException(HeadSymbol.ERROR.getSymbolMerged(SEP_ERROR));
        }
    }
}
