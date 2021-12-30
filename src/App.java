import java.util.Locale;

import model.Rede;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);

        System.out.println("Redes Neurais Artificiais pelo método Back Propagation");

        Double[][] A = { { 1.0, 1.0 }, { 2.0, 2.0 }, { 1.0, 3.0 }, { 2.5, 1.0 }, { 3.0, 3.0 } };
        Double[] D = { 1.0, 1.0, 1.0, 0.0, 0.0 };
        Double[] W = { 0.0, 0.0 };
        Double n = 0.6;
        Double teta = 0.0, xTeta = 1.0;

        Rede rede = new Rede(A, D, W, n, teta, xTeta);

        // rede.mostrarX();
        // linha();
        // rede.mostrarD();
        // linha();
        rede.mostrarW();
        System.out.printf("Teta = %.4f\txTeta = %.4f\n", teta, xTeta);
        linha();
        rede.resolver(1);
    }

    public static void linha() {
        System.out.println("--------------------------------------------\n");
    }
}
