import { Coordinate } from '../../types/Coordinate.js'
import { MessageDialog } from './MessageDialog.js'

export class BoardView {
  #board
  #messageDialog

  constructor(board) {
    this.#board = board
    this.#messageDialog = new MessageDialog(board);
    const section = document.getElementById('boardId');
    section.innerHTML = ''
    section.append(this.#createTable())
  }

  #createTable() {
    let table = document.createElement('table');
    table.append(this.#createRowH(0));
    for (let row = Coordinate.NUMBER_ROWS; row > 0; row--) {
      table.append(this.#createRow(row));
    }
    return table;
  }

  #createRowH(row) {
    let tr = document.createElement('tr')
    tr.id = 'controls'
    for (let column = 0; column < Coordinate.NUMBER_COLUMNS; column++) {
      let th = document.createElement('th')
      th.id = `Column-${column}-Control`
      tr.append(th)
    }
    return tr
  }

  #createRow(row) {
    let tr = document.createElement('tr')
    tr.id = `${row - 1}`
    for (let column = 0; column < Coordinate.NUMBER_COLUMNS; column++) {
      let td = document.createElement('td')
      td.id = `${row - 1}-${column}`
      tr.append(td)
    }
    return tr
  }

  addUpdateListener(onUpdate) {
    console.log(document.querySelectorAll('th'));
    document.querySelectorAll('th').forEach((headElement, column) => {
      headElement.addEventListener('click', () => {
        onUpdate(column)
      })
    })
  }

  update() {
    let lastToken = this.#board.getLastDrop()
    let color = this.#board.getColor(lastToken).toString()
    document.getElementById(`${lastToken.getRow()}-${lastToken.getColumn()}`)
      .style.backgroundImage = `url("../views/images/${color.toLowerCase()}-token.png")`
  }

  updateResults() {
    document.getElementById('controls').replaceWith(this.#createRowH())
    this.#messageDialog.update()
  }

}
