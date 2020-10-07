package RentCar.car;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@Table(name = "car")
@NoArgsConstructor
@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mark;
    private String model;
    private int yearProduction;
    private double engineCapacity;
    private int horsePower;
    private int doors;
    @Enumerated(value = EnumType.STRING)
    private Color color;
    private BigDecimal price;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


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


}
