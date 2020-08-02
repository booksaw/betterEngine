package com.booksaw.betterEngine.objectRendering;

import java.awt.image.BufferedImage;

import com.booksaw.betterEngine.utils.ImageUtils;

public class TestRender extends ObjectRenderer {

	@Override
	public BufferedImage getImage() {
		return ImageUtils.getNoTextureImage();
	}

}
