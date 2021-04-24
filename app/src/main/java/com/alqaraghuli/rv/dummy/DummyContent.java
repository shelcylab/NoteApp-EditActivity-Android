package com.alqaraghuli.rv.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
//    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 20;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
//        ITEM_MAP.put(item.title, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, "Detail " + position, position%2==0);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String title;
        public String content;
        public String details;
        public boolean isBookmarked;

        public DummyItem(String title, String content, String details, Boolean isBookmarked) {
            this.title = title;
            this.content = content;
            this.details = details;
            this.isBookmarked = isBookmarked;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}