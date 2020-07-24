package scorekeep;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserFactory factory = new UserFactory();
    private final UserModel model = new UserModel();

    /* POST /user */
    @RequestMapping(method = RequestMethod.POST)
    public User newUser(@RequestBody(required = false) User userbody) throws IOException {
        User user;
        if (userbody == null || userbody.getName() == null) {
            user = factory.newUser();
        } else {
            user = factory.newUser(userbody.getName());
        }
        return user;
    }

    /* PUT /user/USER */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        model.saveUser(user);
        return user;
    }

    /* GET /user */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return factory.getUsers();
    }

    /* GET /user/USER */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) throws UserNotFoundException {
        return factory.getUser(userId);
    }

    /* DELETE /user/USER */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId) throws UserNotFoundException {
        model.deleteUser(userId);
    }
}
