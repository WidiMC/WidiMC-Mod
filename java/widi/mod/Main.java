package widi.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import widi.mod.init.BiomeInit;
import widi.mod.proxy.CommonProxy;
import widi.mod.tabs.ThunderlandsTab;
import widi.mod.util.Reference;
import widi.mod.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.SidedProxy;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	public static final CreativeTabs thunderlandstab = new ThunderlandsTab("thunderlandstab");
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegistryHandler.preInitRegistries();}
	@EventHandler
	public static void init(FMLInitializationEvent event) {}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {RegistryHandler.postInitRegistries();}
	
}
