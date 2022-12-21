package menu.view.util.converter;

import menu.model.Category;
import menu.model.Coach;
import menu.view.constant.ResultSign;

import java.util.List;
import java.util.StringJoiner;

public class ResultFormatConverter {
    private static final String PHRASE_DIVISION = "구분";
    private static final String PHRASE_CATEGORY = "카테고리";

    public String convertWeekDaysToColumnHeading(){
        StringJoiner joiner = new StringJoiner(ResultSign.DELIMITER, ResultSign.PREFIX, ResultSign.SUFFIX);
        joiner.add(PHRASE_DIVISION);
        joiner.add("월요일");
        joiner.add("화요일");
        joiner.add("수요일");
        joiner.add("목요일");
        joiner.add("금요일");
        return joiner.toString();
    }
    public String convertRandomCategoriesToResult(List<Category> randomCategories){
        StringJoiner joiner = new StringJoiner(ResultSign.DELIMITER, ResultSign.PREFIX, ResultSign.SUFFIX);
        joiner.add(PHRASE_CATEGORY);
        for(Category randomCategory : randomCategories){
            joiner.add(randomCategory.getName());
        }
        return joiner.toString();
    }
    public String convertCoachToResult(Coach coach){
        StringJoiner joiner = new StringJoiner(ResultSign.DELIMITER, ResultSign.PREFIX, ResultSign.SUFFIX);
        joiner.add(coach.getName());
        for(String randomMenu : coach.getRandomFoods()){
            joiner.add(randomMenu);
        }
        return joiner.toString();
    }
}
