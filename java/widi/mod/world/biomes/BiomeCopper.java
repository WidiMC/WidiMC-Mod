package widi.mod.world.biomes;

import java.util.Random;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import widi.mod.init.BlockInit;
import widi.mod.objects.blocks.BlockOres;
import widi.mod.objects.blocks.BlockPlank;
import widi.mod.util.handlers.EnumHandler;
import widi.mod.world.gen.generators.WorldGenCopperTree;

public class BiomeCopper extends Biome {

	protected static final WorldGenAbstractTree TREE = new WorldGenCopperTree();
	
	public BiomeCopper() {

		super(new BiomeProperties("Copper").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
		
		topBlock = BlockInit.BLOCK_COPPER.getDefaultState();
		fillerBlock = BlockInit.ORE_COPPER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.OVERWORLD);
		
		this.decorator.coalGen = new WorldGenMinable(BlockInit.PLANKS.getDefaultState().withProperty(BlockPlank.VARIANT, EnumHandler.EnumTypeMaterial.COPPER), 10);
		
		this.decorator.treesPerChunk = 2;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
		
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return TREE;
	}
	
}
