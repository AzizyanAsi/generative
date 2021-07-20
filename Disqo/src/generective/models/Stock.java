package generective.models;

import generective.models.Configuration;
import generective.models.Item;

public class Stock extends Item {

    public Stock(String id, String name, double price, Configuration configuration) {
        super(id, name, price, configuration);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}