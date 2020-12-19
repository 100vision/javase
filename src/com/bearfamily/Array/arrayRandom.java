package com.bearfamily.Array;

import java.util.Random;

/*
generate 10 random numbers and add it to array
 */

public class arrayRandom {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i=0;i<=arr.length-1;i++)
        {
            arr[i] = -1;
        }


        int index = 0;

        while (index <=arr.length-1)
        {
            Random random = new Random();
            int randomResult = random.nextInt(100);
            //add the random only if array doesn't contain the random.

            if(!isContain(arr,randomResult))
            {
                arr[index++] = randomResult;
            }

        }

        //print the resulting numbers

        for (int i=0;i<=arr.length-1;i++)
        {
            System.out.println(arr[i]);

        }

    }

    public static boolean isContain(int[] container, int feed)
    {
        for(int i=0;i<=container.length-1;i++)
        {
            if(container[i]==feed)
            {
                return true;
            }
        }

        return false;
    }
}






