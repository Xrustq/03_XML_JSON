package main;

import com.google.gson.Gson;
import main.entity.Category;
import main.entity.Product;
import main.entity.Products;
import main.entity.Subcategory;

import javax.xml.bind.*;
import java.io.*;
import java.util.List;

public class Actions {

    public void marshall(Products products, File file) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(products, file);
//            jaxbMarshaller.marshal(products, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Products unmarshall(File file) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(Products.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Products products = (Products) unmarshaller.unmarshal(file);
        return products;
    }

    public void XmlToJson(Products products, File file) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(file)) {

            gson.toJson(products, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void JsonToXml(File json, File xml) {
        Gson gson = new Gson();
        Products products;

        try (Reader reader = new FileReader(json)) {

            // Convert JSON to Java Object
            products = gson.fromJson(reader, Products.class);

            marshall(products, xml);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(Products products) {
        List<Category> productsList = products.getCategory();
        for (Category category : productsList) {
            System.out.println(category);
            List<Subcategory> subcategoryList = category.getSubcategory();
            for (Subcategory subcategory : subcategoryList) {
                System.out.println(subcategory);
                List<Product> productList = subcategory.getProduct();
                for (Product product : productList) {
                    System.out.println(product);
                }
            }
        }
    }
}
