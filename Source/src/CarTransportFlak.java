import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransportFlak extends Flak{
    protected Deque<Car> contents = new ArrayDeque<>();
    private final int capacity;
    public CarTransportFlak(int capacity, int maxAngle, Truck truck) {
        super(maxAngle);
        this.capacity = capacity;
    }

    public void addCarToFlak(Car bil) {
        if (this.contents.size()<this.capacity)
            this.contents.push(bil);
    }
    public Object removeCarFromFlak(Car bil) {
        return this.contents.pop();
    }

    @Override
    public void updateLocationAndDirection() {
        super.updateLocationAndDirection();
    }
}
