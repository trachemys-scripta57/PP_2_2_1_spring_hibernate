package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User setCar(Car car) {
        this.car = car;
        return this;
    }

    @Override
    public String toString() {
        return "User " + id +
                " firstName: " + firstName +
                ", lastName: " + lastName +
                ", email='" + email + ", model - " + car.getModel() +
                ", series - " + car.getSeries() + '}';
    }
}