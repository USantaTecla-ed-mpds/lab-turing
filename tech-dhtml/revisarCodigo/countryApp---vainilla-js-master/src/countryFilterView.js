
import { LocalStorageService } from "./localStorageService.js";
import { CountrySelectorView } from './countrySelectorView.js';


export class CountryFilterView {

    #FILTERS = {
        all: ['World'],
        regions: ['Africa','Americas','Asia','Europe','Oceania'],
        subregions: [
            'Australia and New Zealand','Central America','Caribbean','Central Asia',
            'North America','South America','Southern Africa','Southern Europe','Western Europe'
        ]
    }

    #countrySelectorView
    #elemFilterRadio
    #elemFilterSelector
    #filterRadio


    constructor() {

        this.#countrySelectorView = new CountrySelectorView()
        this.#elemFilterRadio = document.getElementsByName("filter-radio")
        this.#elemFilterSelector = document.getElementById("filter-selector")
        this.#addListenerToFilterRadio()
        this.#addListenerToFilterSelector()
        this.#initElements()
    }

    #initElements() {

        const defaultFilterRadio = Object.keys(this.#FILTERS)[0]
        this.#filterRadio = LocalStorageService.initItem('filterRadio', defaultFilterRadio)
        document.getElementById(this.#filterRadio).checked = true

        this.#renderElemFilterSelector()

        const defaultFilterSelector = (this.#FILTERS[this.#filterRadio])[0]
        const filterSelector = LocalStorageService.initItem('filterSelector', defaultFilterSelector)
        this.#elemFilterSelector.value = filterSelector

        this.#countrySelectorView.initElemCountrySelector(this.#filterRadio, filterSelector)
    }

    #updateElemFilterSelector() {

        this.#renderElemFilterSelector()

        const defaultFilterSelector = (this.#FILTERS[this.#filterRadio])[0]
        LocalStorageService.setItem('filterSelector', defaultFilterSelector)
        this.#elemFilterSelector.value = defaultFilterSelector
        this.#countrySelectorView.updateElemCountrySelector(this.#filterRadio, defaultFilterSelector)
    }

    #renderElemFilterSelector() {

        let options = ""
        for (const option of this.#FILTERS[this.#filterRadio]) {
            options += "<option value='" + option + "'>" + option + "</option>"
        }
        this.#elemFilterSelector.innerHTML = options
    }

    /////

    #addListenerToFilterRadio() {
    
        this.#elemFilterRadio.forEach((element) => {
            element.addEventListener("input", (event) => {
                // console.log('Event -> INPUT filter-radio')
                this.#filterRadio = event.target.value
                LocalStorageService.setItem('filterRadio', this.#filterRadio)
                this.#updateElemFilterSelector()
            })
        })
    }

    #addListenerToFilterSelector() {

        this.#elemFilterSelector.addEventListener("input", (event) => {
            // console.log('Event -> INPUT filter-selector')
            const filterSelector = event.target.value
            LocalStorageService.setItem('filterSelector', filterSelector)
            this.#countrySelectorView.updateElemCountrySelector(this.#filterRadio, filterSelector)
        })
    }
}
