package Celigo;

public class GameWinner {
    public static String gameWinner(String colors) {
        /*int pos;
        while(true) {
            pos = colors.indexOf("www");
            if(pos!=-1) {
                colors = colors.substring(0,pos) + colors.substring(pos+1,colors.length());
            }
            else {
                return "bob";
            }
            pos = colors.indexOf("bbb");
            if(pos!=-1) {
                colors = colors.substring(0,pos) + colors.substring(pos+1,colors.length());
            }
            else {
                return "wendy";
            }
        }
*/
        int wCount=0, bCount=0, wNum=0, bNum=0, j=0;
        for(int i = 0; i<colors.length(); i++) {
            if(colors.charAt(i)=='w') {
                j = i;
                while(j<colors.length() && colors.charAt(j)=='w') {
                    wCount++;
                    j++;
                }
                wNum += wCount-2;
                i = j-1;
                wCount = 0;
            }
            else if(colors.charAt(i)=='b' ) {
                j = i;
                while(j<colors.length() && colors.charAt(j)=='b') {
                    bCount++;
                    j++;
                }
                bNum += bCount-2;
                i = j-1;
                bCount = 0;
            }
        }
        if(wNum>bNum)
            return "wendy";
        else
            return "bob";
    }
}
