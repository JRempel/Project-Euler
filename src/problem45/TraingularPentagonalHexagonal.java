public class TraingularPentagonalHexagonal
{
    public static void main(String[] args)
    {
        double result = 0;
        int i = 143;
        while(true) {
            i++;
            result = i * (2*i-1);
            if (isPentagonal(result))
                break;
        }
        System.out.println(result);
    }
    
    public static boolean isPentagonal(double result) {
        double n = (Math.sqrt(24*result + 1) + 1.0) / 6.0;
        if (n==(int) n)
            return true;
        return false;
    }
}
