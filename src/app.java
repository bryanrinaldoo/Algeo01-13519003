package src;

import java.util.Scanner;

public class app {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int currentMenu;
        
        String[] menuList = {"Sistem Persamaan Linear", "Determinan", "Matriks Balikan", "Interpolasi Polinom", "Regresi Linear Berganda", "Keluar"};

        System.out.println("\nMENU");
        for (int i = 0; i < menuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(menuList[i]);
        }

        System.out.print("Masukkan pilihan menu: ");
        currentMenu = scan.nextInt();

        switch (currentMenu) {
            case 1:
                menu.SPL(); // TODO: Implement this procedure
                break;
            
            case 2:
                menu.Determinan(); // TODO: Implement this procedure
                break;

            case 3:
                menu.Inverse(); // TODO: Implement this procedure
                break;

            case 4:
                menu.Interpolasi(); // TODO: Implement this procedure
                break;

            case 5:
                menu.Regresi(); // TODO: Implement this procedure
                break;

            case 6:
                menu.Exit(); // TODO: Implement this procedure
                break;
        
            default:
                System.out.println("Menu yang dimasukkan tidak valid.");
                break;
        }

        scan.close();
    }
}
