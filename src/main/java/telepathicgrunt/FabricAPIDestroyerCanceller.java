package telepathicgrunt;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class FabricAPIDestroyerCanceller implements MixinCanceller {
	@Override
	public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
		if (mixinClassName.contains("net.fabricmc.fabric.mixin")
			&& !mixinClassName.endsWith("Accessor")
			&& !mixinClassName.endsWith("Invoker"))
		{
			DestroyerOfFabricAPIMod.LOGGER.info("Cancelled mixin: {}", mixinClassName);
			return true;
		}

		return false;
	}
}