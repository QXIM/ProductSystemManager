import com.neuedu.MyBatis.*;
import com.neuedu.dao.*;
import com.neuedu.entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLogin {


    public  void testCheckUser(){

        UserDao userdao=new MyBatisloginImpl();
        userdao.checkUser("zhaosi","123");

    }

    public void testFindProductByPage(){

        ProductDao productDao=new MyBatisProductImpl();
        productDao.findProductByPage(1,3);

    }

    public  void  testDeleteProduct(){
        ProductDao productDao=new MyBatisProductImpl();
        productDao.deleteProduct(40);
    }

    public void testUpdateProduct(){
        Product product=new Product(50, "789", "789", 123,"789","200");
        ProductDao productDao=new MyBatisProductImpl();
        productDao.updateProduct(product);
    }

    public  void testAddProduct(){

        Product product=new Product("789", "789", 123,"789");

        ProductDao productDao=new MyBatisProductImpl();
        productDao.addProduct(product);


    }

    public void testFindCategoryByPage(){

        CategoryDao productDao=new MyBatisCategoryImpl();
        productDao.findAll(2,3);

    }

    public  void TestsubString()  {
        String s = "sunjavacjavaeeejavapuujavakkkjava";
        int y = 0;
        while (s.indexOf("java")!=-1){
            y++;
            s = s.substring(s.indexOf("java")+4);
        }
        System.out.println(y);
    }

    public void TestIndexOf(){

        String s="javacCjavaC";

        System.out.println(s.indexOf("c"));


    }

    public void testAddCategory(){
        CategoryDao categorydao=new MyBatisCategoryImpl();
     Category ca=   new Category(111, "����", 1, 1, 2018,2018);
        categorydao.addCategory(ca);

    }

    public void testDeleteCategory(){
        CategoryDao categorydao=new MyBatisCategoryImpl();
        categorydao.deleteCategory(20);

    }

    public void testUpdateCategory(){
        CategoryDao categorydao=new MyBatisCategoryImpl();
        Category ca=   new Category();
        ca.setCategoryid(15);
        ca.setName("bbb");

        categorydao.updateCategory(ca);

    }


    public void testAddOrder(){

        OrderDao orderdao=new MyBatisOrderImpl();
        Order order=new Order();
        order.setPostage(12);
        order.setPayment(2000);
        orderdao.addOrder(order);


    }


    public void testFindAllOrder(){
        OrderDao orderdao=new MyBatisOrderImpl();
        orderdao.findAll();


    }



    public void testFindProductById(){

        ProductDao productDao=new MyBatisProductImpl();
        productDao.findproductById(1);

    }
    public void testAddOrderItem(){

        OrderItemDao orderItemDao=new MyBatisOrderItemImpl();
        List<OrderItem> o=new ArrayList<OrderItem>();

        orderItemDao.addOrderItem(o);

    }

    public void testAddCart(){

    CartDao cartDao=new MyBatisCartImpl();
        Cart cart =new Cart();
        Product product=new Product(50, "789", "789", 123,"789","20");

        cart.setQuantity(200);
        cart.setProduct(product);
    cartDao.addCart(cart);

    }

    public void testfindAllCart(){
        CartDao cartDao=new MyBatisCartImpl();
        cartDao.findAllCart();
}


   /* public void  testAddOrderItemi(){
    OrderItemDao orderItemDao=new MyBatisOrderItemImpl();
        Product product=new Product(50, "789", "789", 123,"789");
        List<Product>
        List<OrderItem> list=new ArrayList<OrderItem>();
        list.addAll(cart);
        orderItemDao.addOrderItem(list);

    }*/
   @Test
    public void testorderItem(){
        OrderDao orderDao=new MyBatisOrderImpl();
        orderDao.findOrderItemByOrderNo(1533112716928L);
    }

    public void testdeletecart(){

    CartDao cartDao=new     MyBatisCartImpl();
    cartDao.deleteCart(1);

    }


    public void testclearCart(){
        CartDao cartDao=new     MyBatisCartImpl();
        cartDao.clearCart();
    }



    public  void testupdatecart(){

        CartDao cartDao=new     MyBatisCartImpl();
        cartDao.updateCartNum(36,2);
    }

    public void testfindbyid(){
        CartDao cartDao=new     MyBatisCartImpl();
        cartDao.findById(40);
    }

    @Test
    public void testint(){
        int i=2;
        int y=i++/3;
        System.out.println(y);


    }
    @Test
    public void testCharAt(){
    String str="Stock3num00Amar38sf0";
    String str2="";

if (str!=null&&!str.equals(""))
    {
    for (int i=0;i<str.length();i++){
    if (str.charAt(i)>=48&&str.charAt(i)<=57){
            str2+=str.charAt(i);
        }
    }
} System.out.println(str2);
    }








}




