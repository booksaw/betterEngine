package com.booksaw.betterEngine.utils;

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
}
