package ra;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException{
            int[] arr  ={1,2,3,4,5};
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        s.parse("12/10/1999");
        try{
            System.out.println(getArea(1,2,2));
        }catch (InvalidTriangleSideException | IllegalArgumentException e){
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("vào khối finally");
        }

        System.out.println("chuyowng trình tiep tuc");
    }
    public static  double getArea(double a, double b, double c) throws InvalidTriangleSideException,IllegalArgumentException{
        if (a<=0||b<=0||c<=0){
            // ném ra ngoại lê
            throw new IllegalArgumentException("Cạnh không thể bes hơn hoặc bằng 0 : a="+a+",b="+b+",c="+c);
        }
        if (a+b<=c||b+c<=a||c+a<=b){
            throw new InvalidTriangleSideException("tổng 2 cạnh phải lớn hơn cạnh còn lai : a="+a+",b="+b+",c="+c);
        }
        double p = (a+b+c)/2;
        return  Math.pow(p*(p-a)*(p-b)*(p-c),0.5);
    }
}
