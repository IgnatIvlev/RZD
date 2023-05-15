import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Wagon {
    private int id;
    private WagonType type;
    private int weight;
    private int maxLoad;
    private int load;
    private List<String> cargoList;
    private static final Set<Integer> idList = new HashSet<>();

    public Wagon(int id, WagonType type) {
        if(!idList.contains(id)){
            this.id = id;
            idList.add(id);
            this.type = type;
            switch(type) {
                case TRANSPORTER:
                    this.weight = 1;
                    this.maxLoad = 10;
                    break;
                case BOXCAR:
                    this.weight = 2;
                    this.maxLoad = 10;
                    break;
                case GONDE:
                    this.weight = 3;
                    this.maxLoad = 10;
                    break;
                case TANKER:
                    this.weight = 4;
                    this.maxLoad = 10;
                    break;
                case DUMPCAR:
                    this.weight = 5;
                    this.maxLoad = 10;
                    break;
                case HOPPER:
                    this.weight = 6;
                    this.maxLoad = 10;
                    break;
                case CARCARRIER:
                    this.weight = 7;
                    this.maxLoad = 10;
            }
        }
        else{
            System.out.println("Не верный ID!");
        }
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        if(load < maxLoad){
            this.load = load;
        }
        else{
            System.out.println("Превышен максимальный вес!");
        }
    }

    public String getPassport(){
        return (id + " " + type + " " + weight + " " + load);
    }

    public List<String> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<String> cargoList) {
        this.cargoList = cargoList;
    }
}
