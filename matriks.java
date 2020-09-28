import java.util.Scanner;

public class matriks {
    private int m_brs;
    private int n_kol;
    private double [][] mat;

    public static void main(String[] args) {
        matriks m = new matriks();
        m.tulismatriks();
    }
    
    public matriks (int m, int n){
        this.m_brs = m;
        this.n_kol = n;
        this.mat = new double[m][n];
        for(int i = 0; i< this.m_brs;i++){
            for(int j = 0; j < this.n_kol; j++){
                this.mat[i][j] = 0;
            }
        }
    }
    public matriks(){
        Scanner input = new Scanner(System.in);//Create scanner
        
    
        System.out.println("Masukkan banyak baris: ");
        int m = input.nextInt(); //masukan pengguna 
        this.m_brs = m;
        System.out.println("Masukkan banyak kolom: ");
        int n = input.nextInt(); //masukan pengguna 
        this.n_kol = n;

        this.mat = new double[this.m_brs][this.n_kol];
        System.out.println("Masukkan dengan format : ");
        
        for(int i = 0; i< this.m_brs; i++){
            for(int j = 0; j < this.n_kol; j++){
                System.out.print("X ");
            }
            System.out.println();
        }

        System.out.println("Masukkan Matriks: ");
        
        for(int i = 0; i < this.m_brs; i++){
            for(int j = 0; j < this.n_kol; j++ ){
                this.mat[i][j] = input.nextInt();
            }
        }

        input.close();
    }
    void tulismatriks(){
        for(int i = 0; i < this.m_brs; i++){
            for(int j = 0; j < this.n_kol; j++){
                System.out.print(this.mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
