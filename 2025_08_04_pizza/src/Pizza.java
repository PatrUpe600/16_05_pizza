import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pizza {

    private int type;
    private int size;
    private boolean memberCard;
    private double cost;

    private static ArrayList<Pizza> pizzaData = new ArrayList<Pizza>();

    public Pizza (int type, int size, boolean memberCard, double cost) {
        this.type = type;
        this.size = size;
        this.memberCard = memberCard;
        this.cost = cost;
    }

    public static void addPizza (Pizza pizza) {
        pizzaData.add(pizza);
    }

    public double calculateCost() {
        double sum = 5;
        if (type == 1) {
            sum = sum + ((double) size / 3 * 0.9);
        }
        else if (type == 2) {
            sum = sum + ((double) size / 3 * 1.1);
        }
        else if (type == 3) {
            sum = sum + ((double) size / 3 * 0.95);
        }
        else if (type == 4) {
            sum = sum + ((double) size / 3 * 1.3);
        }
        else if (type == 5) {
            sum = sum + ((double) size / 3 * 1.5);
        }
        else {
            System.out.println("No pizza calculation");
        }

        if (memberCard == true) {
            sum=sum*0.9;
        }


        cost = (double) Math.round(sum * 100) / 100;
        return(cost);
    }

    public String pizzaType() {
        if (type == 1) {
            return("Pizza type: Pepperoni");
        }
        else if (type == 2) {
            return("Pizza type: Ham");
        }
        else if (type == 3) {
            return("Pizza type: Vegetarian");
        }
        else if (type == 4) {
            return("Pizza type: Shroom");
        }
        else if (type == 5) {
            return("Pizza type: All-topping");
        }
        else {
            return("Error");
        }
    }

    public String printInfo() {
        return(pizzaType()+"\nPizza size: "+size+" inches\nMembercard: "+memberCard+"\nCost: "+cost+" euros\n");
    }

    public static void writeFile() {
        try {
            FileWriter fw = new FileWriter("info.txt", true);
            for (Pizza pizza : pizzaData) {
                fw.write(pizza.printInfo());
                fw.write("------------------------\n");
            }
            fw.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public int getType() { return type; }
    public int getSize() { return size; }
    public boolean getMembercard() { return memberCard; }
    public double getCost() { return cost; }

}
