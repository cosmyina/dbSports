package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import ro.db.appl.domain.Category;
import ro.db.appl.domain.Competition;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category remove(Long id);
    List<Category> findAll();
    List<Category> findAll(Pageable pageable);
    List<Category> findByName(String name, Pageable pageable);
    Category findById(Long id);

    List<Competition> findByCategory(String name);

    void logURI(String name);

}
