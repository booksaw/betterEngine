package com.booksaw.betterEngine.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.booksaw.betterEngine.Logger;

public class ImageUtils {

	/**
	 * Used to load the image from the name of the image including the image path
	 * 
	 * @param Name the name of the image including the path
	 * @return The buffered image under that name. This method will return the no
	 *         texture image if no image is found.
	 */
	public static BufferedImage getImage(String name) {

		File f = new File(name);
		if (!f.exists()) {
			return getNoTextureImage();
		}

		return getImage(f);

	}

	/**
	 * <h1>Used to load the image from the specified image file</h1>
	 * <p>
	 * Ensure you check the beforehand that the file exists else some errors will be
	 * thrown
	 * <p>
	 * 
	 * @param file the file to load the image from
	 * @return the bufferedImage version of that image
	 */
	public static BufferedImage getImage(File file) {
		try {
			return ImageIO.read(file);
		} catch (IOException e) {
			Logger.warning("Could not load specified texture, using the noTexture image (" + file.getPath() + ")");
			e.printStackTrace();
			return getNoTextureImage();
		}
	}

	/**
	 * @return The image which is used to replace any image within the program that
	 *         does not have a texture
	 */
	public static BufferedImage getNoTextureImage() {
		// this is used to load the image texture that should be used if the texture is
		// not found
		try {
			return ImageIO.read(Utils.getCompiledResouce("noTexture.png"));
		} catch (IOException e) {
			Logger.error("Could not find the no texture image (noTexture.png)");
			return null;
		}
	}

	/**
	 * Used to scale an image a given scale
	 * 
	 * @param image The image to scale
	 * @param scale The scale to change the image by
	 * @return The Image of the scaled bufferedImage
	 */
	public static Image getScaledInstance(BufferedImage image, double scale) {
		return image.getScaledInstance((int) (image.getWidth() * scale), (int) (image.getHeight() * scale),
				Image.SCALE_SMOOTH);
	}

	/**
	 * Used to scale an image a given scale
	 * 
	 * @param image  The image to scale
	 * @param width  The width of the target image
	 * @param height The height of the target image
	 * @return The Image of the scaled bufferedImage
	 */
	public static Image getScaledInstance(BufferedImage image, int width, int height) {
		return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}

	/**
	 * Used when you are unsure of what the scale should be, it will calculate the
	 * scale from a provided miniumum length
	 * 
	 * @param image   The image to scale
	 * @param minimum The minimum side length
	 * @return The image
	 */
	public static Image getScaledInstance(BufferedImage image, int minimum) {
		double scale;
		if (image.getHeight() < image.getWidth()) {
			scale = (double) minimum / image.getHeight();
		} else {
			scale = (double) minimum / image.getWidth();
		}
		return getScaledInstance(image, scale);

	}

	/**
	 * Converts a given Image into a BufferedImage
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	public static BufferedImage rotateImageByRadians(BufferedImage img, double rads) {

		double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
		int w = img.getWidth();
		int h = img.getHeight();
		int newWidth = (int) Math.floor(w * cos + h * sin);
		int newHeight = (int) Math.floor(h * cos + w * sin);

		BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rotated.createGraphics();
		AffineTransform at = new AffineTransform();
		at.translate((newWidth - w) / 2, (newHeight - h) / 2);

		int x = w / 2;
		int y = h / 2;

		at.rotate(rads, x, y);
		g2d.setTransform(at);
		g2d.drawImage(img, 0, 0, null);
//		g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
		g2d.dispose();

		return rotated;
	}
}
