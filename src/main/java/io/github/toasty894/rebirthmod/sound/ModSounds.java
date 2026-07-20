package io.github.toasty894.rebirthmod.sound;

import io.github.toasty894.rebirthmod.RebirthMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent GEIGER_CLICK = registerSoundEvent("geiger_click");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(RebirthMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerModSounds() {
        RebirthMod.LOGGER.info("Registering Mod Sounds for " + RebirthMod.MOD_ID);
    }

}
