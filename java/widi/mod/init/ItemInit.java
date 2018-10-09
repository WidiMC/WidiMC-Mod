package widi.mod.init;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import widi.mod.objects.armour.ArmourBase;
import widi.mod.objects.items.ItemBase;
import widi.mod.objects.tools.ToolAxe;
import widi.mod.objects.tools.ToolHoe;
import widi.mod.objects.tools.ToolPickaxe;
import widi.mod.objects.tools.ToolShovel;
import widi.mod.objects.tools.ToolSword;
import widi.mod.util.Reference;

public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Material
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 180, 5.0F, 1.5F, 5);
	public static final ToolMaterial TOOL_OBSIDIAN = EnumHelper.addToolMaterial("tool_obsidian", 3, 2800, 20.0F, 5.5F, 10);
	public static final ArmorMaterial ARMOUR_COPPER = EnumHelper.addArmorMaterial("armour_copper", Reference.MODID + ":copper", 13, new int[] {2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	//Items
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	public static final Item INGOT_OBSIDIAN = new ItemBase("ingot_obsidian");
	public static final Item INGOT_COMPRESSED_OBSIDIAN = new ItemBase("ingot_compressed_obsidian");
	
	//Tools
	public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
	public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
	public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
	public static final Item SHOVEL_COPPER = new ToolShovel("shovel_copper", TOOL_COPPER);
	public static final Item SWORD_COPPER = new ToolSword("sword_copper", TOOL_COPPER);
	
	public static final Item AXE_OBSIDIAN = new ToolAxe("axe_obsidian", TOOL_OBSIDIAN);
	public static final Item HOE_OBSIDIAN = new ToolHoe("hoe_obsidian", TOOL_OBSIDIAN);
	public static final Item PICKAXE_OBSIDIAN = new ToolPickaxe("pickaxe_obsidian", TOOL_OBSIDIAN);
	public static final Item SHOVEL_OBSIDIAN = new ToolShovel("shovel_obsidian", TOOL_OBSIDIAN);
	public static final Item SWORD_OBSIDIAN = new ToolSword("sword_obsidian", TOOL_OBSIDIAN);
	
	//Armour
	public static final Item HELMET_COPPER = new ArmourBase("helmet_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_COPPER = new ArmourBase("chestplate_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINS_COPPER = new ArmourBase("leggins_copper", ARMOUR_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_COPPER = new ArmourBase("boots_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.FEET);
}
