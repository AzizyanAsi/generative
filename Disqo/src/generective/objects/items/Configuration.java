package generective.objects.items;

public enum Configuration {
    HD(1), FHD(2), K4(4);
    private int coefficient;

    Configuration(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}
