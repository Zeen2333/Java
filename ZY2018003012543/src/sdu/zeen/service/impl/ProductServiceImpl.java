package sdu.zeen.service.impl;

import sdu.zeen.dao.ProductDao;
import sdu.zeen.dao.impl.ProductDaoImpl;
import sdu.zeen.pojo.Product;
import sdu.zeen.service.ProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    ProductDao pd=new ProductDaoImpl();
    @Override
    public ArrayList<Product> checkProductService() {
        return pd.checkProductDao();
    }
}
