package generective.objects.items.models;

import generective.objects.items.Configuration;

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

    @Override
    public double calculatePrice() {
        return price * configuration.getCoefficient();
    }
}