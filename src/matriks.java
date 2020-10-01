package src;

import java.util.Locale;
import java.util.Scanner;

public class matriks {
    public int m_brs;
    public int n_kol;
    public double [][] mat;

    public static void main(String[] args) {
        // System.out.println("Masukkan banyak baris: ");
        // int m = input.nextInt(); //masukan pengguna 
        
        Scanner input = new Scanner(System.in).useLocale(Locale.US);//Create scanner
        System.out.println("Masukkan banyak baris: ");
        int n = input.nextInt(); //masukan pengguna 
        System.out.println("Masukkan banyak kolom: ");
        int o = input.nextInt(); //masukan pengguna 
        matriks m = new matriks(n,o);
        m.bacamatriks();
        m.tulismatriks();
        System.out.println();
        System.out.println("Determinan : "+ m.determinan(m));
        matriks m2 = m.kofaktor(m);
        System.out.println("kofaktor");
        m2.tulismatriks();
        System.out.println("invers");
        matriks m3 = m.inverse(m);
        m3.tulismatriks();
        input.close();
    }
    
    /* Konstruktor matriks kosong m x n dengan seluruh elemen bernilai 0 */
    public matriks(int m, int n) {
        this.m_brs = m;
        this.n_kol = n;
        this.mat = new double[m][n];

        /* Menginisialisai elemen matriks dengan 0 */
        for(int i = 0; i< this.m_brs;i++){
            for(int j = 0; j < this.n_kol; j++){
                this.mat[i][j] = 0;
            }
        }
    }

    /* Konstruktor matriks dengan membaca elemen dan ukuran dari keyboard */
    public matriks bacamatriks() {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);//Create scanner
    
        matriks matriks= new matriks(this.m_brs, this.n_kol);
        
        System.out.println("Masukkan Matriks: ");
        
        for(int i = 0; i < this.m_brs; i++){
            for(int j = 0; j < this.n_kol; j++ ){
                this.mat[i][j] = input.nextDouble();
            }
        }

