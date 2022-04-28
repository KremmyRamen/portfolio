using System;
using System.IO;

public class OddEven
{
    public static void Main(string[] args)
    {
        try
        {
            using (StreamReader sr = new StreamReader("Numbers.txt"))
            {
                StreamWriter odds = new StreamWriter("Odd.txt");
                StreamWriter evens = new StreamWriter("Even.txt");

                String line;
                int num;
                while ((line = sr.ReadLine()) != null)
                {
                    num = Convert.ToInt32(line);
                    if (num % 2 == 0)
                    {
                        evens.WriteLine(num);
                    }
                    else
                    {
                        odds.WriteLine(num);
                    }
                }

                odds.Close();
                evens.Close();
            }
        }
        catch (Exception e)
        {
            Console.WriteLine("Numbers.txt does not exists");
        }
    }
}
