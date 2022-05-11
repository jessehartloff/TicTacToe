package tictactoe.game

class TicTacToe {

  var lastPressed: Int = -1

  def messageToDisplay(): String = {
    "last pressed: " + this.lastPressed
  }

  def buttonPressed(index: Int): Unit = {
    lastPressed = index
  }

}
