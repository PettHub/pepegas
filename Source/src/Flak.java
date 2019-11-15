import java.util.ArrayDeque;
import java.util.Deque;

public class Flak {
    private Deque<Object> contents = new ArrayDeque<>();
    private int capacity;
    private int angle;

    public Flak(int capacity) {
        this.capacity = capacity;
        this.angle = 0;
    }
    public void currentLoad(){
        for (int x = 0; x<contents.size(); x++){
            System.out.println(contents.peek());
        }
        return ;
    }
    public void addCarToFlak(Car bil) {
        if (this.contents.size()<this.capacity)
            this.contents.push(bil);
    }
    public Object removeCarFromFlak(Car bil) {
        return this.contents.pop();
    }

}
