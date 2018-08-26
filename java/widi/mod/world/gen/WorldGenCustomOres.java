package widi.mod.world.gen;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import widi.mod.init.BlockInit;
import widi.mod.objects.blocks.BlockOres;
import widi.mod.util.handlers.EnumHandler;

public class WorldGenCustomOres implements IWorldGenerator {
	
	private WorldGenerator ore_copper_nether, ore_coppper_overworld, ore_copper_end;
	private WorldGenerator ore_aluminium_nether, ore_aluminium_overworld, ore_aluminium_end;
	
	public WorldGenCustomOres() {
		ore_copper_nether = new WorldGenMinable(BlockInit.ORE_COPPER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.NETHER), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_coppper_overworld = new WorldGenMinable(BlockInit.ORE_COPPER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.OVERWORLD), 9, BlockMatcher.forBlock(Blocks.STONE));
		ore_copper_end = new WorldGenMinable(BlockInit.ORE_COPPER.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.END), 9, BlockMatcher.forBlock(Blocks.END_STONE));
		
		ore_aluminium_nether = new WorldGenMinable(BlockInit.ORE_ALUMINIUM.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.NETHER), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_aluminium_overworld = new WorldGenMinable(BlockInit.ORE_ALUMINIUM.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.OVERWORLD), 9, BlockMatcher.forBlock(Blocks.STONE));
		ore_aluminium_end = new WorldGenMinable(BlockInit.ORE_ALUMINIUM.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumTypeDimensions.END), 9, BlockMatcher.forBlock(Blocks.END_STONE));

		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case -1:
			
			runGenerator(ore_copper_nether, world, random, chunkX, chunkZ, 50, 0, 100);
			runGenerator(ore_aluminium_nether, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case 0:
			
			runGenerator(ore_coppper_overworld, world, random, chunkX, chunkZ, 50, 0, 100);
			runGenerator(ore_aluminium_overworld, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case 1:
			
			runGenerator(ore_copper_end, world, random, chunkX, chunkZ, 50, 0, 100);
			runGenerator(ore_aluminium_end, world, random, chunkX, chunkZ, 50, 0, 100);
			
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}	
}
