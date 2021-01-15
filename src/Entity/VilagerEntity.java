package Entity;

public class VilagerEntity extends AbstractEntity {
 
    public VilagerEntity(String namapen,String passpen){
        super (namapen,passpen);
    }
    @Override
    public String getNama(){
        return nama;
    }
}

