package RentCar;

import RentCar.car.Car;
import RentCar.car.Color;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

public class HibernateApp {
    static SessionFactory sessionFactory;
    public static void main(String[] args) {


        addCarToBase();

    }

    public static void addCarToBase() {
        sessionFactory = new Configuration()
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
