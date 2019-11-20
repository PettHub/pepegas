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
        if (this.contents.size()<this.capacity && this.getAngle()==0 && czechIfCarIsCloseToFlak(bil)) {
            updateCarLocationAndDirection(bil);
            this.contents.add(bil);
        }
    }
    public void removeCarFromFlak() {
        if (this.contents.size() > 0 && this.getAngle()==0) {
            Car bil = this.contents.remove(contents.size()-1);
            updateCarLocationAndDirectionUponCarRemoval(bil);
        }
    }
    public void updateAllTheCars(){
        for (Car bil : contents){
            updateCarLocationAndDirection(bil);
        }
    }

    private void updateCarLocationAndDirection(Car bil){
        bil.setDx(this.getDx());
        bil.setDy(this.getDy());
        bil.setX(this.getX());
        bil.setY(this.getY());
    }
    private void updateCarLocationAndDirectionUponCarRemoval(Car bil){
        bil.setDx(this.getDx());
        bil.setDy(this.getDy());
        bil.setX(this.getX()-Math.cos(getTruck().getDirection()*20));
        bil.setY(this.getY()-Math.sin(getTruck().getDirection()*20));
    }
    private boolean czechIfCarIsCloseToFlak(Car bil){
        return czechIfXOfCarIsInProximityToXOfFlak(bil) && czechIfYOfCarIsInProximityToYOfFlak(bil);
    }
    private boolean czechIfXOfCarIsInProximityToXOfFlak(Car bil){
        return (40>Math.sqrt(Math.pow(this.getX()-bil.getX(), 2)));
    }
    private Boolean czechIfYOfCarIsInProximityToYOfFlak(Car bil){
        return (40>Math.sqrt(Math.pow(this.getY()-bil.getY(), 2)));
    }
}
