import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Participants } from '../participants/participants.model';
import { Events } from '../events/events.model';

@Injectable()
export class EditService {

  constructor(private http: HttpClient) { }

//   getParticipants(): Observable<Participants[]> {
//     return this.http.get('http://localhost:3000/participants') as Observable<Participants[]>;
//   }

//   postParticipants(participants :Participants): Observable<Participants> {
//     return this.http.post('http://localhost:3000/participants/', participants) as Observable<Participants>;
//   }

//   putParticipants(participants: Participants, id: number): Observable<Participants> {
//     return this.http.put(`http://localhost:3000/participants/${id}`, participants) as Observable<Participants>;
//   }

//   deleteParticipants(id: number): Observable<Participants> {
//     return this.http.delete(`http://localhost:3000/participants/${id}`) as Observable<Participants>;
//   }
  getEvents(): Observable<Events[]> {
    return this.http.get('http://localhost:3000/events') as Observable<Events[]>;
  }

  postEvents(events :Events): Observable<Events> {
    return this.http.post('http://localhost:3000/events', events) as Observable<Events>;
  }

  putEvents(events: Events, id: number): Observable<Events> {
    return this.http.put(`http://localhost:3000/events/${id}`, events) as Observable<Events>;
  }

  deleteEvents(id: number): Observable<Events> {
    return this.http.delete(`http://localhost:3000/events/${id}`) as Observable<Events>;
  }
  
}