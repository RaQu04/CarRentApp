package RentCar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Car implements IntroduceCar{
    private String mark;
    private String model;
    private int yearProduction;
    private double engineCapacity;
    private int horsePower;
    private int doors;
    private Color color;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", yearProduction=" + yearProduction +
                ", engineCapacity=" + engineCapacity +
                ", horsePower=" + horsePower +
                ", doors=" + doors +
                ", color=" + color +
                ", prise=" + price +
                '}';
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I am " + getMark() + " and I am from " + getYearProduction());
    }
}
