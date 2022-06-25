import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int amountOfChildren = (int) (random() * (30 - 10 + 1) + 10); //10-30
        Bag bag = new Bag((int) (random() * (30 - 15 + 1) + 15), (int) (random() * (4 - 3 + 1) + 3)); // 15-30, 3-4

        Thread woolf = new Thread(new Assistant(bag), "Woolf");
        Thread rabbit = new Thread(new Assistant(bag), "Rabbit");

        rabbit.start();
        woolf.start();

        for (int i = 0; i < amountOfChildren; i++) {
            if (bag.getAmountOfToys() > 0) {
                Thread.sleep(500);
                bag.decrementToys();
                System.out.println("The child took his toy.");
            } else {
                new RuntimeException("The child was left without a toy.");
            }
        }

        woolf.interrupt();
        rabbit.interrupt();
    }
}