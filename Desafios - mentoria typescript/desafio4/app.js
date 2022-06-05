"use strict";
//RESPOSTA
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
let apiKey = '2d65c5581f74742a7a75810da655e0e6';
let username;
let password;
let loginButton = document.getElementById('login-button');
let searchButton = document.getElementById('search-button');
let searchContainer = document.getElementById('search-container');
let apikey = document.getElementById('api-key');
let titlefilm = document.getElementById('p-titlefilm');
//input login - receiving value validate login button
function preencherLogin() {
    let login = document.getElementById('login');
    username = login.value;
    validateLoginButton();
}
//input password - receiving value validate login button
function preencherSenha() {
    let senha = document.getElementById('senha');
    password = senha.value;
    validateLoginButton();
}
//input apikey - receiving value validate login button
function preencherApi() {
    apiKey = apikey.value;
    validateLoginButton();
}
//validate login button
function validateLoginButton() {
    if (password && username && apiKey) {
        loginButton.disabled = false;
        apikey.value = apiKey; //REMOVER  - REMOVER  - REMOVER  - REMOVER  - REMOVER  - REMOVER  - REMOVER  - REMOVER  - REMOVER
    }
    else {
        loginButton.disabled = true;
    }
}
//method Search Films in API
function procurarFilme(query) {
    return __awaiter(this, void 0, void 0, function* () {
        query = encodeURI(query);
        console.log(query);
        let result = yield HttpClient.get({
            url: `https://api.themoviedb.org/3/search/movie?api_key=${apiKey}&query=${query}`,
            method: "GET"
        });
        return result;
    });
}
// fill container with list of movies
if (searchButton) {
    searchButton.addEventListener('click', () => __awaiter(void 0, void 0, void 0, function* () {
        let listasearch = document.getElementById("listasearch");
        if (listasearch) {
            listasearch.outerHTML = "";
            titlefilm.hidden = true;
        }
        let query = document.getElementById('search');
        let listaDeFilmes = yield procurarFilme(query.value);
        // let ul = document.createElement('ul');
        let div = document.createElement('div');
        div.id = "listasearch";
        for (const item of listaDeFilmes.results) {
            let p = document.createElement('p');
            let img = document.createElement('img');
            let a = document.createElement('a');
            let imglink = `https://image.tmdb.org/t/p/w500/` + item.poster_path;
            div.setAttribute("style", "display:flex; flex-direction:column; align-content:center;");
            img.setAttribute("src", imglink);
            img.setAttribute("style", "border: solid 1px #000; float: left; margin-right:10px;");
            img.height = 90;
            a.setAttribute("href", imglink);
            a.setAttribute("target", "_blank");
            p.setAttribute("title", "click to see enlarged image");
            p.setAttribute("style", " line-height:100px; float: left; font-size:12px; font-family: Arial, Helvetica, sans-serif; color:#000;");
            document.body.appendChild(div);
            document.body.appendChild(a);
            p.appendChild(img);
            p.appendChild(document.createTextNode(item.original_title + '  |  id.(' + item.id + ')'));
            a.appendChild(p);
            div.appendChild(a);
        }
        if (titlefilm) {
            titlefilm.hidden = false;
        }
        console.log(listaDeFilmes);
        if (searchContainer) {
            searchContainer.appendChild(div);
        }
    }));
}
//fill body of site
class HttpClient {
    static get({ url, method, body = null }) {
        return __awaiter(this, void 0, void 0, function* () {
            return new Promise((resolve, reject) => {
                let request = new XMLHttpRequest();
                request.open(method, url, true);
                request.onload = () => {
                    if (request.status >= 200 && request.status < 300) {
                        resolve(JSON.parse(request.responseText));
                    }
                    else {
                        reject({
                            status: request.status,
                            statusText: request.statusText
                        });
                    }
                };
                request.onerror = () => {
                    reject({
                        status: request.status,
                        statusText: request.statusText
                    });
                };
                if (body) {
                    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                    body = JSON.stringify(body);
                }
                request.send(body);
            });
        });
    }
}
