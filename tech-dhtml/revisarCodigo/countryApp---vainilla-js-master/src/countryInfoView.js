
import { CountryDataService } from './countryDataService.js'


export class CountryInfoView {

    #countryDataService;

    constructor() {

        this.#countryDataService = new CountryDataService()
    }


    async renderCountryInfo(countryCode) {

        const countryInfo = await this.#countryDataService.getCountryDataByCode(countryCode)

        document.getElementById("country-name").innerHTML = countryInfo.name.common
        document.getElementById("country-code").innerHTML = " (" + countryInfo.cca2 + ")"
        document.getElementById("country-capital").innerHTML = countryInfo.capital
        document.getElementById("country-area").innerHTML = countryInfo.area.toLocaleString('es-ES')
        document.getElementById("country-population").innerHTML = countryInfo.population.toLocaleString('es-ES')
        document.getElementById("country-languages").innerHTML = Object.values(countryInfo.languages)
        document.getElementById("country-currencies").innerHTML = Object.keys(countryInfo.currencies).map(
            (valor) => countryInfo.currencies[valor].name + " (" + countryInfo.currencies[valor].symbol + ")"
        )
        document.getElementById("country-flag").src = countryInfo.flags.png
    }
}
