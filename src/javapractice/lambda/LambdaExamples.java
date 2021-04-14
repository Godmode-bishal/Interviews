package javapractice.lambda;

public class LambdaExamples {
    static String thirdText = "Third text";
    private  String fourthText = " 4th text";

    public void doIt() {
        final String otherText = " Hello ";
        MyFunction myFunction = (text)-> System.out.println(otherText + text + thirdText + fourthText);
        myFunction.printIt(" Arg ");
        //can't change : effectively final
        //otherText = "hjhjd";

        thirdText = "Changed third text";
        MyFunction myFunction2 = (text)-> System.out.println(otherText + text + thirdText + fourthText);
        myFunction2.printIt(" Arg ");

    }

    public static void main(String[] args) {
        LambdaExamples lambdaExamples = new LambdaExamples();
        lambdaExamples.doIt();

    }
}
