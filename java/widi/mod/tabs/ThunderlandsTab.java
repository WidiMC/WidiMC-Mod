package widi.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import widi.mod.init.ItemInit;

public class ThunderlandsTab extends CreativeTabs{

	public ThunderlandsTab(String label) {
		super("thunderlandstab");
		this.setBackgroundImageName("thunderlands.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.INGOT_COPPER);
	}

	
	
}
