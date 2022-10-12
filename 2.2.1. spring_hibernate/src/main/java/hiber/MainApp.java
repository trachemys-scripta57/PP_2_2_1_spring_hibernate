package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car1 = new Car("Жигули", 2107);
        Car car2 = new Car("Медресес", 123);
        Car car3 = new Car("БМВ", 5);
        Car car4 = new Car("Volvo", 740);

        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru").setCar(car4));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru").setCar(car3));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru").setCar(car2));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru").setCar(car1));

        List<User> users = userService.getUserList();
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println();
        System.out.println("User for car " + car3);
        System.out.println(userService.getUserByCar(car3));
        System.out.println();
        System.out.println("User for car " + car1);
        System.out.println(userService.getUserByCar(car1));
        System.out.println();

        context.close();
    }
}
