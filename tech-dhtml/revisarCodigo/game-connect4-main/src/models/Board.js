import { Coordinate } from '../types/Coordinate.js'
import { Color } from '../types/Color.js'
import { Line } from './Line.js'
import { Direction } from '../types/Direction.js'
import {assert} from "../utils/assert.js";

export class Board {
  #colors
  #lastDrop

  constructor() {
    this.#colors = []
    for (let i = 0; i < Coordinate.NUMBER_ROWS; i++) {
      this.#colors[i] = []
      for (let j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
        this.#colors[i][j] = Color.NULL
      }
    }
  }

  dropToken(column, color) {
    assert(!this.isComplete(column))
    assert(!this.isWinner())
    this.#lastDrop = new Coordinate(0, column)
    while (!this.isEmpty(this.#lastDrop)) {
      this.#lastDrop = this.#lastDrop.shifted(Direction.NORTH.getCoordinate())
    }
    this.#colors[this.#lastDrop.getRow()][this.#lastDrop.getColumn()] = color

  }

  isComplete(column) {
    if (column !== undefined) {
      return !this.isEmpty(new Coordinate(Coordinate.NUMBER_ROWS - 1, column))
    }
    for (let i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
      if (!this.isComplete(i)) {
        return false
      }
    }
    return true
  }

  isFinished() {
    return this.isComplete() || this.isWinner()
  }

  isWinner() {
    if (this.#lastDrop === undefined) {
      return false
    }
    let line = new Line(this.#lastDrop)
    for (let direction of Direction.values().splice(0, 4)) {
      line.set(direction)
      for (let i = 0; i < Line.LENGTH; i++) {
        if (this.isConnect4(line)) {
          return true
        }
        line.shift()
      }
    }
    return false
  }

  isConnect4(line) {
    let coordinates = line.getCoordinates()
    for (let i = 0; i < Line.LENGTH; i++) {
      if (!coordinates[i].isValid()) {
        return false
      }
      if (
        i > 0 &&
        this.getColor(coordinates[i - 1]) !== this.getColor(coordinates[i])
      ) {
        return false
      }
    }
    return true
  }

  isOccupied(coordinate, color) {
    return this.getColor(coordinate) === color
  }

  isEmpty(coordinate) {
    return this.isOccupied(coordinate, Color.NULL)
  }

  getColor(coordinate) {
    return this.#colors[coordinate.getRow()][coordinate.getColumn()]
  }

  getLastDrop() {
    return this.#lastDrop
  }
}
