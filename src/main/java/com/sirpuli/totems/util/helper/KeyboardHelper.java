/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

package com.sirpuli.totems.util.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper{
	private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();


	/**
	 * @return the shift key is pressed or not.
	 */
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingShift(){
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
	}

	/**
	 * @return the control key is pressed or not.
	 */
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingCtrl(){
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_CONTROL);
	}
}
