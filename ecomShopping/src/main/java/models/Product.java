package models;

public class Product {

    private int id;
    private String name;
    private String price;
    private String imgSrc;
    private Boolean inCard = false;

    public Product(int id, String name, String price, String imgSrc, Boolean inCard) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgSrc = imgSrc;
        this.inCard = inCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Boolean getInCard() {
        return inCard;
    }

    public void setInCard(Boolean status) {
        this.inCard = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return this.id == product.id;
    }
}