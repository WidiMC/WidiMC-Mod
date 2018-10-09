package widi.mod.objects.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import widi.mod.Main;
import widi.mod.init.BlockInit;
import widi.mod.init.ItemInit;
import widi.mod.objects.blocks.item.ItemBlockVariants;
import widi.mod.util.handlers.EnumHandler;
import widi.mod.util.interfaces.IHasModel;
import widi.mod.util.interfaces.IMetaName;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockLogs extends BlockLog implements IMetaName, IHasModel{

	public static final PropertyEnum<EnumHandler.EnumTypeMaterial> VARIANT = PropertyEnum.<EnumHandler.EnumTypeMaterial>create("variant", EnumHandler.EnumTypeMaterial.class, new Predicate<EnumHandler.EnumTypeMaterial>() {

		public boolean apply(@Nullable EnumHandler.EnumTypeMaterial apply){

			return apply.getMeta() < 2;

		}

	});

	private String name;

	public BlockLogs(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumTypeMaterial.COPPER).withProperty(LOG_AXIS, EnumAxis.Y));
		setCreativeTab(Main.thunderlandstab);

		this.name = name;

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

		for(EnumHandler.EnumTypeMaterial customblockplanks$enumtype : EnumHandler.EnumTypeMaterial.values()){

			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));

		}

	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumTypeMaterial.byMetadata((meta & 1) % 2));

		switch(meta & 6){
		case 0:
			state = state.withProperty(LOG_AXIS, EnumAxis.Y);
			break;
			
		case 2:
			state = state.withProperty(LOG_AXIS, EnumAxis.X);
			break;

		case 4:
			state = state.withProperty(LOG_AXIS, EnumAxis.Z);
			break;

		default:
			state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
		}

		return state;

	}

	@SuppressWarnings("incomplete-switch")

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;

		i = i | ((EnumHandler.EnumTypeMaterial)state.getValue(VARIANT)).getMeta();

		switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {

		case X:
			i |= 2;
			break;

		case Y:
			i |= 4;
			break;

		case Z:
			i |= 6;

		}

		return i;

	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {VARIANT,LOG_AXIS});

	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {

		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandler.EnumTypeMaterial)state.getValue(VARIANT)).getMeta());

	}

	@Override
	public int damageDropped(IBlockState state) {

		return ((EnumHandler.EnumTypeMaterial)state.getValue(VARIANT)).getMeta();

	}

	@Override
	public String getSpecialName(ItemStack stack) {

		return EnumHandler.EnumTypeMaterial.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {

		for(int i = 0; i < EnumHandler.EnumTypeMaterial.values().length; i++){

			Main.proxy.registerVariantRender(Item.getItemFromBlock(this), i, "log_" + EnumHandler.EnumTypeMaterial.values()[i].getName(), "inventory");

		}

	}	

}