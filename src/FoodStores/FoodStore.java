package FoodStores;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class FoodStore {

    private Hashtable<String, Integer> foods;

    private static HashMap<String, Integer> foodsHealth =  new HashMap<String, Integer>() {{
        put("hay", 1);
        put("steak", 4);
        put("fruit", 2);
        put("celery", 0);
        put("fish", 3);
        put("ice cream", 1);
    }};

    private static HashMap<String, Integer> foodsWaste = new HashMap<String, Integer>() {{
        put("hay", 4);
        put("steak", 4);
        put("fruit", 3);
        put("celery", 1);
        put("fish", 2);
        put("ice cream", 3);
    }};

    public FoodStore(){
        foods = new Hashtable<String,Integer>();
        initializeFoods();
    }

    public void initializeFoods(){
        for(String food : foodsHealth.keySet()){
            foods.put(food, 0);
        }
    }

    public static Set<String> getFoods(){
        return foodsHealth.keySet();
    }

    public static int getFoodHealth(String food){
        return foodsHealth.get(food);
    }

    public static int getFoodWaste(String food){
        return foodsWaste.get(food);
    }

    public void addFood(String food, int amount){
        if(amount>0){
            foods.put(food, foods.get(food) + amount);
        }
    }

    public boolean takeFood(String food){
        if(foods.get(food) > 0){
            foods.put(food, foods.get(food) - 1);
            return true;
        }
        return false;
    }
}
/*
Food is held in a Foodstore class. Each Enclosure.Enclosure will have a Foodstore where the animals get their food
from, and the Zoos.Zoo will have a Foodstore where food is delivered to the Zoos.Zoo.
Your Foodstore class will need a number of access methods. addFood(String, int) that adds a number of
items of food of the specified type to the Foodstore, i.e. addFood(“steak”,5). takeFood(String), which is
used by the animals when they eat in their Enclosure.Enclosure, and also by the Zookeepers as they move food from
the Zoos.Zoo foodstore to the Enclosure.Enclosure foodstore. You may find you want to add other access functions for the
foodstores later on.
How you model the storage in the Foodstore is up to you. It would be fine to have an int variable for each
type of food, holding the quantity of that food in the Foodstore. If you want to make your code more
flexible you might choose to use a structure such as a Hashtable with the key being the food name and the
value being the quantity.
The health given by food and waste produced will be modelled in the eat method of the animals later on to
keep things simple.
At this stage you should now be able to create a Foodstore and add varying quantities of various types of
food to it.
 */
