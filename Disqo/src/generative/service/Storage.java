package generective.service;

import generective.models.Basket;
import generective.models.Group;
import generective.models.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Storage {
    private static List<Group> roots = new ArrayList<>();
    public static Basket basket = new Basket();

    public static void addToRoots(Group group) {
        roots.add(group);
    }

    public static boolean addGroup(Group addedGroup, List<Group> groups, boolean addToRoot) {
        boolean isAdded = false;
        List<Group> copyGroup = new ArrayList<>(groups);
        Group parent;
        Iterator<Group> iterator = copyGroup.iterator();
        while (iterator.hasNext()) {
            parent = iterator.next();
            if (parent.getId().equals(addedGroup.getParentId())) {
                parent.getGroups().add(addedGroup);//parent group add sub
                addedGroup.setGroupParent(parent);//sub group add parent
                return true;
            } else {
                isAdded = addGroup(addedGroup, parent.getGroups(), false);
                if (isAdded) return true;
            }
        }

        if (addToRoot && !isAdded) {
            roots.add(addedGroup);
        }

        return false;
    }

    public static boolean addItem(Item addedItem, List<Group> groups) {
        boolean isAdded = false;
        List<Group> copyGroup = new ArrayList<>(groups);
        Group g;
        Iterator<Group> iterator = copyGroup.iterator();
        while (iterator.hasNext()) {
            g = iterator.next();
            if (g.getId().equals(addedItem.getParentId())) {
                g.getItems().add(addedItem);
                addedItem.setParentGroup(g);
                return true;
            } else {
                isAdded = addItem(addedItem, g.getGroups());
                if (isAdded) return true;
            }
        }
        return false;
    }

    public static List<Group> getRoots() {
        return roots;
    }

}