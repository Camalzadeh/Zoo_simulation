package Animals;

import Enclosures.Enclosure;
import FoodStores.FoodStore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    public static final Set<String> animalTypes = new HashSet<String>(Arrays.asList(
            "lion",
            "chimpanzee",
            "tiger",
            "gorilla",
            "penguin",
            "bear",
            "elephant",
            "giraffe")
    );
    Animal(int age, char gender, String[] eats, int health, int lifeExpectancy) {
        this.age = age;
        setGender(gender);
        this.eats = eats;
        setHealth(health);
        this.lifeExpectancy = lifeExpectancy;
        this.waste=0;
        details=new StringBuilder();
    }
    Animal() {this(START_AGE,'m', new String[]{"hay", "fruit", "steak","celery"},MAX_HEALTH,30);}

    private int age;
    private char gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;

    private Enclosure enclosure;
    private int waste;

    protected StringBuilder details;

    static final int MAX_HEALTH=10;
    static final int MIN_HEALTH=0;
    static final int START_AGE=1;

    private void setGender(char gender){
        if (gender == 'm' || gender == 'f') {
            this.gender = gender;
        } else {
            this.gender = 'm';
        }
    }

    private void setHealth(int health){
        if(health>MAX_HEALTH){
            this.health=MAX_HEALTH;
        }else if (health<MIN_HEALTH){
            this.health=MIN_HEALTH;
        }else{
            this.health=health;
        }
    }

    public void setEnclosure(Enclosure enclosure){
        this.enclosure=enclosure;
    }

    private boolean isDead(){
        if(health<=0){
            return true;
        }
        return age >= lifeExpectancy;
    }
    public int getAge(){ return age;}
    public char getGender(){ return gender;}
    public String[] getEats(){return Arrays.copyOf(eats,eats.length);}
    public double getHealth(){return isValidHealth() ? health : 0;}
    public int getLifeExpectancy(){ return lifeExpectancy;}
    public boolean canEat(String food){
        for(String eat : eats){
            if(eat.equals(food)) return true;
        }
        return false;
    }
    public boolean eat(){
        int foodCount = eats.length;
        String food = "";
        boolean eaten = false;
        while ((foodCount > 0) && (!eaten)) {
            foodCount--;
            food = eats[foodCount];
            eaten = enclosure.getFoodStore().takeFood(food);
        }

        if (eaten) {
            details.append("eats " + food + "; ");
            increaseHealth( FoodStore.getFoodHealth(food) );
            waste += FoodStore.getFoodWaste(food);
            return true;
        } else {
            details.append("FAILS to eat; ");
            return false;
        }
    }

    public void decreaseHealth(int amount){
        if (amount > 0){
            details.append("looses " + amount + " health points; ");
            setHealth(health - amount);
        }
    }
    public void increaseHealth(int amount){
        if (amount > 0) {
            details.append("gains " + amount + " health points; ");
            setHealth(health + amount);
        }
    }

    public void increaseAge(){
        details.append("grows older by 1 month; ");
        age++;
    }
    public abstract void treat();

    public void excrete(){
        enclosure.addWaste(waste);
        details.append("produces " + waste + " waste; ");
        waste=0;
    }

    public String getAnimalDetails(){
        return (this.getClass().getName()+"("+gender+") "+
                details+"\n\t\t" + " At the end of the month has "+
                health+" health and is "+ age +" months old");
    }
    public boolean aMonthPasses(){
        details.setLength(0);
        decreaseHealth(2);
        increaseAge();
        if(isDead()){
            details.append("dies; ");
            return false;
        }
        eat();
        excrete();
        return true;
    }
    public boolean isValidHealth() {return health >= MIN_HEALTH && health <= MAX_HEALTH;}

}
/*
The abstract Animals.Animal class will also need to define some methods for use by the Zoos.Zoo and Zookeepers. These
methods can be overridden by the other specific sub-classes. The methods you need to create are getAge(),
getGender(), getLifeExpectancy(), canEat(String), that returns true if the Animals.Animal can eat that food, eat(),
decreaseHealth(), treat(), and the abstract method aMonthPasses(),which will have a return type of
boolean. aMonthPasses() will be called on each Animals.Animal in the zoo once each month and will contain all
the code that enables the animal to do what they need to do and to change its state over time. Principally,
for Animals it will allow them to eat, excrete and grow old. We will fill in the details of this method later.
You should now have an Animals.Animal class. As we progress you may need to, and choose to add additional
methods to your abstract class. Some aspects, such as the lifeExpectancy, will be specific for each type of
Animals.Animal you go on to create.
 */