        input.close();
        return(matriks);
    }

    /* Menampilkan elemen matrik ke layar */
    void tulismatriks() {
        for(int i = 0; i < this.m_brs; i++){
            for(int j = 0; j < this.n_kol; j++){
                System.out.print(this.mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    /* Mencari determinan */
    public double determinan(matriks M) {
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
        if (this.m_brs==2 && this.n_kol==2) {
            hasil = ((this.mat[0][0] * this.mat[1][1]) - (this.mat[0][1] * this.mat[1][0]));
			return (hasil);
        }
        // determinan matriks nxn
        
        for (int i=0;i<this.m_brs;i++) {
            matriks mkecil = new matriks(this.m_brs - 1,this.n_kol - 1);
            for(int j=1 ; j<m_brs ; j++) {
                for (int k=0; k < m_brs ;k++) {
                    if (k<i){
                        mkecil.mat[j-1][k]= this.mat[j][k];
                    }
                    else if (k>i){
                        mkecil.mat[j-1][k-1]= this.mat[j][k];
                    }
                }
            }

            if (i%2==1) {
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

    // perkalian matriks 
    public matriks kali_x (matriks M , Double x){
        matriks x_kali = new matriks(this.m_brs,this.n_kol);
        for (int i=0;i<this.m_brs;i++){
            for(int j=0 ; j< this.n_kol; j++){
                x_kali.mat [i][j] = x * this.mat[i][j];
            }
        }
        return (x_kali);
    }

    //inverse 
    public matriks inverse (matriks M){
        matriks inverse = new matriks (this.m_brs, this.m_brs);
        if (this.m_brs==2){
            inverse.mat[0][0]= this.mat[1][1];
            inverse.mat[0][1]= -1 * this.mat[0][1];
            inverse.mat[1][0]= -1 * this.mat[1][0];
            inverse.mat[1][1]= this.mat[0][0];
            inverse = inverse.kali_x(inverse, 1/M.determinan(M));
            return (inverse);
        }
        else{
            inverse = M.kofaktor(M);
            inverse = inverse.transpose(inverse);
            inverse = inverse.kali_x(inverse, 1/M.determinan(M));
            return (inverse);
        }
    }
    
    /* Melakukan pertukaran dua buah baris */
    /* I.S. matriks M terdefinisi sembarang, m_brs >= 2 */
    /* F.S. Baris row1 dan baris row2 bertukartempat */
    private void swapRow(int row1, int row2) {
        double[] temp = this.mat[row1];
        this.mat[row1] = this.mat[row2];
        this.mat[row2] = temp;
    }

    /* Mengalikan setiap elemen pada baris row dengan K, K non-nol */
    /* I.S. matriks M terdefinisi sembarang */
    /* F.S. Setiap elemen M[i][j] = M[i][j] x K */
    private void multiplyRowK(int row, double K) {
        for (int j = 0; j < this.n_kol; j++) {
            this.mat[row][j] *= K;
        }
    }

    /* Mengalikan setiap elemen pada kolom column dengan K, K non-nol */
    /* I.S. matriks M terdefinisi sembarang */
    /* F.S. Setiap elemen M[i][column] = M[i][column] x K */
    private void multiplyColumnK(int column, double K) {
        for (int i = 0; i < this.m_brs; i++) {
            this.mat[i][column] *= K;
        }
    }

    /* Melakukan operasi pada baris matriks dalam bentuk rowTarget = rowTarget + (K * rowAdd) */
    /* I.S. matriks M terdefinisi sembarang, m_brs >= 2 */
    /* F.S. Setiap elemen pada baris berindeks rowTarget = M[rowTarget][j] + K x M[rowAdd][j] */
    private void addRowWithRow(int rowTarget, int rowAdd, double K) {
        for (int j = 0; j < this.n_kol; j++) {
            this.mat[rowTarget][j] += K * this.mat[rowAdd][j];
        }
    }

    /* Mengirimkan indeks baris pertama yang terdapat elemen non-nol, jika tidak terdapat
       elemen non-nol mengembalikan nilai -1 */
    private int searchNonZeroKol(int kol) {
        for (int i = 0; i < this.m_brs; i++) {
            if (this.mat[i][kol] != 0) {
                return i;
            }
        }

        return -1;
    }

    /* Mengirimkan indeks kolom pertama yang terdapat elemen non-nol, jika tidak terdapat
       elemen non-nol mengembalikan nilai -1 */
       private int searchNonZeroRow(int row) {
        for (int j = 0; j < this.n_kol; j++) {
            if (this.mat[j][row] != 0) {
                return j;
            }
        }

        return -1;
    }
    
    /* Prosedur untuk mengonversi matriks menjadi bentuk eselon baris */
    /* I.S. matriks M terdefinisi sembarang */
    /* F.S. matriks M dalam bentuk eselon baris, yaitu setiap baris diawali nilai 1
            dan di bawah nilai 1 itu semuanya diisi oleh 0 */
    public void convertToMEB() {
        for (int j = 0; j < this.n_kol; j++) {
            if (searchNonZeroKol(j) == -1) {
                continue;
            }

            int row = 0;

            if (row + j < this.m_brs) {
                if (this.mat[row + j][j] == 0) {
                    swapRow(row + j, searchNonZeroKol(j));
                }
    
                multiplyRowK(row + j, 1/this.mat[row + j][j]);
    
                if (row + j + 1 < this.m_brs) {
                    for (int i = row + j + 1; i < this.m_brs; i++) {
                        addRowWithRow(i, row + j, -1 * this.mat[i][j] / this.mat[row + j][j]);
                    }   
                }
            }
        }
    }

    /* Mengembalikan array yang berisi solusi dari suatu matriks eselon baris
       dengan menggunakan metode substitusi mundur */
    public double[] backwardSubs() {
        // TODO: Need to complete method for infinity solutions condition
        double[] solution = new double[this.n_kol - 1];

        if (searchNonZeroRow(this.m_brs - 1) == (this.n_kol - 1)) {
            solution[0] = -1;
            return solution;
        } else if (searchNonZeroRow(this.m_brs - 1) == -1) {
            return solution;
        } else {
            for (int i = this.m_brs - 1; i > -1; i--) {
                solution[i] = this.mat[i][this.n_kol-1];
                for (int j = i + 1; j < this.m_brs; j++) {
                    solution[i] -= this.mat[i][j] * solution[j];
                }
                solution[i] /= this.mat[i][i];
            }

            return solution;
        }
    }


    //end 
}
