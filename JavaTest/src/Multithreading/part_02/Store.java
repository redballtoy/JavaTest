package Multithreading.part_02;

//Задача сделать логику покупки товаров из магазина такой, что бы
//покупатель ожидал пока продавец добавит товаров на склад так что бы их
//остаток на складе был положительным.
//Для этого необходимо организовать логику потоков так что второй ожидает пока
//первый что то сделает(например добавит товар на склад)
class MainShop {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Customer customer = new Customer(store);

        new Thread(customer).start();
        new Thread(producer).start();


    }

}



//покупатель покупает товар, продавец добавляет товар
//возможна ситуация что товара слишком мало и его не сможет купить покупатель
//либо слишком много и часто будет добаляться товар
public class Store {
    private int product = 0;

    //получить и купить продукт покупателем
    public synchronized void get() {
        //Для этого необходимо организовать логику потоков так что второй ожидает пока
        //первый что то сделает(например добавит товар на склад)
        //Если товара слишком мало сиди и жди
        if (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        product--;
        System.out.println("\nПокупатель купил 1 единицу товара");
        System.out.println("Товаров на складе: " + product);
        //Оповестить продавца что не складе нет товара
        notify();
    }

    //Продавец добавляет товар на склад
    public synchronized void set() {
        //Склад не затовариваем, пока товара меньше 3 ждем пока раскупят тот что есть
        if (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        product++;
        System.out.println("\nПродавец добавил 1 единицу товара на склад");
        System.out.println("Товаров на складе: " + product);
        //Поскольку товара достаточно можно позвать покупателей
        notify();
    }
}

class Producer implements Runnable {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            store.set();
        }
    }
}
class Customer implements Runnable {
    Store store;

    public Customer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            store.get();
        }
    }
}

