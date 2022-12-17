package menu.menu.repository;

import camp.nextstep.edu.missionutils.Randoms;
import menu.menu.dto.Category;

import java.util.*;

public class CategoryRepository {
        private static final List<Map<String, Category>> categories = new ArrayList<>();

        static {
            addCategory(new Category("일식",
                    "규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
            addCategory(new Category("한식",
                    "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
            addCategory(new Category("중식",
                    "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
            addCategory(new Category("아시안",
                    "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
            addCategory(new Category("양식",
                    "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        }
        // read-only
        public static List<Map<String, Category>> categories() {
            return Collections.unmodifiableList(categories);
        }
        public static Map<String,Category> getRandomCategory() {
            return categories.get(Randoms.pickNumberInRange(1, 5));
        }

        // add
        private static void addCategory(Category category){
            Map<String, Category> entry = new HashMap<>();
            entry.put(category.getName(), category);
            categories.add(entry);
        }

        // find
//        public static Category findCategoryByName(String categoryName) {
//            return categories.get(categoryName);
//        }
//        public static boolean isCategoryExist(String categoryName){
//            return repo.containsKey(categoryName);
//        }

        // delete
//        public static boolean deleteLineByName(String name) {
//            return repo.entrySet().removeIf(entry -> Objects.equals(entry.getKey(), name));
//        }
    }

