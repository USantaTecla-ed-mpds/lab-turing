import { Color } from '../../types/Color.js'

export class TurnView {

  #turn

  constructor(turn) {
    this.#turn = turn
    this.#update()
  }

  #update() {
    let activeColor = this.#turn.getActivePlayer().getColor().toString()
    for(let color of Color.values()){
      document.getElementById(color+`Id`).style.opacity = activeColor === color ? 1 : 0.2
    }
    document.querySelectorAll('th').forEach((th) => {
      th.style.setProperty(
        `--th-background-image`,
        `url("../images/${activeColor.toLowerCase()}-token.png")`
      )
    })
  }

  dropToken(column) {
    this.column = column
    this.#turn.getActivePlayer().accept(this)
    this.#turn.next()
    this.#update()
  }

  visitUserPlayer(userPlayer) {
    userPlayer.dropToken(this.column)
    delete this.column
  }

  visitMachinePlayer(machinePlayer) {
    machinePlayer.dropToken(machinePlayer.getColumn())
  }

}
