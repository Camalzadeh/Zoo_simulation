package Zoos;

import Enclosures.Enclosure;
import FoodStores.FoodStore;
import Zookeepers.Zookeeper;

import java.util.ArrayList;

public class Zoo {
    private Enclosure[] enclosures;
    private ArrayList<Zookeeper> zookeepers;
    private FoodStore foodStore;
    private Enclosure currentEnclosure;
    private Zookeeper currentZookeeper;
    private int enclosuresSize;
    private int zooID;
    private boolean isOpen;

    public Zoo(){
        enclosures = new Enclosure[10];
        zookeepers = new ArrayList<>();
        foodStore = new FoodStore();
        currentEnclosure = null;
        currentZookeeper = null;
        enclosuresSize = 0;
        isOpen = true;
    }

    public boolean aMonthPasses(){
        isOpen=false;
        for(int i =0; i<enclosuresSize;i++){
            if(enclosures[i].aMonthPasses()){
                isOpen=true;
            }
        }

        if(isOpen){
            for(Zookeeper zookeeper : zookeepers){
                zookeeper.aMonthPasses();
            }
            restockFoodStore();
        }
        return isOpen;
    }
    public FoodStore getFoodStore(){
        return foodStore;
    }

    public void restockFoodStore(){
        for(String food : FoodStore.getFoods()){
            foodStore.addFood(food, 50);
        }
    }
    public Enclosure getEnclosure(int ID) throws NullPointerException{
        if((enclosuresSize >= ID) && (0<=ID)){
            return enclosures[ID-1];
        }else {
            throw new NullPointerException("Enclosure.Enclosure does not exist");
        }
    }
    public void addEnclosure(Enclosure enclosure){
        enclosures[enclosuresSize++] = enclosure;
        enclosure.setEnclosureID(enclosuresSize);
        currentEnclosure = enclosure;
    }

    public Enclosure getCurrentEnclosure(){ return currentEnclosure;}

    public void addZookeeper(Zookeeper zookeeper){
        zookeepers.add(zookeeper);
        currentZookeeper = zookeeper;
        zookeeper.setZoo(this);
    }

    public Zookeeper getCurrentZookeeper(){ return currentZookeeper;}

    public String getZooDetails(){
        StringBuilder details=new StringBuilder(":::Zoo " + zooID  + " Details");
        if(isOpen){
            details.append(":::OPENED:::");
            details.append("\nZOO"+foodStore.getFoodStoreDetails()+"\n");
            for (Zookeeper zookeeper : zookeepers){
                details.append("\n"+zookeeper.getDetails());
            }
            details.append("\n");
            for(int i=0;i<enclosuresSize;i++){
                details.append("\n> "+enclosures[i].getEnclosureDetails());
            }

        }else{
            details.append(":::CLOSED:::");
        }
        return details.toString();
    }

    public void setZooID(int zooID) {
        this.zooID = zooID;
    }
    public int getZooID() {
        return zooID;
    }
}
