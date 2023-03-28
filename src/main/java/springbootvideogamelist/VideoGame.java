package springbootvideogamelist;

import jakarta.persistence.Entity;			// These classes used to come from javax
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VideoGame {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String player;
    private String serialnbr;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getSerialnbr() {
        return serialnbr;
    }

    public void setSerialnbr(String serialnbr) {
        this.serialnbr = serialnbr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
