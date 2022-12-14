import { Game } from '../../models/Game.js'
import { TurnView } from './TurnView.js'
import { BoardView } from './BoardView.js'
import { assert } from '../../utils/assert.js'
import { NumPlayersDialog } from './NumPlayersDialog.js'
import { ResumeDialog } from './ResumeDialog.js'

export class GameView {

  #game
  #boardView
  #turnView

  constructor(){
    this.#init()
  }

  #init() {
    new NumPlayersDialog((numOfUsersPlayer) => {
      this.#game = new Game(numOfUsersPlayer)
      this.#turnView = new TurnView(this.#game.getTurn())
      this.#boardView = new BoardView(this.#game.getBoard())
      if (numOfUsersPlayer > 0) {
        this.#boardView.addUpdateListener(this.#onUpdate.bind(this))
      } else {
        this.#game.getActivePlayer().accept(this)
      }
    });
  }

  #onUpdate(column) {
    assert(!this.#game.isWinner())

    this.#turnView.dropToken(column)
    this.#boardView.update()
    if (!this.#game.isFinished()) {
      this.#game.getActivePlayer().accept(this)
    } else {
      this.#boardView.updateResults()
      new ResumeDialog(() => {
        this.#init()
      })
    }
  }

  visitUserPlayer() {
  }

  visitMachinePlayer() {
    setTimeout(() => {
      this.#onUpdate()
    }, 300)
  }

}

window.onload = () => {
  new GameView()
}
