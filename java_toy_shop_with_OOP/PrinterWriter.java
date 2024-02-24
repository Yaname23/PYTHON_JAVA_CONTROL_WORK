import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class PrinterWriter extends Toys{
    private static File path;
    private static ArrayListToy result;

    public static List<Toy> PrintWrite() {
        Queue<Toy> queue = new PriorityQueue<>(3, Comparator.comparingDouble(Toy::getWeigth));
        List<Toy> toys = result.GetArreyList();
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
        return toys;
    }
    }




