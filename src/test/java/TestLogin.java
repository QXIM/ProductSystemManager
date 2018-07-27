import com.neuedu.MyBatis.MyBatisCategoryImpl;
import com.neuedu.MyBatis.MyBatisProductImpl;
import com.neuedu.MyBatis.MyBatisloginImpl;
import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.UserDao;
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
    @Test
    public void testFindCategoryByPage(){

        CategoryDao productDao=new MyBatisCategoryImpl();
        productDao.findAll(2,3);

    }



}
