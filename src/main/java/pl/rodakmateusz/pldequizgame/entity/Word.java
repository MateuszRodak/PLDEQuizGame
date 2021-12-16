package pl.rodakmateusz.pldequizgame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Word")
public class Word implements Serializable {

    @Id
    private int Id;
    private String wordPL;
    private String wordDE;

}
