package tictactoe.gui

import javafx.event.EventHandler
import javafx.event.ActionEvent
import tictactoe.game.TicTacToe

class ButtonAction(index: Int, game: TicTacToe) extends EventHandler[ActionEvent]{

  override def handle(event: ActionEvent): Unit = {
    game.buttonPressed(index)
  }

}
