package menu.controller;

import menu.model.Category;
import menu.model.Coach;
import menu.service.CategoryService;
import menu.service.CoachService;
import menu.view.MenuView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private static final int MAX_CATEGORY_DUPLICATION = 2;
    private final MenuView view ;
    private final CategoryService categoryService ;
    private final CoachService coachService ;
    private final List<Category> weeklyCategories;

    public MenuController(){
        this.view = new MenuView();
        this.categoryService = new CategoryService();
        this.coachService = new CoachService(view);
        this.weeklyCategories = new ArrayList<>();
    }

    public void start(){
        view.printStartPhrase();
        receiveCoachInfo();
        decideWeeklyCategory();

        decideWeeklyMenus();

        showResult();
    }

    private void receiveCoachInfo(){
        coachService.setCoachInfo();
    }

    private void decideWeeklyCategory(){
        for(int i = 0; i < 5; i++){
            Category randomCategory ;
            do{
                randomCategory = categoryService.getRandomCategory();
            }while(checkIsExistOverTwice(randomCategory));
            weeklyCategories.add(randomCategory);
        }
    }
    private boolean checkIsExistOverTwice(Category randomCategory){
        return this.weeklyCategories.stream()
                .filter(category -> category.getName().equals(randomCategory.getName()))
                .count() >= MAX_CATEGORY_DUPLICATION ;
    }

    private void decideWeeklyMenus(){
        for(Category dailyCategory : weeklyCategories){
            for(Coach coach : coachService.getAllCoaches()){
                recommendRandomMenuToCoach(dailyCategory, coach);
            }
        }
    }
    private void recommendRandomMenuToCoach(Category dailyCategory, Coach targetCoach){
        String randomMenu ;
        do{
            randomMenu = dailyCategory.getRandomMenu();
        }while(coachService.isMenuPossible(randomMenu,targetCoach));
        coachService.saveRandomMenuOfCoach(targetCoach.getName(), randomMenu);
    }

    private void showResult(){
        view.printColumnHeading();
        view.printRandomCategories(weeklyCategories);
        view.printCoachResult(coachService.getAllCoaches());
    }
}
