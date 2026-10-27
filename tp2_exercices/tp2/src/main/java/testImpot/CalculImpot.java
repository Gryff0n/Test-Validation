package testImpot;

public class CalculImpot {

    public static Double calculerImpot(Double revenu) {
        double revenuAct = revenu;
        if(revenu<0) throw new IllegalArgumentException("negative money");
        double totImpot = revenuAct * 0.1;
        if(revenu>20000) {
            revenuAct-=20000;
            totImpot+=revenuAct*0.2;
        }
        if(revenu>100000) {
            revenuAct-=80000;
            totImpot+=revenuAct*0.3;
        }
        return totImpot;
    }
}
