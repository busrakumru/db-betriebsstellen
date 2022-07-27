import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Betriebsstelle } from '../interface/betriebsstelle';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  private baseUrl = 'https://localhost:8443';


  constructor(private http: HttpClient) { }

  getBetriebsstellen(): Observable<Betriebsstelle[]> {
    return this.http.get<Betriebsstelle[]>(this.baseUrl + '/db/betriebsstellen');
  }

}