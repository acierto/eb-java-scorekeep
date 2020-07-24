package scorekeep;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/move/{sessionId}/{gameId}")
public class MoveController {
    private final MoveFactory moveFactory = new MoveFactory();
    private final MoveModel model = new MoveModel();
    private final GameController gameController = new GameController();

    /* GET /move/SESSION/GAME */
    @RequestMapping(method = RequestMethod.GET)
    public List<Move> getMoves(@PathVariable String sessionId, @PathVariable String gameId) throws SessionNotFoundException, GameNotFoundException {
        return moveFactory.getMoves(sessionId, gameId);
    }

    /* POST /move/SESSION/GAME/USER ; move string */
    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public Move newMove(@PathVariable String sessionId, @PathVariable String gameId, @PathVariable String userId, @RequestBody String move) throws SessionNotFoundException, GameNotFoundException, StateNotFoundException, RulesException {
        return moveFactory.newMove(sessionId, gameId, userId, move);
    }

    /**
     * GET /move/SESSION/GAME/MOVE
     **/
    @RequestMapping(value = "/{moveId}", method = RequestMethod.GET)
    public Move getMove(@PathVariable String sessionId, @PathVariable String gameId, @PathVariable String moveId) throws SessionNotFoundException, GameNotFoundException, MoveNotFoundException {
        return moveFactory.getMove(sessionId, gameId, moveId);
    }
}
