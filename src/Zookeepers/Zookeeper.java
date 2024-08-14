package Zookeepers;
import Animals.Animal;
import Animals.Bear;
import Animals.Lion;
import Animals.Tiger;
import Enclosures.Enclosure;
import Zoos.Zoo;

import java.util.*;

public class Zookeeper {
    public static final Set<String> zookeeperTypes = new HashSet<String>(Arrays.asList(
            "zookeeper",
            "playzookeeper",
            "phisiozookeeper")
    );

    public static final int MAX_FOOD =20;
    public static final int MAX_CLEAN =20;
    private ArrayList<Enclosure> enclosures;
    private Zoo zoo;

    protected ArrayList<Class<? extends Animal>> canTreat = new ArrayList<>(
            List.of(Lion.class,Tiger .class, Bear.class));

    protected StringBuilder details;

    public Zookeeper(Enclosure enclosure){
        enclosures = new ArrayList<Enclosure>();
        enclosures.add(enclosure);
        this.zoo =null;
        details = new StringBuilder();
    }

    public Zookeeper(){
        enclosures = new ArrayList<Enclosure>();
        this.zoo =null;
        details = new StringBuilder();
    }

    public Enclosure getEnclosure(int index){return enclosures.get(index);}

    public void addEnclosure(Enclosure enclosure){enclosures.add(enclosure);}

    public void setZoo(Zoo zoo){this.zoo = zoo;}

    public void aMonthPasses(){
        details.setLength(0);
        removeWaste();
        moveFood();
        giveTreat();
    }
    public void moveFood() {
        for (Enclosure enclosure : enclosures) {
            if (enclosure.isNotEmpty()) {
                moveFood(enclosure);
            }
        }
    }
    public void moveFood(Enclosure enclosure){
        HashMap<String, Integer> requirements = enclosure.getFoodRequirements();
        int foodCount = MAX_FOOD;
        try {
            boolean requirementMet = (Collections.max(requirements.values()) <= 0);
            boolean foodTankenSuccessfully = true;
            while ((foodCount > 0) && (!requirementMet) && (foodTankenSuccessfully)) {
                foodTankenSuccessfully = false;
                for (String food : requirements.keySet()) {
                    if ((foodCount > 0) && (requirements.get(food) > 0) && (zoo.getFoodStore().takeFood(food))) {
                        enclosure.getFoodStore().addFood(food, 1);
                        requirements.put(food, requirements.get(food) - 1);
                        foodCount--;
                        details.append("moves " + 1 + " " + food + " to enclosure " + enclosure.getEnclosureID() + "; ");
                        foodTankenSuccessfully = true;
                    }
                }
                requirementMet = (Collections.max(requirements.values()) <= 0);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeWaste(){
        for(Enclosure enclosure : enclosures){
            removeWaste(enclosure);
        }
    }
     public void removeWaste(Enclosure enclosure){
         int removeMax= MAX_CLEAN;
         int wasteToRemove = enclosure.getWasteSize();
         details.append("removes ");
         if ( wasteToRemove > removeMax ) {
             // The following line means: if (enclosure.removeWaste(removeMAX)) is carried out successfully append removeMAX to detailStatus else append 0
             details.append( (enclosure.removeWaste(removeMax)? removeMax : 0 ));
         } else {
             details.append( (enclosure.removeWaste(wasteToRemove)? wasteToRemove : 0 ));
         }
         details.append(" waste from Enclosure " + enclosure.getEnclosureID() + "; ");
     }

     public void giveTreat(){
         for(Enclosure enclosure : enclosures){
             giveTreat(enclosure);
         }
     }

     public void giveTreat(Enclosure enclosure){
         Animal animal;
         int i = 0;
         int toTreat = 2;
         while ( (i < enclosure.size()) && (toTreat > 0) ) {
             animal = enclosure.getAnimalAt(i);
             if (canTreat.contains(animal.getClass())){
                 details.append(" treats " + animal.getClass().getName()+ " in enclosure " + enclosure.getEnclosureID() + "; ");
                 animal.treat();
                 toTreat--;
             }
             i++;
         }
     }

     public String getDetails(){
         return "ZOOKEEPER(" + this.getClass().getName() + ") : " + details;
     }
}
