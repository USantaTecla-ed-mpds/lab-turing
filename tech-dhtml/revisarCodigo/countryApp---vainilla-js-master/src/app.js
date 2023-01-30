
import { CountryFilterView } from './countryFilterView.js'
import { CountrySelectorView } from './countrySelectorView.js'
import { CountryInfoView } from './countryInfoView.js'
import { AppSetupView } from './appSetupView.js'


class CountryApp {

    constructor() {

        new CountryFilterView()
        new CountrySelectorView()
        new CountryInfoView()
        new AppSetupView()
    }
}


function run() {
    new CountryApp()
}

run()
