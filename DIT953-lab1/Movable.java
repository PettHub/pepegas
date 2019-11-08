interface Movable(){
    public void move();
    public void turnLeft();
    public void turnRight();
    private void incrementSpeed(double amount);
    private void decramentSpeed(double amount);
}