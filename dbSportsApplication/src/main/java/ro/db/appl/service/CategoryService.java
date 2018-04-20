package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import ro.db.appl.domain.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category remove(Long id);
    List<Category> findAll();
    List<Category> findAll(Pageable pageable);
    List<Category> findByName(String name, Pageable pageable);
    Category findById(Long id);

}
