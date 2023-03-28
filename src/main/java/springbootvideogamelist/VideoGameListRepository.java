package springbootvideogamelist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameListRepository extends JpaRepository<VideoGame, Long> {

    List<VideoGame> findByPlayer(String player);

}
