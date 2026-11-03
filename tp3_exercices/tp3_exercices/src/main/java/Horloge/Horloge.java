package Horloge;

import static java.lang.Math.abs;

public class Horloge {
    private int heures;
    private int minutes;
    private int secondes;

    public Horloge(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSecondes() {
        return secondes;
    }

    public void addSecondes(int s) {
        secondes+=s;
        if(s>=0) {
            if(secondes>=60) {
                minutes+=secondes/60;
                secondes=secondes%60;
            }
            if(minutes>=60) {
                heures+=minutes/60;
                minutes=minutes%60;
            }
            if(heures>=24) heures= heures % 24;
        }
        else {
            if(secondes<0) {
                int emprunt = (abs(secondes)+59)/60;
                minutes-=emprunt;
                secondes+=emprunt*60;
            }
            if(minutes<0) {
                int emprunt = (abs(minutes)+59)/60;
                heures-=emprunt;
                minutes+=emprunt*60;
            }
            if(heures<0) {
                int emprunt = (abs(heures)+23)/24;
                heures+=emprunt*24;
            }
        }
    }
}
