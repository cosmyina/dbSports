import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Events } from './events.model';

@Injectable()
export class EventsService {

  constructor(private http: HttpClient) { }

  getEvents(): Observable<Events[]> {
    return this.http.get('http://localhost:8081/dbSports-app/competition') as Observable<Events[]>;
  }

  postEvents(events :Events): Observable<Events> {
    return this.http.post('http://localhost:8081/dbSports-app/competition', events) as Observable<Events>;
  }

  putEvents(events: Events, id: number): Observable<Events> {
    return this.http.put(`http://localhost:8081/dbSports-app/competition/${id}`, events) as Observable<Events>;
  }

  deleteEvents(id: number): Observable<Events> {
    return this.http.delete(`http://localhost:8081/dbSports-app/competition/${id}`) as Observable<Events>;
  }


}