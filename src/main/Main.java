package main;

import main.entity.Category;;
import main.entity.Product;
import main.entity.Products;
import main.entity.Subcategory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/resources/products.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        JAXBContext jc = JAXBContext.newInstance(Products.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<Products> jb = unmarshaller.unmarshal(xsr, Products.class);
        xsr.close();

        Products products = jb.getValue();

        List<Category> productsList = products.getCategory();
        for (Category category : productsList) {
            System.out.println(category);
            List<Subcategory> subcategoryList = category.getSubcategory();
            for (Subcategory subcategory: subcategoryList) {
                System.out.println(subcategory);
                List<Product> productList = subcategory.getProduct();
                for (Product product: productList) {
                    System.out.println(product);
                }
            }

            
        }

    }
}
