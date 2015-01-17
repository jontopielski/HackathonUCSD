import java.util.*;

public class MyQuickSort {
     
    public double[] theArray = new double[5];
    public int length;
    public int type;
    
    public MyQuickSort(Item[] array, int flag, int length) {
        this.length = length;
        this.type = type;
        double[] copyArray = new double[5];
        
        if (flag == 2) {
            for (int i = 0; i < length; i++) {
                theArray[i] = array[i].getDiningPrice();
            }
        }
        
        else if (flag == 3) {
            for (int i = 0; i < length; i++) {
                theArray[i] = array[i].getRalphsPrice();
            }
        }
        
        else {
            for (int i = 0; i < length; i++) {
                theArray[i] = array[i].getChangeInPrice();
            }
        }
        
        sort(theArray);
        
        if (flag == 2) {
        
        for (int i = 0; i < theArray.length; i++) {
            array[i].setDiningPrice(theArray[i]);
        }
        }
        
        else if (flag == 3) {
            for (int i = 0; i < theArray.length; i++) {
                array[i].setRalphsPrice(theArray[i]);
            }
        }
        
        else {
            for (int i = 0; i < theArray.length; i++) {
                array[i].setChangeInPrice(theArray[i]);
            }
        }
    }
 
    public void sort(double[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0.0) {
            return;
        }
        this.theArray = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        double pivot = theArray[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (theArray[i] < pivot) {
                i++;
            }
            while (theArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
        
    }
 
    private void exchangeNumbers(int i, int j) {
        double temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }
}