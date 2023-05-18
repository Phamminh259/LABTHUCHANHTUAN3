
package product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private LocalDate OrderDate;
    private List <OrderDetail> lineItems;
    
    public Order (){
        lineItems=new ArrayList<> ();
    }
    
    
    public Order (int orderID,LocalDate orderDate){
        this.orderID=orderID;
        this.OrderDate=OrderDate;
        lineItems=new ArrayList <>();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate OrderDate) {
        this.OrderDate = OrderDate;
    }
  
    
    public List <OrderDetail> getLineItems (){
        return lineItems;
        
    }
    public void addLineItems(Product product ,int quantily){
        lineItems.add(new OrderDetail(quantily,product));
        
    }
    public double calcTotalCharge (int n){
        double totalCharge =0;
        int count=0;
        for (int i=n;count <lineItems.size();i++){
            OrderDetail orderDetail =lineItems.get(count);
            totalCharge+=orderDetail.calcTotalPrice();
            count ++;
           
            
        }
        return totalCharge;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", OrderDate=" + OrderDate + ", lineItems=" + lineItems + '}';
    }

            
        
        
    }
    
    
    
    
    
    

