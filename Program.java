import java.util.*;
import java.io.*;

public class Program {

    public static void main(String[] args) {
        
        /* four arrays created */
        Item[] candyArray = createArray(1, 5);
        Item[] dairyArray = createArray(2, 5);
        Item[] frozenArray = createArray(3, 5);
        Item[] snackArray = createArray(4, 5);
        
        /* copy arrays : to manipulate when sorting by a certain type */
        Item[] copyCandyArray = copyArray(candyArray);
        Item[] copyDairyArray = copyArray(dairyArray);
        Item[] copyFrozenArray = copyArray(frozenArray);
        Item[] copySnackArray = copyArray(snackArray);
        
        
        /* key: sort by dining price = 2
         *      sort by ralph's price = 3
         *      sort by change in price = 4
         */

        sortArrayByCat(copyCandyArray, 4);
        printArray(copyCandyArray);
        
        
    }
    
    public static Item[] copyArray(Item[] originalArray) {
        Item[] copyArray = new Item[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            copyArray[i] = originalArray[i];
        }
        return copyArray;
    }
    
    public static void sortArrayByCat(Item[] theArray, int flag) {
        
        
        MyQuickSort sort = new MyQuickSort(theArray, flag, theArray.length);
        
    }
    
    public static void printArray(Item[] array) {
        for (int i = 0; i < array.length; i++) {
            
            System.out.printf("Item: %10s", array[i].getName());
            System.out.printf(" | Dining Dollars price: %15f", array[i].getDiningPrice());
            System.out.printf(" | Ralph's price: %10f", array[i].getRalphsPrice(), " | ");
            if (array[i].getChangeInPrice() < 0) {
                System.err.printf("Change in price: %10f", array[i].getChangeInPrice());
            } else {
                System.out.printf("Change in price: %10f", array[i].getChangeInPrice());
            }
            System.out.println();
        }
    }
    
    
    /* This function creates an item[] filled with items of a specified class
     * depending on which type is passed in.
     */
    
    public static Item[] createArray(int type, int length) {
        
        Scanner input = null;
        Item[] theArray = new Item[length];
        if (type == 1) {
            try {
            input = new Scanner(new File("candylist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }            
            for (int i = 0; input.hasNext() && i < theArray.length; i++) {
                String currentName = input.nextLine();
                theArray[i] = new CandyFood(currentName);
            }
        }
        
        if (type == 2) {
            try {
            input = new Scanner(new File("dairylist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
            for (int i = 0; input.hasNext() && i < theArray.length; i++) {
                String currentName = input.nextLine();
                theArray[i] = new DairyFood(currentName);
            }
        }
        
        if (type == 3) {
            try {
            input = new Scanner(new File("frozenlist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
            for (int i = 0; input.hasNext() && i < theArray.length; i++) {
                String currentName = input.nextLine();
                theArray[i] = new FrozenFood(currentName);
            }
        }
        
        if (type == 4) {
            try {
            input = new Scanner(new File("snacklist.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
            for (int i = 0; input.hasNext() && i < theArray.length; i++) {
                String currentName = input.nextLine();
                theArray[i] = new SnackFood(currentName);
            }
        }
        return theArray;
    }   
}

