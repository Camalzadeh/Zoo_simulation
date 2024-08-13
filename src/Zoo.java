import Zookeeper.Zookeeper;

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
        for(Enclosure enclosure : enclosures){
            if(enclosure.aMonthPasses()){
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
        for(String food : foodStore.getFoods())

    }
    public void setZooID(int zooID) {
        this.zooID = zooID;
    }

    public void aMonthPasses(){

    }
}
