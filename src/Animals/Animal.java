package Animals;

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
    Animal(int age, char gender, String[] eats, double health) {
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;
    }
    Animal() {
        this(0, 'm', new String[0], 10 );
    }
    int age;
    char gender;
    String[] eats;
    double health;
    int lifeExpectancy;
    static final int MAX=10;
    static final int MIN=0;

    int getAge(){ return age;}
    char getGender(){ return gender;}
    String[] getEats(){return Arrays.copyOf(eats,eats.length);}
    double getHealth(){return isValidHealth() ? health : 0;}
    int getLifeExpectancy(){ return lifeExpectancy;}
    boolean canEat(String food){
        for(String eat : eats){
            if(eat.equals(food)) return true;
        }
        return false;
    }
    abstract void eat();
    abstract void decreaseHealth();
    abstract void treat();
    public abstract boolean aMonthPasses();
    boolean isValidHealth() {return health >= MIN && health <= MAX;}

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