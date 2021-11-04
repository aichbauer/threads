package whysynchronized;

public class Task1 implements Runnable {
    private Table table;

    public Task1(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        // here we use the method WITHOUT the synchronized keyword
        table.printTable(5);
    }
}
