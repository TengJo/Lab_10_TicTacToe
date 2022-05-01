import java.util.Scanner;

public class SafeInput<regex>
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n"+prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int intVal = 0;
        String trash;
        boolean doneInt = false;
        do
        {
            System.out.print("\n"+prompt + ": ");
            if (pipe.hasNextInt())
            {
                intVal = pipe.nextInt();
                doneInt = true;
            }
            else
            {
                trash = pipe.next();
                System.out.println("\nYou have entered an incorrect value: " + trash + " Try again.");
            }
        }while (!doneInt);

        return intVal;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double doubleVal = 0;
        String trash;
        boolean doneDouble = false;
        do
        {
            System.out.print("\n"+prompt + ": ");
            if (pipe.hasNextDouble())
            {
                doubleVal = pipe.nextDouble();
                doneDouble = true;
            }
            else
            {
                trash = pipe.next();
                System.out.println("\nYou have entered an incorrect value: " + trash + " Try again.");
            }
        }while (!doneDouble);
        return doubleVal;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int rangedIntVal = 0;
        String trash;
        boolean rangedIntDone = false;
        do
        {
            System.out.print("\n"+prompt +"[" + low + "-" + high + "]: ");
            if (pipe.hasNextInt())
            {
                rangedIntVal = pipe.nextInt();
                if (rangedIntVal>= low && rangedIntVal<= high)
                {
                    rangedIntDone = true;
                }
                else
                {
                    System.out.println("\nYou have entered a value outside the range: " + rangedIntVal + " Try again.");
                }

            }
            else
            {
                trash = pipe.next();
                System.out.println("\nYou have entered an incorrect value: " + trash + " Try again.");
            }
        }while (!rangedIntDone);
        return rangedIntVal;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double rangedDoubleVal = 0;
        String trash;
        boolean rangedDoubleDone = false;
        do
        {
            System.out.print("\n"+prompt +"[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble())
            {
                rangedDoubleVal = pipe.nextDouble();
                if (rangedDoubleVal>= low && rangedDoubleVal<= high)
                {
                    rangedDoubleDone = true;
                }
                else
                {
                    System.out.println("\nYou have entered a value outside the range: " + rangedDoubleVal + " Try again.");
                }

            }
            else
            {
                trash = pipe.next();
                System.out.println("\nYou have entered an incorrect value: " + trash + " Try again.");
            }
        }while (!rangedDoubleDone);
        return rangedDoubleVal;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
    boolean continueYN = false;
    boolean trueFalse = false;
    String yesNo;
    do
    {
        System.out.print("\n"+prompt + ": ");
        yesNo=pipe.next();
        if (yesNo.equalsIgnoreCase("y"))
        {
            trueFalse = true;
            continueYN = true;
        }
        else if (yesNo.equalsIgnoreCase("n"))
        {
            trueFalse = false;
            continueYN = true;
        }
        else
        {
            System.out.println("\nYou have entered an incorrect value: " + yesNo + " Please Enter Y or N.");
        }
    }while(!continueYN);
    return trueFalse;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean matchValue = false;
        String regExValue;
        do
        {
            System.out.print("\n"+prompt + ": ");
            regExValue = pipe.nextLine();
            if (regExValue.matches(regEx))
            {
                matchValue = true;
            }
            else
            {
                System.out.println("\nYou have entered an incorrect value: " + regExValue);
            }

        }while(!matchValue);
        return regExValue;
    }
    public static void prettyHeader(String msg)
    {
    int spaceLength1;
    int spaceLength2;
    for (int x =0; x<60; x++)
        {
            System.out.print("*");
        }
    spaceLength1 = 60 - 6 - msg.length();
    if (spaceLength1 %2 == 0)
    {
        spaceLength1 = spaceLength1 /2;
        spaceLength2 = spaceLength1;
    }
    else
    {
        spaceLength1 =(spaceLength1 + 1 )/2;
        spaceLength2 =  spaceLength1 - 1;
    }
        System.out.print("\n***");

    for (int x =0; x<spaceLength1; x++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
    for (int x =0; x<spaceLength2; x++)
        {
            System.out.print(" ");
        }
        System.out.print("***\n");
    for (int x =0; x<60; x++)
        {
            System.out.print("*");
        }
    System.out.println("");
    }
}
