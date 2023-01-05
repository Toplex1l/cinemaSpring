package fr.kira.formation.spring.cinema.seances;

import fr.kira.formation.spring.cinema.films.Film;
import fr.kira.formation.spring.cinema.salles.Salle;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("seances")
public class SeanceController {

    private final SeanceService service;

    public SeanceController(SeanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Seance> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Seance findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Seance save(@RequestBody Seance seance) {
        return service.save(seance);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/byDate/{date}")
    public List<Film> findFilmsByDate(@PathVariable LocalDate date) {
        return this.service.findByDate(date);
    }

    @GetMapping("/byDateLibre/{date}")
    public List<Salle> findFilmsByReleaseDate(@PathVariable LocalDate date) {
        return this.service.findByDateLibre(date);
    }
}
