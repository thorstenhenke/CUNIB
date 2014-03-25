public class datenstrukturen {

public static void main(String[] args) {
    DecisionGraph dg = new DecisionGraph();

    dg.addRelation("A", "1", "C");
    dg.addRelation("A", "2", "D");
    dg.addRelation("B", "1", "D");
    dg.addRelation("C", "1", "D");
    dg.addRelation("C", "2", "D");
    dg.addRelation("C", "3", "E");
    dg.addRelation("D", "1", "E");
    dg.addRelation("E", "*", "B");

    System.out.println("Initial State");
    dg.printState();

    System.out.println("Erster Testlauf <D erwartet>");
    dg.start("A");
    dg.next("1").next("2");
    dg.printState();

    System.out.println("Zweiter Testlauf <E erwartet>");
    dg.start("A");
    dg.next("2").next("1");
    dg.printState();

    System.out.println("Dritter Testlauf <C erwartet>");
    dg.start("A");
    dg.next("1").next("3").rollback();
    dg.printState();

    System.out.println("Vierter Testlauf <B erwartet");
    dg.start("A");
    dg.next("1").next("3").next("91");
    dg.printState();

    System.out.println("Gebe die gesamte History aus");
    dg.printHistory();
    }
}
