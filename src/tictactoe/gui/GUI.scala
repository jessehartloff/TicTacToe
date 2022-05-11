package tictactoe.gui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import scalafx.scene.layout.GridPane
import tictactoe.game.TicTacToe

object GUI extends JFXApp {

  val game: TicTacToe = new TicTacToe

  val buttons: Array[GameButton] = Array(
    new GameButton(0, game), new GameButton(1, game), new GameButton(2, game),
    new GameButton(3, game), new GameButton(4, game), new GameButton(5, game),
    new GameButton(6, game), new GameButton(7, game), new GameButton(8, game)
  )

  val messages: TextField = new TextField {
    this.style = "-fx-font: 20 ariel;"
    this.text = "Welcome to TicTacToe! change"
  }

  this.stage = new PrimaryStage {
    this.title = "TicTacToe"
    this.scene = new Scene() {
      this.content = List(
        new GridPane {
          add(buttons(0), 0, 0)
          add(buttons(1), 1, 0)
          add(buttons(2), 2, 0)

          add(buttons(3), 0, 1)
          add(buttons(4), 1, 1)
          add(buttons(5), 2, 1)

          add(buttons(6), 0, 2)
          add(buttons(7), 1, 2)
          add(buttons(8), 2, 2)

          add(messages, 0,3,3,1)
        }

      )
    }

    addEventFilter(MouseEvent.MOUSE_CLICKED, (_:MouseEvent) => messages.text = game.messageToDisplay())

  }

}
