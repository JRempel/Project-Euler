public class TruncatablePrimes
{
    public static void main(String[] args)
    {
        int sum = 0, primesFound = 0, current = 11;
        while (primesFound < 11) {
            if (truncateRight(current) && truncateLeft(current)) {
                sum += current;
                primesFound ++;
            }
            current++;
        }
        System.out.println(sum);
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

    public static boolean truncateLeft(int n)
    {
        boolean isPrime = true;
        while (n > 0) {
            isPrime = isPrime(n);
            if (!isPrime)
                return false;
            int length = numLength(n);
            if (n > 9) {
                while (numLength(n) == length) {
                    n -= (int) Math.pow(10, length - 1);
                }
            }
            else
                break;
        }
        return isPrime;
    }

    public static boolean truncateRight(int n)
    {
        boolean isPrime = true;
        while (n > 0) {
            isPrime = isPrime(n);
            if (!isPrime)
                return false;
            n /= 10;
        }
        return isPrime;
    }
    
    public static int numLength(int num)
    {
        int length;
        for (length = 0; num > 0; ++length)
            num /= 10;
        return length;
    }
}
