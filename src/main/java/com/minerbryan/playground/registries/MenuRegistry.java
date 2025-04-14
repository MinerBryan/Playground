package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.entity.ExampleBlockEntityEntity;
import com.minerbryan.playground.gui.ExampleBEMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, PlaygroundMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<ExampleBEMenu>> EXAMPLE_BE_MENU = registerMenuType("example_be_menu", ExampleBEMenu::new);

    public static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus bus){
        MENUS.register(bus);
    }
}
