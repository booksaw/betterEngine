package com.booksaw.betterEngine.objectRendering;

import java.awt.image.BufferedImage;

import com.booksaw.betterEngine.object.Object;
import com.booksaw.betterEngine.utils.ImageUtils;

public class TestRender extends ObjectRenderer {

	public TestRender(Object object) {
		super(object);
	}

	@Override
	public BufferedImage getImage() {
		return ImageUtils.getNoTextureImage();
	}

}
