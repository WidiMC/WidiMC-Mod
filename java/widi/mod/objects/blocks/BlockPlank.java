package widi.mod.objects.blocks;



import widi.mod.Main;
import widi.mod.init.BlockInit;
import widi.mod.init.ItemInit;
import widi.mod.objects.blocks.item.ItemBlockVariants;
import widi.mod.util.handlers.EnumHandler;
import widi.mod.util.handlers.EnumHandler.EnumTypeMaterial;
import widi.mod.util.interfaces.IHasModel;
import widi.mod.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockPlank extends Block implements IMetaName, IHasModel{

	public static final PropertyEnum<EnumHandler.EnumTypeMaterial> VARIANT = PropertyEnum.<EnumHandler.EnumTypeMaterial>create("variant", EnumHandler.EnumTypeMaterial.class);

	private String name;

	public BlockPlank(String name) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumTypeMaterial.COPPER));
		setCreativeTab(Main.thunderlandstab);

		this.name = name;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		
		return ((EnumHandler.EnumTypeMaterial)state.getValue(VARIANT)).getMeta();

	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

		for(EnumHandler.EnumTypeMaterial customblockplanks$enumtype : EnumHandler.EnumTypeMaterial.values()){

			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));

		}

	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumTypeMaterial.byMetadata(meta));

	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return ((EnumHandler.EnumTypeMaterial)state.getValue(VARIANT)).getMeta();

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));

	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {VARIANT});

	}
	
	@Override
	public String getSpecialName(ItemStack stack) {

		return EnumHandler.EnumTypeMaterial.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {

		for(int i = 0; i < EnumHandler.EnumTypeMaterial.values().length; i++){

			Main.proxy.registerVariantRender(Item.getItemFromBlock(this), i, "planks_" + EnumHandler.EnumTypeMaterial.values()[i].getName(), "inventory");

		}

	}

}