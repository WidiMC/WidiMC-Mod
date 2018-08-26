package widi.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import widi.mod.Main;
import widi.mod.init.BlockInit;
import widi.mod.init.ItemInit;
import widi.mod.objects.blocks.item.ItemBlockVariants;
import widi.mod.objects.tools.ToolPickaxe;
import widi.mod.util.handlers.EnumHandler;
import widi.mod.util.interfaces.IHasModel;
import widi.mod.util.interfaces.IMetaName;

public class BlockOres extends Block implements IHasModel, IMetaName {

	public static final PropertyEnum<EnumHandler.EnumTypeDimensions> VARIANT = PropertyEnum.<EnumHandler.EnumTypeDimensions>create("variant", EnumHandler.EnumTypeDimensions.class);
	
	private String name, ore;
	
	public BlockOres(String name, String ore, Material material, float hardness, float resistance, float light, int harvest, String tool) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.thunderlandstab);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumTypeDimensions.OVERWORLD));
		
		this.name = name;
		this.ore = ore;
		
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setLightLevel(light);
		this.setHarvestLevel(tool, harvest);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ((EnumHandler.EnumTypeDimensions)state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumHandler.EnumTypeDimensions)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumTypeDimensions.byMetadata(meta));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for(EnumHandler.EnumTypeDimensions variant : EnumHandler.EnumTypeDimensions.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});				
	}
	
	@Override
	public String getSpecialName(ItemStack stack) {
		return EnumHandler.EnumTypeDimensions.values()[stack.getItemDamage()].getName();
	}

	
	@Override
	public void registerModels() {
		for(int i = 0; i < EnumHandler.EnumTypeDimensions.values().length; i++) {
			Main.proxy.registerVariantRender(Item.getItemFromBlock(this), i, "ore_" + this.ore + "_" + EnumHandler.EnumTypeDimensions.values()[i].getName(), "inventory");

		}
	}
	
}
