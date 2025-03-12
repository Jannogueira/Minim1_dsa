import models.Order;
import models.Product;
import models.User;

import java.util.*;

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
        Collections.sort(ordProducts, Comparator.comparingDouble(Product::getPrice));
        return ordProducts;
    }

    @Override
    public void addOrder(Order order) {
        orderQueue.add(order);
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
        // TO-DO

        return order;
    }

    @Override
    public Product getProduct(String c1) {

        return null;
    }

    @Override
    public User getUser(String number) {
        //for(int i; i<users.size(); i++){}
            //if(users[i].)
              //  return
        return null;
    }
}
