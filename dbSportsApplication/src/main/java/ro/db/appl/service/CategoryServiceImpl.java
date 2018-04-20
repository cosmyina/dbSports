package ro.db.appl.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.Category;
import ro.db.appl.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Inject
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category remove(Long id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if(category != null) {
            this.categoryRepository.delete(category);
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        Stream<Category> stream = this.categoryRepository.findAll().stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Category> findAll(Pageable pageable) {
        Stream<Category> stream = this.categoryRepository.findAll(pageable).stream();
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Category> findByName(String name, Pageable pageable) {
        return this.categoryRepository.findByName(name, pageable);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> byId = this.categoryRepository.findById(id);
        return byId.orElse(null);
    }
}
