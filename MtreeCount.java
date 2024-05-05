/**
 Clase que cuenta los accesos.
 */
public class MtreeCount {

    //Cuenta.
    private int count;

    //Constructor.
    public MtreeCount(){
        this.count = 0; 
    }

    //Getter.
    public int getCount(){
        return count;
    }

    //Suma.
    public void addCount(){
        count ++;
    }
}
