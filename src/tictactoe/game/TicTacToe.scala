package tictactoe.game

class TicTacToe {

  var lastPressed: Int = -1

  var whosTurn: String = "X"

  /*
  start with X's turn -> "Take your turn X"
  then O's turn       -> "Take your turn O"

  win condition       -> "X wins" / "O wins"
  tie condition       -> "cats game. click to reset"
   */

  val xTurnString: String = "Take your turn X"
  val oTurnString: String = "Take your turn O"
  val xWinString: String = "X wins. click to play again"
  val oWinString: String = "O wins. click to play again"
  val tieGameString: String = "cats game. click to play again"

  val stringMap: Map[String, String] = Map(
    "X" -> xTurnString,
    "O" -> oTurnString,
    "xwin" -> xWinString,
    "owin" -> oWinString,
    "tie" -> tieGameString
  )

  var gameBoard: Array[String] = Array("", "", "", "", "", "", "", "", "")

  def messageToDisplay(): String = {
    this.stringMap.getOrElse(this.whosTurn, "Error")
  }

  def getGameBoard: Array[String] = {
    this.gameBoard
  }

  def checkForWins(player: String): Unit = {
    val validLines: List[List[Int]] = List(
      List(0, 1, 2),
      List(3, 4, 5),
      List(6, 7, 8),
      List(0, 3, 6),
      List(1, 4, 7),
      List(2, 5, 8),
      List(0, 4, 8),
      List(2, 4, 6)
    )
    for(line <- validLines){
      if(line.forall(this.gameBoard(_) == player)){
        this.whosTurn = player.toLowerCase + "win"
      }
    }
  }

  def checkForTies(): Unit = {
    if (this.gameBoard.foldLeft(true)(_ && !_.isBlank)) {
      this.whosTurn = "tie"
    }
  }

  def buttonPressed(index: Int): Unit = {
    if (this.whosTurn == "X") {
      if (this.gameBoard(index) == "") {
        this.gameBoard(index) = "X"
        this.whosTurn = "O"
        this.checkForWins("X")
      }
    } else if (this.whosTurn == "O") {
      if (this.gameBoard(index) == "") {
        this.gameBoard(index) = "O"
        this.whosTurn = "X"
        this.checkForWins("O")
      }
    } else {
      // game's over
      gameBoard = Array("", "", "", "", "", "", "", "", "")
      this.whosTurn = "X"
    }
    this.checkForTies()
  }

}
