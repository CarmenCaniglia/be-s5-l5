package carmencaniglia.bes5l5;

import carmencaniglia.bes5l5.dao.BuildingService;
import carmencaniglia.bes5l5.dao.UserService;
import carmencaniglia.bes5l5.dao.WorkstationService;
import carmencaniglia.bes5l5.entities.Building;
import carmencaniglia.bes5l5.entities.User;
import carmencaniglia.bes5l5.entities.Workstation;
import carmencaniglia.bes5l5.entities.WorkstationType;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    WorkstationService workstationService;

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

        System.out.println("Users with the surname Bros: " + userService.filterBySurname("Bros"));
        System.out.println("Users with email containing 'gmail': " + userService.getUsersByEmailContaining("gmail"));
        System.out.println("User with name 'Mario' and surname 'Bros': " + userService.getUsersByNameAndSurname("Mario", "Bros"));

        //------BUILDINGS

        String buildingName = faker.company().name();
        String buildingAddress = faker.address().streetAddress();
        String buildingCity = faker.address().city();

        Building newBuilding = new Building(buildingName, buildingAddress, buildingCity);
        buildingService.save(newBuilding);
        System.out.println("Created building: " + newBuilding);

        //------WORKSTATIONS
        List<Building> buildings = buildingService.findAll();

        if(!buildings.isEmpty()){
            Building rndmBuilding = buildings.get(faker.number().numberBetween(0, buildings.size()));
            String description = faker.lorem().sentence();
            int peoples = faker.number().numberBetween(1,50);

            Workstation newWorkstation = new Workstation(description, WorkstationType.MEETING_ROOM,peoples,rndmBuilding);
            workstationService.save(newWorkstation);
            System.out.println("Created workstation: " + newWorkstation);
        }else{
            System.err.println("No buildings found to associate with workstations.");
        }
    }
}
