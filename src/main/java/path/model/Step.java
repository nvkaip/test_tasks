package path.model;

public class Step {

    private int positionX;
    private int positionY;
    private Step prevStep;
    private String direction;
    private boolean isSolved = false;

    public Step(int x, int y, Step prevStep, String direction) {
        this.positionX = x;
        this.positionY = y;
        this.prevStep = prevStep;
        this.direction = direction;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public Step getPrevStep() {
        return prevStep;
    }

    public String getDirection() {
        return direction;
    }

    public boolean hasPrevious(){
        return prevStep != null;
    }
}
