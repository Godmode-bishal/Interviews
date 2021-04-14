package Fortigo;

public class NumToSTring {
    static String ones[] ={"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen"
    , "nineteen"};

    static String tens[] = {"", "", "twenty","thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    static String convert(long input, String suffix) {
        String result = "";
        if(input>19) {
            result += tens[(int) (input/10)] + " " +ones[(int) (input%10)];
        }
        else {
            result += ones[(int) input];
        }
        if(input != 0)
            result += suffix;
        return result;
    }
    public static void main(String[] args) {
        long inputNumber = 11111111;
        String output = "";
        if(inputNumber == 0)
            System.out.println("Zero");
        output += convert(inputNumber/10000000, " crores ");
        output +=  convert((inputNumber/100000)%100, " lakhs ");
        output += convert((inputNumber/1000)%100, " thousand ");
        output += convert((inputNumber/100)%10," hundred ");
        output += convert(inputNumber%100, "");
        System.out.println(output);
    }
}
//Table name Sales
//Col 1 : SalesPersonId (string)
//Col 2 : CustomerId  (string)(Primary key)
//Col 3 : Revenue (long)
//Col 4 : PercentExceed (double)
//Col 5 : Date in yyyymmdd (long)
//Select salesPersonId from Sales group by SalesPersonId order by PercentExceed
//Select  top 5 CustomerId from Sales group by SalesPersonId order by Revenue
//Select salesPersonId, CustomerId from Sales where Revenue=0 and Date >=20201101 and Date <=20201131