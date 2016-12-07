package springapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable {
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "price")
    private Double price;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}