public class Bag {
    int capacity;
    int amountOfToys;

    public Bag(int capacity, int amountOfToys) {
        this.capacity = capacity;
        this.amountOfToys = amountOfToys;
    }

    public synchronized boolean putToys (int amount) throws InterruptedException {
        if (amountOfToys > capacity - 6) {
            wait();
            return false;
        }
        if(amountOfToys + amount <= capacity) {
            amountOfToys += amount;
            System.out.println(Thread.currentThread().getName() +  " put " + amount + " toys into bag.");
            amountOfToys += amount;
            return true;
        }
        return false;
    }

    public synchronized void decrementToys() {
        amountOfToys--;
        if(amountOfToys < capacity - 6)
            notifyAll();
    }

    public int getAmountOfToys() {
        return amountOfToys;
    }
}
