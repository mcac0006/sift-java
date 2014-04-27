/**
 * 
 */
package com.mcac0006.siftscience.types;

import java.util.Arrays;
import java.util.Currency;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.event.domain.AddItemToCart;
import com.mcac0006.siftscience.event.domain.RemoveItemFromCart;

/**
 * 
 * This class represents a product or service for sale in your business. Generally used when 
 * using {@link AddItemToCart} and {@link RemoveItemFromCart} events.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class Item {

	@JsonProperty("$item_id")
	private String itemId;
	
	@JsonProperty("$product_title")
	private String productTitle;
	
	/**
	 * The item unit price in micros, in the base unit of the {@link #currency}. 
	 * 1 cent = 10,000 micros. 
	 * $1.23 USD = 123 cents = 1,230,000 micros.
	 */
	@JsonProperty("$price")
	private Long price;
	
	/**
	 * <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO-4217</a> currency code for the price.
	 */
	@JsonProperty("$currency_code")
	private String currency;
	
	/**
	 * Quantity of the item.
	 */
	@JsonProperty("$quantity")
	private Integer quantity;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/Universal_Product_Code">Universal Product Code</a> of the item, if available.
	 */
	@JsonProperty("$upc")
	private String UPC;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/Stock_keeping_unit">Stock Keeping Unit</a>, if available.
	 */
	@JsonProperty("$sku")
	private String SKU;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/International_Standard_Book_Number">International Standard Book Number</a>, if available.
	 */
	@JsonProperty("$isbn")
	private String ISBN;
	
	/**
	 * The brand name of the item.
	 */
	@JsonProperty("$brand")
	private String brand;
	
	/**
	 * Name of the item’s manufacturer.
	 */
	@JsonProperty("$manufacturer")
	private String manufacturer;
	
	/**
	 * The category this item is listed under in your business. e.g., "kitchen appliance", "mens wear > pants"
	 */
	@JsonProperty("$category")
	private String category;
	
	/**
	 * The tags used to describe this item in your business. e.g., "funny", "halloween"
	 */
	@JsonProperty("$tags")
	private String[] tags;
	
	/**
	 * The color of the item.
	 */
	@JsonProperty("$color")
	private String color;
	
	/**
	 * The size of the item.
	 */
	@JsonProperty("$size")
	private String size;

	public String getItemId() {
		return itemId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public Long getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getUPC() {
		return UPC;
	}

	public String getSKU() {
		return SKU;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getBrand() {
		return brand;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public String[] getTags() {
		return tags;
	}

	public String getColor() {
		return color;
	}

	public String getSize() {
		return size;
	}

	public Item setItemId(String itemId) {
		this.itemId = itemId;
		return this;
	}

	public Item setProductTitle(String productTitle) {
		this.productTitle = productTitle;
		return this;
	}

	public Item setPrice(Long price) {
		this.price = price;
		return this;
	}

	public Item setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public Item setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Item setUPC(String uPC) {
		UPC = uPC;
		return this;
	}

	public Item setSKU(String sKU) {
		SKU = sKU;
		return this;
	}

	public Item setISBN(String iSBN) {
		ISBN = iSBN;
		return this;
	}

	public Item setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	public Item setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}

	public Item setCategory(String category) {
		this.category = category;
		return this;
	}

	public Item setTags(String[] tags) {
		this.tags = tags;
		return this;
	}

	public Item setColor(String color) {
		this.color = color;
		return this;
	}

	public Item setSize(String size) {
		this.size = size;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Item)) {
			return false;
		}
		
		final Item item = (Item)obj;
		
		if (this.brand == null) {
			if (item.getBrand() != null) {
				return false;
			}
		} else if (!this.brand.equals(item.getBrand())) {
			return false;
		}
		
		if (this.category == null) {
			if (item.getCategory() != null) {
				return false;
			}
		} else if (!this.category.equals(item.getCategory())) {
			return false;
		}
		
		if (this.color == null) {
			if (item.getColor() != null) {
				return false;
			}
		} else if (!this.color.equals(item.getColor())) {
			return false;
		}
		
		if (this.currency == null) {
			if (item.getCurrency() != null) {
				return false;
			}
		} else if (!this.currency.equals(item.getCurrency())) {
			return false;
		}
		
		if (this.ISBN == null) {
			if (item.getISBN() != null) {
				return false;
			}
		} else if (!this.ISBN.equals(item.getISBN())) {
			return false;
		}
		
		if (this.itemId == null) {
			if (item.getItemId() != null) {
				return false;
			}
		} else if (!this.itemId.equals(item.getItemId())) {
			return false;
		}
		
		if (this.manufacturer == null) {
			if (item.getManufacturer() != null) {
				return false;
			}
		} else if (!this.manufacturer.equals(item.getManufacturer())) {
			return false;
		}
		
		if (this.price == null) {
			if (item.getPrice() != null) {
				return false;
			}
		} else if (!this.price.equals(item.getPrice())) {
			return false;
		}
		
		if (this.productTitle == null) {
			if (item.getProductTitle() != null) {
				return false;
			}
		} else if (!this.productTitle.equals(item.getProductTitle())) {
			return false;
		}
		
		if (this.quantity == null) {
			if (item.getQuantity() != null) {
				return false;
			}
		} else if (!this.quantity.equals(item.getQuantity())) {
			return false;
		}
		
		if (this.size == null) {
			if (item.getSize() != null) {
				return false;
			}
		} else if (!this.size.equals(item.getSize())) {
			return false;
		}
		
		if (this.SKU == null) {
			if (item.getSKU() != null) {
				return false;
			}
		} else if (!this.SKU.equals(item.getSKU())) {
			return false;
		}
		
		if (this.tags == null) {
			if (item.getTags() != null) {
				return false;
			}
		} else if (!Arrays.equals(tags, item.getTags())) {
			return false;
		}
		
		if (this.UPC == null) {
			if (item.getUPC() != null) {
				return false;
			}
		} else if (!this.UPC.equals(item.getUPC())) {
			return false;
		}
		
		return true;
	}
}
