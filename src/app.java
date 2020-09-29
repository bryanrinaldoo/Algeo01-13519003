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
                menu.SPL();
                break;
            
            case 2:
                menu.Determinan();
                break;

            case 3:
                menu.Inverse();
                break;

            case 4:
                menu.Interpolasi();
                break;

            case 5:
                menu.Regresi();
                break;

            case 6:
                menu.Exit();
                break;
        
            default:
                System.out.println("Menu yang dimasukkan tidak valid.");
                break;
        }

        scan.close();
    }
}
