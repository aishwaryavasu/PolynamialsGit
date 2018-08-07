public class MainClass {
    public static void main(String args[]) {
        poly p = new poly("x^5 + 3x^3 + 4");
        poly q = new poly("6x^6 + 4x^3");
        q.add(p).printPoly();
        System.out.println();
        q.sub(p).printPoly();
        System.out.println();
        q.multiply(p).printPoly();
        System.out.println();
        System.out.print("Remainder\n");
        q.multiply(p).divide(q).printPoly();
        System.out.println();

    }
}
