package Ingeritance.multiple_inheritance_via_interface;

import Interfaces.InheritageInterfaces.Jump;

public class Duck implements Run, Fly {

    //Если два интерфейса с одинаковыми дефолтными методами
    //Java не может понять какой метод использовать и просит переопределить его

    @Override
    public void showInfo() {
        System.out.println("Я умею бегать и летать");
    }
}
