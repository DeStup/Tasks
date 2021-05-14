import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class task2 {
    public static void main(String[] args) {

        Path firstPath = Paths.get(args[0]);
        Path secondPath = Paths.get(args[1]);

        ArrayList<String> listOfPointsOfFigure = new ArrayList<>();
        ArrayList<String> listOfPoints = new ArrayList<>();

        ArrayList<Double> listOfAnglesX = new ArrayList<>();
        ArrayList<Double> listOfAnglesY = new ArrayList<>();

        ArrayList<Double> listOfPointsX = new ArrayList<>();
        ArrayList<Double> listOfPointsY = new ArrayList<>();


        try {
            File file = new File(String.valueOf(firstPath));
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                listOfPointsOfFigure.add(line);
                line = reader.readLine();
            }

            file = new File(String.valueOf(secondPath));
            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            line = reader.readLine();
            while (line != null) {
                listOfPoints.add(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        transferNumbers(listOfPointsOfFigure, listOfPoints, listOfAnglesX, listOfAnglesY, listOfPointsX, listOfPointsY);
        MyQuadrangle quadrangle = new MyQuadrangle(listOfAnglesX, listOfAnglesY);

        findMaxX(quadrangle);
        findMaxY(quadrangle);
        findMinX(quadrangle);
        findMinY(quadrangle);

        analise(quadrangle, listOfPointsX, listOfPointsY);

    }

    public static void transferNumbers(ArrayList<String> listOfPointsOfFigure, ArrayList<String> listOfPoints, ArrayList<Double> listOfAnglesX, ArrayList<Double> listOfAnglesY, ArrayList<Double> listOfPointsX, ArrayList<Double> listOfPointsY) {
        String array[];
        for (String s : listOfPointsOfFigure) {
            array = s.split(" ");
            listOfAnglesX.add(Double.parseDouble(array[0]));
            listOfAnglesY.add(Double.parseDouble(array[1]));
        }
        for (String s : listOfPoints) {
            array = s.split(" ");
            listOfPointsX.add(Double.parseDouble(array[0]));
            listOfPointsY.add(Double.parseDouble(array[1]));
        }
    }

    public static void findMaxX(MyQuadrangle quadrangle) {
        double max = 0;
        ArrayList<Double> list = quadrangle.getListOfAnglesX();
        for (Double aDouble : list) {
            if (max < aDouble) max = aDouble;
        }
        //System.out.println(max);
        quadrangle.setMaxX(max);
    }

    public static void findMaxY(MyQuadrangle quadrangle) {
        double max = 0;
        ArrayList<Double> list = quadrangle.getListOfAnglesY();
        for (Double aDouble : list) {
            if (max < aDouble) max = aDouble;
        }
        //System.out.println(max);
        quadrangle.setMaxY(max);
    }

    public static void findMinX(MyQuadrangle quadrangle) {
        double min = 0;
        ArrayList<Double> list = quadrangle.getListOfAnglesX();
        for (Double aDouble : list) {
            if (min > aDouble) min = aDouble;
        }
        //System.out.println(min);
        quadrangle.setMinX(min);
    }

    public static void findMinY(MyQuadrangle quadrangle) {
        double min = 0;
        ArrayList<Double> list = quadrangle.getListOfAnglesX();
        for (Double aDouble : list) {
            if (min > aDouble) min = aDouble;
        }
        //System.out.println(min);
        quadrangle.setMinY(min);
    }

    public static void analise(MyQuadrangle quadrangle, ArrayList<Double> listOfPointsX, ArrayList<Double> listOfPointsY) {
        int size;
        size = listOfPointsX.size();
        for (int i = 0; i < size; i++) {
            double n = listOfPointsX.get(i);
            double m = listOfPointsY.get(i);
            if (n < quadrangle.getMinX() || n > quadrangle.getMaxX() || m < quadrangle.getMinY() || m > quadrangle.getMaxX())
                System.out.println(3);
            else if (n == quadrangle.getMinX() && m == quadrangle.getMinY() || n == quadrangle.getMinX() && m == quadrangle.getMaxY() || n == quadrangle.getMaxX() && m == quadrangle.getMinY() || n == quadrangle.getMaxX() && m == quadrangle.getMaxY())
                System.out.println(0);
            else if (n == quadrangle.getMinX() && m < quadrangle.getMaxY() || n == quadrangle.getMinX() && m > quadrangle.getMinY() || n == quadrangle.getMaxX() && m < quadrangle.getMaxY() || n == quadrangle.getMaxX() && m > quadrangle.getMinY() || m == quadrangle.getMinY() && n < quadrangle.getMaxX() || m == quadrangle.getMinY() && n > quadrangle.getMinX() || m == quadrangle.getMaxY() && n < quadrangle.getMaxX() || m == quadrangle.getMaxY() && n > quadrangle.getMinX())
                System.out.println(1);
            else System.out.println(2);
        }
    }
}
