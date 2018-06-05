package main;

import main.entity.Products;

import java.io.File;

public class Main {

    private final static String JSON_PATH = "src\\resources\\vehicle.json";
    private final static String XML_PATH = "src\\resources\\products.xml";
    private final static String SAVE_PATH = "src\\resources\\vehicle.xml";


    public static void main(String[] args) throws Exception {

        Actions actions = new Actions();
        //XML to POJO
        Products products = actions.unmarshall(new File(XML_PATH));

        actions.XmlToJson(products, new File(JSON_PATH));

        actions.JsonToXml(new File(JSON_PATH), new File(SAVE_PATH));
    }
}
