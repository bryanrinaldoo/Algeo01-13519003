package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class subMenu {
    public static void Inverse() {
        int currentSubMenuSPL = subMenuSPL();
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                Scanner inputf = new Scanner(System.in).useLocale(Locale.US);//Create scanner
                System.out.println("masukkan nama file : ");
                String file = inputf.nextLine();
                matriks n = new matriks(file);
                n.tulismatriks();
                System.out.println("SPL dengan Metode Inverse : ");
                matriks splinv_f= n.splinverse(n);
                splinv_f.tulismatriks();            
                inputf.close();
                break;

            case 2:
            // isi sendiri
                Scanner inputn= new Scanner(System.in); // buat scanner 
                System.out.println("Masukkan banyak baris: ");
                int x = inputn.nextInt(); //masukan pengguna 
                System.out.println("Masukkan banyak kolom: ");
                int o = inputn.nextInt(); //masukan pengguna 
                matriks m = new matriks(x,o);
                m.bacamatriks();
                m.tulismatriks();
                System.out.println("SPL dengan Metode Inverse : ");
                matriks splinv_i = m.splinverse(m);
                splinv_i.tulismatriks();
                inputn.close();
                break;
            default:
                break;
        }
    }
    public static void Cramer() {
        int currentSubMenuSPL = subMenuSPL();
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                Scanner inputf = new Scanner(System.in).useLocale(Locale.US);//Create scanner
                System.out.println("masukkan nama file : ");
                String file = inputf.nextLine();
                matriks n = new matriks(file);
                n.tulismatriks();
                System.out.println("SPL dengan Metode Cramer : ");
                matriks splcrm_f= n.splcrammer(n);
                splcrm_f.tulismatriks();            
                inputf.close();
                break;

            case 2:
            // isi sendiri
                Scanner inputn= new Scanner(System.in); // buat scanner 
                System.out.println("Masukkan banyak baris: ");
                int x = inputn.nextInt(); //masukan pengguna 
                System.out.println("Masukkan banyak kolom: ");
                int o = inputn.nextInt(); //masukan pengguna 
                matriks m = new matriks(x,o);
                m.bacamatriks();
                m.tulismatriks();
                System.out.println("SPL dengan Metode Cramer: ");
                matriks splcrm_i = m.splcrammer(m);
                splcrm_i.tulismatriks();
                inputn.close();
                break;
            default:
                break;
        }
    }
    public static void Gauss() {
        int currentSubMenuSPL = subMenuSPL();
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                
                break;

            case 2:
            // isi sendiri
                
            default:
                break;
        }
    }
    public static void GaussJordan() {
        int currentSubMenuSPL = subMenuSPL();
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                
                break;

            case 2:
            // isi sendiri
                
            default:
                break;
        }
    }


}
