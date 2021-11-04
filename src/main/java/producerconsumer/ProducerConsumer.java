package producerconsumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        Producer task1 = new Producer(messageService);
        Consumer task2 = new Consumer(messageService);
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
