package com.charein.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemsDB {
    private static ItemsDB sInstance;
    private List<Item> ItemsDB;

    public static ItemsDB getInstance() {
        if (sInstance == null) {
            sInstance = new ItemsDB();
        }
        return sInstance;
    }

    private ItemsDB() {
        ItemsDB = new ArrayList<>();
    }

    public String listItems() {
        String r = "";
        for (int i = 0; i < ItemsDB.size(); i++) {
            r = r + "\n Buy " + ItemsDB.get(i).toString();
        }
        return r;
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("coffee", "Irma"));
        ItemsDB.add(new Item("carrots", "Netto"));
        ItemsDB.add(new Item("milk", "Netto"));
        ItemsDB.add(new Item("bread", "bakery"));
        ItemsDB.add(new Item("butter", "Irma"));
    }

    public void addItem(Item item) {
        ItemsDB.add(item);
    }

    public boolean delItem(Item item) {
        boolean ret = false;

        Iterator it = ItemsDB.iterator();
        while (it.hasNext()) {
            Item db = (Item) it.next();
            if (db.getWhat().equals(item.getWhat())
                    && db.getWhere().equals(item.getWhere())) {
                it.remove();
                ret = true;
            }
        }

        return ret;
    }
}