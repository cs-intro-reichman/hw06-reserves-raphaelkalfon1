import java.awt.Color;

public class Editor4 {

    public static void main(String[] args) {
        // Check for the correct number of command-line arguments
        if (args.length != 2) {
            System.err.println("Usage: java Editor4 <image_file.ppm> <steps>");
            System.exit(1); // Exit with an error code
        }

        String fileName = args[0]; // The filename of the PPM image
        int steps = Integer.parseInt(args[1]); // The number of steps for the morphing process

        // Read the original image using Runigram.read
        Color[][] imageIn = Runigram.read(fileName);

        // Check if the image was successfully read
        if (imageIn == null) {
            System.err.println("Failed to read the image file: " + fileName);
            System.exit(1); // Exit with an error code
        }

        // Create a grayscaled version of the original image
        Color[][] grayScaledImage = Runigram.grayScaled(imageIn);

        // Morph the original image into its grayscaled version
        Runigram.setCanvas(imageIn); // Set the canvas size based on the original image
        Runigram.morph(imageIn, grayScaledImage, steps);
    }
}
