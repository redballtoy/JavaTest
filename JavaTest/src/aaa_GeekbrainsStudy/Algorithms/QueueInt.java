package aaa_GeekbrainsStudy.Algorithms;

public class QueueInt {
    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public QueueInt(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;
        rear = -1;//маркер конца очереди
        items = 0;//количество элементов в очереди
    }

    /*
     * Про циклический перенос
     *   - используются метки начала и конца элементов в очереди
     *   - при вставке элементов сдвигаются не все компоненты, а только метка маркер, что
     *       позволяет ускорить вставку и не двигать все элементы
     *           - при добавлении элемента передвигается rear
     *           - при удалении элемента передвигается front
     * */

    public void insert(int i) {
        if (rear == maxSize - 1) {//если маркер достиг максимального значения
            rear = -1;//устанавливаем его на начало очереди
        } else {
            //когда значение очереди не конечное
            queue[++rear] = i;
            items++;//увеличиваем количество элементов
        }
    }

    public int remove() {
        int temp = queue[front++];
        if (front == maxSize) {
            front = 0;
        } else {
            items--;
        }
        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public int size() {
        return items;
    }

    public void print(){
        int i = items-1;
        while (i != 0) {
            System.out.println("items: "+i+"\tqueue[items]: " +queue[i]);
            i--;
        }
    }

}
