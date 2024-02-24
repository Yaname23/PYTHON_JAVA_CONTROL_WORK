import java.util.ArrayList;
import java.util.List;

public class ArrayListToy {

    private double[] weights = new double[3];
    private int[] ids = new int[3];
    private String[] names = new String[3];

    public List<Toy> GetArreyList() {
        List<Toy> toys = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Toy toy = toys.get(i);
            ids[i] = toy.getId();
            names[i] = toy.getNames();
            weights[i] = toy.getWeigth();
        }
        return toys;
    }
}


