package softuni.models.collection;

import softuni.interfaces.Fragment;

import java.util.ArrayList;
import java.util.List;

public class LStack {

    private List<Fragment> innerList;

    public LStack() {
        this.innerList = new ArrayList<>();
    }

    public int size() {
        return this.innerList.size();
    }

    public void push(Fragment item) {
        this.innerList.add(item);
    }

    public Fragment pop() {
        Fragment removedItem = this.innerList.remove(this.innerList.size()-1);
        return removedItem;
    }

    public Fragment peek() {
        Fragment peekedItem = this.innerList.get(0);
        return peekedItem;
    }

    public Boolean isEmpty() {
        return this.innerList.isEmpty();
    }
}