package sekwah.mods.narutomod.items.creativetabs;

import sekwah.mods.narutomod.items.NarutoItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabNinjaWeapons extends CreativeTabs {

    public CreativeTabNinjaWeapons(int par1, String par2Str) {
        super(par1, par2Str);
    }

    public ItemStack getIconItemStack() {
        return new ItemStack(NarutoItems.Kunai);
    }

    @SideOnly(Side.CLIENT)

    /**
     * the itemID for the item to be displayed on the tab
     */
    public Item getTabIconItem() {
        return NarutoItems.Kunai;
    }

}
