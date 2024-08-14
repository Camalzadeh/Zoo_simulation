import Animals.*;
import Enclosures.Enclosure;
import FoodStores.FoodStore;
import Zookeepers.PhysioZookeeper;
import Zookeepers.PlayZookeeper;
import Zookeepers.Zookeeper;
import Zoos.Zoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulation {
    private static final ArrayList<Zoo> zoos= new ArrayList<>();
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
        String absolutePath = "/home/ubuntu/Desktop/ASUS komputer/Learning/coding/Java/Zoo_simulation/src/Data/"+filename;
        runSimulation(absolutePath,speed);
    }
    static void runSimulation(String filename, int speed){
        try{
            fileToSimulation(filename);

            boolean zooParkIsOpened = true;
            int month=1;

            while(zooParkIsOpened){
                zooParkIsOpened=false;
                System.out.println("------MONTH "+month+"----------------------------------------------");
                for(Zoo zoo: zoos){
                    if(zoo.aMonthPasses()){
                        System.out.println(zoo.getZooDetails());
                        zooParkIsOpened=true;
                    }
                }

                try{
                    Thread.sleep(speed);
                }catch(InterruptedException e){
                    System.err.println("ERROR! ");
                    System.err.println(e.getMessage());
                }
                month++;
            }
            for(Zoo zoo:zoos){
                System.out.println(zoo.getZooDetails());
            }
        }catch (FileNotFoundException e) {
            System.err.println("Unable to open file '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Error reading file '" + filename + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("Simulation finished");
        }
    }
    static void fileToSimulation(String file) throws Exception {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while((line=bufferedReader.readLine())!=null){
            lineIndex++;
            readLine(line);
        }
        bufferedReader.close();
        fileReader.close();
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

            else if(currentZoo.getCurrentEnclosure()!=null){
                Enclosure lastEnclosure=currentZoo.getCurrentEnclosure();

                if (FoodStore.getFoods().contains(key)) {
                    int quantity = Integer.parseInt(line.split(":")[1]);
                    currentZoo.getCurrentEnclosure().getFoodStore().addFood(key, quantity);
                }
                else{
                    if(Animal.animalTypes.contains(key)){
                        addAnimal(key,line.split(":")[1]);
                    }
                    else if(Zookeeper.zookeeperTypes.contains(key)){
                        if( line.split(":").length>1){
                            addZookeeper(key,line.split(":")[1]);
                        }else{
                            addZookeeper(key, ":");
                        }
                    }
                }
            }
            else {
                if (FoodStore.getFoods().contains(key)){
                    int quantity = Integer.parseInt(line.split(":")[1]);
                    currentZoo.getFoodStore().addFood(key, quantity);
                }
            }

        }

    }

    static void addAnimal(String key, String line){
        char gender = Character.toLowerCase(line.charAt(0));
        int age = Integer.parseInt( line.split(",")[1] );
        int health = Integer.parseInt( line.split(",")[2] );
        Enclosure enclosure;

        if (line.split(",").length == 4) {
            enclosure = currentZoo.getEnclosure( Integer.parseInt( line.split(",")[3] ) );
        } else {
            enclosure = currentZoo.getCurrentEnclosure();
        }

        switch (key) {
            case "lion":
                Lion lion = new Lion(age, gender, health);
                enclosure.addAnimal(lion);
                break;

            case "bear":
                Bear bear = new Bear( age,gender, health);
                enclosure.addAnimal(bear);
                break;

            case "chimpanzee":
                Chimpanzee chimpanzee = new Chimpanzee(age, gender,  health);
                enclosure.addAnimal(chimpanzee);
                break;

            case "elephant":
                Elephant elephant = new Elephant( age, gender,health);
                enclosure.addAnimal(elephant);
                break;

            case "gorilla":
                Gorilla gorilla = new Gorilla( age, gender, health);
                enclosure.addAnimal(gorilla);
                break;

            case "penguin":
                Penguin penguin = new Penguin(age, gender, health);
                enclosure.addAnimal(penguin);
                break;

            case "tiger":
                Tiger tiger = new Tiger(age, gender, health);
                enclosure.addAnimal(tiger);
                break;

            case "giraffe":
                Giraffe giraffe = new Giraffe(age, gender, health);
                enclosure.addAnimal(giraffe);
                break;
            default:
                break;
        }
    }

    static void addZookeeper(String key, String line){
        switch(key){
            case "zookeeper":
                Zookeeper zookeeper = new Zookeeper();
                currentZoo.addZookeeper(zookeeper);
                break;
            case "physioZookeeper":
                Zookeeper physioZookeeper = new PhysioZookeeper();
                currentZoo.addZookeeper(physioZookeeper);
                break;
            case "playZookeeper":
                Zookeeper playZookeeper = new PlayZookeeper();
                currentZoo.addZookeeper(playZookeeper);
                break;
            default:
                break;
        }
        if(line.length()>0){
            for(String ID: line.split(",")){
                currentZoo.getCurrentZookeeper().addEnclosure(currentZoo.getEnclosure(Integer.parseInt(ID)));
            }
        }else{
            currentZoo.getCurrentZookeeper().addEnclosure(currentZoo.getCurrentEnclosure());
        }
    }
    static void addZoo(Zoo zoo){
        zoos.add(zoo);
        currentZooIndex++;
        zoo.setZooID(currentZooIndex);
    }
}