package Exceptions;

public class CustomException  extends Exception{
    String exMassage;
    public CustomException(String exMassage){
        this.exMassage = exMassage;
         printException();
    }
    public void printException(){
        System.out.println(exMassage);
    };
}
