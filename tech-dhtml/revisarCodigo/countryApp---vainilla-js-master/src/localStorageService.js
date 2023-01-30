
export class LocalStorageService {


    static getItem(key) {

        return localStorage.getItem(key)
    }


    static setItem(key, value) {

        localStorage.setItem(key, value)
        return value
    }


    static initItem(key, defaultValue) {

        let value = localStorage.getItem(key)
        if (!value) {
            value = defaultValue
            localStorage.setItem(key, value)
        }
        return value
    }
}