package testbench;

import javax.swing.event.EventListenerList;
import java.util.*;


/**
 * Created by macos on 24.03.14.
 */
public class EventStuff {

    public static void main(String[] args) {

        class ComplainingAdListener implements AdListener {
            @Override public void advertisement( AdEvent e ) {
                System.out.println( "Oh nein, schon wieder Werbung: " + e.getSlogan() );
            }
        }

        Radio r = new Radio();
        r.addAdListener( new ComplainingAdListener() );
    }
}


class AdEvent extends EventObject {
    private String slogan;

    public AdEvent( Object source, String slogan ) {
        super( source );
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }
}


interface AdListener extends EventListener
{
    void advertisement( AdEvent e );
}

class Radio {
    private EventListenerList listeners = new EventListenerList();
    private List<String> ads = Arrays.asList("Jetzt explodiert auch der Haarknoten",
            "Red Fish verleiht Flossen",
            "Bom Chia Wowo",
            "Wunder Whip. Iss milder.");

    public Radio() {
        new Timer().schedule( new TimerTask() {
            @Override public void run()
            {
                Collections.shuffle( ads );
                notifyAdvertisement( new AdEvent( this, ads.get(0) ) );
            }}, 0, 500 );
    }

    public void addAdListener( AdListener listener ) {
        listeners.add( AdListener.class, listener );
    }

    protected synchronized void notifyAdvertisement( AdEvent event ) {
        // AdListener.class ??
        for ( AdListener l : listeners.getListeners( AdListener.class ) )
            l.advertisement( event );
    }
}

