package widi.mod.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import widi.mod.Main;
import widi.mod.init.ItemInit;
import widi.mod.proxy.ClientProxy;
import widi.mod.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.thunderlandstab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRender(this, 0, "inventory");
	}
}
