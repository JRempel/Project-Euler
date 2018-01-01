import java.util.ArrayList;

public class DigitCancelling
{
    public static ArrayList<Integer> numerators = new ArrayList<Integer>();
    public static ArrayList<Integer> denominators = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        for (int denominator = 10; denominator < 100; denominator++)
        {
            for (int numerator = 10; numerator < denominator; numerator++)
            {
                if (euclidGCD(numerator, denominator) != 1 && numerator % 10 != 0 && denominator % 10 != 0)
                {
                    String denomS = String.valueOf(denominator);
                    String numerS = String.valueOf(numerator);
                    for (char c : denomS.toCharArray())
                    {
                        if (numerS.contains("" + c))
                        {
                            int newDenom = Integer.parseInt(denomS.replaceFirst("" + c, ""));
                            int newNumer = Integer.parseInt(numerS.replaceFirst("" + c, ""));
                            if (equalFractions(numerator, denominator, newNumer, newDenom))
                            {
                                numerators.add(newNumer);
                                denominators.add(newDenom);
                            }
                        }
                    }
                }
            }
        }
        int finalNumer = 1;
        int finalDenom = 1;
        for (Integer i : numerators)
        {
            finalNumer *= i;
        }
        for (Integer i : denominators)
        {
            finalDenom *= i;
        }
        int gcd = euclidGCD(finalNumer, finalDenom);
        finalNumer /= gcd;
        finalDenom /= gcd;
        System.out.println(finalNumer + "/" + finalDenom);
    }

    public static int euclidGCD(int a, int b)
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static boolean equalFractions(int n1, int d1, int n2, int d2)
    {
        return d1 * n2 == d2 * n1;
    }
}
