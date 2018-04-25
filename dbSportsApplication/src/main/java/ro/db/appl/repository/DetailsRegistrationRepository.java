package ro.db.appl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.db.appl.domain.DetailsRegistration;

import javax.annotation.security.PermitAll;

@Repository
public interface DetailsRegistrationRepository extends JpaRepository<DetailsRegistration, Long> {

    @Query("select id from Competitor where email = ?1")
    Long findByEmail(String email);


    @Modifying
    @Query(value = "insert into Competitor (firstName, lastName, email, gender, size) VALUES (:firstName, :lastName, :email, :gender, :size)", nativeQuery = true)
    @Transactional
    void insertCompetitor(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("gender") String gender, @Param("size") String size);

    @Query("select re from Registration re where re.competitor = :id_competitor and re.competition = :id_competition")
    Long findByRegistration(@Param("id_competitor") Long id_competitor, @Param("id_competition") Long id_competition);

}
