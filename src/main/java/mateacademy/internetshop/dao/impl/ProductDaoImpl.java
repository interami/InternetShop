package mateacademy.internetshop.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import mateacademy.internetshop.dao.ProductDao;
import mateacademy.internetshop.db.Storage;
import mateacademy.internetshop.lib.Dao;
import mateacademy.internetshop.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return Storage.products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        IntStream.range(0, Storage.products.size())
                .filter(x -> product.getId().equals(Storage.products.get(x).getId()))
                .forEach(i -> Storage.products.set(i, product));
        return product;
    }

    @Override
    public boolean deletedById(Long id) {
        return Storage.products.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public boolean deletedByProduct(Product product) {
        return Storage.products.remove(product);
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }
}
