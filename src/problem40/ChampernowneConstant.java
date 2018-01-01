public class ChampernowneConstant
{
    public static void main(String[] args)
    {
        String decimalString = "";
        int curr = 1;
        while (decimalString.length() < 1000000)
        {
            decimalString += curr;
            curr++;
        }
        int result = 1;
        result *= Integer.parseInt("" + decimalString.charAt(0));
        result *= Integer.parseInt("" + decimalString.charAt(9));
        result *= Integer.parseInt("" + decimalString.charAt(99));
        result *= Integer.parseInt("" + decimalString.charAt(999));
        result *= Integer.parseInt("" + decimalString.charAt(9999));
        result *= Integer.parseInt("" + decimalString.charAt(99999));
        result *= Integer.parseInt("" + decimalString.charAt(999999));
        System.out.println(result);
    }
}
