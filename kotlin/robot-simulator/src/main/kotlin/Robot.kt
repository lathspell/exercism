import Orientation.*

// I wanted private setters for the properties even if that takes some more lines
// changed: Learned from taigua's solution that ctor variables can have same name as properties
// changed: Learned from araqnid's solution how to use copy()
// changed: Got reminded from vrto's solution to always add an "else" case in a "when"
class Robot(gridPosition: GridPosition = GridPosition(0, 0), orientation: Orientation = NORTH) {

    var gridPosition: GridPosition = gridPosition
        private set

    var orientation: Orientation = orientation
        private set

    fun advance() {
        gridPosition = with(gridPosition) {
            when (orientation) {
                NORTH -> copy(y = y + 1)
                EAST -> copy(x = x + 1)
                SOUTH -> copy(y = y - 1)
                WEST -> copy(x = x - 1)
            }
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }
    }

    fun turnRight() {
        turnLeft(); turnLeft(); turnLeft() // :-)
    }

    fun simulate(orders: String) {
        orders.forEach {
            when (it) {
                'L' -> turnLeft()
                'R' -> turnRight()
                'A' -> advance()
                else -> throw IllegalArgumentException("Invalid command $it!")
            }
        }
    }

}