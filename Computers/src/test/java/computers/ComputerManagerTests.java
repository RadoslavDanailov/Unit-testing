package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    private ComputerManager computerManager;

    @Before
    public void setup(){
        computerManager = new ComputerManager();
    }

    @Test
    public void testGetComputers(){

        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p800", 230);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);

        List<Computer>computerList = this.computerManager.getComputers();

        Assert.assertEquals(this.computerManager.getComputers(), computerList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExitingComputer(){
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Dell", "p30", 200);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);
    }

    @Test
    public void testAddComputer(){
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p501", 250);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);

        Assert.assertEquals(this.computerManager.getCount(), 2);
    }

    @Test
    public void testRemoveComputer(){
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p501", 250);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);                   ///////////////////////////////
        Computer remove = new Computer("Dell", "p30", 200);
        this.computerManager.removeComputer("Dell", "p30");
        Assert.assertEquals(this.computerManager.getCount(), 1);


    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNullComputer(){
        Computer computer = null;
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p501", 250);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);

        this.computerManager.getComputer("Lenovo", "3000");
    }

    @Test
    public void testGetComputer(){
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p501", 250);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);


        Assert.assertEquals(this.computerManager.getComputer("Acer", "p501"), computer2);
    }

    @Test
    public void testGetComputersByManufacturer(){
        Computer computer1= new Computer("Dell", "p30", 200);
        Computer computer2= new Computer("Acer", "p501", 250);

        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer2);

        List<Computer>equalManufacturer = new ArrayList<>();
        equalManufacturer.add(computer2);

        Assert.assertEquals(this.computerManager.getComputersByManufacturer("Acer"), equalManufacturer);

    }
}