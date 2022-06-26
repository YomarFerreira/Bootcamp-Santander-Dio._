import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()


export class BooksService {
    //private url = 'https://localhost:44382/api/bookstore'
    //private url = "https://sheet.best/api/sheets/7227561f-6f49-44da-91a5-1bfdb2039a84"
    private url = "https://sheet.best/api/sheets/3f67348f-df1e-4a9e-bbde-945e4377972e"

    httpOptions={
        Headers: new HttpHeaders({ 'content-type':'application/json'})

    }

    constructor(private http:HttpClient){}


    getBook(){

        return this.http.get(this.url)

    }




}