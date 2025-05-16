import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Scanner;

public class Main extends JFrame {

    private JPanel rootPanel;
    private JTextField pizzaSizeField;
    private JComboBox pizzaTypeComboBox;
    private JButton orderButton;
    private JButton registerButton;
    public boolean pizCard;
    public int pizSize;
    public int pizType;
    public PepperoniPizza pp1 = new PepperoniPizza(1, pizSize, pizCard, 0);
    public HamPizza hp1 =  new HamPizza(2, pizSize, pizCard, 0);
    public VegetarianPizza vp1 = new VegetarianPizza(3, pizSize, pizCard, 0);
    public ShroomPizza sp1 = new ShroomPizza(4, pizSize, pizCard, 0);
    public AllTopingPizza ap1 = new AllTopingPizza(5, pizSize, pizCard, 0);


    public Main() {
        setContentPane(rootPanel);
        setTitle("Max's Pizzeria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pizCard = true;
                String message = "Card registered!";
                JOptionPane.showMessageDialog(Main.this, message);
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pizSizeString = pizzaSizeField.getText();
                pizSize = Integer. parseInt(pizSizeString);

                String selectedItem = (String)pizzaTypeComboBox.getSelectedItem();

                if (selectedItem.equals("Pepperoni")) {
                    pizType = 1;
                }
                else if (selectedItem.equals("Ham")) {
                    pizType = 2;
                }
                if (selectedItem.equals("Vegetarian")) {
                    pizType = 3;
                }
                if (selectedItem.equals("Shroom")) {
                    pizType = 4;
                }
                if (selectedItem.equals("All-toping")) {
                    pizType = 5;
                }
                String message = "";

                if (pizType == 1) {
                    pp1 = new PepperoniPizza(pizType, pizSize, pizCard, pp1.calculateCost());
                    pp1.calculateCost();
                    Pizza.addPizza(pp1);
                    message = pp1.printInfo();;
                }
                else if (pizType == 2) {
                    hp1 = new HamPizza(pizType, pizSize, pizCard, hp1.calculateCost());
                    hp1.calculateCost();
                    Pizza.addPizza(hp1);
                    message = hp1.printInfo();;
                }
                else if (pizType == 3) {
                    vp1 = new VegetarianPizza(pizType, pizSize, pizCard, vp1.calculateCost());
                    vp1.calculateCost();
                    Pizza.addPizza(vp1);
                    message = vp1.printInfo();
                }
                else if (pizType == 4) {
                    sp1 = new ShroomPizza(pizType, pizSize, pizCard, sp1.calculateCost());
                    sp1.calculateCost();
                    Pizza.addPizza(sp1);
                    message = sp1.printInfo();
                }
                else if (pizType == 5) {
                    ap1 = new AllTopingPizza(pizType, pizSize, pizCard, ap1.calculateCost());
                    ap1.calculateCost();
                    Pizza.addPizza(ap1);
                    message = ap1.printInfo();
                }
                else {
                    message = "Cost: Error";
                }


                JOptionPane.showMessageDialog(Main.this, message);

                int optionResult = JOptionPane.showConfirmDialog(null, "Purchase this pizza?");

                if (optionResult == JOptionPane.YES_OPTION) {
                    String thankYou = "Thank you for ordering! Come again soon!";
                    JOptionPane.showMessageDialog(Main.this, thankYou);
                    Pizza.writeFile();
                }
                else if (optionResult == JOptionPane.NO_OPTION) {
                }
            }
        });
    }



    public static void main(String[] args) {
        new Main();

        Pizza.writeFile();

//        Scanner input = new Scanner(System.in);
//
////        System.out.println("Welcome to Max's Pizzeria!");
//
////        System.out.println("Do you have a membership card? 1 - yes, 2 - no");
////        int hasCard = input.nextInt();
//        boolean pizCard = false;
//        int pizType = 0;
////
////        if (hasCard == 1) {
////            pizCard = true;
////            System.out.println("Card registered!");
////        }
//
//            System.out.println("What pizza size would you like? 10-40 inches");
//            int pizSize = input.nextInt();
//
//            System.out.println("What pizza type would you like? 1 - Pepperoni, 2 - Ham, 3 - Vegetarian, 4 - Shroom, 5 - All-toping");
//            pizType = input.nextInt();
//
//        PepperoniPizza pp1 = new PepperoniPizza(1, pizSize, pizCard, 0);
//        HamPizza hp1 = new HamPizza(2, pizSize, pizCard, 0);
//        VegetarianPizza vp1 = new VegetarianPizza(3, pizSize, pizCard, 0);
//        ShroomPizza sp1 = new ShroomPizza(4, pizSize, pizCard, 0);
//        AllTopingPizza ap1 = new AllTopingPizza(5, pizSize, pizCard,0 );
//
//            if (pizType == 1) {
//                pp1 = new PepperoniPizza(pizType, pizSize, pizCard, pp1.calculateCost());
//                System.out.println(pp1.printInfo());
//                Pizza.addPizza(pp1);
//            }
//            else if (pizType == 2) {
//                hp1 = new HamPizza(pizType, pizSize, pizCard, hp1.calculateCost());
//                System.out.println(hp1.printInfo());
//                Pizza.addPizza(hp1);
//            }
//            else if (pizType == 3) {
//                vp1 = new VegetarianPizza(pizType, pizSize, pizCard, vp1.calculateCost());
//                System.out.println(vp1.printInfo());
//                Pizza.addPizza(vp1);
//            }
//            else if (pizType == 4) {
//                sp1 = new ShroomPizza(pizType, pizSize, pizCard, sp1.calculateCost());
//                System.out.println(sp1.printInfo());
//                Pizza.addPizza(sp1);
//            }
//            else if (pizType == 5) {
//                ap1 = new AllTopingPizza(pizType, pizSize, pizCard, ap1.calculateCost());
//                System.out.println(ap1.printInfo());
//                Pizza.addPizza(ap1);
//            }
//            else {
//                System.out.println("Error");
//            }
//
//        Pizza.writeFile();
//        System.out.println("Thank you for visiting! Come again soon!");

    }
}