import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Station {
    private String name;
    private int amountWays;
    private int maxWagonsOnWay; // будем считать, что количество на всех путях одинаковое;
    private ArrayList<LinkedList<Wagon>> ways;

    public Station(String name, int amountWays) {
        this.name = name;
        this.amountWays = amountWays;
    }

    public int getAmountWays() {
        return amountWays;
    }

    public void addWagon(int way, Wagon wagon, boolean head){
        if(ways.get(way).size() < maxWagonsOnWay){
            if(head){
                ways.get(way).add(0, wagon);
            }
            else{
                ways.get(way).add(wagon);
            }
        }
        else{
            System.out.println("Превышено количество вагонов на " + way + " пути!");
        }
    }

    public void removeWagon(int way, boolean head){
        if(ways.get(way).size() > 0){
            if(head){
                ways.get(way).removeFirst();
            }
            else{
                ways.get(way).removeLast();
            }
        }
        else{
            System.out.println("Путь №" + way + " пустой!");
        }
    }

    public void moveWagon(int wayFrom, boolean headFrom, int wayTo, boolean headTo){
        Wagon wagonTemp;
        if(wayFrom > 0 && wayTo < maxWagonsOnWay){
            if(headFrom){
                wagonTemp = ways.get(wayFrom).pollFirst();
                addWagon(wayTo, wagonTemp, headTo);
            }
            else{
                wagonTemp = ways.get(wayFrom).pollLast();
                addWagon(wayTo, wagonTemp, headTo);
            }
        }
        else{
            System.out.println("ОШИБКА!");
        }
    }

    public LinkedList<Wagon> sendTrain(int way){
        if( ways.get(way).size() > 0){
            LinkedList<Wagon> train = ways.get(way);
            ways.get(way).clear();
            return train;
        }
        else{
            System.out.println("Путь №" + way + " пустой!");
            return null;
        }
    }

    public String getWagonPassport(int way, int wagonIndex){
        if((way > 0 && way <= amountWays) && ( wagonIndex > 0 && wagonIndex <= maxWagonsOnWay)){
            return ways.get(way).get(wagonIndex).getPassport();
        }
        else{
            return "ОШИБКА!";
        }
    }

    public String getTrainPassports(int way){
        String trainPassport = "";
        int i = 0;
        if(way > 0 && way <= amountWays){
            for(Wagon wagon: ways.get(way)){
                i++;
                trainPassport += i + " " + wagon.getPassport() + "\n";
            }
        }
        return trainPassport;
    }
}
