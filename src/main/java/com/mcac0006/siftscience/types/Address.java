/**
 * 
 */
package com.mcac0006.siftscience.types;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This represents a physical address, such as a billing or shipping address. 
 * Sift Science extracts many geolocation features from these values.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Address {

	@JsonProperty("$name")
	private String name;
	
	/**
	 * Billing address first line, e.g., "2100 Main Street".
	 */
	@JsonProperty("$address_1")
	private String addressLine1;
	
	/**
	 * Billing address second line, e.g., "Apt 3B".
	 */
	@JsonProperty("$address_2")
	private String addressLine2;
	
	/**
	 * The city or town name.
	 */
	@JsonProperty("$city")
	private String city;
	
	/**
	 * The region portion of the address. In the USA, this corresponds to the state.
	 */
	@JsonProperty("$region")
	private String region;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO-3166</a> country code for the billing address.
	 */
	@JsonProperty("$country")
	private String country;
	
	@JsonProperty("$zipcode")
	private String zipCode;
	
	@JsonProperty("$phone")
	private String phone;
	

	public String getName() {
		return name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getCountry() {
		return country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public Address setName(String name) {
		this.name = name;
		return this;
	}

	public Address setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public Address setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public Address setRegion(String region) {
		this.region = region;
		return this;
	}

	public Address setCountry(String country) {
		this.country = country;
		return this;
	}

	public Address setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public Address setPhone(String phone) {
		this.phone = phone;
		return this;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
        result = prime * result
                + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Address)) {
            return false;
        }
        
        final Address address = (Address)obj;
        
        if (this.addressLine1 == null) {
            if (address.getAddressLine1() != null) {
                return false;
            }
        } else if (!this.addressLine1.equals(address.getAddressLine1())) {
            return false;
        }
        
        if (this.addressLine2 == null) {
            if (address.getAddressLine2() != null) {
                return false;
            }
        } else if (!this.addressLine2.equals(address.getAddressLine2())) {
            return false;
        }
        
        if (this.city == null) {
            if (address.getCity() != null) {
                return false;
            }
        } else if (!this.city.equals(address.getCity())) {
            return false;
        }
        
        if (this.country == null) {
            if (address.getCountry() != null) {
                return false;
            }
        } else if (!this.country.equals(address.getCountry())) {
            return false;
        }
        
        if (this.name == null) {
            if (address.getName() != null) {
                return false;
            }
        } else if (!this.name.equals(address.getName())) {
            return false;
        }
        
        if (this.phone == null) {
            if (address.getPhone() != null) {
                return false;
            }
        } else if (!this.phone.equals(address.getPhone())) {
            return false;
        }
        
        if (this.region == null) {
            if (address.getRegion() != null) {
                return false;
            }
        } else if (!this.region.equals(address.getRegion())) {
            return false;
        }
        
        if (this.zipCode == null) {
            if (address.getZipCode() != null) {
                return false;
            }
        } else if (!this.zipCode.equals(address.getZipCode())) {
            return false;
        }
        
        return true;
    }
	
}
