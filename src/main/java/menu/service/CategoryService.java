package menu.service;

import menu.model.Category;
import menu.model.repository.CategoryRepository;

public class CategoryService {
    public Category getRandomCategory(){
        return CategoryRepository.getRandomCategory();
    }
}
