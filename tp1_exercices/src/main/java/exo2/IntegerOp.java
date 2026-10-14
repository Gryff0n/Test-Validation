package exo2;

public class IntegerOp {
    private int e;
    public IntegerOp(int e){
        this.e = e;
    }
    public void twice(){
        e *= 2;
    }
    public void half(){
        e /= 2;
    }
    public int getE(){
        return e;
    }
}