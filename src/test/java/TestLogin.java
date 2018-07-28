import com.neuedu.MyBatis.MyBatisCategoryImpl;
import com.neuedu.MyBatis.MyBatisProductImpl;
import com.neuedu.MyBatis.MyBatisloginImpl;
import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.UserDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.Product;
import org.junit.Test;

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
        Product product=new Product(50, "789", "789", 123,"789");
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
     Category ca=   new Category(111, "±ùÏä", 1, 1, 2018,2018);
        categorydao.addCategory(ca);

    }

    public void testDeleteCategory(){
        CategoryDao categorydao=new MyBatisCategoryImpl();
        categorydao.deleteCategory(20);

    }
    @Test
    public void testUpdateCategory(){
        CategoryDao categorydao=new MyBatisCategoryImpl();
        Category ca=   new Category();
        ca.setCategoryid(15);
        ca.setName("bbb");

        categorydao.updateCategory(ca);

    }



}
