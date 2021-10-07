package com.bearfamily.Random;

import java.util.Iterator;
import java.util.Random;

/* 随机数的学习
   打印5个不重复的随机数
 */

public class RandomTest {

    public static void main(String[] args) {

        Random r = new Random();
        int [] myInt = new int[5];
        for (int i=0;i<myInt.length;i++) {
            myInt[i] = -1;

        }

        int index = 0;
        while (index < myInt.length) {

            int re = r.nextInt(6);
            if (!(isExist(myInt,re))) {
                    myInt[index++] = re;
                }

            }


            //print the resulting numbers.
            for(int i1:myInt) {
                System.out.println(i1);
            }

        }


    /**
     *
     * @param container 数组
     * @param i 数组元素
     * @return 布尔值
     */
    public static boolean isExist( int [] container,int i) {

        for (int i1 : container) {

            if (i1 == i) {

                return true;
            }

        }

        return  false;
    }

}

