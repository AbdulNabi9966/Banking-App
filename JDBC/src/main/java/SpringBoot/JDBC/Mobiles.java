package SpringBoot.JDBC;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mobiles {
private String name;
private int price;
private int ram;
private int storage;
private int mobile_id;
@Override
public String toString() {
	return "Mobiles [name=" + name + ", price=" + price + ", ram=" + ram + ", storage=" + storage + ", mobile_id="
			+ mobile_id + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getRam() {
	return ram;
}
public void setRam(int ram) {
	this.ram = ram;
}
public int getStorage() {
	return storage;
}
public void setStorage(int storage) {
	this.storage = storage;
}
public int getMobile_id() {
	return mobile_id;
}
public void setMobile_id(int mobile_id) {
	this.mobile_id = mobile_id;
}
}
