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
				System.out.printf("%.9f\t", x[i][j]);
			System.out.println();
		}
	}

	public void mostrarD() {
		System.out.printf("O vetor D tem %d elementos\n", d.length);
		for (int i = 0; i < d.length; i++) {
			System.out.printf("%.9f\n", d[i]);
		}
	}

	public void mostrarW() {
		for (int i = 0; i < w.length; i++) {
			System.out.printf("w[%d] = %.9f\t", (i + 1), w[i]);
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

			// double valorIteracao = teta;// xteta
			System.out.printf("Iteração #%d\n", iteracoes);
			for (int i = 0; i < d.length; i++) {
				double valorIteracao = teta;// xteta

				for (int u = 0; u < w.length; u++) {
					valorIteracao += w[u] * x[i][u];// w[0]
					System.out.printf("X[%d] = %.9f\n", (u + 1), x[i][u]);
				}
				// passagem por valorIteracao += w[0] * x[i][0] + teta;
				System.out.printf("i_A[%d] = %.9f\n", (i + 1), valorIteracao);
				double funAtivacao = funcaoAtivacao(valorIteracao);
				System.out.printf("Função de ativação A[%d] = %.9f\n", (i + 1), funAtivacao);
				double nTaxa = d[i] - funAtivacao;
				double[] varW = new double[w.length];

				System.out.printf("Nova taxa = %.9f\n", nTaxa);

				for (int j = 0; j < w.length; j++) {
					varW[j] = nTaxa * x[i][j] * n;
					w[j] += varW[j];
					System.out.printf("varW[%d] = %.9f\n", (j + 1), varW[j]);
					System.out.printf("Novo w[%d] = %.9f\n", (j + 1), w[j]);
				}
				double deltaTeta = nTaxa * xTeta * n;
				System.out.printf("VarTeta = %.9f\n", deltaTeta);
				teta += deltaTeta;
				System.out.printf("Teta = %.9f\n\n", teta);

			}

		}

	}
}