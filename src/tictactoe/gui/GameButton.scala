package tictactoe.gui

import scalafx.scene.control.Button
import tictactoe.game.TicTacToe

class GameButton(index: Int, game: TicTacToe) extends Button {
  this.minWidth = 120
  this.minHeight = 120
  this.text = ""
  this.style = "-fx-font: 42 ariel;"
  this.onAction = new ButtonAction(index, game)
}
