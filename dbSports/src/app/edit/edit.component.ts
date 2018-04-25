import { Component, OnInit } from '@angular/core';
import { EventsService } from '../events/events.service';
import { Events } from '../events/events.model';
import { Participants } from '../participants/participants.model';
import { ParticipantsService } from '../participants/participants.service';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { BsModalService } from 'ngx-bootstrap/modal/bs-modal.service';
import { ModalEventComponent } from '../modal-event/modal-event.component';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  eventsList: Events[];
  participantsList: Participants[];
  bsModalRef: BsModalRef;
  constructor(private eventsService: EventsService,
    private participantsService: ParticipantsService,
    private modalEventService: BsModalService) { 
    
  }

  ngOnInit(){
    this.getEvents();
    this.getParticipants();
  }
  getEvents(){
    this.eventsService.getEvents().subscribe((response) => {
      console.log('get events', response);
      this.eventsList = response;
    })
  }
  getParticipants(){
    this.participantsService.getParticipants().subscribe((response) => {
      this.participantsList = response;
    })
  }
  deleteEvent(id: number){
    this.eventsService.deleteEvents(id).subscribe((response) => {
      this.getEvents();
    })
  }
  deleteParticipant(id: number){
    this.participantsService.deleteParticipants(id).subscribe((response) => {
      this.getParticipants();
    })
  }
  openEventModal(eventId, eventName) {
    const initialState = { eventId, eventName };
    this.bsModalRef = this.modalEventService.show(ModalEventComponent, { initialState });
  }

}
