public record Assistant(Bag bag) implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (Thread.currentThread().getName().equals("Woolf")) {
                    bag.putToys(4);
                    Thread.sleep(2000);
                }
                if (Thread.currentThread().getName().equals("Rabbit")) {
                    bag.putToys(2);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}