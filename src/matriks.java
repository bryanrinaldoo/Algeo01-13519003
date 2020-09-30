package src;

import java.util.Scanner;

public class matriks {
    public int m_brs;
    public int n_kol;
    public double [][] mat;

    public static void main(String[] args) {
        matriks m = new matriks();
        m.tulismatriks();
        System.out.println("Determinan : "+ m.determinan(m));
        matriks m2 = m.kofaktor(m);
        System.out.println("kofaktor");
        m2.tulismatriks();
        System.out.println("sub matriks (1,1)");
        // matriks m3 = m.submat(m, 1, 1);
        // m3.tulismatriks();
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
    // mencari determinan 
    public double determinan (matriks M){

        double hasil =0;
        double plusmin;
        // cek apakah nxn 
        if (this.m_brs!=this.n_kol){
            System.out.println("Tidak bisa membuat determinan");
        }
        //determinan matriks 1 
        if (this.m_brs==1 && this.n_kol==1) {
            hasil = this.mat[0][0];
            return (hasil);
        }
        // determinan matriks 2x2
        if (this.m_brs==2 && this.n_kol==2){
            hasil = ((this.mat[0][0] * this.mat[1][1]) - (this.mat[0][1] * this.mat[1][0]));
			return (hasil);
        }
        // determinan matriks nxn
        
        for (int i=0;i<this.m_brs;i++){
            matriks mkecil = new matriks(this.m_brs - 1,this.n_kol - 1);
            for(int j=1 ; j<m_brs ; j++){
                for (int k=0; k < m_brs ;k++){
                    if (k<i){
                        mkecil.mat[j-1][k]= this.mat[j][k];
                    }
                    else if (k>i){
                        mkecil.mat[j-1][k-1]= this.mat[j][k];
                    }
                }
            }
            if (i%2==1){
                plusmin=-1;
            }
            else {
                plusmin=1;
            }
            
            hasil = hasil + ( plusmin * this.mat[0][i] * (mkecil.determinan(mkecil)) );   
        }
        return (hasil);
    }
    
    // transpose 
    public matriks transpose (matriks M){
        matriks trans = new matriks(this.m_brs, this.n_kol);
        for (int i=0; i<m_brs;i++){
            for (int j=0 ; j<n_kol; j++){
                trans.mat[i][j] = this.mat[j][i];
            }
        }
        return (trans);
    }
    // mencari submatriks 
    public matriks submat (matriks M, int row, int col){
        matriks submat = new matriks(this.m_brs - 1,this.n_kol - 1);
        int x = 0, y=0;
        for (int i =0 ; i<this.m_brs; i++){
            for (int j=0 ; j<this.n_kol; j++){
                if (i!=row && j!= col ){
                    submat.mat[x][y++] = this.mat[i][j]; // dimasukkin ke submat
                    if (y == this.m_brs-1){
                        y=0;
                        x++;
                        // y di reset lalu x ditambahkan 1
                    }
                }
            }
        }
        return (submat);
    }

    // kofaktor 
    public matriks kofaktor (matriks M){
        int plusmin;
        matriks kofak = new matriks(this.m_brs,this.n_kol);
        for (int i=0;i<this.m_brs;i++){
            for(int j=0 ; j< this.n_kol; j++){
                if (i%2==1){
                    if (j%2==1){
                        plusmin=1;
                    }
                    else{
                        plusmin =-1;
                    }
                }
                else {
                    if (j%2==1){
                        plusmin = -1;
                    }
                    else {
                        plusmin =1;
                    }
                }
                kofak.mat[i][j]= plusmin * submat(M, i, j).determinan(submat(M,i,j));
            }
            
        }
        return (kofak);
    }

    //inverse 
    public matriks inverse (matriks M){

    }
    


    //end 
}
