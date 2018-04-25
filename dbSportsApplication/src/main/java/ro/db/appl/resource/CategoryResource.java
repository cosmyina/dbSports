package ro.db.appl.resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ro.db.appl.domain.Category;
import ro.db.appl.domain.Competition;
import ro.db.appl.service.CategoryService;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryResource {

    private final CategoryService categoryService;

    @Inject
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public Category remove(@PathVariable("id") Long id) {
        return this.categoryService.remove(id);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return this.categoryService.findById(id);
    }

    @GetMapping("/{name}/{start}/{rows}")
    public List<Category> findByName(@PathVariable("name") String name, @PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.categoryService.findByName(name, PageRequest.of(start, rows));
    }

    @GetMapping
    public List<Category> findAll() {
        //this.categoryService.logURI("THTHTHTH");
        return this.categoryService.findAll();
    }

    @GetMapping("/{start}/{rows}")
    public List<Category> findAll(@PathVariable("start") Integer start, @PathVariable("rows") Integer rows) {
        return this.categoryService.findAll(PageRequest.of(start, rows));
    }

    @GetMapping("/competitions/{name}")
    List<Competition> findByCategory(@PathVariable("name") String name) {
        return this.categoryService.findByCategory(name);
    }

}
