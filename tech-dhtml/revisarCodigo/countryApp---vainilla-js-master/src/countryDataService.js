
export class CountryDataService {

    #APIurl = 'https://restcountries.com/v3.1/'

    async getCountryDataAll() {
        const url = this.#APIurl + "all"
        return await this.#requestCountries(url)
    }

    async getCountryDataByCode(code) {
        const url = this.#APIurl + "alpha/" + code
        return await this.#requestCountries(url, true)
    }

    async getCountryDataByRegion(region) {
        const url = this.#APIurl + "region/" + region
        return await this.#requestCountries(url)
    }

    async getCountryDataBySubregion(subregion) {
        const url = this.#APIurl + "subregion/" + subregion
        return await this.#requestCountries(url)
    }



    async #requestCountries(url, isOneObjectArray) {
        const response = await fetch(url)
        if(response.ok) {
            const jsonValue = await response.json()
            return !!isOneObjectArray ? jsonValue[0] : jsonValue
        } else {
            alert("API request rejected")
        }
    }
}
