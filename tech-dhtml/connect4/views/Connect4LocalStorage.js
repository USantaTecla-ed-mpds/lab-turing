export class Connect4LocalStorage {

    saveGame(connect4){
        const key=Date.now().toString();
        window.localStorage.setItem(key, JSON.stringify(connect4));
    }

    getKeysOfSavedGames(){
        let keys=[];
        for(let key in window.localStorage){
           if(window.localStorage.getItem(key)){
            
            keys.push(key);
           } 
        }
        return keys;
    }

    loadGameByKey(key){
        return JSON.parse(window.localStorage.getItem(key));
    }
}