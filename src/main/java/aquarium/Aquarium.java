package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public static final int CAPACITY = 20;
    private List<Fish> fishList = new ArrayList<>();

    public void feed() {
        for (Fish f : fishList) {
            f.feed();
        }
    }

    public void addFish(Fish fish) {
        if (fishList.size() * 5 > 15) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishList.add(fish);
    }

    public List<String> getStatus() {
        List<String> fishStatus = new ArrayList<>();
        for (Fish f : fishList) {
            fishStatus.add(f.getStatus());
        }
        return fishStatus;
    }

    public void removeFish(int maxWeight) {
        List<Fish> removeFish = new ArrayList<>();
        for (Fish fish : fishList) {
            if (fish.getWeight() > maxWeight) {
                removeFish.add(fish);
            }
        }
        fishList.removeAll(removeFish);
    }

    public int getNumberOfFishWithMemoryLoss() {
        int count = 0;
        for (Fish f : fishList) {
            if (f.hasMemoryLoss()) {
                count++;
            }
        }
        return count;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish f : fishList) {
            if (f.getColor().equals(color)) {
                return true;
            }

        }
        return false;
    }

    public Fish getSmallestFish() {
        int fishMinWeight = fishList.get(0).getWeight();
        Fish smallFish = fishList.get(0);
        for (Fish f : fishList) {
            if (f.getWeight() < fishMinWeight) {
                fishMinWeight = f.getWeight();
                smallFish = f;
            }
        }
        return smallFish;
    }
}