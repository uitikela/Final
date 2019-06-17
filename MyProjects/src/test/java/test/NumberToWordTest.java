package test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class NumberToWordTest {

    private final String expected;
    private final int input;

    static HashMap<Integer,String> numberMap = new HashMap<Integer,String>();
    static{
        numberMap.put(0,"Zero");
        numberMap.put(1,"One");
        numberMap.put(2,"Two");
        numberMap.put(3,"Three");
        numberMap.put(4,"Four");
        numberMap.put(5,"Five");
        numberMap.put(6,"Six");
        numberMap.put(7,"Seven");
        numberMap.put(8,"Eight");
        numberMap.put(9,"Nine");
        numberMap.put(10,"Ten");
        numberMap.put(11,"Eleven");
        numberMap.put(12,"Twelve");
        numberMap.put(13,"Thirteen");
        numberMap.put(14,"Fourteen");
        numberMap.put(15,"Fifteen");
        numberMap.put(16,"Sixteen");
        numberMap.put(17,"Seventeen");
        numberMap.put(18,"Eighteen");
        numberMap.put(19,"Nineteen");
        numberMap.put(20,"Twenty");
        numberMap.put(30,"Thirty");
        numberMap.put(40,"Forty");
        numberMap.put(50,"Fifty");
        numberMap.put(60,"Sixty");
        numberMap.put(70,"Seventy");
        numberMap.put(80,"Eighty");
        numberMap.put(90,"Ninety");
        numberMap.put(100,"Hundred");
        numberMap.put(1000,"Thousand");

    }
    public NumberToWordTest(final String expected, final int input) {
        this.expected = expected;
        this.input = input;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] {
            { "One Hundred Thousand", 100000 },
            { "Nine HundredNinetyNine Thousand Nine HundredNinetyNine", 999999 },
            { "Six HundredSeventyEight Thousand Nine Hundred", 678900 },
            { "Zero", 0 },
            { "One Hundred Thousand Five HundredSixtySeven", 100567 },
            { "FourThousandFive HundredEightyNine", 4589 },
            { "ThreeThousandThree HundredThirtyThree", 3333 },
            { "SixtySeven Thousand Five Hundred", 67500 },
            { "SeventyTwo", 72 },
            { "One HundredSeventyTwo Thousand Three HundredFortySix", 172346 },
            { "Eight HundredNinety Thousand", 890000 },
            { "Six Hundred Thousand Seven Hundred", 600700 },
            { "SixtySeven", 67 },
            { "Nine HundredNinetyNine Million Nine HundredNinetyNine Thousand Nine HundredNinetyNine", 999999999 } };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        assertEquals(expected, numberToWord(input));
    }

    public static String numberToWord(int number)
    {
        String wordForm = "";
        int quotient =0;
        int remainder = 0;
        int divisor = 0;
        if(number<1000000000 && number>=1000000)
        {
            divisor = 1000000;
            quotient = number/divisor;
            remainder = number % divisor;
            if(quotient!=0)
            wordForm += numberToWord(quotient) + " " + "Million";
            if(remainder!=0)
                wordForm+= " " + numberToWord(remainder);
        }
        else if(number<1000000 && number>=10000)
        {
            divisor = 1000;
            quotient = number/divisor;
            remainder = number % divisor;
            if(quotient!=0)
            wordForm += numberToWord(quotient) + " " + "Thousand";
            if(remainder!=0)
                wordForm+= " " + numberToWord(remainder);
        }
        else if(number<10000 && number>=1000)
        {
            divisor = 1000;
            quotient = number/divisor;
            remainder = number % divisor;
            if(quotient!=0)
            wordForm += numberMap.get(quotient) + "Thousand";
            if(remainder!=0)
                wordForm+= numberToWord(remainder);

        }else if(number<1000 && number>=100)
        {
            divisor = 100;
            quotient = number/divisor;
            remainder = number % divisor;
            if(quotient!=0)
            wordForm += numberMap.get(quotient) + " " + "Hundred";
            if(remainder!=0)
                wordForm +=numberToWord(remainder);

        }else if(number<100 && number>=10)
        {
            divisor = 10;
            quotient = number/divisor;
            remainder = number % divisor;
            if(quotient!=0)
                wordForm+= numberMap.get(quotient*divisor);
            if(remainder!=0)
                wordForm+= numberMap.get(remainder);


        }else if(number<10 && number>=0)
        {
            wordForm +=  numberMap.get(number);

        }
        return wordForm;
    }

}