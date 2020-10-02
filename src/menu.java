package src;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class menu {
    
    public static void SPL() throws FileNotFoundException {
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
        

        switch (currentSubMenu) {
            case 1:
                subMenu.Gauss(); // TODO: Implement this procedure
                break;

            case 2:
                subMenu.GaussJordan(); // TODO: Implement this procedure
                break;

            case 3:
                subMenu.SPLInverse(); // TODO: Implement this procedure
                break;

            case 4:
                subMenu.Cramer(); // TODO: Implement this procedure
                break;
        
            default:
                break;
        }
        scan.close();
    }

    public static void Determinan() throws FileNotFoundException{
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
        int currentSubMenu = subMenu;

        switch (currentSubMenu) {
            case 1:
            // pake file
                Scanner inputf = new Scanner(System.in).useLocale(Locale.US);//Create scanner
                System.out.println("masukkan nama file : ");
                String file = inputf.nextLine();
                matriks n = new matriks(file);
                n.tulismatriks();
                System.out.println("Determinan dari matriks di atas adalah : "+ n.determinan(n));
                inputf.close();
                break;

            case 2:
            // isi sendiri
                Scanner inputn= new Scanner(System.in); // buat scanner 
                System.out.println("Masukkan banyak N untuk matriks (N x N):  ");
                int x = inputn.nextInt(); //masukan pengguna 
                matriks m = new matriks(x,x);
                m.bacamatriks();
                m.tulismatriks();
                System.out.println("Determinan dari matriks di atas adalah : "+ m.determinan(m));
                inputn.close();
                break;
                
            default:
                break;
        }
        scan.close();
    }

    public static void Inverse() throws FileNotFoundException {
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
        int currentSubMenu = subMenu;

        switch (currentSubMenu) {
            case 1:
            // pake file
                Scanner inputf = new Scanner(System.in).useLocale(Locale.US);//Create scanner
                System.out.println("masukkan nama file : ");
                String file = inputf.nextLine();
                matriks n = new matriks(file);
                n.tulismatriks();
                System.out.println("Matriks balikan dari matriks di atas adalah : ");
                matriks inv_f = n.inverse(n);
                inv_f.tulismatriks();                
                inputf.close();
                break;

            case 2:
            // isi sendiri
                Scanner inputn= new Scanner(System.in); // buat scanner 
                System.out.println("Masukkan banyak N untuk matriks (N x N):  ");
                int x = inputn.nextInt(); //masukan pengguna 
                matriks m = new matriks(x,x);
                m.bacamatriks();
                m.tulismatriks();
                System.out.println("Matriks balikan dari matriks di atas adalah : ");
                matriks inv_i = m.inverse(m);
                inv_i.tulismatriks();
                inputn.close();
                break;
            default:
                break;
        }
        scan.close();

    }

    public static void Interpolasi() {
        // TODO: Implement this procedure
        
           Scanner input = new Scanner(System.in);
           
           int n; 
           int i, j; 
           
           double [] arrayx = new double[200]; //Array limit 199
           double [] arrayy = new double[200]; //Array limit 199
           //The arbitrary value, x to be entered for
           //which the value of y can be known
           double x = 0; 
           double y = 0; 
           double kecil;
           double besar;  
   
           //meminta masukan pengguna
            System.out.print("Masukkan banyak N : "); 
            n = input.nextInt(); 
    
           
            for(i = 0; i<n; i++) { 
                System.out.print("Masukkan x" + i + ": ");
                arrayx[i] = input.nextDouble(); 
            }
            for(i = 0; i<n; i++) {
                System.out.print("Masukkan y" + i + ": ");
                arrayy[i] = input.nextDouble();
            }
            //Masukkan x yang mau dimasukkan kedalam fungsi
            System.out.print("Masukkan X : ");
            x = input.nextDouble(); 
            
            for(i = 0; i<n; i++)
            {
                kecil = 1; besar = 1;
                for(j = 0; j<n; j++)
                {
                    if (j != i)
                    {
                      kecil = kecil * (x - arrayx[j]);
                      besar = besar * (arrayx[i] - arrayx[j]);
                    }  
                }
                y = y + (kecil/besar) * arrayy[i];
            }
            System.out.println("Saat x = " + x + "maka" + " y = " +  y);
            input.close();
        }
    

    public static void Regresi() {
        int k, n;
        double[] x, xk, solution;
        double y, yk;
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

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
            if (i != 0) {
                System.out.print("X");
                System.out.print(i);
            }
        }

        System.out.println("\nHasil taksirannya adalah:");
        System.out.println(yk);
    }

    public static void Exit() {
        System.exit(0);
    }

    
}
