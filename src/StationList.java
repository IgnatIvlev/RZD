import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StationList {
    private static StationList instance;
    private Map<String, ArrayList<Wagon>> stationList;

    private StationList() {
        stationList = new HashMap<>();
    }

    public static synchronized StationList getInstance() {
        if (instance == null) {
            instance = new StationList();
        }
        return instance;
    }

    public Map<String, ArrayList<Wagon>> getStationList() {
        return stationList;
    }
}
