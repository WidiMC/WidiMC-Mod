package widi.mod.objects.armour;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import widi.mod.Main;
import widi.mod.init.ItemInit;
import widi.mod.util.interfaces.IHasModel;

public class ArmourBase extends ItemArmor implements IHasModel {

	public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
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
