package cn.tedu.test;

import cn.tedu.config.Config;
import cn.tedu.dao.ProductMapper;
import cn.tedu.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestCase {
    AnnotationConfigApplicationContext ctx;
    @Before
    public  void init(){
        ctx=new AnnotationConfigApplicationContext(Config.class);
    }
    @After
    public  void destory(){
        ctx.close();
    }
    @Test
    public void testInsertProduct(){
        Product product=new Product();
        product.setName("华为手机P30");
        product.setCategory("手机");
        product.setBand("华为");
        product.setDescription("智能手机");
        ProductMapper productMapper=ctx.getBean(ProductMapper.class);
        int n=productMapper.insertProduct(product);
        System.out.println(n);
    }
    @Test
    public  void testUpdateProduct(){
        Product product=new Product();
        product.setId(3);
        product.setName("vivoP20");
        product.setCategory("手机");
        product.setBand("vivo");
        product.setDescription("智能手机");
        ProductMapper productMapper=ctx.getBean(ProductMapper.class);
        int n=productMapper.updateProduct(product);
        System.out.println(n);
    }
    @Test
    public void testUpdateUsername(){
        ProductMapper productMapper=ctx.getBean(ProductMapper.class);
        int n=productMapper.updateProductUsername("vivoRENO",3);
        System.out.println(n);
    }



    @Test
    public void testDeleteProduct(){
        ProductMapper productMapper=ctx.getBean(ProductMapper.class);
        int n=productMapper.deleteProduct(4);
        System.out.println(n);
    }
    @Test
    public void selectgetByBan(){
        ProductMapper productMapper=ctx.getBean(ProductMapper.class);
        Product product=productMapper.updateProductBan("华为");
        System.out.println(product);

    }





}
