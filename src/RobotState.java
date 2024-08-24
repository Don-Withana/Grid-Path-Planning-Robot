public class RobotState {
    private int row;
    private int col;
    private Orientation orientation;

    public RobotState(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
