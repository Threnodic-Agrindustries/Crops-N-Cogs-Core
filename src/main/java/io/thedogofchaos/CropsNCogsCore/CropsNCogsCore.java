package io.thedogofchaos.CropsNCogsCore;

import com.google.common.base.CaseFormat;
import io.thedogofchaos.CropsNCogsCore.client.ClientProxy;
import io.thedogofchaos.CropsNCogsCore.unified.UnifiedProxy;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * “Life is a hideous thing, and from the background behind what we know of it peer daemoniacal hints of truth which make it sometimes a thousandfold more hideous.
 * <br>Science, already oppressive with its shocking revelations, will perhaps be the ultimate exterminator of our human species
 * —if separate species we be—
 * for its reserve of unguessed horrors could never be borne by mortal brains if loosed upon the world.”
 * <br>- H.P. Lovecraft
 */
@Mod(CropsNCogsCore.MOD_ID)
public class CropsNCogsCore {
    public static final String MOD_ID = "cropsncogscore";
    public static final String MOD_NAME = "Crops 'N Cogs Core";
    public static final String MOD_NAME_SHORT = "CNCC";
    public static final Logger LOGGER = LogManager.getLogger();

    public CropsNCogsCore() {
        CropsNCogsCore.init();
        DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> UnifiedProxy::new); // Use whenever possible for stable builds.
        // DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> UnifiedProxy::new); // Only use on unstable builds, or while developing.
    }

    public static void init() {
        LOGGER.info("We're loading {} on the {}", MOD_NAME, FMLEnvironment.dist);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(CropsNCogsCore.MOD_ID, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, path));
    }
}