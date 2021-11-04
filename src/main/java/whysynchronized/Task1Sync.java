package whysynchronized;

public class Task1Sync implements Runnable {
    private Table table;

    public Task1Sync(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        // here we use the method with the synchronized keyword
        table.printTableSync(5);
    }
}
