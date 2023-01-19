public class Main {
    public static void main(String[] args) {

        TimeRepresentation test1 = new TimeRepresentation();
        TimeRepresentation test2 = new TimeRepresentation(23, 59, 59);
        test1.displayTime();
        test2.displayTime();
        //test2.setTime();
        test2.displayTime();
        test2.addTime();
        test2.displayTime();
        test2.subtractTime();
        test2.displayTime();
    }
}