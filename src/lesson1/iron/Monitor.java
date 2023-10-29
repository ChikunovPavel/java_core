package lesson1.iron;

public class Monitor {
    private int diagonal;
    private String matrix;

    public Monitor(int diagonal, String matrix) {
        this.diagonal = diagonal;
        this.matrix = matrix;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public String getMatrix() {
        return matrix;
    }

    public void runMonitor(){
        System.out.println("Монитор запушен");
    }

    @Override
    public String toString() {
        return "Monitor{"
                + "Diagonal: " +  diagonal+"," +" "
                + "Matrix: " + matrix + "}";
    }

}
