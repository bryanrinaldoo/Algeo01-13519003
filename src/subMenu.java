package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class subMenu  {
    public static void SPLInverse() throws FileNotFoundException {
        String[] subMenuList = {"Masukkan dengan File (.txt)", "Masukkan manual"};
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPILIHAN");
        for (int i = 0; i < subMenuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(subMenuList[i]);
        }
        System.out.print("Masukkan pilihan menu: ");
        int subMenu = scan.nextInt();
        int currentSubMenuSPL = subMenu;
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
        scan.close();
    }
    public static void Cramer() throws FileNotFoundException{
        String[] subMenuList = {"Masukkan dengan File (.txt)", "Masukkan manual"};
        Scanner plh = new Scanner(System.in);
        System.out.println("\nPILIHAN");
        for (int i = 0; i < subMenuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(subMenuList[i]);
        }
        System.out.print("Masukkan pilihan menu: ");

        int subMenuSPL = plh.nextInt();

        int currentSubMenuSPL = subMenuSPL;
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
        plh.close();

    }
    public static void Gauss() {
        
        String[] subMenuList = {"Masukkan dengan File (.txt)", "Masukkan manual"};
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPILIHAN");
        for (int i = 0; i < subMenuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(subMenuList[i]);
        }
        System.out.print("Masukkan pilihan menu: ");
        int subMenuSPL = scan.nextInt();

        int currentSubMenuSPL = subMenuSPL;
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                
                break;

            case 2:
            // isi sendiri
                // Scanner scanf = new Scanner(System.in);
                // System.out.println("Gaussian Elimination Algorithm Test\n");
                // /** Make an object of GaussianElimination class **/
                // System.out.println("Masukkan banyak baris: ");
                // int x = inputn.nextInt(); //masukan pengguna 
                // System.out.println("Masukkan banyak kolom: ");
                // int o = inputn.nextInt(); //masukan pengguna 
                // matriks ge = new matriks(x,o);
                
        
                // System.out.println("\nEnter number of variables");
                // int N = scan.nextInt();
        
                // double[] B = new double[N];
                // double[][] A = new double[N][N];
        
                // System.out.println("\nEnter "+ N +" equations coefficients ");
                // for (int i = 0; i < N; i++)
                //     for (int j = 0; j < N; j++)
                //         A[i][j] = scan.nextDouble();
        
                // System.out.println("\nEnter "+ N +" solutions");
                // for (int i = 0; i < N; i++)
                //     B[i] = scan.nextDouble();
        
                // ge.solve(A,B);
                // scan.close();
                break;
            default:
                break;
        }
       

    }
    public static void GaussJordan() {
        String[] subMenuList = {"Masukkan dengan File (.txt)", "Masukkan manual"};
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPILIHAN");
        for (int i = 0; i < subMenuList.length; i++) {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.println(subMenuList[i]);
        }
        System.out.print("Masukkan pilihan menu: ");
        int subMenuSPL = scan.nextInt();

        int currentSubMenuSPL = subMenuSPL;
        switch (currentSubMenuSPL) {
            case 1:
            // pake file
                
                break;

            case 2:
            // isi sendiri
                
            default:
                break;
        }
        scan.close();

    }


}
