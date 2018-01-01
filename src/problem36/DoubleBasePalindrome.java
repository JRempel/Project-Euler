
public class DoubleBasePalindrome
{   
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPalindrome("" + i) && isPalindrome("" + Integer.toBinaryString(i)))
                sum += i;
        }
        System.out.println(sum);
    }
    
    public static boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }
    
}
