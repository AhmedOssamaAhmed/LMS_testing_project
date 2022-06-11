package engine;

import java.io.File;

public class Ass {
    File ASS;
    public String name;
    String Date;
    String Deadlinetime;

    public Ass(File ASS, String name, String date, String deadlinetime) {
        this.ASS = ASS;
        this.name = name;
        this.Date = date;
        this.Deadlinetime = deadlinetime;
    }

}
