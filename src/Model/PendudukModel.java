package Model;
import Entity.*;
import java.util.ArrayList;
public class PendudukModel implements ModelInterfaces{
    private ArrayList<VilagerEntity>VilagerEntityArrayList;
    private ArrayList<PendudukEntity>PendudukEntityArrayList = new ArrayList<PendudukEntity>();
    
    public void insertPenduduk(PendudukEntity PendudukEntity){
        PendudukEntityArrayList.add(PendudukEntity);
    }
    public void updatePenduduk(PendudukEntity PendudukEntity,int i){
        PendudukEntityArrayList.set(i ,PendudukEntity);
    }
    
    @Override
    public void view(){
        for(PendudukEntity penduduk : PendudukEntityArrayList)
        {
            System.out.print(penduduk.getNamapen());
            System.out.print(penduduk.getPasspen());
            System.out.print(penduduk.getTempatlahir() + penduduk.getTglLahir());
            System.out.print(penduduk.getKelamin());
            System.out.print(penduduk.getAgama());
            System.out.print(penduduk.getStatus());
            System.out.print(penduduk.getPekerjaan());
        }
    }
    public int cekData(String namapen,String passpen){
        int loop = 0;
        while(!PendudukEntityArrayList.get(loop).getNamapen().equals(namapen) &&
              !PendudukEntityArrayList.get(loop).getPasspen().equals(passpen)){
            loop++;
        }
        return loop;
    }




}