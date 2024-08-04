import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class FoodStore {
    Hashtable<String, Integer> foods = new Hashtable<>();

    public void addFood(String food, int amount){
        if(foods.containsKey(food)){
            foods.put(food, foods.get(food) + amount);
        }else{
            foods.put(food, amount);
        }
    }

    public void takeFood(String food){
        if(foods.containsKey(food)){
            foods.put(food, foods.get(food) - 1);
        }
    }
}
/*
Food is held in a Foodstore class. Each Enclosure will have a Foodstore where the animals get their food
from, and the Zoo will have a Foodstore where food is delivered to the Zoo.
Your Foodstore class will need a number of access methods. addFood(String, int) that adds a number of
items of food of the specified type to the Foodstore, i.e. addFood(“steak”,5). takeFood(String), which is
used by the animals when they eat in their Enclosure, and also by the Zookeepers as they move food from
the Zoo foodstore to the Enclosure foodstore. You may find you want to add other access functions for the
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
