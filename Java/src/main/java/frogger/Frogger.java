package frogger;

/**
 * Refactor Task 1 & 2: Frogger
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22), Duan Liang (F23)
 */
public class Frogger {

    // Field for task 1.
    private final Road road;
    private int position;
    
    // Field for task 2. Anything to add/change?
    private final Records records;
    private final FroggerID froggerID;

    public Frogger(Road road, int position, Records records, FroggerID froggerID) {
        this.road = road;
        this.position = position;
        this.records = records;
        this.froggerID = froggerID;
    }

    /**
     * Moves Frogger.
     *
     * @param forward true is move forward, else false.
     * @return true if move successful, else false.
     */
    public boolean move(boolean forward) {
        int nextPosition = this.position + (forward ? 1 : -1);
        if (isTraversable(nextPosition)) {
            return false;
        }
        this.position = nextPosition;
        return true;
    }

    // This method is a refactored version of the original isOccupied method and the isValid method.
    /**
     * Checks if the position is valid and not occupied.
     * @param position the position to check.
     * @return true if the position is valid and not occupied, else false.
     */
    private boolean isTraversable(int position) 
    {
        boolean[] occupied = this.road.getOccupied();
        if(position < 0 || position >= occupied.length)
        {
            return false;
        }
        return !occupied[position];
    }

    /**
     * Records Frogger to the list of records.
     * 
     * @return true if record successful, else false.
     */
    public boolean recordMyself() {
        boolean success = records.addRecord(froggerID);
        return success;
    }

}
