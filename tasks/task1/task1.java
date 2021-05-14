import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        ArrayList<Double> listOfTaskOne = new ArrayList<Double>();
        Path path = Paths.get(args[0]);
        // read file
        try {
            File file = new File(String.valueOf(path));
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                listOfTaskOne.add(Double.valueOf(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sort manipulation with values in list
        Collections.sort(listOfTaskOne);
        System.out.printf("%.2f%n", percentile(listOfTaskOne, 90));
        System.out.printf("%.2f%n", medianOfList(listOfTaskOne));
        System.out.printf("%.2f%n", maxOfList(listOfTaskOne));
        System.out.printf("%.2f%n", minOfList(listOfTaskOne));
        System.out.printf("%.2f%n", meanOfList(listOfTaskOne));
    }
    
    public static double percentile(List<Double> valuesOfList, double percentile) {
        double sum = sumOfList(valuesOfList);
        //System.out.println(sumOfValues);
        int index = (int) Math.ceil(percentile / 100.0 * valuesOfList.size());
        return valuesOfList.get(index - 1);
    }

    public static double minOfList(List<Double> valuesOfList) {
        return valuesOfList.get(0);
    }

    public static double maxOfList(List<Double> valuesOfList) {
        return valuesOfList.get(valuesOfList.size() - 1);
    }

    public static double meanOfList(List<Double> valuesOfList) {
        return sumOfList(valuesOfList) / valuesOfList.size();
    }

    public static double sumOfList(List<Double> valuesOfList) {
        double sumOfValues = 0;
        for (Double aDouble : valuesOfList) {
            sumOfValues += aDouble;
        }
        return sumOfValues;
    }

    public static double medianOfList(List<Double> valuesOfList) {
        double median = 0;
        int size = valuesOfList.size();
        boolean even = false;

        //checking parity of size
        double checkEven = size % 2;

        if (checkEven == 0) {
            even = true;
        }

        if (even) {
            int firstMedian = size / 2;
            int secondMedian = firstMedian - 1;
            median = (valuesOfList.get(firstMedian) + valuesOfList.get(secondMedian)) / 2;
        } else {
            median = valuesOfList.get(size / 2);
        }

        return median;
    }
}
