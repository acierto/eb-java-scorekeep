package scorekeep;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Move does not exist.")
public class MoveNotFoundException extends Exception {
    private String moveId;

    public MoveNotFoundException(String moveId) {
        this.moveId = moveId;
    }

    public String getMoveId() {
        return moveId;
    }
}
