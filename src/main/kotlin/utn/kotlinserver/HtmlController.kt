package utn.kotlinserver

import com.google.gson.Gson
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import utn.kotlinserver.models.User

@RestController
class HtmlController {
    var users: MutableList<User> = mutableListOf(User("ncoen", "Nicolas", "Coen"))

    @GetMapping("/")
    fun helloWorld(model: Model): String {
        model["title"] = "Blog";
        return "Hello World!";
    }

    @GetMapping("/users")
    fun getUser(model: Model): String {
        return Gson().toJson(users);
    }

    @PostMapping("/users")
    fun createUser(@RequestBody newUser: User): User {
        val user = User(
                newUser.username,
                newUser.firstName,
                newUser.lastName
        );
        users.add(user);
        return user;
    }

}