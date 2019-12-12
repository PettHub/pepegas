import java.util.Observable;
import java.util.Observer;

public class Main extends Observable {
    int number = 1;
    double number2 = 25.3;
    public Main(){
        this.number = 2;
    }
    void addObservers(Observer o){
        this.addObserver(o);
    }
    void updateObservers(){
        notifyObservers();
    }
    public static void main(String[] args) {
        Main main = new Main();
        view1 v1 = new view1(100, 100);
        view2 v2 = new view2(50, 200);
        v1.main=main;
        main.addObserver(v1);
        main.setChanged();
        main.updateObservers();
        combined comb = new combined(400, 500);
        comb.add(v1);
        comb.add(v2);
        comb.setVisible(true);
    }
}
