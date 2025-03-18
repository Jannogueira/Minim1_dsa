import models.Order;
import models.Product;
import models.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProductManagerImpl implements ProductManager {
    private List<Product> productList;
    private Queue<Order> orderQueue;
    private List<User> userList;


    public ProductManagerImpl() {
        productList = new ArrayList<>();
        orderQueue = new LinkedList<>();
    }

    @Override
    public void addProduct(String id, String name, double price) {
        productList.add(new Product(id, name, price));
    }

    @Override
    public List<Product> getProductsByPrice() {
        List<Product> ordProducts = new ArrayList<>();
        ordProducts.addAll(productList);
        Collections.sort(ordProducts, Comparator.comparingDouble(Product::getPrice).reversed());
        return ordProducts;
    }

    @Override
    public void addOrder(Order order) {
        AtomicBoolean encontrado = new AtomicBoolean(false);
        orderQueue.add(order);
        /*if(!(userList ==null)) {
            userList.forEach(user -> {
                if(user.getDni().equals(order.getUser())){
                    user.setOrder(order);
                    encontrado.set(true);
                }
            });
        }
        if(!encontrado.get()) {
            User nuevoUsuario = new User(order.getUser());
            nuevoUsuario.setOrder(order);
            userList.add(nuevoUsuario);
        }*/
    }

    @Override
    public int numOrders() {
        if (!orderQueue.isEmpty())
            return orderQueue.size();
        return 0;
    }

    @Override
    public Order deliverOrder() {
        Order order = orderQueue.poll();
        order.getContenido().forEach((cantidad, id) -> {
            Product p = getProduct(id);
            p.addSales(cantidad);
        });
        return order;
    }

    @Override
    public Product getProduct(String c1) {
        return productList.stream()
                .filter(p -> p.getId().equals(c1))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUser(String number) {
        return userList.stream()
                .filter(usuario -> usuario.getDni().equals(number))
                .findFirst()
                .orElse(null);
    }
}
