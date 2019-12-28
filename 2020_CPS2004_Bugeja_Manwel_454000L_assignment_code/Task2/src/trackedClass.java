import java.util.ArrayList;

public class trackedClass {
    private static ArrayList<trackedClass> instances = new ArrayList<>();

    public static void addInstance(trackedClass instance) {
        instances.add(instance);
    }

    public static void deleteInstance(trackedClass instance) {
        instances.remove(instance);
    }

    public static ArrayList<trackedClass> returnList() {
        return instances;
    }
}
