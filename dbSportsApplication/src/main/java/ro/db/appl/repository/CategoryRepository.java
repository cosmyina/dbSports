package ro.db.appl.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ro.db.appl.domain.Category;
import ro.db.appl.domain.Competition;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByName(String name, Pageable pageable);

    @Query("select co from Competition co, Category ca where co.category = ca.id and ca.name = ?1")
    List<Competition> findByCategory(String name);

    @Modifying
    @Query(value = "insert into Category (name) VALUES (:name)", nativeQuery = true)
    @Transactional
    void logURI(@Param("name") String name);

}
