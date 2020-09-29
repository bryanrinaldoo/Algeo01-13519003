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
        // TODO: Implement this procedure
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
