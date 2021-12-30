package model;

public class Rede {

    private Double[][] x;
    private Double d[];
    private Double w[];
    private Double n;
    private Double teta;
    private Double xTeta;

    public Rede() {
    }

    public Rede(Double[][] x, Double[] d, Double[] w, Double n, Double teta, Double xTeta) {
        this.x = x;
        this.d = d;
        this.w = w;
        this.n = n;
        this.teta = teta;
        this.xTeta = xTeta;
    }
   
    public Double[][] getX() {
        return x;
    }

    public void setX(Double[][] x) {
        this.x = x;
    }

    public Double[] getD() {
        return d;
    }

    public void setD(Double[] d) {
        this.d = d;
    }

    public Double[] getW() {
        return w;
    }

    public void setW(Double[] w) {
        this.w = w;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }

    public Double getTeta() {
        return teta;
    }

    public void setTeta(Double teta) {
        this.teta = teta;
    }

    public Double getxTeta() {
        return xTeta;
    }

    public void setxTeta(Double xTeta) {
        this.xTeta = xTeta;
    }

    public void mostrarX() {
        int linhas = x.length;
        int colunas = x[0].length;
        System.out.printf("A matriz X tem %d linhas e %d colunas\n", linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++)
                System.out.printf("%.4f\t", x[i][j]);
            System.out.println();
        }
    }

    public static double funcaoAtivacao(double x) {
        return 1 / (1 + Math.exp(-x)); 
    }
}