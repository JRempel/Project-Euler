import java.util.ArrayList;
import java.util.Collections;


public class PandigitalPrime
{
    public static void main(String[] args) {
       String digits = "" + 1234567890;
       ArrayList<String> permutations;
       ArrayList<String> primes = new ArrayList<String>();
       while (primes.size() == 0) {
           digits = digits.substring(0, digits.length()-1);
           permutations = permutation(digits);
           for(String s: permutations) {
               int num = Integer.parseInt(s);
               if (isPrime(num))
                   primes.add(s);
           }
           
       }
       Collections.sort(primes);
       Collections.reverse(primes);
       System.out.println(primes.get(0));
    }
    
    public static boolean isPrime(int n)
    {
        if (n == 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        if (n % 3 == 0)
            return false;
        int i = 5, w = 2;

        while (i * i <= n)
        {
            if (n % i == 0)
                return false;
            i += w;
            w = 6 - w;
        }
        return true;
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
