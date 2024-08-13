import Animals.Animal;

import java.util.ArrayList;

public class Enclosure {
    ArrayList<Animal> animals = new ArrayList<>();
    int waste;
    FoodStore enclusureFoodStore;

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }
    public void addWaste(int amount){
        waste += amount;
    }
    public void removeWaste(int amount){
        waste-=amount;
    }
    public int getWasteSize(){
        return waste;
    }
    public FoodStore getFoodStore(){
        return enclusureFoodStore;
    }
    public int size(){return animals.size();}
    public boolean aMonthPasses(){
        animals.forEach(Animal::aMonthPasses);
        return true;
    }
}
