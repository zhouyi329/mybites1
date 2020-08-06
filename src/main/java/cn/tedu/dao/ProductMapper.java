package cn.tedu.dao;

import cn.tedu.entity.Product;
import org.apache.ibatis.annotations.*;

public interface ProductMapper {
    @Insert({"insert into product" ,
            "(name,category,band,description)",
            "values",
            "(#{name},#{category},#{band},#{description})"
    })
    int insertProduct(Product product);

    @Update({"update product",
            "set",
            "name=#{name},",
            "category=#{category},",
            "band=#{band},",
            "description=#{description}",
            "where id=#{id}"

    })
    int updateProduct(Product product);

    @Update("update  product set name=#{name} where id=#{id}")
    public int updateProductUsername(@Param("name")String name,@Param("id")Integer id);

    @Select("select*from product where band=#{band}")
     Product updateProductBan(String band);



    @Delete("delete from product where id=#{id}")
    int deleteProduct(Integer id);





}
