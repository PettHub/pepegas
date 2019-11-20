import java.util.ArrayList;
import java.util.List;

public class CarTransportFlak extends Flak{
    private List<Car> contents = new ArrayList<>();
    private final int capacity;
    public CarTransportFlak(int capacity) {
        super(1);
        this.capacity = capacity;
    }

    public void addCarToFlak(Car bil) {
        if (this.contents.size()<this.capacity) {
            updateCarLocationAndDirection(bil);
            this.contents.add(bil);
        }
    }
    public void removeCarFromFlak() {
        if (this.contents.size() > 0) {
            Car bil = this.contents.remove(contents.size()-1);
            updateCarLocationAndDirectionUponFlakRemoval(bil);
        }
    }

    @Override
    public void updateLocationAndDirection() {
        super.updateLocationAndDirection();
    }

    private void updateCarLocationAndDirection(Car bil){
        bil.setDx(this.getDx());
        bil.setDy(this.getDy());
        bil.setX(this.getX());
        bil.setY(this.getY());
    }
    private void updateCarLocationAndDirectionUponFlakRemoval(Car bil){
        bil.setDx(0);
        bil.setDy(0);
        bil.setX(this.getX()-Math.cos(getTruck().getDirection()*20));
        bil.setY(this.getY()-Math.sin(getTruck().getDirection()*20));
    }
}
