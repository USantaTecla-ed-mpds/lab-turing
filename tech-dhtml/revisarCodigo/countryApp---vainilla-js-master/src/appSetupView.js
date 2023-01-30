
import { LocalStorageService } from "./localStorageService.js"


export class AppSetupView {

    #THEMES = { 
        light: 'style-light.css',
        dark: 'style-dark.css'
    }
    #EMPHASIS = {
        magenta: '#dc1478',
        cyan: '#00aeac',
        khaki: '#ccaa66'
    }
    #elementThemeRadio
    #elementEmphasisRadio


    constructor() {

        this.#elementThemeRadio = document.getElementsByName("theme-radio")
        this.#elementEmphasisRadio = document.getElementsByName("emphasis-radio")

        this.#addListenerToThemeRadio()
        this.#addListenerToEmphasisRadio()

        this.#updateTheme()
        this.#updateEmphasis()
    }


    #updateTheme() {

        let theme = LocalStorageService.getItem('theme')
        if (!theme) {
            theme = Object.keys(this.#THEMES)[0]
        }

        document.getElementById(theme).checked = true

        document.querySelector("link[id='theme']").href = "./" + this.#THEMES[theme]
    }

    #updateEmphasis() {

        let emphasis = LocalStorageService.getItem('emphasis')
        if (!emphasis) {
            emphasis = Object.keys(this.#EMPHASIS)[0]
        }

        document.getElementById(emphasis).checked = true

        const elementsEmphasis = document.getElementsByClassName("emphasis")
        for(let element of elementsEmphasis) {
            element.style.color = this.#EMPHASIS[emphasis]
        }
    }

    /////

    #addListenerToThemeRadio() {
        this.#elementThemeRadio.forEach((element) => {
            element.addEventListener("input", (event) => {
                LocalStorageService.setItem('theme', event.target.value)
                this.#updateTheme()
            })
        })
    }

    #addListenerToEmphasisRadio() {
        this.#elementEmphasisRadio.forEach((element) => {
            element.addEventListener("input", (event) => {
                LocalStorageService.setItem('emphasis', event.target.value)
                this.#updateEmphasis()
            })
        })
    }
}