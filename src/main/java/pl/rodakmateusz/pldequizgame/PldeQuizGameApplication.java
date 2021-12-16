package pl.rodakmateusz.pldequizgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import pl.rodakmateusz.pldequizgame.entity.Word;
import pl.rodakmateusz.pldequizgame.repository.WordDao;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/words")
public class PldeQuizGameApplication {

    @Autowired
    private WordDao dao;

    @PostMapping("/{wordPL}/{wordDE}")
    public Word save(@PathVariable String wordPL, @PathVariable String wordDE){
        return dao.save(wordPL, wordDE);
    }

    @GetMapping
    public List<Word> getAllWords(){
        return dao.findAll();
    }

    @GetMapping("/{wordPL}")
    public String findWord(@PathVariable String wordPL){
        return dao.findWordByName(wordPL);
    }


    @DeleteMapping("/{wordPL}")
    public  String remove(@PathVariable String wordPL){
        return dao.deleteWord(wordPL);
    }



    public static void main(String[] args) {
        SpringApplication.run(PldeQuizGameApplication.class, args);
    }

}
