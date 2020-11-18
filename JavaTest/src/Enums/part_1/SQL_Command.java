package Enums.part_1;

//Использование перечислений как абстрактные команды
public enum SQL_Command {
    //1.создаем объекты перечислений
    //2. реализуем абстрактный метод
    SELECT {
        @Override
        public void action() {
            System.out.println("SELECT");
        }
    },
    UPDATE {
        @Override
        public void action() {
            System.out.println("UPDATE");
        }
    };

    //2 создаем абстракный метод который должен реализовать каждый объект перечислений
    public abstract void action();
}
