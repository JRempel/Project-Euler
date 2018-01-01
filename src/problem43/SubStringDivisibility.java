import java.util.ArrayList;


public class SubStringDivisibility
{
    public static void main(String[] args) {
        String digits = "" + 1234567890;
        ArrayList<String> permutations = permutation(digits);
        long sum = 0;
        for (String s: permutations) {
            int d2 = Integer.parseInt(s.substring(1, 4)), d3 = Integer.parseInt(s.substring(2, 5)), d4 = Integer.parseInt(s.substring(3, 6)), d5 = Integer.parseInt(s.substring(4, 7)), d6 = Integer.parseInt(s.substring(5, 8)), d7 = Integer.parseInt(s.substring(6, 9)), d8 = Integer.parseInt(s.substring(7, 10));
            if (d2 % 2 + d3 % 3 + d4 % 5 +d5 % 7 + d6 % 11 + d7 % 13 + d8 % 17 == 0)
                sum += Long.parseLong(s);
        }
        System.out.println(sum);
    }
    
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutation(rest), last);
        }
        return res;
    }
    
    public static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        for (String s : list) {
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
}
