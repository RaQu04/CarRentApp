import RentCar.HibernateApp;
import RentCar.car.Car;
import RentCar.car.Color;
import RentCar.client.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean turnOn = true;

    public static void main(String[] args) {
        System.out.println("Witam w aplikacji RentCarApp");

        while (turnOn){
            runApp();
        }
    }

    public static void runApp(){
        System.out.println("Co chcesz zrobić? ");
        System.out.println("1. Wyświel auta");
        System.out.println("2.Wyświetl użytkowników");
        System.out.println("3. Dodaj auto");
        System.out.println("4. Dodaj użytkownika");
        System.out.println("q - wyłącz aplikację");
        String choose = scanner.nextLine();
        switch (choose.toLowerCase()){
            case "1" -> showCarList();
            case "2" -> showClientList();
            case "3" -> addCar();
            case "4" -> addClient();
            case "q" -> turnOn = false;
            default -> System.out.println("Błędny wybór");
        }
    }

    private static void addClient() {

        Client client = new Client();
        System.out.println("Podaj imie:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String surname = scanner.nextLine();
        System.out.println("Podaj swój wiek");
        int age = scanner.nextInt();

        client.setName(name);
        client.setSurname(surname);
        client.setAge(age);

        scanner.nextLine();

        HibernateApp.addClientToBase(client);
        System.out.println("Nowy klient dodany!");
    }

    private static void addCar() {

        Car car = new Car();
        System.out.println("Podaj markę auta:");
        String mark = scanner.nextLine();
        System.out.println("Podaj model auta:");
        String model = scanner.nextLine();
        System.out.println("Podaj rok produkcji auta:");
        int year = scanner.nextInt();
        System.out.println("Podaj pojemność silnika:");
        double engineCap = scanner.nextDouble();
        System.out.println("Podaj ilośc koni mechanicznych");
        int horsePower = scanner.nextInt();
        System.out.println("Podaj ilość drzwi");
        int doors = scanner.nextInt();
        System.out.println("Podaj kolor auta");
        scanner.nextLine();
        String color = scanner.nextLine();
        System.out.println("Podaj cene auta");
        BigDecimal price = scanner.nextBigDecimal();

        scanner.nextLine();

        car.setMark(mark);
        car.setModel(model);
        car.setYearProduction(year);
        car.setEngineCapacity(engineCap);
        car.setHorsePower(horsePower);
        car.setDoors(doors);
        car.setColor(Color.valueOf(color));
        car.setPrice(price);

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();

        Transaction tx;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(car);

            tx.commit();

        }
    }

    private static void showClientList() {
        //TODO
    }

    private static void showCarList() {
        //TODO
    }
}
