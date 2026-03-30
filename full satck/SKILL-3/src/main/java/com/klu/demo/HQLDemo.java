package com.klu.demo;

import com.klu.entity.Product;
import com.klu.loader.ProductDataLoader;
import com.klu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            // Uncomment below to load sample data (run once only)
            // ProductDataLoader.loadSampleProducts(session);

            // Task 3a: Sort by price ascending
            sortProductsByPriceAscending(session);

            // Task 3b: Sort by price descending
            sortProductsByPriceDescending(session);

            // Task 4: Sort by quantity descending
            sortProductsByQuantityDescending(session);

            // Task 5a: First 3 products
            getFirstThreeProducts(session);

            // Task 5b: Next 3 products
            getNextThreeProducts(session);

            // Task 6a: Count total products
            countTotalProducts(session);

            // Task 6b: Count products in stock
            countProductsInStock(session);

            // Task 6c: Count by description
            countProductsByDescription(session);

            // Task 6d: Min/Max price
            findMinMaxPrice(session);

            // Task 7: Group by description
            groupProductsByDescription(session);

            // Task 8: Price range filter
            filterProductsByPriceRange(session, 20.0, 100.0);

            // Task 9a: Names starting with 'D'
            findProductsStartingWith(session, "D");

            // Task 9b: Names ending with 'p'
            findProductsEndingWith(session, "p");

            // Task 9c: Names containing 'Desk'
            findProductsContaining(session, "Desk");

            // Task 9d: Names with exact length
            findProductsByNameLength(session, 5);

        } finally {
            session.close();
            factory.close();
        }
    }

    // Task 3a: Sort ascending
    public static void sortProductsByPriceAscending(Session session) {
        String hql = "FROM Product p ORDER BY p.price ASC";
        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();
        System.out.println("\n=== Products Sorted by Price (Ascending) ===");
        for (Product p : products) System.out.println(p);
    }

    // Task 3b: Sort descending
    public static void sortProductsByPriceDescending(Session session) {
        String hql = "FROM Product p ORDER BY p.price DESC";
        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();
        System.out.println("\n=== Products Sorted by Price (Descending) ===");
        for (Product p : products) System.out.println(p);
    }

    // Task 4
    public static void sortProductsByQuantityDescending(Session session) {
        String hql = "FROM Product p ORDER BY p.quantity DESC";
        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();
        System.out.println("\n=== Products Sorted by Quantity (Highest First) ===");
        for (Product p : products) System.out.println(p.getName() + " - Quantity: " + p.getQuantity());
    }

    // Task 5a
    public static void getFirstThreeProducts(Session session) {
        String hql = "FROM Product p";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setFirstResult(0);
        query.setMaxResults(3);
        List<Product> products = query.list();
        System.out.println("\n=== First 3 Products ===");
        for (Product p : products) System.out.println(p);
    }

    // Task 5b
    public static void getNextThreeProducts(Session session) {
        String hql = "FROM Product p";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setFirstResult(3);
        query.setMaxResults(3);
        List<Product> products = query.list();
        System.out.println("\n=== Next 3 Products ===");
        for (Product p : products) System.out.println(p);
    }

    // Task 6a
    public static void countTotalProducts(Session session) {
        String hql = "SELECT COUNT(p) FROM Product p";
        Query<Long> query = session.createQuery(hql, Long.class);
        Long count = query.uniqueResult();
        System.out.println("\n=== Total Number of Products ===");
        System.out.println("Total Products: " + count);
    }

    // Task 6b
    public static void countProductsInStock(Session session) {
        String hql = "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0";
        Query<Long> query = session.createQuery(hql, Long.class);
        Long count = query.uniqueResult();
        System.out.println("\n=== Products in Stock (Quantity > 0) ===");
        System.out.println("Products in Stock: " + count);
    }

    // Task 6c
    public static void countProductsByDescription(Session session) {
        String hql = "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description";
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.list();
        System.out.println("\n=== Products Grouped by Description ===");
        for (Object[] r : results) System.out.println(r[0] + ": " + r[1] + " products");
    }

    // Task 6d
    public static void findMinMaxPrice(Session session) {
        String hql = "SELECT MIN(p.price), MAX(p.price) FROM Product p";
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        Object[] result = query.uniqueResult();
        System.out.println("\n=== Price Range ===");
        System.out.println("Minimum Price: $" + result[0]);
        System.out.println("Maximum Price: $" + result[1]);
    }

    // Task 7
    public static void groupProductsByDescription(Session session) {
        String hql = "SELECT p.description, p.name, p.price FROM Product p ORDER BY p.description";
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.list();
        System.out.println("\n=== Products Grouped by Description ===");
        String current = "";
        for (Object[] r : results) {
            String desc = (String) r[0];
            if (!desc.equals(current)) {
                System.out.println("\n" + desc + ":");
                current = desc;
            }
            System.out.println("  - " + r[1] + " ($" + r[2] + ")");
        }
    }

    // Task 8
    public static void filterProductsByPriceRange(Session session, double min, double max) {
        String hql = "FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("minPrice", min);
        query.setParameter("maxPrice", max);
        List<Product> products = query.list();
        System.out.println("\n=== Products Between $" + min + " and $" + max + " ===");
        for (Product p : products) System.out.println(p.getName() + " - $" + p.getPrice());
    }

    // Task 9a
    public static void findProductsStartingWith(Session session, String prefix) {
        Query<Product> query = session.createQuery("FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", prefix + "%");
        System.out.println("\n=== Products Starting with '" + prefix + "' ===");
        for (Product p : query.list()) System.out.println(p.getName());
    }

    // Task 9b
    public static void findProductsEndingWith(Session session, String suffix) {
        Query<Product> query = session.createQuery("FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", "%" + suffix);
        System.out.println("\n=== Products Ending with '" + suffix + "' ===");
        for (Product p : query.list()) System.out.println(p.getName());
    }

    // Task 9c
    public static void findProductsContaining(Session session, String substring) {
        Query<Product> query = session.createQuery("FROM Product p WHERE p.name LIKE :pattern", Product.class);
        query.setParameter("pattern", "%" + substring + "%");
        System.out.println("\n=== Products Containing '" + substring + "' ===");
        for (Product p : query.list()) System.out.println(p.getName());
    }

    // Task 9d
    public static void findProductsByNameLength(Session session, int length) {
        Query<Product> query = session.createQuery("FROM Product p WHERE LENGTH(p.name) = :length", Product.class);
        query.setParameter("length", length);
        System.out.println("\n=== Products with Name Length " + length + " ===");
        for (Product p : query.list()) System.out.println(p.getName() + " (Length: " + p.getName().length() + ")");
    }
}
