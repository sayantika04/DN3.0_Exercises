public interface Image {
    void display();
}
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
public class ProxyPatternTest {
    public static void main(String[] args) {
        // Create proxy images
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display images using proxy
        // The image will be loaded and displayed only when `display()` is called
        image1.display(); // Image will be loaded from the server
        image1.display(); // Image will be displayed from cache

        image2.display(); // Image will be loaded from the server
        image2.display(); // Image will be displayed from cache
    }
}
