import java.util.HashSet;


public class PermutedMultiples
{
    public static void main(String[] args) {
        int x = 0;
        while (true) {
            x++;
            int twoX = 2 * x;
            int threeX = 3 * x;
            int fourX = 4 * x;
            int fiveX = 5 * x;
            int sixX = 6 * x;
            if (numLength(x) == numLength(twoX) && numLength(x) == numLength(threeX) && numLength(x) == numLength(fourX) && numLength(x) == numLength(fiveX) && numLength(x) == numLength(sixX)) {
                HashSet<String> perms = permutation("" + x);
                if (perms.contains("" + twoX) && perms.contains("" + threeX)&& perms.contains("" + fourX)&& perms.contains("" + fiveX)&& perms.contains("" + sixX)) {
                    System.out.println(x);
                    return;
                }
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
    
    public static int numLength(int num)
    {
        int length;
        for (length = 0; num > 0; ++length)
            num /= 10;
        return length;
    }
}
