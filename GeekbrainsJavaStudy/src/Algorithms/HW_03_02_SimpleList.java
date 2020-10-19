package Algorithms;

import java.util.ArrayList;
import java.util.List;

/*
 * Задание 3.2
 * На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или
 * элемента из списка.
 * Оценить выполненные методы с помощью базового класса System.nanoTime().
 */


public class HW_03_02_SimpleList {
    public static void main(String[] args) {

        List<ArObj> mArrayArObj = new ArrayList<>();
        mArrayArObj.add(new ArObj(1, 2));
        mArrayArObj.add(new ArObj(3, 2));
        mArrayArObj.add(new ArObj(5, 8));
        mArrayArObj.add(new ArObj(12, 18));

        mArrayArObj.remove(1);

        mArrayArObj.set(2, new ArObj(8, 5));
        System.out.println("getX = " + mArrayArObj.get(2).getX() + " " + "getY = " + mArrayArObj.get(2).getY());
        for (ArObj n : mArrayArObj) {
            n.print();
        }
    }


}

