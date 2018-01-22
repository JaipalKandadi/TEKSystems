package com.tek.interview.question;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
*  There are many ways to remove duplicates from randomIntegers. One method is using the Collection API ( HashSet or LinkedHashSet )
*  and another one is without using the Collection API.First method is easy and gives better performance than the second method.
*  It is recommended to use the first method if you need to remove duplicates from an array.
*/

public class RemoveDuplicates {

    public static void main(String s[]) {
        int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3,
                20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19,
                13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};

        removeDuplicatesWithoutAPI(randomIntegers);
        removeDuplicatesWithAPI(randomIntegers);

    }

    // Removing duplicates without using the Collections API
    public static void removeDuplicatesWithoutAPI(int[] arrayWithDuplicates) {
        System.out.println("Array With Duplicates : ");

        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            System.out.print(arrayWithDuplicates[i] + "\t");
        }

        //Assuming all elements in input array are unique

        int noOfUniqueElements = arrayWithDuplicates.length;

        //Comparing each element with all other elements

        for (int i = 0; i < noOfUniqueElements; i++) {
            for (int j = i + 1; j < noOfUniqueElements; j++) {
                //If any two elements are found equal

                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
                    //Replace duplicate element with last unique element

                    arrayWithDuplicates[j] = arrayWithDuplicates[noOfUniqueElements - 1];

                    //Decrementing noOfUniqueElements

                    noOfUniqueElements--;

                    //Decrementing j

                    j--;
                }
            }
        }

        //Copying only unique elements of arrayWithDuplicates into arrayWithoutDuplicates

        int[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, noOfUniqueElements);

        //Printing arrayWithoutDuplicates

        System.out.println();

        System.out.println("Array Without Duplicates : ");

        for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
            System.out.print(arrayWithoutDuplicates[i] + "\t");
        }

        System.out.println();

    }


    // Removing duplicates using the Collections API
    public static void removeDuplicatesWithAPI(int[] arrayWithDuplicates) {
        System.out.println("Array With Duplicates : ");

        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            System.out.print(arrayWithDuplicates[i] + "\t");
        }

        Set<Integer> set = new LinkedHashSet<Integer>();      //Use HashSet if you don't want insertion order

        for (int i = 0; i < arrayWithDuplicates.length; i++) {
            set.add(arrayWithDuplicates[i]);
        }

        //Converting set into an array

        Object[] arrayWithoutDuplicates = set.toArray();

        //Printing arrayWithoutDuplicates

        System.out.println();

        System.out.println("Array Without Duplicates : ");

        for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
            System.out.print(arrayWithoutDuplicates[i] + "\t");
        }
        System.out.println();
    }

}
