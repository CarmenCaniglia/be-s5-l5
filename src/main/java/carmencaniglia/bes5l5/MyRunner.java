package carmencaniglia.bes5l5;

import carmencaniglia.bes5l5.dao.UserService;
import carmencaniglia.bes5l5.entities.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        String username = name.toLowerCase() + "." + surname.toLowerCase();
        String email = username + "@fakemail.com";

        User newUser = new User(username, name, surname, email);
        userService.save(newUser);
        System.out.println("Created user: " + newUser);

        try {
            System.out.println(userService.findById(1));
            System.out.println(userService.findById(15));
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
