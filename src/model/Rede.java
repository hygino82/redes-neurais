package model;

public class Rede {

    private Double x[][];
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

    public void mostrarD() {
        System.out.printf("O vetor D tem %d elementos\n", d.length);
        for (int i = 0; i < d.length; i++) {
            System.out.printf("%.4f\n", d[i]);
        }
    }

    public void mostrarW() {
        for (int i = 0; i < w.length; i++) {
            System.out.printf("w[%d] = %.4f\t", (i + 1), w[i]);
        }
        System.out.println();
    }

    public static double funcaoAtivacao(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public void resolver(int numeroIteracoes) {
        int iteracoes = 0;

        while (iteracoes < numeroIteracoes) {
            iteracoes++;
            double valorIteracao = 0.0;
            System.out.printf("Iteração #%d\n", iteracoes);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < w.length; j++) {
                    valorIteracao += w[j] * x[i][j];
                }
                valorIteracao +=  teta;//+xteta
                System.out.printf("i_A[%d] = %.4f\n", (i + 1), valorIteracao);
                double funAtivacao = funcaoAtivacao(valorIteracao);
                System.out.printf("Função de ativação A[%d] = %.4f\n", (i + 1), funAtivacao);
                double nTaxa = d[i] - funAtivacao;
                System.out.printf("Nova taxa = %.4f\n", nTaxa);

                double[] varW = new double[w.length];

                for (int j = 0; j < w.length; j++) {
                    // System.out.printf("Anterior w[%d] = %.4f\n", (j + 1), w[j]);

                    varW[j] = n * d[j] * nTaxa;

                    System.out.printf("varW[%d] = %.4f\n", (j + 1), varW[j]);
                    w[j] += varW[j];
                    System.out.printf("Novo w[%d] = %.4f\n", (j + 1), w[j]);
                }
                double varTeta = n * xTeta * nTaxa;
                teta += varTeta;
                System.out.printf("Teta = %f\n", teta);
            }

        }

    }
}