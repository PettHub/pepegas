public class CarTransportFlak extends Flak{

    public CarTransportFlak(int capacity, int maxAngle, Truck truck) {
        super(capacity, maxAngle, truck);
    }

    public void addCarToFlak(Car bil) {
        if (this.contents.size()<this.getCapacity())
            this.contents.push(bil);
    }
    public Object removeCarFromFlak(Car bil) {
        return this.contents.pop();
    }
}
