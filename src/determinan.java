package src;
import java.util.Scanner;

public class determinan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // buat scanner 
        System.out.println("Masukkan banyak N untuk matriks (N x N):  ");
        int n = input.nextInt(); //masukan pengguna 
        matriks m = new matriks(n,n);
        m.bacamatriks();
        m.tulismatriks();
        System.out.println("Determinan dari matriks di atas adalah : "+ m.determinan(m));
        input.close();
    }
    
}
