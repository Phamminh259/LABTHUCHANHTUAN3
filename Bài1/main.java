
package product;
import java.text.DecimalFormat;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



public class main {
    public static void main (String [] args){
        Scanner sc=new Scanner (System.in);
        
        System.out.println("nhap ma hoa don");
        int orderID =sc.nextInt ();
        System.out.println("nhap ngay lap hoa don(dd/MM/yyyy): ");
        String orderDateStr =sc.next();
        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate orderDate =LocalDate.parse(orderDateStr,dateFormatter);
        
        
     Order order =new Order (orderID,orderDate );
     boolean continueAdding =true;
     while (continueAdding){
         System.out.println("nhap ten san pham");
         String productName =sc.next();
         sc.nextLine();
         
         System.out.println("nhap ma san pham");
         String productID =sc.nextLine();
         System.out.println("nhap don gia ");
         double price =sc.nextDouble ();
         System.out.println("nhap so lương");
         int quantily=sc.nextInt ();
         
         Product product=new Product(productName, productID,price);
         order.addLineItems(product, quantily);
         
         
         System.out.print("tiep tuc them san pham ?(y/n):");
         String choise =sc.next();
         continueAdding=choise.equalsIgnoreCase("y");
         
         
         
         
     }
     
        System.out.println("ma hoa don"+order.getOrderID());
        String formattedDate = order.getOrderDate().format(dateFormatter);
        System.out.println("ngay lap hoa don"+formattedDate);
        System.out.println("STT    | ma SP  | mo ta| don  gia | so luong|thanh tien");
        DecimalFormat decimalFormat =new DecimalFormat("#,### VND");
        List<OrderDetail> lineItems=order.getLineItems();
        int stt=1;
        for (OrderDetail orderDetail : lineItems){
            System.out.printf("%-10s|  %-10s|  %-10s|   %-10s|   %-10s| %-10s\n  ",
                    stt,
                    orderDetail.getProduct().getProductID(),
                    orderDetail.getProduct().getDes(),
                    decimalFormat.format(orderDetail.getProduct().getPrice()),
                    orderDetail.getQuantily(),
                    decimalFormat.format(orderDetail.calcTotalPrice()));
            stt++;
            
        }
        System.out.println("tong tien thanh toan "+decimalFormat.format(order.calcTotalCharge(0)));
        
        
        
        
        
        
        
    }
    
    
    
}
