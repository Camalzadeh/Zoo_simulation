import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    private static ArrayList<Zoo> zoos= new ArrayList<>();
    private static Zoo currentZoo;
    private static int currentZooIndex;
    private static int lineIndex;
    public static void main(String[] args) {
        String filename="myZoo.txt";
        int speed=500;
        if(args.length>0){
            filename=args[0];
        }
        if(args.length>1){
            speed=Integer.parseInt(args[1]);
        }
        runSimulation(filename,speed);
    }
    static void runSimulation(String filename, int speed){

    }
    static void fileToSimulation(String file) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader((file)));
        String line;
        while((line=bufferedReader.readLine())!=null){
            lineIndex++;
        }
    }
    static void readLine(String line){
        String key = line.split(":")[0];

        if("zoo".equals(key)){
            Zoo zoo=new Zoo();
            addZoo(zoo);
            currentZoo=zoo;
        }

        else if(currentZoo != null){

            if("enclosure".equals(key)){
                Enclosure enclosure = new Enclosure();
                enclosure.addWaste(Integer.parseInt(line.split(":")[1]));
                currentZoo.addEnclosure(enclosure);
            }
            else if(currentZoo.lastEnclosure()==null){
                if (Foodstore.getFoodSet().contains(key) {
                    int quantity = Integer.parseInt(line.split(":")[1]);
                    currentZoo.getFoodstore().addFood(key, quantity);
                }
            }
            else if(currentZoo.lastEnclosure()!=null){

                if (Foodstore.getFoodSet().contains(key) {
                    int quantity = Integer.parseInt(line.split(":")[1]);
                    currentZoo.lastEnclosure().getFoodStore().addFood(key, quantity);
                }
                else{
                    if()
                }
            }

        }

    }
    static void addZoo(Zoo zoo){
        zoos.add(zoo);
        currentZooIndex++;
        zoo.setZooID(currentZooIndex);
    }
}