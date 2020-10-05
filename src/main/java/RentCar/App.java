package RentCar;



import RentCar.car.Car;
import RentCar.car.Color;
import RentCar.client.Client;
import RentCar.HibernateApp.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 *  App to rent a car, with dataBase in .txt
 */

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        /*
         * Created constructor car, and car's set
         */

        List<Car> cars = new ArrayList<>();

        Car audiA6 = Car.builder()
                .id(1)
                .mark("Audi")
                .model("A6")
                .yearProduction(2018)
                .engineCapacity(2.0)
                .horsePower(196)
                .doors(4)
                .color(Color.BLACK)
                .price(BigDecimal.valueOf(599))
                .build();

        Car citroenC5 = new Car(
                2,
                "Citroen",
                "C5",
                2008,
                1.6,
                116,
                4,
                Color.WHITE,
                BigDecimal.valueOf(299)
        );

        Car skodaOctavia = new Car(
                3,
                "Skoda",
                "Octavia",
                2016,
                1.6,
                132,
                4,
                Color.GREEN,
                BigDecimal.valueOf(349)
        );

        Car bmwM5 = new Car(
                4,
                "BMW",
                "M5",
                2020,
                2.0,
                194,
                4,
                Color.BLACK,
                BigDecimal.valueOf(499)
        );
        cars.add(citroenC5);
        cars.add(skodaOctavia);
        cars.add(bmwM5);
        cars.add(audiA6);

        /*
         * Created constructor Client, and Client's set
         */

        List<Client> clients = new ArrayList<>();

//        Client client1 = new Client(
//                "Jan",
//                "Kowalski",
//                50
//        );
//
//        Client client2 = new Client(
//                "Janina",
//                "Paździerz",
//                75
//        );

//        final String carJsonFileName = "car.json";
//        CarJsonConverter carJsonConverter = new CarJsonConverter(carJsonFileName);
//        carJsonConverter.toJson(cars);
//        carJsonConverter.fromJson().ifPresent(System.out::println);



//
//        clients.add(client1);
//        clients.add(client2);

        /*
         * Go to method to generate list Car or Client
         */

        generateCarList(cars);
        generateClientList(clients);




    }

    public static void generateCarList(List<Car> car) throws FileNotFoundException {

        File file = new File("CarList.txt");
        boolean exists = file.exists();
        System.out.println(exists);

        PrintWriter printWriter = new PrintWriter(file);

        for (Car o : car) {
            printWriter.println(o.toString());
        }
        printWriter.close();
    }

    public static void generateClientList(List<Client> client) throws FileNotFoundException {

        File file = new File("ClientList.txt");
        boolean exists = file.exists();
        System.out.println(exists);

        PrintWriter printWriter = new PrintWriter(file);

        for (Object o : client) {
            printWriter.println(o.toString());
        }
        printWriter.close();
    }
}
