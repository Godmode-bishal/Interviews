package Tower.SimilarNumbers;

public class CupsnBalls {
    public int totalPossibilities(int N, int white, int black) {
        int allWays = (int) Math.pow(2,N);
        for(int j = 2; j<=N; j++) {
            allWays -= N-j+1;
        }
        if(N==1 || N==2) {
            return allWays%((int)(Math.pow(10,9)+7));
        }
        return (allWays -(int) Math.pow(2,N-2))%((int)(Math.pow(10,9)+7));
    }
}
