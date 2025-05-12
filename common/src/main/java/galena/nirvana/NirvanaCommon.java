package galena.nirvana;

import galena.nirvana.index.NirvanaBanners;
import galena.nirvana.index.NirvanaBlocks;
import galena.nirvana.index.NirvanaBrewing;
import galena.nirvana.index.NirvanaEffects;
import galena.nirvana.index.NirvanaEntities;
import galena.nirvana.index.NirvanaItems;
import galena.nirvana.index.NirvanaPaintings;
import galena.nirvana.index.NirvanaParticles;
import galena.nirvana.index.NirvanaRecipeTypes;
import galena.nirvana.index.NirvanaSounds;
import galena.nirvana.platform.Services;
import net.minecraft.core.registries.Registries;

public class NirvanaCommon {

    public static void init() {
        NirvanaSounds.register();
        NirvanaEffects.register();
        NirvanaBlocks.register();
        NirvanaEntities.register();
        NirvanaItems.register();
        NirvanaRecipeTypes.register();
        NirvanaPaintings.register();
        NirvanaParticles.register();
        NirvanaBanners.register();
    }

}
