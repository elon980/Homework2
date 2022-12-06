public class ex2 {
    public static void main(String[] args){
    String num = "0543393314";
    String ne = (CheckPhoneNumber(num));
    System.out.println(ne);
    }
    public static String CheckPhoneNumber(String number){
        String newNum = "";
        if (number.length()==10 && number.substring(0, 2).equals("05")){
            newNum="05"+number.charAt(2)+"-"+number.substring(3,10);
        }
        if (number.length() == 11 && number.substring(0, 2).equals("05") && number.charAt(3) == '-')
            newNum=number;
        if (number.length() == 12 && number.substring(0, 3).equals("972"))
            newNum="05"+number.charAt(4)+"-"+number.substring(5,12);
        return newNum;
    }
}
