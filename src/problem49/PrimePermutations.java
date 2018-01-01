import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class PrimePermutations
{
    public static boolean[] isPrime = new boolean[10000];
    public static TreeSet<Integer> primes = new TreeSet<Integer>();

    public static void main(String[] args)
    {
        primeSieve();
        
        Iterator<Integer> iterator = primes.iterator();
        while (iterator.hasNext())
        {
            Integer n = iterator.next();
            int two = n + 3330;
            int three = two + 3330;
            if (primes.contains(two) && primes.contains(three)) {
                HashSet<String> permutations = permutation("" + n);
                if (permutations.contains("" + two) && permutations.contains("" + three))
                    System.out.println(n + " " + two + " " + three);
            }
                
        }
    }

    public static void primeSieve()
    {
        Arrays.fill(isPrime, true);
        primes.add(2);
        for (int i = 3; i < 10000; i += 2)
        {
            if (isPrime[i])
            {
                for (int j = i * 2; j < 10000; j += i)
                {
                    isPrime[j] = false;
                }
                if (i > 999 && i < 10000)
                    primes.add(i);
            }
        }
    }

    public static HashSet<String> permutation(String s)
    {
        HashSet<String> res = new HashSet<String>();
        if (s.length() == 1)
        {
            res.add(s);
        }
        else if (s.length() > 1)
        {
            int lastIndex = s.length() - 1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutation(rest), last);
        }
        return res;
    }

    public static HashSet<String> merge(HashSet<String> list, String c)
    {
        HashSet<String> res = new HashSet<String>();
        for (String s : list)
        {
            for (int i = 0; i <= s.length(); ++i)
            {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
}
