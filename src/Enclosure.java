import java.util.ArrayList;

public class Enclosure {
    ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }
    public void addWaste(int amount){

    }
    public int removeWaste(){
        return 0;
    }
    public FoodStore getFoodStore(){
        return null;
    }
    public int size(){return animals.size();}
    public boolean aMonthPasses(){return false;}
}
