package de.testing;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class InventoryGUI {
    Inventory inv;
    public static Plugin pl;

    public InventoryGUI(String name, int size) {
        this.inv = Bukkit.createInventory((InventoryHolder)null, size, name);
    }
    public InventoryGUI() {
        this.inv = Bukkit.createInventory(null, InventoryType.ANVIL);
    }

    public InventoryGUI(Inventory inv) {
        this.inv = inv;
    }

    public InventoryGUI addButton(String name, int index, Material material, String id) {
        ItemStack button = new ItemStack(material);
        ItemMeta buttonmeta = button.getItemMeta();
        buttonmeta.setDisplayName(name);
        NamespacedKey key = new NamespacedKey(pl, "button-id");
        buttonmeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
        button.setItemMeta(buttonmeta);
        this.inv.setItem(index, button);
        return this;
    }

    public InventoryGUI addButton(String name, int index, Material material) {
        ItemStack button = new ItemStack(material);
        ItemMeta buttonmeta = button.getItemMeta();
        buttonmeta.setDisplayName(name);
        NamespacedKey key = new NamespacedKey(pl, "button-id");
        buttonmeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, name);
        button.setItemMeta(buttonmeta);
        this.inv.setItem(index, button);
        return this;
    }
    public InventoryGUI addinfo(String name, int index, Material material) {
        ItemStack button = new ItemStack(material);
        ItemMeta buttonmeta = button.getItemMeta();
        buttonmeta.setDisplayName(name);
        NamespacedKey key = new NamespacedKey(pl, "gui-info");
        buttonmeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "gui-info");
        button.setItemMeta(buttonmeta);
        this.inv.setItem(index, button);
        return this;
    }

    public InventoryGUI open(Player p) {
        p.openInventory(this.inv);
        return this;
    }

    public InventoryGUI clear() {
        this.inv.clear();
        return this;
    }

    public Inventory getInv() {
        return this.inv;
    }
}
