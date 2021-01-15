package modul2;
import Entity.*;
import Model.*;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
public class SistemPelayananKtp {
private static AdminModel adminModel = new AdminModel();
private static PendudukModel pendudukmodel = new PendudukModel();
static public ArrayList <PendudukEntity> dataPenduduk = new ArrayList();
static int cekAdmin;
static int cekPenduduk;
static Scanner input = new Scanner (System.in);

    public static void main(String[] args) {
            System.out.println("Selamat Datang Di Pusat Layanan Publik Kota");
            System.out.println("-------------------------------------------");
    int pilihan;
    do{
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("pilih = ");
        pilihan = input.nextInt();
            System.out.println("-------------------------------------------");
        switch(pilihan){
            case 1 : if (pilihan == 1){
                     int pilihLogin ;
                System.out.print("1. Login Admin" + "\n2. Login Penduduk" + "\npilih :");
                pilihLogin = input.nextInt();
                if(pilihLogin == 1){
                    LoginAdmin();
                }else{
                    LoginPenduduk();
                }
                }
                break;
        }
            System.out.println("-------------------------------------------");
    }while(pilihan!=2);
    }
    static void registrasi()
    {
    System.out.print("masukan nama = ");
    String namapen = input.next();
    System.out.print("masukan pass = ");
    String passpen = input.next();
    System.out.print("masukan tempat lahir = ");
    String tempatlahir = input.next();
    System.out.print("masukan Tgl lahir(mm/dd/yyyy) = ");
    Date tglLahir = new Date (input.next());
    System.out.print("masukan kelamin(L/P) = ");
    String kelamin = input.next();
    System.out.print("masukan Agama = ");
    String agama = input.next();
    System.out.print("masukan Status = ");
    String status = input.next();
    System.out.print("masukan Pekerjaan = ");
    String pekerjaan = input.next();

    
    pendudukmodel.insertPenduduk( new PendudukEntity(namapen,passpen,tempatlahir,tglLahir,kelamin,agama,status,pekerjaan));    
    }
    static void dataAdmin()
    {
        String nama[] = {"riswanda"};
        String pass[] = {"12"};
        for(int i=0; i<nama.length;i++)
        {
            adminModel.insertAdmin(new AdminEntity(nama[i],pass[i]));
        }
    }
    static void update(){
    for(int i=0;i<dataPenduduk.size();i++)
        {
    System.out.print("masukan nama = ");
    String namapen = input.next();
    System.out.print("masukan pass = ");
    String passpen = input.next();
    System.out.print("masukan tempat lahir = ");
    String tempatlahir = input.next();
    System.out.print("masukan Tgl lahir(mm/dd/yyyy) = ");
    Date tglLahir = new Date (input.next());
    System.out.print("masukan kelamin(L/P) = ");
    String kelamin = input.next();
    System.out.print("masukan Agama = ");
    String agama = input.next();
    System.out.print("masukan Status = ");
    String status = input.next();
    System.out.print("masukan Pekerjaan = ");
    String pekerjaan = input.next();
    
    pendudukmodel.updatePenduduk(new PendudukEntity(namapen,passpen,tempatlahir,tglLahir,kelamin,agama,status,pekerjaan),i);    
        }
    }

    static void view()
    {
        for(int i=0;i<dataPenduduk.size();i++)
        {
            System.out.print("Nama              : "+dataPenduduk.get(i).getNamapen());
            System.out.print("Tempat tgl lahir  : "+dataPenduduk.get(i).getTempatlahir()+dataPenduduk.get(i).getTglLahir());
            System.out.print("Kelamin           : "+dataPenduduk.get(i).getKelamin());
            System.out.print("Agama             : "+dataPenduduk.get(i).getAgama());
            System.out.print("Status            : "+dataPenduduk.get(i).getStatus());
            System.out.print("Pekerjaan         : "+dataPenduduk.get(i).getPekerjaan());
        }
    }
    static void hapus(String namapen)
    {
        for(int i=0;i<dataPenduduk.size();i++)
        {
            if(namapen.equals(dataPenduduk.get(i).getNamapen()))
            {
                dataPenduduk.remove(i);
                System.out.println("Data Telah Dihapus");
            }
            else
            {
                System.out.println("Nama Tidak Ada");
            }
        }
    }

    static void LoginAdmin(){
        int pilih;
        System.out.print("Masukkan Nama Admin : ");
        String nama = input.next();
        System.out.print("Password Admin : ");
        String pass = input.next();
        cekAdmin = adminModel.cekData(nama,pass);
        do{ System.out.println("1. Input Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pilih = input.nextInt();
            System.out.println("                         ");
            switch(pilih){
                case 1 : registrasi();
                        break;
                case 2 : view();
                        break;
                case 3 : System.out.print("Inputkan Nama Penduduk : ");
                         String namapen =input.next();
                         hapus(namapen);
                        break;
                case 4 : 
                    System.out.print("Inputkan Nama Penduduk : ");
                    namapen = input.next();
                    update();
                    
                        break;
                    
            }
        }while(pilih!=5);  
    }
    static void LoginPenduduk()
    {
        int pilih;
        System.out.print("Nama : ");
        String namapen = input.next();
        System.out.print("Pass : ");
        String passpen = input.next();
        cekPenduduk = pendudukmodel.cekData(namapen,passpen);
        do
        {
            System.out.println("1. Cek Data Diri");
            System.out.println("2. Keluar");
            System.out.print("Pilih : ");
            pilih = input.nextInt();
            switch(pilih)
            {
                case 1 : view();
                break;
            }
        }while (pilih!=2);
    }
}
