package scorekeep;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "State does not exist.")
public class StateNotFoundException extends Exception {
    private String stateId;

    public StateNotFoundException(String stateId) {
        this.stateId = stateId;
    }

    public String getStateId() {
        return stateId;
    }
}
