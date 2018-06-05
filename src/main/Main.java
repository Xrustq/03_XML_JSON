package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.entity.Products;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {






    public static void main(String[] args) throws Exception {

        Actions actions = new Actions();

//            Product product = new Product();
//            product.setManufacturer("Manufacturer");
//            product.setColor("Color");
//            product.setCount(1);
//            product.setDate("2016-01-01");
//            product.setModel("Model");
//            product.setPrice(2);
//
//            Subcategory subcategory = new Subcategory();
//            subcategory.setProduct(new ArrayList<>());
//            List<Product> productList = subcategory.getProduct();
//            productList.add(product);
//            subcategory.setSubcategoryName("subcategory");
//
//            Category category = new Category();
//            category.setSubcategory(new ArrayList<>());
//            List<Subcategory> subcategoryList = category.getSubcategory();
//            subcategoryList.add(subcategory);
//            category.setCategoryName("category");
//
//            Products products = new Products();
//            products.setCategory(new ArrayList<>());
//            List<Category> categoryList = products.getCategory();
//            categoryList.add(category);


        Products products = actions.unmarshall(new File("C:\\Users\\Rustam_Mirgazizov\\Desktop\\EPAM Training\\03_XML_JSON\\src\\resources\\products.xml"));

//        actions.print(products);
//        actions.marshall(products, new File("D:\\file.xml"));

//        Gson gson = new Gson();
//        String json = gson.toJson(products);
//        System.out.println(json);
//        try (FileWriter writer = new FileWriter("C:\\Users\\Rustam_Mirgazizov\\Desktop\\EPAM Training\\03_XML_JSON\\src\\resources\\staff.json")) {
//
//            gson.toJson(products, writer);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        actions.XmlToJson(products, new File("C:\\Users\\Rustam_Mirgazizov\\Desktop\\EPAM Training\\03_XML_JSON\\src\\resources\\staff.json"));
        actions.JsonToXml(new File("C:\\Users\\Rustam_Mirgazizov\\Desktop\\EPAM Training\\03_XML_JSON\\src\\resources\\staff.json"),
                new File("C:\\Users\\Rustam_Mirgazizov\\Desktop\\EPAM Training\\03_XML_JSON\\src\\resources\\test.xml"));
    }
}
