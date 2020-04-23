package mateacademy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;
import mateacademy.internetshop.dao.ProductDao;
import mateacademy.internetshop.db.Storage;
import mateacademy.internetshop.lib.Inject;
import mateacademy.internetshop.lib.Service;
import mateacademy.internetshop.model.Product;
import mateacademy.internetshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean deletedById(Long id) {
        return productDao.deletedById(id);
    }

    @Override
    public boolean deletedByProduct(Product product) {
        return productDao.deletedByProduct(product);
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }
}
