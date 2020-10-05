package RentCar.client;

import RentCar.car.Car;
import RentCar.car.Color;
import RentCar.rental.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ClientTest {

    public static final Client CLIENT = new Client("Jan", "Kowalski", 25);
    public static final Rental RENTAL = new Rental();

    public static final Car CAR = Car.builder()
            .mark("Skoda")
            .model("Fabia")
            .yearProduction(2018)
            .engineCapacity(1.0)
            .horsePower(97)
            .doors(4)
            .color(Color.BLACK)
            .price(BigDecimal.valueOf(299))
            .build();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @Test
    public void shouldCreateClientBase(){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            System.out.println("Connect");


            session.persist(CLIENT);

            tx.commit();
        }

    }

    @Test
    public void shouldCreateRentalBase() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Transaction tx = null;
        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.persist(CLIENT);
            session.persist(CAR);

            Rental rental = new Rental();
            rental.setCar(CAR);
            rental.setClient(CLIENT);

            session.persist(rental);



            tx.commit();

        }
    }
}