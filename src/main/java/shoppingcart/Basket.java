package shoppingcart;

import java.io.IOException;
import java.util.*;

public class Basket {
    Map<ItemInfo, Integer> cart = new LinkedHashMap<ItemInfo, Integer>();
    Invent invent;

    public Basket() throws IOException {
        invent = new Invent();
    }

    public void addSingleItemToCart(ItemInfo it){
        if(invent.validateItem(it)){
            if(invent.getItemStock(it)>0){
                if(cart.size()== 0){
                    cart.put(it,1);
                }
                else{
                    if(cart.containsKey(it)) {
                        Integer quan = cart.get(it);
                        quan = quan + 1;
                        cart.put(it, quan);
                    }
                    else {cart.put(it,1);

                    }}}}}

    public void addMultipleItemsToCart(ItemInfo it, Integer quantity){
        if(invent.validateItem(it)){
            if(invent.getItemStock(it)>=quantity){
                if (cart.size()==0){
                    cart.put(it,quantity);
                }
                else{
                    if(cart.containsKey(it)){
                        Integer quan = cart.get(it);
                        quan = quan+quantity;
                        cart.put(it,quan);
                    }
                    else{cart.put(it,quantity);

                }}}}}

    public void getCartContents() {
        ItemInfo[] cartarraykeys = cart.keySet().toArray(new ItemInfo[cart.size()]);
        Integer [] cartarrayvalues = cart.values().toArray(new Integer[cart.size()]);
        System.out.println("Cart item information as Array  "+ (Arrays.toString(cartarraykeys)));

        System.out.println("Quantity of each item as Array  "+ (Arrays.toString(cartarrayvalues)));

    }

    public void removeItemFromCart(ItemInfo it){
            if (invent.validateItem(it)) {
                if(cart.containsKey(it)){
                Integer i = cart.get(it);
                if (i > 1) {
                    i--;
                    cart.put(it, i);
                    //System.out.println("Removed item from cart   "+cart);
                } else if (i == 1) {
                    cart.remove(it);
                    // System.out.println("Removed item from cart   "+cart);
                } else System.out.println("Item not in the cart");
            }}
        }


    public void totalCost(){
        long totalcost=0;
        if (cart.size() !=0){
            for(Map.Entry<ItemInfo,Integer> listofitems: cart.entrySet()){
               double priceofitems = listofitems.getKey().getItemprice();
               long priceperitem = (long) priceofitems * listofitems.getValue();
               totalcost = totalcost+priceperitem;
            }
            System.out.println("The Cost to Customer is   "+ totalcost);
        }
    }

    public void checkout(){
        System.out.println("These are the items in the cart  "+cart);
        for(Map.Entry<ItemInfo,Integer> listofitems:cart.entrySet()){
            System.out.println(invent.reduceStock(listofitems.getKey(), listofitems.getValue()));
        }
    }


    public static void main(String[] args) throws IOException {
        Basket sh = new Basket();
        ItemInfo in1 = new ItemInfo(1001,"IPhone12","Apple",800.0);
        ItemInfo in3 = new ItemInfo(1003,"Pro20","Huawei",740.0);
        ItemInfo in2 = new ItemInfo(1002, "S10", "Samsung", 830.0);
       sh.addSingleItemToCart(in1);
       //sh.addSingleItemToCart(in2);
        //sh.addSingleItemToCart(in1);
       // sh.addMultipleItemsToCart(in2,2);
        //sh.addMultipleItemsToCart(in3,4);
       // sh.addMultipleItemsToCart(in1,10);
        sh.removeItemFromCart(in1);
      //  sh.removeItemFromCart(in3);
       // sh.getCartContents();
        sh.totalCost();
        sh.checkout();
        //sh.addSingleItemToCart(in1);
        //sh.addSingleItemToCart(in2);
        //sh.addSingleItemToCart(in3);
    }
}
