import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class BasicMath
{
    public static void main(String[] args)
    {
        SecureRandom rand = new SecureRandom();
        int total = 0, flag = 0;
        int output_determinate = rand.nextInt(3 - 0);
        Scanner scnr = new Scanner(System.in);
        double input = 0;
        int difficulty = 0, type = 0;
        double c;

        while(!(type >= 1 && type <= 5))
        {
            System.out.println("Select a arithmetic type:\n1. Addition\n" +
                    "2. Subtraction\n3. Multiplication\n4. Division" +
                    "\n5. Random");
            type = scnr.nextInt();
        }

        while(!(difficulty >= 1 && difficulty <= 4))
        {
            System.out.println("Select a difficulty:\n1. Easy\n2. Medium\n" +
                    "3. Hard\n4. Insane");
            difficulty = scnr.nextInt();
        }

        for (int i = 0; i < 10; i++)
        {
            c = create_question(difficulty, type);

            input = scnr.nextDouble();

            if (input == c)
            {
                if (output_determinate == 0)
                    System.out.println("Very Good!");
                else if (output_determinate == 1)
                    System.out.println("Excellent!");
                else if (output_determinate == 2)
                    System.out.println("Nice work!");
                else
                    System.out.println("Keep up the good work!");
                total++;
            }
            else
                {
                    if (output_determinate == 0)
                        System.out.println("No. Please try again.");
                    else if (output_determinate == 1)
                        System.out.println("Wrong. Try once more.");
                    else if (output_determinate == 2)
                        System.out.println("Don’t give up!");
                    else
                        System.out.println("No. Keep trying.");
            }

                flag++;

        }

        if(total > 7)
            System.out.println("Congratulations, you are ready to go to the next level!");
        else
            System.out.println( "Please ask your teacher for extra help.");

    }
    public static double create_question(int input, int number)
    {
        int a, b, d, high = 9, low = 1, temp;
        double c;
        for(int i = 0; i < input - 1; i++)
        {
            high *= 10;
        }

        SecureRandom rand = new SecureRandom();
        a = rand.nextInt(high) + 1;
        b = rand.nextInt(high) + 1;
        if(number == 5)
            number = rand.nextInt(4) + 1;;
        c = a + b;
        if(number ==1)
        {
            c = a + b;
            System.out.printf("How much is %d plus %d?\n", a, b);
        }
        else if(number == 2)
        {
            if(b > a)
            {
                temp = b;
                b = a;
                a = b;
            }
            c = a - b;
            System.out.printf("How much is %d minus %d?\n", a, b);
        }
        else if(number == 3)
        {
            c = a * b;
            System.out.printf("How much is %d times %d?\n", a, b);
        }
        else if(number == 4)
        {
            if(b > a)
            {
                temp = b;
                b = a;
                a = b;
            }
            c = (double)a / b;
            c = Math.round(c);
            System.out.printf("How much is %d divided %d (rounded to nearest whole number)\n", a, b);
        }
        System.out.printf("Type:%d, a:%d, b%d, c%f\n", number, a ,b, c);
        return c;
    }

}