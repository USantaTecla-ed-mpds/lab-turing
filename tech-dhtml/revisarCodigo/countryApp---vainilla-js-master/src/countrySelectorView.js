
import { CountryDataService } from './countryDataService.js'
import { LocalStorageService } from "./localStorageService.js"
import { CountryInfoView } from './countryInfoView.js'


export class CountrySelectorView {

    #countryDataService
    #countryInfoView
    #elemCountrySelector

    constructor() {
    
        this.#countryDataService = new CountryDataService()
        this.#countryInfoView = new CountryInfoView()
        this.#elemCountrySelector = document.getElementById("country-selector")
        this.#addListenerToCountrySelector()
    }


    async initElemCountrySelector(filterRadio, filterSelector) {

        await this.#renderElemCountrySelector(filterRadio, filterSelector);

        const firstCountrySelector = this.#elemCountrySelector.options[0].value
        const countrySelector = LocalStorageService.initItem('countrySelector', firstCountrySelector)
        this.#elemCountrySelector.value = countrySelector
        this.#countryInfoView.renderCountryInfo(countrySelector)
    }

    async updateElemCountrySelector(filterRadio, filterSelector) {

        await this.#renderElemCountrySelector(filterRadio, filterSelector);

        const firstCountrySelector = this.#elemCountrySelector.options[0].value
        const countrySelector = LocalStorageService.setItem('countrySelector', firstCountrySelector)
        this.#elemCountrySelector.value = countrySelector
        this.#countryInfoView.renderCountryInfo(countrySelector)
    }

    async #renderElemCountrySelector(filterRadio, filterSelector) {

        let countryData

        if (filterRadio === 'all') {
            countryData = await this.#countryDataService.getCountryDataAll()
        } else if (filterRadio === 'regions') {
            countryData = await this.#countryDataService.getCountryDataByRegion(filterSelector)
        } else if (filterRadio === 'subregions') {
            countryData = await this.#countryDataService.getCountryDataBySubregion(filterSelector)
        }

        const countryDataSorted = countryData.sort(
            (a,b) => a.name.common < b.name.common ? -1 : a.name.common > b.name.common ? 1 : 0
        )

        let countryOptions = ""
        for (const country of countryDataSorted) {
            countryOptions += "<option value='" + country.cca2 + "'>" + country.name.common + "</option>"
        }

        this.#elemCountrySelector.innerHTML = countryOptions
    }

    /////

    #addListenerToCountrySelector() {

        this.#elemCountrySelector.addEventListener("input", (event) => {
            // console.log('Event -> INPUT country-selector')
            const countrySelector = event.target.value
            LocalStorageService.setItem('countrySelector', countrySelector)
            this.#countryInfoView.renderCountryInfo(countrySelector)
        })
    }
}
