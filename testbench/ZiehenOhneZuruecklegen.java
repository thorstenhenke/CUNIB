import java.util.Arrays;

public class ZiehenOhneZuruecklegen {
    public void ziehung()
    {
        int[] lotto = new int[5];
        int i    ; // Schleifenzähler
        int idx  ; // der Index der gezogenen Zahl
        int num  ; // die gezogene Zahl
        int limit; // die Anzahl der verfügbaren Zahlen

        // Initialisierung der Ziehungszahlen
        for ( i = 0; i < lotto.length; i++ )
        { lotto[i] = i+1; }
        // Ziehen und ausgeben der 6 Zahlen
        for ( i = 0, limit = lotto.length; i < 6; i++ )
        {
            if (limit == 0) {
                System.out.println("Ahhhhh");
                System.exit(0);
            }
            // Es wird zufällig eine Zahl gezogen
            idx = (int) (Math.random()*limit);
            num = lotto[idx];
            // limit wird erniedrigt, weil nun eine Zahl weniger zu Verfügung steht
            limit--;
            // die gezogene Zahl und die letzte Zahl tauschen den Platz
            // dadurch kann die letzte Zahl das nächste Mal auch noch gezogen werden
            // und die gezogene Zahl kommt in den Bereich der nicht verfügbaren Zahlen
            System.out.println("Vor dem Tausch (Limit " + limit + ", Idx " + idx + ")");
            System.out.println(Arrays.toString(lotto));

            lotto[idx] = lotto[limit];
            lotto[limit] = num;

            System.out.println(Arrays.toString(lotto));
            // Ausgabe der gezogenen Zahl
            System.out.println("Gezogen: " + num);
        }
    }

    public static void main(String[] args) {
        new ZiehenOhneZuruecklegen().ziehung();
    }
}
