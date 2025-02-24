package qh.q.runnerz.Run;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;



//receive requests, delegate to service, return response

@RestController
public class RunController {

    private final RunResporitory runResporitory;

    public RunController(RunResporitory runResporitory) {
        this.runResporitory = runResporitory;
    }

    @GetMapping("/api/runs")
    List<Run> findAll() {
        return runResporitory.findAll();
    }

    @GetMapping("/api/runs/{id}")
    Run findById(@PathVariable Integer id) {
        
        Optional<Run> run = runResporitory.findById(id);
        if(run.isPresent()) {
            return run.get();
        } else {
            throw new RunNotFoundException(id);
        }

    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/runs")
    void create(@Valid @RequestBody Run run) {
        runResporitory.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/api/runs/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runResporitory.update(run, id);
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/runs/{id}")
    void delete(@PathVariable Integer id) {
        runResporitory.delete(id);
    }
}
