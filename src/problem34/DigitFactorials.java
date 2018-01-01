public class DigitFactorials
{
    public static int[] factorials;
    public static int totalSum = 0;

    public static void main(String[] args)
    {
        initFactorials();
        for (int i = 10; i < 2540161; i++)
        {
            int sum = 0, digits = i;
            while (digits != 0)
            {
                sum += factorials[digits % 10];
                digits /= 10;
            }
            if (sum == i)
                totalSum += sum;
        }
        System.out.println(totalSum);
    }

    public static void initFactorials()
    {
        factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++)
        {
            factorials[i] = i * factorials[i - 1];
        }
    }
}
