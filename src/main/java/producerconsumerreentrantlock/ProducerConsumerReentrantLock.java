package producerconsumerreentrantlock;

public class ProducerConsumerReentrantLock {
    public static void main(String[] args) {
        MessageServiceReentrantLock messageServiceReentrantLock = new MessageServiceReentrantLock();
        ProducerReentrantLock task1 = new ProducerReentrantLock(messageServiceReentrantLock);
        ConsumerReentrantLock task2 = new ConsumerReentrantLock(messageServiceReentrantLock);
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
