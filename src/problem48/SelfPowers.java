import java.math.BigInteger;

public class SelfPowers
{
    public static void main(String[] args)
    {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++)
        {
            sum = sum.add(new BigInteger("" + i).pow(i));
        }
        String sumS = sum.toString();
        System.out.println(sumS.substring(sumS.length() - 10, sumS.length()));
    }
}
