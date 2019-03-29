package lesson10.shop;

public class Good {
    String title;
    int qty;
    double price;

    public Good(String title, int qty, double price) {
        this.title = title;
        this.qty = qty;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (qty != good.qty) return false;
        if (Double.compare(good.price, price) != 0) return false;
        return title != null ? title.equals(good.title) : good.title == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + qty;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
