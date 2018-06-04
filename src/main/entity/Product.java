package main.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlElement
    private String manufacturer;
    @XmlElement
    private String model;
    @XmlElement
    private Date date;
    @XmlElement
    private String color;
    @XmlElement
    private int price;
    @XmlElement
    private int count;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        return  "Product{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", date=" + dateString +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}