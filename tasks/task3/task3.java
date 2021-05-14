import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        ArrayList<Double> listOfCashOne = new ArrayList<>();
        ArrayList<Double> listOfCashTwo = new ArrayList<>();
        ArrayList<Double> listOfCashThree = new ArrayList<>();
        ArrayList<Double> listOfCashFour = new ArrayList<>();
        ArrayList<Double> listOfCashFive = new ArrayList<>();

        ArrayList<Double> listOfSumCashes = new ArrayList<>();

        Path path = Paths.get(args[0]);

        try {
            File fileCashOne = new File(path + "\\Cash1.txt");
            File fileCashTwo = new File(path + "\\Cash2.txt");
            File fileCashThree = new File(path + "\\Cash3.txt");
            File fileCashFour = new File(path + "\\Cash4.txt");
            File fileCashFive = new File(path + "\\Cash5.txt");

            FileReader fr = new FileReader(fileCashOne);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                listOfCashOne.add(Double.valueOf(line));
                line = reader.readLine();
            }

            fr = new FileReader(fileCashTwo);
            reader = new BufferedReader(fr);

            line = reader.readLine();
            while (line != null) {
                listOfCashTwo.add(Double.valueOf(line));
                line = reader.readLine();
            }

            fr = new FileReader(fileCashThree);
            reader = new BufferedReader(fr);

            line = reader.readLine();
            while (line != null) {
                listOfCashThree.add(Double.valueOf(line));
                line = reader.readLine();
            }

            fr = new FileReader(fileCashFour);
            reader = new BufferedReader(fr);

            line = reader.readLine();
            while (line != null) {
                listOfCashFour.add(Double.valueOf(line));
                line = reader.readLine();
            }

            fr = new FileReader(fileCashFive);
            reader = new BufferedReader(fr);

            line = reader.readLine();
            while (line != null) {
                listOfCashFive.add(Double.valueOf(line));
                line = reader.readLine();
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listOfCashOne.size(); i++) {
            listOfSumCashes.add(listOfCashOne.get(i) + listOfCashTwo.get(i) + listOfCashThree.get(i) + listOfCashFour.get(i) + listOfCashFive.get(i));
        }
        System.out.println(maxOfList(listOfSumCashes));
    }

    public static int maxOfList(List<Double> valuesOfList){
        int lastValue = valuesOfList.size()-1;
        double max = valuesOfList.get(lastValue);

        int indexOfMax = lastValue;

        for(int i = valuesOfList.size()-1; i>-1; i--){
            if (max <= valuesOfList.get(i)){
                max = valuesOfList.get(i);
                indexOfMax = i;
            }
        }
        return indexOfMax+1;
    }
}
