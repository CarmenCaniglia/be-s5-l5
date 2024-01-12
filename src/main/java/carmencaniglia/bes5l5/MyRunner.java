package carmencaniglia.bes5l5;

import carmencaniglia.bes5l5.dao.BuildingService;
import carmencaniglia.bes5l5.dao.ReservationService;
import carmencaniglia.bes5l5.dao.UserService;
import carmencaniglia.bes5l5.dao.WorkstationService;
import carmencaniglia.bes5l5.entities.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    BuildingService buildingService;
    @Autowired
    WorkstationService workstationService;
    @Autowired
    ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random rndm = new Random();

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
        if (!buildings.isEmpty()) {
            Building randomBuilding = buildings.get(rndm.nextInt(buildings.size()));
            String workstationDescription = faker.lorem().sentence();
            int maxPeoples = rndm.nextInt(10) + 1;
            WorkstationType type = WorkstationType.values()[rndm.nextInt(WorkstationType.values().length)];

            Workstation newWorkstation = new Workstation(workstationDescription, type, maxPeoples, randomBuilding);
            workstationService.save(newWorkstation);
            System.out.println("Created workstation: " + newWorkstation);
        } else {
            System.out.println("No buildings available to create workstations.");
        }

        //----RESERVATIONS
        /*List<User> users = userService.findAll();
        List<Workstation> workstations = workstationService.findAll();
        if (!users.isEmpty() && !workstations.isEmpty()) {
            User randomUser = users.get(rndm.nextInt(users.size()));
            Workstation randomWorkstation = workstations.get(rndm.nextInt(workstations.size()));

            Reservation newReservation = new Reservation(randomUser, randomWorkstation);
            reservationService.saveReservation(newReservation);
            System.out.println("Created reservation: " + newReservation);
        } else {
            System.out.println("No users or workstations available to create reservations.");
        }*/
    }
}
