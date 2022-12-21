package menu.model.repository;

import menu.model.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();

    // read-only
    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    // add
    public static void addCoach(Coach coach) {
        coaches.add(coach);
    }

    // find
    public static Coach findCoachByName(String coachName) {
        return coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst()
                .get();
    }


}
