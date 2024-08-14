package Enclosures;

import Animals.Animal;
import FoodStores.FoodStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Enclosure {
    ArrayList<Animal> animals = new ArrayList<>();
    int waste;
    FoodStore enclusureFoodStore;
    private int enclosureID;

    private StringBuilder details;

    public Enclosure(){
        animals = new ArrayList<>();
        enclusureFoodStore = new FoodStore();
        details = new StringBuilder();
        waste=0;
    }
    public boolean addAnimal(Animal animal){
        if(size()<20){
            animals.add(animal);
            animal.setEnclosure(this);
            details.append("animal added to enclosure ");
            return true;
        }
        else{
            details.append("enclosure is full; ");
            return false;
        }
    }

    public void removeAnimal(Animal animal){
        animal.setEnclosure(null);
        animals.remove(animal);
    }
    public void addWaste(int amount){
        waste += amount;
    }
    public boolean removeWaste(int amount){
        if(amount<0){
            return false;
        }else if(amount>waste){
            waste=0;
        }else{
            waste -= amount;
        }
        return true;
    }
    public int getWasteSize(){
        return waste;
    }
    public FoodStore getFoodStore(){
        return enclusureFoodStore;
    }
    public boolean isNotEmpty(){return size()!=0;}
    public int size(){return animals.size();}
    public int getEnclosureID(){return enclosureID;}
    public void setEnclosureID(int enclosureID) {
        this.enclosureID = enclosureID;
    }
    public boolean aMonthPasses(){
        details.setLength(0);
        boolean animalAlive;

        ArrayList<Class<? extends Animal>> maleAnimals = new ArrayList<>();
        ArrayList<Class<? extends Animal>> femaleAnimals = new ArrayList<>();

        Iterator<Animal> itrAnimal = animals.iterator();
        while (itrAnimal.hasNext()) {
            Animal animal = itrAnimal.next();
            animalAlive = animal.aMonthPasses();

            if (!animalAlive) {
                details.append(animal.getClass().getName() + "(" + animal.getGender() + ") dies at "+ animal.getAge() +"; ");
                itrAnimal.remove();
            } else {
                if (animal.getGender()=='m'){
                    maleAnimals.add(animal.getClass());
                } else {
                    femaleAnimals.add(animal.getClass());
                }
            }
        }
        if ((femaleAnimals.size() > 0 ) && (maleAnimals.size() > 0)) {
            breedAnimals(maleAnimals, femaleAnimals);
        }
        return this.isNotEmpty();
    }

    private void breedAnimals(ArrayList<Class<? extends Animal>> maleAnimals, ArrayList<Class<? extends Animal>> femaleAnimals){
        for (Class<? extends Animal> maleAnimalClass : maleAnimals){
            for (Class<? extends Animal> femaleAnimalClass : femaleAnimals){
                if (maleAnimalClass.isAssignableFrom(femaleAnimalClass)) {
                    Random rand = new Random();
                    int number = rand.nextInt(1000);
                    if (number < 10){
                        try {
                            char gender = ( (number % 2 == 0 )? 'm' : 'f' );
                            Animal newAnimal = maleAnimalClass.getConstructor(char.class, int.class, int.class).newInstance(gender,0,10);
                            details.append( "new " + newAnimal.getClass().getName() + " is born; " );
                            if ( addAnimal(newAnimal) ) {
                                details.append( "sucessfully added; ");
                            } else {
                                details.append( "failed to add; ");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public HashMap<String, Integer> getFoodRequirements(){
        HashMap<String, Integer> foodRequirements = new HashMap<>();
        for(Animal animal : animals){
            for(String food : animal.getEats()){
                if(foodRequirements.containsKey(food)){
                    foodRequirements.put(food, foodRequirements.get(food) + 1);
                }else{
                    foodRequirements.put(food, 1);
                }
            }
        }

        for(String food : foodRequirements.keySet()){
            foodRequirements.put(food, foodRequirements.get(food) -enclusureFoodStore.foodAvailable(food));
        }

        return foodRequirements;
    }

    public Animal getAnimalAt(int index){
        if ( (index < size()) && (index >= 0) )
            return this.animals.get(index);
        else
            return null;
    }

    public String getEnclosureDetails(){
        StringBuilder moreDetails = new StringBuilder("ENCLOSURE "+ getEnclosureID() + ": \t size(" + size() + ")  waste(" + waste + ") \n");
         moreDetails.append(enclusureFoodStore.getFoodStoreDetails());
         moreDetails.append("\nGENERAL: \t " + details.toString() + "\nANIMALS: \n");
         for(Animal animal: animals){
             moreDetails.append("\t"+animal.getAnimalDetails() + "\n");
         }
         return moreDetails.toString();
    }
}
