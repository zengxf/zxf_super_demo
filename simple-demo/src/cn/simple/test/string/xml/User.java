package cn.simple.test.string.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "user" )
public class User {

    private String name;
    @XmlElement( name = "token" )
    private String pwd;
    private int	   age;
    private String address;
    private String note;

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge( int age ) {
	this.age = age;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress( String address ) {
	this.address = address;
    }

    public String getNote() {
	return note;
    }

    public void setNote( String note ) {
	this.note = note;
    }

    public String getPwd() {
	return pwd;
    }

    @Override
    public String toString() {
	return "User [name=" + name + ", pwd=" + pwd + ", age=" + age + ", address=" + address + ", note=" + note + "]";
    }

}
