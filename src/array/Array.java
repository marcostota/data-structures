package array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 8, 7, 3};
//        System.out.println(arr[3]);
        Array array = new Array();

        array.printAllElement("All element before adding ::", arr);

        arr = array.addElement(arr, 4, 15);
        array.printAllElement("All element after adding ::", arr);
        System.out.println("--------------------------------------");

        //Search element from array.Array
        int index = array.search(arr, 7);
        System.out.println("Element found at index: " + index);
        System.out.println("--------------------------------------");

        //Delete element from array.Array
        array.printAllElement("All element before removing ::", arr);
        arr = array.deleteElement(arr, 1);
        array.printAllElement("All element after removing ::", arr);
    }

    public int search(int[] array, int value) {
        int loc = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                loc = i;
                break;
            }
        }
        return loc;
    }

    public int[] deleteElement(int[] array, int value) {
//        1,5,2,8,15,7,3

        int loc = search(array, value);
        if (loc >= 0) {
            for(int i = loc + 1; i< array.length; i++) {
                array[i-1] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length -1);
    }

    public void printAllElement(String msg, int[] arr) {
        System.out.print(msg);
        for (int j : arr) {
            System.out.print(" " + j);
        }
        System.out.println();
    }

    public int[] addElement(int[] array, int position, int value) {

        int[] result = new int[array.length + 1];
        for (int i = 0; i < position; i++) {
            result[i] = array[i];
        }
        result[position] = value;
        for (int i = position + 1; i < result.length; i++) {
            result[i] = array[i - 1];
        }
        return result;
    }
}