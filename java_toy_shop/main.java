import java.io.*;
import java.util.*;

public class main {
    private static File path;

    public static void main(String[] args) {
        class Toy {
            private int id;
            private String name;
            private double weigth;

            public Toy(int id, String name, double weight) {
                this.id = id;
                this.name = name;
                this.weigth = weight;
            }


            public int getId() {
                return id;
            }


            public double getWeigth() {

                return weigth;
            }


            public String getNames() {
                return name;
            }
        }

        List<Toy> toys = new ArrayList<>();
        double[] weights = new double[3];
        int[] ids = new int[3];
        String[] names = new String[3];

        toys.add(new Toy(1, "Конструктор", 2));
        toys.add(new Toy(2, "Робот", 2));
        toys.add(new Toy(3, "Кукла", 6));

        for (int i = 0; i < 3; i++) {
            Toy toy = toys.get(i);
            ids[i] = toy.getId();
            names[i] = toy.getNames();
            weights[i] = toy.getWeigth();


        }
        Queue<Toy> queue = new PriorityQueue<>(3, Comparator.comparingDouble(Toy::getWeigth));
        for (int i = 0; i < 3; i++) {
            queue.offer(toys.get(i));
        }
        try (PrintWriter writer = new PrintWriter(new File("res.txt"))) {
            for (int i = 0; i < 10; i++) {
                double random = Math.random();
                if (random <= 0.2) {
                    writer.write(queue.peek().getId() + " " + queue.peek().getNames() + "\n");
                } else if (random <= 0.6) {
                    Toy[] toy = queue.toArray(new Toy[0]);
                    writer.write(toy[2].getId() + " " + toy[2].getNames() + "\n");
                } else {
                    Toy[] toy = queue.toArray(new Toy[0]);
                    writer.write(toy[1].getId() + " " + toy[1].getNames() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());

        }
    }
}

