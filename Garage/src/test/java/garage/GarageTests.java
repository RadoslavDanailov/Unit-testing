package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {
        private Garage garage;

        @Before
    public void setup(){
            garage = new Garage();
        }

        @Test
    public void testGetCars(){
            List<Car>carList = new ArrayList<>();
            Car car1 = new Car("Skoda", 240, 42000);
            Car car2 = new Car("Fiat", 180, 22000);
            Car car3 = new Car("Seat", 250, 55000);

            this.garage.addCar(car1);
            this.garage.addCar(car2);
            this.garage.addCar(car3);
            carList.add(car1);
            carList.add(car2);
            carList.add(car3);

            Assert.assertEquals(this.garage.getCars(), carList);
        }

    @Test
    public void testGetCount(){
        Car car1 = new Car("Skoda", 240, 42000);
        Car car2 = new Car("Fiat", 180, 22000);
        Car car3 = new Car("Seat", 250, 55000);

        this.garage.addCar(car1);
        this.garage.addCar(car2);
        this.garage.addCar(car3);

        Assert.assertEquals(this.garage.getCount(), 3);
    }

    @Test
    public void testFindAllCarsMaxSpeedAbove(){
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Skoda", 240, 42000);
        Car car2 = new Car("Fiat", 180, 22000);
        Car car3 = new Car("Seat", 250, 55000);
        this.garage.addCar(car1);
        this.garage.addCar(car2);
        this.garage.addCar(car3);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<Car>findCarsList = cars.stream().filter(c -> c.getMaxSpeed() > 200).collect(Collectors.toList());
        Assert.assertEquals(this.garage.findAllCarsWithMaxSpeedAbove(200), findCarsList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNull(){
            this.garage.addCar(null);
    }

    @Test
    public void testGetMostExpensiveCar(){
        Car car1 = new Car("Skoda", 240, 42000);
        Car car2 = new Car("Fiat", 180, 22000);
        Car car3 = new Car("Seat", 250, 55000);

        this.garage.addCar(car1);
        this.garage.addCar(car2);
        this.garage.addCar(car3);

        Assert.assertEquals(this.garage.getTheMostExpensiveCar(), car3);
    }

    @Test
    public void testFindAllCarsByBrand(){
            List<Car>foundCars = new ArrayList<>();
        Car car1 = new Car("Skoda", 240, 42000);
        Car car2 = new Car("Fiat", 180, 22000);
        Car car3 = new Car("Seat", 250, 55000);
        Car car4 = new Car("Skoda", 250, 55000);

        this.garage.addCar(car1);
        this.garage.addCar(car2);
        this.garage.addCar(car3);
        this.garage.addCar(car4);
        foundCars.add(car1);
        foundCars.add(car4);

        Assert.assertEquals(this.garage.findAllCarsByBrand("Skoda"), foundCars);
    }


}