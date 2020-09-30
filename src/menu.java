package src;

import java.util.Scanner;

public class menu {
    
    public static void SPL() {
        int currentSubMenu = subMenu();

        switch (currentSubMenu) {
            case 1:
                subMenu.Gauss(); // TODO: Implement this procedure
                break;

            case 2:
                subMenu.GaussJordan(); // TODO: Implement this procedure
                break;

            case 3:
                subMenu.Inverse(); // TODO: Implement this procedure
                break;

            case 4:
                subMenu.Cramer(); // TODO: Implement this procedure
                break;
        
            default:
                break;
        }
    }

    public static void Determinan() {
        int currentSubMenu;
        currentSubMenu = subMenu();

        switch (currentSubMenu) {
            case 1:
                subMenu.Gauss(); // TODO: Implement this procedure
                break;

            case 2:
                subMenu.GaussJordan(); // TODO: Implement this procedure
                break;

            case 3:
                subMenu.Inverse(); // TODO: Implement this procedure
                break;

            case 4:
                subMenu.Cramer(); // TODO: Implement this procedure
                break;
        
            default:
                break;
        }
    }

    public static void Inverse() {
        int currentSubMenu;
        currentSubMenu = subMenu();

        switch (currentSubMenu) {
            case 1:
                subMenu.Gauss(); // TODO: Implement this procedure
                break;

            case 2:
                subMenu.GaussJordan(); // TODO: Implement this procedure
                break;

            case 3:
                subMenu.Inverse(); // TODO: Implement this procedure
                break;

            case 4:
                subMenu.Cramer(); // TODO: Implement this procedure
                break;
        
            default:
                break;
        }
    }

    public static void Interpolasi() {
        // TODO: Implement this procedure
    }

    public static void Regresi() {
        int k, n;
        double[] x, xk, solution;
        double y, yk;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nMasukkan jumlah variabel: ");
        k = scan.nextInt();

        System.out.print("Masukkan jumlah data: ");
        n = scan.nextInt();

        System.out.println();

        x = new double[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Masukkan nilai X");
            System.out.print(i+1);
            System.out.print("i: ");
            x[i] = scan.nextDouble();
        }

        System.out.print("\nMasukkan nilai Yi: ");
        y = scan.nextDouble();

        System.out.println();

        xk = new double[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Masukkan nilai X");
            System.out.print(i+1);
            System.out.print("k yang akan ditaksir: ");
            xk[i] = scan.nextDouble();
        }

        scan.close();

        MVLR regression = new MVLR(k, n, x, y, xk);
        solution = regression.resolve();
        yk = regression.predict();

        System.out.println("\nPersamaan regresi yang terbentuk:");
        System.out.print("Y");
        System.out.print(" = ");
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] >= 0 || i != 0) {
                System.out.print(" + ");
            }
            System.out.print(solution[i]);
            System.out.print("X");
            System.out.print(i+1);
        }

        System.out.println("\nHasil taksirannya adalah:");
        System.out.println(yk);
    }

    public static void Exit() {
        System.exit(0);
    }

    private static int subMenu() {
        String[] subMenuList = {"Metode Eliminasi Gauss", "Metode Eliminasi Gauss-Jordan", "Metode Matriks Balikan", "Metode Cramer"};
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nSUB-MENU");
        for (int i = 0; i < subMenuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(subMenuList[i]);
        }

        System.out.print("Masukkan pilihan sub-menu: ");
        int currentSubMenu = scan.nextInt();
        scan.close();

        return currentSubMenu;
    }
}
