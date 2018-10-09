package widi.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import widi.mod.Main;
import widi.mod.init.BlockInit;
import widi.mod.init.ItemInit;
import widi.mod.util.interfaces.IHasModel;

public class BlockBase extends Block implements IHasModel{

	public BlockBase(String name, Material material, float hardness, float resistance, float light, int harvest, String tool) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.thunderlandstab);
		
		setHardness(hardness);
		setResistance(resistance);
		setLightLevel(light);
		setHarvestLevel(tool, harvest);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRender(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		return true;
	}
	
}
