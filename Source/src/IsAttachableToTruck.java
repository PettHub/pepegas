public interface IsAttachableToTruck {
    void attachToTruck(Truck newTruck);
    void detachFromTruck();
    void updateLocationAndDirection();
    boolean readyForMoving();
    int[] getCoordinates();
}
