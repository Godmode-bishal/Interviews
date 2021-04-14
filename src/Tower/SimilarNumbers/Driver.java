package Tower.SimilarNumbers;

public class Driver {
    public static void main(String[] args) {
        //Similar Numbers
        /*SimilarNumbers similarNumbers = new SimilarNumbers();
        long result = similarNumbers.similarNumCount("1100","10001");
        System.out.println(result);*/

        CupsnBalls cupsnBalls = new CupsnBalls();
        System.out.println(cupsnBalls.totalPossibilities(2,4,4));
    }
}
