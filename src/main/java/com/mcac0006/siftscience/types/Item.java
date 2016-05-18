/**
 * 
 */
package com.mcac0006.siftscience.types;

import java.util.Arrays;

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
	private String upc;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/Stock_keeping_unit">Stock Keeping Unit</a>, if available.
	 */
	@JsonProperty("$sku")
	private String sku;
	
	/**
	 * The <a href="http://en.wikipedia.org/wiki/International_Standard_Book_Number">International Standard Book Number</a>, if available.
	 */
	@JsonProperty("$isbn")
	private String isbn;
	
	/**
	 * The brand name of the item.
	 */
	@JsonProperty("$brand")
	private String brand;
	
	/**
	 * Name of the item's manufacturer.
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

	public String getUpc() {
		return upc;
	}

	public String getSku() {
		return sku;
	}

	public String getIsbn() {
		return isbn;
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

	public Item setUpc(String upc) {
		this.upc = upc;
		return this;
	}

	public Item setSku(String sku) {
		this.sku = sku;
		return this;
	}

	public Item setIsbn(String isbn) {
		this.isbn = isbn;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result
                + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result
                + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result
                + ((manufacturer == null) ? 0 : manufacturer.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result
                + ((productTitle == null) ? 0 : productTitle.hashCode());
        result = prime * result
                + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        result = prime * result + Arrays.hashCode(tags);
        result = prime * result + ((upc == null) ? 0 : upc.hashCode());
        return result;
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
        
        if (this.isbn == null) {
            if (item.getIsbn() != null) {
                return false;
            }
        } else if (!this.isbn.equals(item.getIsbn())) {
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
        
        if (this.sku == null) {
            if (item.getSku() != null) {
                return false;
            }
        } else if (!this.sku.equals(item.getSku())) {
            return false;
        }
        
        if (this.tags == null) {
            if (item.getTags() != null) {
                return false;
            }
        } else if (!Arrays.equals(tags, item.getTags())) {
            return false;
        }
        
        if (this.upc == null) {
            if (item.getUpc() != null) {
                return false;
            }
        } else if (!this.upc.equals(item.getUpc())) {
            return false;
        }
        
        return true;
    }
	
}
