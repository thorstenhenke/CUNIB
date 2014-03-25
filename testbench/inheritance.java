
/**
 * Created by macos on 22.03.14.
 */

abstract class oberklasse {
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
public class inheritance extends oberklasse{

    public static void main(String[] args) {
        inheritance i = new inheritance();
        System.out.println(i);
    }
}


