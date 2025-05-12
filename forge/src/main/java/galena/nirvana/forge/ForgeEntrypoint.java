package galena.nirvana.forge;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import galena.nirvana.NirvanaCommon;
import galena.nirvana.NirvanaConstants;
import galena.nirvana.forge.client.ForgeClientEntrypoint;
import galena.nirvana.forge.world.AddItemLootModifier;
import galena.nirvana.forge.world.ReplaceItemLootModifier;
import galena.nirvana.index.NirvanaBrewing;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

@Mod(NirvanaConstants.MOD_ID)
public class ForgeEntrypoint {

    public static final NonNullSupplier<ForgeNirvanaRegistrate> REGISTRATE = NonNullSupplier.lazy(() -> ForgeNirvanaRegistrate.create(NirvanaConstants.MOD_ID));

    public ForgeEntrypoint() {
        NirvanaCommon.init();
        FMLJavaModLoadingContext.get().getModEventBus().<FMLCommonSetupEvent>addListener(event -> NirvanaBrewing.register());
        //noinspection Convert2MethodRef
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ForgeClientEntrypoint.init());

        REGISTRATE.get()
                .object("replace_item")
                .generic(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, () -> ReplaceItemLootModifier.CODEC)
                .register();

        REGISTRATE.get()
                .object("add_item")
                .generic(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, () -> AddItemLootModifier.CODEC)
                .register();
    }

}
