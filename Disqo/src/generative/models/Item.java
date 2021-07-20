package generective.models;


import generective.models.Configuration;

import java.util.Currency;
import java.util.Locale;

public class Item {
    protected String parentId;
    protected String id;
    protected String name;
    protected double price;
    protected Currency currency;
    protected Configuration configuration;
    private Group parentGroup;

    public Item(String id, String name, double price, Configuration configuration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.configuration = configuration;
        this.currency = Currency.getInstance(Locale.getDefault());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append('{')
                .append(id)
                .append("_")
                .append(name)
                .append("_")
                .append(calculatePrice())
                .append("_")
                .append(currency)
                .append("_")
                .append(configuration.resolution.name())
                .append("}").toString();
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double calculatePrice() {
        return price;
    }
}
