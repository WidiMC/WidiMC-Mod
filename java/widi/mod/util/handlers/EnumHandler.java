package widi.mod.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	public static enum EnumTypeDimensions implements IStringSerializable {
		
		OVERWORLD(0, "overworld"),
		END(1, "end"),
		NETHER(2, "nether");
		
		private static final EnumTypeDimensions[] META_LOOKUP = new EnumTypeDimensions[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private EnumTypeDimensions(int meta, String name) {
			this(meta, name, name);
		}
		
		private EnumTypeDimensions(int meta, String name, String unlocalizedName) {
			this.meta = meta;
			this.name= name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return meta;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumTypeDimensions byMetadata(int meta) {
			return META_LOOKUP[meta];
		}
		
		static {
			for(EnumTypeDimensions enumtype : values()) {
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
	
public static enum EnumTypeMaterial implements IStringSerializable {
		
		COPPER(0, "copper"),
		ALUMINIUM(1, "aluminium");
		
		private static final EnumTypeMaterial[] META_LOOKUP = new EnumTypeMaterial[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private EnumTypeMaterial(int meta, String name) {
			this(meta, name, name);
		}
		
		private EnumTypeMaterial(int meta, String name, String unlocalizedName) {
			this.meta = meta;
			this.name= name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return meta;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumTypeMaterial byMetadata(int meta) {
			return META_LOOKUP[meta];
		}
		
		static {
			for(EnumTypeMaterial enumtype : values()) {
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
	
}
