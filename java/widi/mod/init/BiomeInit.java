package widi.mod.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import widi.mod.world.biomes.BiomeCopper;

public class BiomeInit {

	public static final Biome COPPER = new BiomeCopper();
	
	public static void registerBiomes() {
		
		initBiome(COPPER, "Copper", BiomeType.WARM, Type.HILLS, Type.MOUNTAIN, Type.DRY);
		
	}
	
	public static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type...type ) {
		
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Registerd");
		BiomeDictionary.addTypes(biome, type);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome Added");
		return biome;
		
	}
	
}
