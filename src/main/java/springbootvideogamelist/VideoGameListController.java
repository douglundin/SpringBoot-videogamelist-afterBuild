package springbootvideogamelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller					// Ensures component-scanning and bean registration
@RequestMapping("/")				// Maps all handlers to base URL "/"

public class VideoGameListController {

    private VideoGameListRepository videoGameRepository;

    // Constructor takes injected videoGameRepository
    @Autowired
    public VideoGameListController(VideoGameListRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }


    /* Method: playersVideoGames
    Handles HTTP GET requests for /{player} by retrieving a VideoGame list from the
    repository (which was injected into the controller’s constructor) for the player
    specified in the path. It puts the list of VideoGame into the model under the key
    “videogames” and returns “videoGameList” as the logical name of the view to
    render the model. */
    @RequestMapping(value="/{player}", method=RequestMethod.GET)
    public String playersVideoGames(@PathVariable("player") String player, Model model) {

        List<VideoGame> videoGameList = videoGameRepository.findByPlayer(player);
        if (videoGameList != null) {
            model.addAttribute("videogames", videoGameList);
        }
        return "videoGameList";

    }

    /* Method: addToVideoGameList
    Handles HTTP POST requests for /{player}, binding the data in the body of the
    request to a VideoGame object. This method sets the VideoGame object’s player
    property to the player’s name, and then saves the modified VideoGame via the
    repository’s save() method. Finally, it returns by specifying a redirect to /{player}
    (which will be handled by the other controller method). */
    @RequestMapping(value="/{player}", method=RequestMethod.POST)
    public String addToVideoGameList(@PathVariable("player") String player, VideoGame videogame){

        videogame.setPlayer(player);
        videoGameRepository.save(videogame);
        return "redirect:/{player}";

    }

}
