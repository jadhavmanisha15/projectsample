package reports;

public class SwapingNumber {

	public static void main(String[] args) {
     int a=20;
     int b=30;
     
     System.out.println("value of a is"+a);
     System.out.println("value of b is"+b);
     
     System.out.println("After Swaping");
     
     int temp=a;
         a=b;
         b=temp;
         
         System.out.println("value of a is"+a);
         System.out.println("value of b is"+b);
         
	}

}
