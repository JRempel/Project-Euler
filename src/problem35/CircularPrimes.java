import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class CircularPrimes
{
    public static boolean[] isPrime = new boolean[1000000];
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static HashSet<Integer> rotatedPrimes = new HashSet<Integer>();
    public static ArrayList<Integer> finalList = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        primeSieve();
        rotateNums();
        System.out.println(finalList.size());
    }

    public static void primeSieve()
    {
        Arrays.fill(isPrime, true);
        primes.add(2);
        for (int i = 3; i < 1000000; i += 2)
        {
            if (isPrime[i])
            {
                primes.add(i);
                for (int j = i * 2; j < 1000000; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static int numLength(int num)
    {
        int length;
        for (length = 0; num > 0; ++length)
            num /= 10;
        return length;
    }

    public static void rotateNums()
    {
        finalList.add(2);
        for (Integer num : primes)
        {
            rotatedPrimes.clear();
            rotatedPrimes.add(num);
            int temp = num;
            int length = numLength(num);
            for (int i = length - 1; i > 0; i--)
            {
                temp = (temp % 10) * (int)Math.pow(10, length - 1) + (temp / 10);
                rotatedPrimes.add(temp);
            }
            boolean addRotations = true;
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            for (Iterator<Integer> i = rotatedPrimes.iterator(); i.hasNext();)
            {
                Integer itrNum = i.next();
                if (finalList.contains(itrNum))
                    break;
                if (itrNum % 2 == 0 || !isPrime[itrNum] || containsZero(itrNum)) {
                    addRotations = false;
                    break;
                } else {
                    toAdd.add(itrNum);
                }
            }
            if (addRotations) {
                for (Integer i: toAdd) {
                    finalList.add(i);
                }
            }
        }
    }
    
    public static boolean containsZero(int n) {
        while (n > 0) {
            if(n % 10 == 0)
                return true;
            n /= 10;
        }
        return false;
    }
}
