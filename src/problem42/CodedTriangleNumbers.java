import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CodedTriangleNumbers
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        ArrayList<String> words = readFile("p042_words.txt");
        words.set(0, words.get(0).replaceAll("\"", ""));
        words.set(words.size() - 1, words.get(words.size() - 1).replaceAll("\"", ""));
        int triangleWords = 0;
        for (String s : words)
        {
            int value = 0;
            for (char c : s.toCharArray())
            {
                value += c - 'A' + 1;
            }
            if (isTriangleNum(value))
                triangleWords++;
        }
        System.out.println(triangleWords);
                
    }

    public static boolean isTriangleNum(int num)
    {
        double n = (Math.sqrt(1 + 8 * num) - 1.0) / 2.0;
        if (n == (int)n)
            return true;
        return false;
    }

    public static ArrayList<String> readFile(String fileName)
        throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(fileName)).useDelimiter("\",\"");
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext())
        {
            list.add(s.next());
        }
        s.close();
        return list;
    }
}
