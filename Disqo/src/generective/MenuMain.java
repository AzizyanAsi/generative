package generective;

import generective.objects.group.Group;
import generective.objects.items.Configuration;
import generective.objects.items.models.Generative;
import generective.objects.items.models.Item;
import generective.objects.items.models.Stock;
import generective.service.Util;

import java.util.Scanner;
import java.util.UUID;

import static generective.service.Util.basket;


public class MenuMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("type group name or continue");
            String s = sc.nextLine();
            switch (s) {
                case "continue":
                    isMenuActive = false;
                    generateItem(sc);

                    break;
                default:
                    if (s.isEmpty()) {
                        break;
                    }
                    Group g = new Group(UUID.randomUUID().toString(), s);
                    System.out.println("Type Parent id");
                    String parentId = sc.nextLine();
                    g.setParentId(parentId);
                    g.setParentId(Util.addGroup(g, Util.getRoots(), true) ? "root" : parentId);
                    System.out.print("Created group: ");
                    System.out.println(g);
            }
        }
        for (Group x : Util.getRoots()) {
            x.printGroupInfo();

        }
        System.out.println(String.format("Total price %f", basket.calculatePrice()));
    }

    private static void generateItem(Scanner sc) {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("type item name or continue");
            String command = sc.nextLine();
            switch (command) {
                case "continue":
                    return;
                default:
                    if (command.isEmpty()) {
                        break;
                    }
                    System.out.println("what type of item do you want to create 1.generative 2.stock");
                    int i = sc.nextInt();
                    sc.nextLine();
                    Item item;
                    System.out.println("type price");
                    double price = sc.nextDouble();
                    sc.nextLine();//new line
                    System.out.println("choose configuration 1.HD 2.FHD 3.4K");
                    int x = sc.nextInt();
                    sc.nextLine();
                    Configuration c;
                    switch (x) {
                        case 2:
                            c = Configuration.FHD;
                            break;
                        case 3:
                            c = Configuration.K4;
                            break;
                        default:
                            c = Configuration.HD;
                            break;
                    }
                    if (i == 1) {
                        System.out.println("choose complexity from 1-2");
                        double complexity = sc.nextDouble();
                        sc.nextLine();//for new line
                        item = new Generative(UUID.randomUUID().toString(), command, complexity, price, c);
                    } else {
                        item = new Stock(UUID.randomUUID().toString(), command, price, c);
                    }
                    System.out.println("Type Parent id");
                    String parentId = sc.nextLine();
                    item.setParentId(parentId);


                    boolean isAdded = Util.addItem(item, Util.getRoots());
                    if (isAdded) {
                        System.out.print("Created item: ");
                        System.out.println(item);
                        basket.addToBasket(item);
                    } else {
                        System.out.printf("Parent id not found: %s%n", parentId);
                    }
            }
        }
    }
}