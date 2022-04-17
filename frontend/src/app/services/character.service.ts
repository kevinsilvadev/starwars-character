import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { Character } from '../models/character';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  url = "http://localhost:9000/characters"

  constructor(private httpCliente: HttpClient) { }

  httpOptions = {
    http: new HttpHeaders({ 'Content-type': 'application/json' })
  }

  getCharacters(): Observable<Character[]> {
    return this.httpCliente.get<Character[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }



  getCharacterByName(name: String): Observable<Character[]> {
    return this.httpCliente.get<Character[]>(this.url + '/' + name)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };


}
