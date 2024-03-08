import java.awt.Color;

public class Editor4 {

    public static void main(String[] args) {
        // Ensure the correct number of command-line arguments are provided
        if (args.length != 2) {
            System.err.println("Usage: java Editor4 <source_image.ppm> <steps>");
            System.exit(1); // Exit with an error status
        }

        String sourceFileName = args[0]; // The filename of the source PPM image
        int steps = Integer.parseInt(args[1]); // The number of steps for the morphing process

        // Read the source image using Runigram.read
        Color[][] sourceImage = Runigram.read(sourceFileName);

        // Check if the source image was successfully read
        if (sourceImage == null) {
            System.err.println("Failed to read the source image file: " + sourceFileName);
            System.exit(1); // Exit with an error status
        }

        // Convert the source image to its grayscale version
        Color[][] grayImage = Runigram.grayScaled(sourceImage);

        // Morph the source image into its grayscale version using the specified number of steps
        Runigram.setCanvas(sourceImage); // Set the canvas size based on the source image
        Runigram.morph(sourceImage, grayImage, steps);
    }
}
