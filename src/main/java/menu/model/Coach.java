package menu.model;

import java.util.*;

public class Coach {
    private final String name ;
    private final Set<String> excludeFoods ;
    private final List<String> randomFoods = new ArrayList<>();

    public Coach(String name, List<String> foods){
        this.name = name;
        this.excludeFoods = new HashSet<>();
        excludeFoods.addAll(foods);
    }
    public String getName(){
        return name;
    }

    public void setRandomFood(String foods){
        randomFoods.add(foods);
    }
    public List<String> getRandomFoods(){
        return Collections.unmodifiableList(randomFoods);
    }

    public boolean isFoodExclude(String food){
        return excludeFoods.contains(food);
    }
    public boolean isFoodExist(String food) {
        return randomFoods.contains(food);
    }
}
