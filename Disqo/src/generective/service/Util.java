package generective.service;

import generective.objects.items.Basket;
import generective.objects.group.Group;
import generective.objects.items.models.Item;

import java.util.ArrayList;
import java.util.Iterator;

public class Util {
    private static ArrayList<Group> roots = new ArrayList<>();
    public static Basket basket = new Basket();

    public static void addToRoots(Group group) {
        roots.add(group);
    }

    public static boolean addGroup(Group addedGroup, ArrayList<Group> groups, boolean addToRoot) {
        boolean isAdded = false;
        ArrayList<Group> copyGroup = new ArrayList<>(groups);
        Group g;
        Iterator<Group> iterator = copyGroup.iterator();
        while (iterator.hasNext()) {
            g = iterator.next();
            if (g.getId().equals(addedGroup.getParentId())) {
                g.getGroups().add(addedGroup);
                return true;
            } else {
                isAdded = addGroup(addedGroup, g.getGroups(), false);
                if (isAdded) return true;
            }
        }

        if (addToRoot && !isAdded) {
            roots.add(addedGroup);
        }

        return false;
    }

    public static boolean addItem(Item addedItem, ArrayList<Group> groups) {
        boolean isAdded = false;
        ArrayList<Group> copyGroup = new ArrayList<>(groups);
        Group g;
        Iterator<Group> iterator = copyGroup.iterator();
        while (iterator.hasNext()) {
            g = iterator.next();
            if (g.getId().equals(addedItem.getParentId())) {
                g.getItems().add(addedItem);
                return true;
            } else {
                isAdded = addItem(addedItem, g.getGroups());
                if (isAdded) return true;
            }
        }
        return false;
    }

    public static ArrayList<Group> getRoots() {
        return roots;
    }

}