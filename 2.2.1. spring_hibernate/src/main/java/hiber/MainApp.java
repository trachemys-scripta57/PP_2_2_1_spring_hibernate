package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("Жигули", 2107);
        Car car2 = new Car("Медресес", 123);
        Car car3 = new Car("БМВ", 5);
        Car car4 = new Car("Volvo", 740);

        user1.setCar(car4);
        user2.setCar(car3);
        user3.setCar(car2);
        user4.setCar(car1);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

        List<User> users = userService.getUserList();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println("User for car " + car2);
        System.out.println(userService.getUserByCar(car2));
        System.out.println();
        System.out.println("User for car " + car4);
        System.out.println(userService.getUserByCar(car4));
        System.out.println();

        context.close();
    }
}
