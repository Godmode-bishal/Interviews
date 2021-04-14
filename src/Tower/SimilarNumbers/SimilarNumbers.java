package Tower.SimilarNumbers;

public class SimilarNumbers {
    boolean isSimilar(long a, long b, int[] arrayA, int[] arrayB) {
        while(a != 0) {
            arrayA[(int)(a%10)]++;
            a /= 10;
        }
        while(b != 0) {
            arrayB[(int)(b%10)]++;
            b /= 10;
        }
        for(int i = 0; i<10; i++) {
            if(arrayA[i] != arrayB[i])
                return false;
        }
        return true;
    }


    long fac(long a) {
        if(a ==1) {
            return 1;
        }
        else {
            return a*fac(a-1);
        }
    }


    long findCount(long number, int[] arrayInvolved) {
        int numDigits = 0;
        long result=1;
        for(int i = 0; i< arrayInvolved.length; i++ ) {
            if(arrayInvolved[i] !=0 ) {
                numDigits += arrayInvolved[i];
            }
        }
        if(arrayInvolved[0]!=0) {
            result *= (numDigits - arrayInvolved[0]);
            numDigits--;
        }

        for(int i = 1; i<=numDigits; i++) {
            result *= i;
        }
        for(int i = 0; i< arrayInvolved.length; i++ ) {
            if(arrayInvolved[i] >1 ) {
                result /= fac(arrayInvolved[i]);
            }
        }
        return result;
    }


    long similarNumCount(String a, String b) throws NumberFormatException {
        int[] arrayA = new int[10];
        int[] arrayB = new int[10];
        if(isSimilar(Long.parseLong(a), Long.parseLong(b), arrayA, arrayB)) {
            return findCount(Long.parseLong(a), arrayA);
        }
        else {
            return findCount(Long.parseLong(b), arrayB);
        }
    }
}
