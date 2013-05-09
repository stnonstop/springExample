package com.gg.example.springExample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Parent;

@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="telephone")
	private String telephone;

	@Enumerated(EnumType.STRING)
	@Column(name="phone_type")
	private PhoneType phoneType;
	
	@Parent
	@JsonIgnore
	private Owner owner;
	
	public Address() {
		
	}
	
	public Address(Owner o) {
		this.owner = o;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (!Address.class.isAssignableFrom(o.getClass()))
			return false;
		Address a = (Address) o;
		return new EqualsBuilder().append(this.getAddress(), a.getAddress())
				.append(this.getCity(), a.getCity())
				.append(this.getTelephone(), a.getTelephone()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(this.getAddress())
				.append(this.getCity()).append(this.getTelephone())
				.toHashCode();
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
	}
}
