package pl.rodakmateusz.pldequizgame.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import pl.rodakmateusz.pldequizgame.entity.Word;

import java.util.List;

@Repository
public class WordDao {

    public static final String HASH_KEY = "Word";

    @Autowired
    private RedisTemplate template;

    public Word save(String wordPL, String wordDE){
        template.opsForHash().put(HASH_KEY,wordPL,wordDE);

        Word word = new Word();
        word.setWordDE(wordDE);
        word.setWordPL(wordPL);

        return word;
    }

    public List<Word> findAll(){
        return template.opsForHash().values(HASH_KEY);
       // return template.opsForHash().keys(HASH_KEY);
    }

    public String findWordByName(String wordPL)
    {
        String wordDE;
        wordDE = (String)template.opsForHash().get(HASH_KEY,wordPL);
      //  word.setWordPL(template.opsForHash().values());
        if (wordDE != null){
            return wordDE;
        }
        else {
            return "NOTHING IS HERE";
        }
    }

    public String deleteWord(String wordPL){
        template.opsForHash().delete(HASH_KEY,wordPL);
        return "word:" + wordPL + "removed";
    }


}
