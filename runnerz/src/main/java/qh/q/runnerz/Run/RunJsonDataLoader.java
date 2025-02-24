package qh.q.runnerz.Run;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);

    private final RunResporitory runResporitory;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(RunResporitory runResporitory, ObjectMapper objectMapper){ 
        this.runResporitory = runResporitory;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data from JSON file");
        if(runResporitory.count() == 0){
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")){
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                log.info("Reading {} runs from JSON data and saving to database.", allRuns.runs().size());
                runResporitory.saveAll(allRuns.runs());
            }catch(IOException e){
                log.error("Failed to load data from JSON file: {}", e.getMessage());
            }
        }else{
            log.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }
}
