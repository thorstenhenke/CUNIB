import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by macos on 24.03.14.
 */
public class TimerExperiment implements ActionListener{



    TimerExperiment() {
        Timer t = new Timer(new TimerTask(){

            @Override
            public void run() {
                System.out.println("Hallo");
            }
        }), 2000, 5000);
    }

    public static void main(String[] args) {
        TimerExperiment e = new TimerExperiment();




        TimerTask t = new TimerTask(){

            @Override
            public void run() {

            }
        };
        System.out.println("Nach dem Timer");
	    //timer.cancel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer2.stop();
        System.out.println("Aus die Maus");
        timer.cancel();
    }
}

class Task extends TimerTask
{
    private String n;
	Task(String n) {
        this.n = n;
	}

    @Override public void run()
    {
        System.out.println( n );
    }
}
