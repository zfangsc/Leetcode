import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by fangzhou on 3/15/14.
 */
public class OnlineUtil {
    private static final int kilo = 1000;
    private static final int meg = 1000000;
    private static final int gig = 1000000000;
    private static final String[] unit = new String[] {"B", "K", "M", "G"};

    public String convert(int n) {
        if(n == 0) {
            return "0B";
        }

        // consider round  e.g. 999500  the 4th efficient digit is 5, so add 1000 into n
        // => 1000500    then extracting 1M in the later code part
        n = roundPreProcessing(n);


        int digNumber = count(n);                   // count how many digits in total
        String effiDig = "";
        int unitCount = 0;                          // the index of unit array   e.g. unitCount = 1,  unitCount[1] is "K"
        if(digNumber == 10)                         // 1G
        {
            return "1G";
        }
        if(digNumber >= 7 && digNumber <= 9) {
            unitCount = 2;
            effiDig = getEffiDig(n, digNumber);     // get 3 efficient digits, e.g.  1234567 =>  1.23,  1, 2 and 3 are efficient digit
        }
        if(digNumber >= 4 && digNumber <= 6) {
            unitCount = 1;
            effiDig = getEffiDig(n, digNumber);
        }
        if(digNumber >= 1 && digNumber <= 3) {
            unitCount = 0;
            effiDig = getEffiDig(n, digNumber);

        }
        return effiDig+unit[unitCount];
    }

    public int count(int n) {                       // count how many digits in total
        if(n == 0) {
            return 1;
        }
        int c = 0;
        int div = 10;
        while(n > 0) {
            c++;
            n = n/10;
        }
        return c;
    }

    // round has been preprocessed, so we don't need to consider it now
    public String getEffiDig(int n, int digNumber) { // get 3 efficient digits, e.g.  1234567 =>  1.23,  1, 2 and 3 are efficient digit
        char[] chars = ("" + n).toCharArray();      // convert number into char array to manipulate easier
        StringBuffer sb = new StringBuffer();
        int decimal = digNumber % 3;                // how many digit in decimal part  e.g. 12345 => 5%3 = 2   so "12" is in decimal
        if(decimal == 0) {
            decimal = 3;
        }

        // get dicimal part
        for(int i = 0; i < decimal; i++) {
            sb.append(chars[i]);
        }

        boolean needRound = false;
        // get digits of float part
        StringBuffer sbFloat = new StringBuffer();
        for(int i = decimal; i < 3 && i < chars.length; i++) {
            sbFloat.append(chars[i]);
        }

        //remove tailing 0 for float part
        for(int i = sbFloat.length()-1; i >= 0; i--) {
            if(sbFloat.charAt(i) == '0') {
                sbFloat.deleteCharAt(sbFloat.length()-1);
            }
            else {
                break;
            }
        }
        if(sbFloat.length() != 0) {
            sb.append('.');
            sb.append(sbFloat.toString());
        }
        return sb.toString();
    }

    public int roundPreProcessing(int n) {
        char[] chars = ("" + n).toCharArray();
        char roundc = '0';
        int i = 0;
        for(; i < chars.length && i < 4; i++) {
            if(i == 3) {
                roundc = chars[i];
            }
        }

        int addNumber = 1;
        if(roundc > '4') {          // need round
            for(; i < chars.length; i++) {
                addNumber *= 10;
            }
            n += addNumber;
        }
        return n;
    }


    public void printArray(int[] arr) {
        for(int a : arr) {
            System.out.print(a + ",");
        }
        System.out.println();
        System.out.println();
    }

    public void iterateUtil(List l) {
        ListIterator iterator = l.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        OnlineUtil o = new OnlineUtil();
/*        int[] arr = new int[] {3, 6, 2, 7, 2, 1, 9, -1};
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for(int a:arr) {
            arrlist.add(a);
        }
        //Arrays.sort(arr);
        o.printArray(arr);
        o.iterateUtil(arrlist);*/

        int n = 999999;
        System.out.println(o.convert(n));

    }

}
