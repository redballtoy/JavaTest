package NestedClasses.part_01;

import Enums.part_1.Color;

public class Dog {

    private Color color = Color.BLACK;

    //Можно в основном классе сразу создать экземпляр внутреннего класса
    public Dog() {
        //DogAttribute dogAttribute = new DogAttribute();
    }



    //Внутренний вложенный класс нужен для декомпозиции
    //когда есть сущность которая неразрывно связана с основным классом
    class DogAttribute {
        public String name;
        private int age;
        //внутренний и внешний класс похожи за исключением того что
        //внутренний класс не может иметь статических полей
        //public static String p; //error

        public DogAttribute(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        //попытка из внутреннего класса обратиться к приватному полю внешнего
        //возможно потому что у каждого внутреннего класса только одна оболочка внешний класс
        @Override
        public String toString() {
            return "DogAttribute{" +
                    "name='" + name + '\'' +
                    ", age=" + age + ", Dog color =" + color+
                    '}';
        }
    }
}
