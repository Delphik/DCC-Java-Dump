   /**
 * @author maxh
 *
 * @param <T>
 */
public class A5GItem<T> implements Comparable<T> {
    double price;
    String product;
    String brand;
    String count;
    int upc;

    /**
     * Constructor
     *
     * @param      pri: the price
     * @param      pro: the product
     * @param brnd : the brand
     * @param w    : the weight
     * @param u    : the UPC
     */
    public A5GItem(String brnd, String pro, String c, double pri, int u) {
        price = pri;
        product = pro;
        brand = brnd;
        count = c;
        upc = u;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the weight
     */
    public String getCount() {
        return count;
    }

    /**
     * @param weight the weight to set
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * @return the upc
     */
    public int getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(int upc) {
        this.upc = upc;
    }

    /*
     * ToString (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Product: " + getProduct() + ", Price: $" + getPrice() + ", Brand: " + getBrand() + ", Count: "
                + getCount() + ", UPC: " + getUpc();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + upc;
        return result;
    }

    /*
     * Equals mehtod (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        A5GItem other = (A5GItem) obj;
        if (upc != other.upc)
            return false;
        return true;
    }

    /**
     * CompareTo
     */
    @Override
    public int compareTo(T obj) {
        if (this.upc > upc)
            return 1;
        else if (this.upc < upc)
            return -1;
        else
            return 0;

    }
}
