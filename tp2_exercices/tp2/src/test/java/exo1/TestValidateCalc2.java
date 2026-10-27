package exo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
00,Y,Z,X
01,y>0,z<1,x=1
02,y=0,z=1,x=1
03,y<0,z>1,x=1
04,y<0,z=1,x=-1
05,y=0,z<1,x=-1
06,y>0,z>1,x=-1
07,y>0,z=1,-1<x<1
08,y=0,z>1,-1<x<1
09,y<0,z<1,-1<x<1
10,y<0,z<1,x>1
11,y=0,z>1,x>1
12,y>0,z=1,x>1
13,y>0,z=1,x<-1
14,y=0,z>1,x<-1
15,y<0,z<1,x<-1
*/


//testCalcImplX correspont a la ligne X du commentaire ci dessus
public class TestValidateCalc2 {

    @Test
    public void testCalcImpl1() {
        double resultat = CalculImpl2.Calculer(1,1,0);
        Assertions.assertTrue(Double.isNaN(resultat));
    }

    @Test
    public void testCalcImpl2() {
        double resultat = CalculImpl2.Calculer(1,0,1);
        Assertions.assertTrue(Double.isNaN(resultat));
    }

    @Test
    public void testCalcImpl3() {
        double resultat = CalculImpl2.Calculer(1,-1,2);
        Assertions.assertTrue(Double.isNaN(resultat));
    }

    @Test
    public void testCalcImpl4() {
        double resultat = CalculImpl2.Calculer(-1,-1,1);
        Assertions.assertTrue(Double.isNaN(resultat));
    }

    @Test
    public void testCalcImpl5() {
        double resultat = CalculImpl2.Calculer(-1,0,0);
        Assertions.assertTrue(Double.isNaN(resultat));
    }

    @Test
    public void testCalcImpl6() {
        double resultat = CalculImpl2.Calculer(-1,1,2);
        Assertions.assertTrue(Double.isInfinite(resultat));
    }

    @Test
    public void testCalcImpl7() {
        double resultat = CalculImpl2.Calculer(0,1,1);
        Assertions.assertTrue(Double.isFinite(resultat));
    }

    @Test
    public void testCalcImpl8() {
        double resultat = CalculImpl2.Calculer(0,0,2);
        Assertions.assertTrue(Double.isFinite(resultat));
    }

    //...
}
