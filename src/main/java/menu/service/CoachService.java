package menu.service;

import menu.model.Coach;
import menu.model.repository.CoachRepository;
import menu.view.MenuView;

import java.util.List;

public class CoachService {
    private final MenuView view ;

    public CoachService(MenuView view){
        this.view = view;
    }
    public void setCoachInfo(){
        List<String> coachesName =  view.readCoachName();
        for (String name : coachesName){
            Coach coach = makeCoach(name);
            saveCoach(coach);
        }
    }
    private void saveCoach(Coach coach){
        CoachRepository.addCoach(coach);
    }
    private Coach makeCoach(String name){
        return new Coach(name, view.readExcludeMenu(name));
    }
    public List<Coach> getAllCoaches(){
        return CoachRepository.coaches();
    }
    public boolean isMenuPossible(String food, Coach coach){
        return coach.isFoodExclude(food) && !coach.isFoodExist(food);
    }
    public void saveRandomMenuOfCoach(String coachName, String menu){
        CoachRepository.findCoachByName(coachName).setRandomFood(menu);
    }
}
