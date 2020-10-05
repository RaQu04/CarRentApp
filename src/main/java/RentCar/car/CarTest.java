package RentCar.car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CarTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    public void shouldCreateBase() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            System.out.println("Connect");


            Car car = new Car();
            car.setMark("Audi");
            car.setModel("A6");
            car.setDoors(4);
            car.setYearProduction(2019);
            car.setPrice(new BigDecimal(100000));
            car.setColor(Color.WHITE);
            car.setEngineCapacity(196);
            session.persist(car);


            Car car1 = Car.builder()
                    .mark("Skoda")
                    .model("Fabia")
                    .yearProduction(2018)
                    .engineCapacity(1.0)
                    .horsePower(97)
                    .doors(4)
                    .color(Color.BLACK)
                    .price(BigDecimal.valueOf(299))
                    .build();

            session.persist(car1);

            tx.commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
