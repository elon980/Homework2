import java.util.Scanner;

public class ex6 {
    public static void main(String [] args){
        System.out.println("Enter quadratic equation");
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        if (checkEquation(equation)){
            int a = parameterA(equation);
            int b = parameterB(equation);
            int c = parameterC(equation);
            String result=equationResults(a,b,c);
            System.out.println(result);
        }
        else
            System.out.println("Your equation is incorrect");
    }
    public static boolean checkEquation(String equation){
        if(!equation.contains("^2")||!equation.contains("=0"))
            return false;
        int index = equation.indexOf("=");
        equation = equation.substring(0,index);
        index = equation.indexOf("x^2");
        String a = equation.substring(0,index);
        if ((a.charAt(0)=='-'||a.charAt(0)=='+')&&a.length()==1)
            a=a+1;
        equation=equation.substring(index+3);
        index=equation.indexOf("x");
        String b = equation.substring(0,index);
        if ((a.charAt(0)=='-'||a.charAt(0)=='+')&&b.length()==1)
            b=b+1;
        String c = equation.substring(index+1);
        if ((a.charAt(0)=='-'||a.charAt(0)=='+')&&c.length()==1)
            c=c+1;
        if (isNumeric(a)&&isNumeric(b)&&isNumeric(c))
            return true;
        else
            return false;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static int parameterA(String equation){
        int index = equation.indexOf("x^2");
        String parameter = equation.substring(0,index);
        int a = Integer.parseInt(parameter);
        return a;
    }
    public static int parameterB(String equation){
        int inex1 = equation.indexOf("x^2");
        equation = equation.substring(inex1+3);
        int index = equation.indexOf("x");
        String parameter = equation.substring(0,index);
        int b = Integer.parseInt(parameter);
        return b;
    }
    public static int parameterC(String equation){
        int index = equation.indexOf("x^2");
        equation = equation.substring(index+3);
        index = equation.indexOf("x");
        equation=equation.substring(index+1);
        index=equation.indexOf("=");
        String paramter = equation.substring(0,index);
        int c = Integer.parseInt(paramter);
        return c;
    }
    public static String equationResults(int a,int b,int c){
        int root = b*b-4*a*c;
        String result="";
        if (root<0)
            result = "no results";
        if (root==0){
            double oneAnswer;
            oneAnswer=(b*-1)/(a*2);
            result="x= "+oneAnswer;
        }
        if (root>0){
            double e=Math.sqrt(root);
            int x1 =(-b+root)/(a*2);
            int x2 = (-b-root)/(a*2);
            result="x1 ="+x1+" x2= "+x2;
        }
        return result;
    }
}
