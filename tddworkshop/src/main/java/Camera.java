public class Camera {
    private String name;
    private int priceInUsd;
    private int megaPixels;
    private Brand brand;

    public Camera(Brand brand, String name, int priceInUsd, int megaPixels) {
        this.name = name;
        this.priceInUsd = priceInUsd;
        this.megaPixels = megaPixels;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public int getPriceInUsd() {
        return priceInUsd;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public Brand getBrand() {
        return brand;
    }
}
