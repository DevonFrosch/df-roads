package derfl007.roads.proxy;

import derfl007.roads.Reference;
import derfl007.roads.client.renderer.tileentity.TileEntityRoadTownSignRenderer;
import derfl007.roads.common.tileentities.TileEntityRoadTownSign;
import derfl007.roads.init.RoadBlocks;
import derfl007.roads.init.RoadCrafting;
import derfl007.roads.init.RoadItems;
import derfl007.roads.world.WorldGenOre;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.awt.*;

public class ClientProxy implements CommonProxy {

    @Override
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoadTownSign.class, new TileEntityRoadTownSignRenderer());
        System.out.println("special renderer bound!");
        GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
        RoadCrafting.register();

    }

    @Override
    public void postInit() {

    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            RoadItems.registerModels();
            RoadBlocks.registerModels();
        }
    }
}
