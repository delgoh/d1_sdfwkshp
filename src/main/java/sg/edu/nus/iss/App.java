package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        List<String> items = new ArrayList<String>();

        System.out.println( "Welcome to your shopping cart" );
        String input = scan.nextLine();

        while (!input.equals("quit")) {
            String[] words = input.trim().toLowerCase().split(", |,|\\s+");
            int i = 1;
            switch (words[0]) {  
                case "list":
                    if (items.size() == 0) {
                        System.out.println("Your cart is empty");
                    } else {
                        for (i = 0; i < items.size(); i++) {
                            System.out.println((i + 1) + ". " + items.get(i));
                        }
                    }
                    break;

                case "add":
                    for (i = 1; i < words.length; i++) {
                        if (items.contains(words[i])) {
                            System.out.println("You have " + words[i] + " in your cart");
                        } else {
                            items.add(words[i]);
                            System.out.println(words[i] + " added to cart");
                        }
                    }
                    break;

                case "delete":
                    int itemIndex = Integer.parseInt(words[1]);
                    if (itemIndex > items.size() || itemIndex <= 0) {
                        System.out.println("Incorrect item index");
                    } else {
                        System.out.println(items.get(itemIndex - 1) + " removed from cart");
                        items.remove(itemIndex - 1);
                    }
                    break;

                default:
                    System.out.println("Not a valid command. List of commands:");
                    System.out.println("- list");
                    System.out.println("- add <item1>, <item2>, ...");
                    System.out.println("- delete <item index>");
                    System.out.println("- quit");
            }
            input = scan.nextLine();
        }

        scan.close();
    }
}
