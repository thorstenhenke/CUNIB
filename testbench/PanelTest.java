import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by macos on 25.03.14.
 */
public class PanelTest {

    private MyPanel b;
    private MyPanel e;
    private Timer t;
    private int v;

    PanelTest()
    {
        b = new MyPanel("Beobachte");
        e = new MyPanel("Eintragen");
        t = new Timer();
    }

    public static void main(String[] args) {
        new PanelTest().start();
    }

    void start()
    {
        // simuliert das Actioncommand
        v = 20;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Zeit ist " + v);
                v--;
                if (v == 0) this.cancel();
            }
        };
        beobachte();
        t.schedule(task, 0, 1000);
    }

    void beobachte()
    {
       e.show(false);
       b.show(true);
       TimerTask task = new TimerTask() {
           @Override
           public void run() {
               eintragen();
               this.cancel();
           }
       };
       t.schedule(task, 10 * 1000);
    }


    void eintragen()
    {
        b.show(false);
        e.show(true);
    }
}


class MyPanel
{
    private Boolean show = false;
    private String kennung;

    MyPanel(String k) {
        this.kennung = k;
    }

    void show(Boolean show) {
        this.show = show;
        if (show) System.out.println(" === " + kennung + " === ");
    }

    void updateSekunden(int sek) {
        if (show)  System.out.println("(" + kennung.charAt(0) +  ") Zeit ist" + sek);
    }
}
