package menu.view;

import menu.model.Category;
import menu.model.Coach;
import menu.view.constant.Phrase;
import menu.view.util.InputView;
import menu.view.util.OutputView;
import menu.view.util.converter.ResultFormatConverter;
import menu.view.util.validator.MenuInputValidator;
import menu.view.util.validator.NameInputValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuView {
    private static final String COMMA = ",";
    private final InputView in = new InputView();
    private final OutputView out = new OutputView();
    private final MenuInputValidator menuInputValidator = new MenuInputValidator();
    private final NameInputValidator nameInputValidator = new NameInputValidator();
    private final ResultFormatConverter resultConverter = new ResultFormatConverter();

    public List<String> readCoachName(){
        List<String> names = new ArrayList<>();
        String inputValue ;
        out.print(Phrase.REQUEST_NAME);
        do{
            inputValue = in.read();
        }while (!checkNameValid(inputValue));
        for(String name : inputValue.split(COMMA)){
            names.add(name.trim());
        }
        out.printBlankLine();
        return names;
    }
    private boolean checkNameValid(String inputValue){
        try {
            nameInputValidator.validate(inputValue);
            return true;
        }catch (IllegalArgumentException ie) {
            out.print(ie.getMessage());
            return false;
        }
    }
    public List<String> readExcludeMenu(String coachName){
        List<String> excludeMenus = new ArrayList<>();
        String inputValue ;
        out.print(coachName + Phrase.REQUEST_EXCLUDE);
        do{
            inputValue = in.read();
        }while (!checkMenuValid(inputValue));
        out.printBlankLine();
        if(inputValue.isBlank()){
            return Collections.emptyList();
        }
        for(String menu : inputValue.split(COMMA)){
            excludeMenus.add(menu.trim());
        }
        return excludeMenus;
    }
    private boolean checkMenuValid(String inputValue){
        try {
            if(!inputValue.isBlank()){
                menuInputValidator.validate(inputValue);
            }
            return true;
        }catch (IllegalArgumentException ie) {
            out.print(ie.getMessage());
            return false;
        }
    }

    public void printStartPhrase(){
        out.print(Phrase.START);
        out.printBlankLine();
    }
    public void printColumnHeading(){
        out.print(Phrase.NOTICE_RESULT);
        out.print(resultConverter.convertWeekDaysToColumnHeading());
    }
    public void printRandomCategories(List<Category> randomCategories){
        out.print(resultConverter.convertRandomCategoriesToResult(randomCategories));
    }
    public void printCoachResult(List<Coach> coaches){
        for(Coach coach : coaches){
            out.print(resultConverter.convertCoachToResult(coach));
        }
        out.printBlankLine();
        out.print(Phrase.END);
    }
}
