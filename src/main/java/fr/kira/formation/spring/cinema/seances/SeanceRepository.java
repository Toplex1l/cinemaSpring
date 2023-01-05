package fr.kira.formation.spring.cinema.seances;

import fr.kira.formation.spring.cinema.films.Film;
import fr.kira.formation.spring.cinema.salles.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "seances", path = "seances")
public interface SeanceRepository extends JpaRepository<Seance, Integer> {

    @Query("SELECT f FROM Film f LEFT JOIN Seance s WHERE s.date = :date")
    List<Film> findByDate(@Param("date")LocalDate date);

    @Query("SELECT s FROM Salle s LEFT JOIN Seance se WHERE se.date != :date")
    List<Salle> findByDateLibre(@Param("date")LocalDate date);
}

