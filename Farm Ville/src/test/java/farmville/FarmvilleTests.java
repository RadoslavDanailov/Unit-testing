package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
   private Farm farm;

   @Before
    public void setup(){
       farm = new Farm("Cowland", 3);
   }

   @Test
    public void testGetCount(){
       Animal goat = new Animal("Goat", 30);
       Animal cow = new Animal("Cow", 50);
       Animal sheep = new Animal("Sheep", 20);

       farm.add(goat);
       farm.add(cow);
       farm.add(sheep);
       Assert.assertEquals(this.farm.getCount(), 3);
   }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInFullFarm(){
        Animal goat = new Animal("Goat", 30);
        Animal cow = new Animal("Cow", 50);
        Animal sheep = new Animal("Sheep", 20);
        Animal elephant = new Animal("Elephant", 100);

        farm.add(goat);
        farm.add(cow);
        farm.add(sheep);
        farm.add(elephant);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistAnimal(){
        Animal goat = new Animal("Goat", 30);
        Animal cow = new Animal("Cow", 50);
        Animal sheep = new Animal("Sheep", 20);

        this.farm.add(goat);

        this.farm.add(goat);
    }

    @Test
    public void testRemove(){
        Animal goat = new Animal("Goat", 30);
        Animal cow = new Animal("Cow", 50);
        Animal sheep = new Animal("Sheep", 20);

        farm.add(goat);
        farm.add(cow);
        farm.add(sheep);
        Assert.assertEquals(this.farm.getCount(), 3);
        this.farm.remove("Goat");
        Assert.assertEquals(this.farm.getCount(), 2);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testSetMinusCapacity(){
       farm = new Farm("Cows", -1);
    }

    @Test
    public void testSetCapacity(){
       Assert.assertEquals(this.farm.getCapacity(), 3);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNullName(){
       farm = new Farm(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEmptyName(){
        farm = new Farm("", 0);
    }

    @Test
    public void testSetName(){
       Assert.assertEquals(this.farm.getName(), "Cowland");
    }
}
