package io.github.toasty894.rebirthmod.util;

import io.github.toasty894.rebirthmod.RebirthMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks{
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(RebirthMod.MOD_ID, name));
        }
    }
    public static class Items{
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(RebirthMod.MOD_ID, name));
        }
    }

}
