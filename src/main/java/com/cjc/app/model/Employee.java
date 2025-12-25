package com.cjc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;

@XmlRootElement
@Entity
@DynamicUpdate
@Table(name = "EMPLOYEE_DTLS")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer eid;

	@Column(name = "EMPLOYEE_NAME")
	private String name;

	@Column(name = "EMPLOYEE_ADDRESS")
	private String address;

	@Column(name = "EMPLOYEE_DESIGNATION")
	private String designation;

	@Column(name = "EMPLOYEE_SALARY")
	private Double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer eid, String name, String address, String designation, Double salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.address = address;
		this.designation = designation;
		this.salary = salary;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}

}
