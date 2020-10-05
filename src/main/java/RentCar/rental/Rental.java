package RentCar.rental;

import RentCar.car.Car;
import RentCar.client.Client;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rental")
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Rental() {
    }

    public Rental(Integer id, Car car, Client client) {
        this.id = id;
        this.car = car;
        this.client = client;
    }
}
