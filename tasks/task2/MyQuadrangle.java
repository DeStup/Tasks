import java.util.ArrayList;

public class MyQuadrangle {
    ArrayList<Double> listOfAnglesX = new ArrayList<>();
    ArrayList<Double> listOfAnglesY = new ArrayList<>();
    double maxX;
    double maxY;
    double minX;
    double minY;

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public ArrayList<Double> getListOfAnglesX() {
        return listOfAnglesX;
    }

    public ArrayList<Double> getListOfAnglesY() {
        return listOfAnglesY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public MyQuadrangle(ArrayList<Double> listOfAnglesX, ArrayList<Double> listOfAnglesY) {
        this.listOfAnglesX = listOfAnglesX;
        this.listOfAnglesY = listOfAnglesY;
    }

}
