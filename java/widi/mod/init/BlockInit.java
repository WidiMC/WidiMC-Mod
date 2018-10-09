package widi.mod.init;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import widi.mod.objects.blocks.BlockBase;
import widi.mod.objects.blocks.BlockLeaf;
import widi.mod.objects.blocks.BlockLogs;
import widi.mod.objects.blocks.BlockOres;
import widi.mod.objects.blocks.BlockPlank;
import widi.mod.objects.blocks.BlockSaplings;
import widi.mod.util.handlers.EnumHandler;

public class BlockInit {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON, 6.0F, 15.0F, 0.0F, 2, "pickaxe");
	
	public static final Block ORE_COPPER = new BlockOres("ore_copper", "copper", Material.ROCK, 6.0F, 15.0F, 0.0F, 2, "pickaxe");
	public static final Block ORE_ALUMINIUM = new BlockOres("ore_aluminium", "aluminium", Material.ROCK, 6.0F, 15.0F, 0.0F, 2, "pickaxe");
	
	public static final Block PLANKS = new BlockPlank("planks");
	public static final Block LOGS = new BlockLogs("log");
	public static final Block LEAVES = new BlockLeaf("leaves");
	public static final Block SAPLINGS = new BlockSaplings("sapling");
	
}
