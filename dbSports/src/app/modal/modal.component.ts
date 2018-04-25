import { Component } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

import { ParticipantsService } from '../participants/participants.service';
import { ParticipantsComponent } from '../participants/participants.component';
import { Events } from '../events/events.model';
import { EventsService } from '../events/events.service';
import { Participants } from '../participants/participants.model';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  participants = new Participants;
  eventId: number;
  eventName: string;
  
  constructor(public bsModalRef: BsModalRef,
    public participantsService: ParticipantsService) { }

    onSave(eventId, eventName) {
     this.participants.eventId =eventId;
     this.participants.eventName =eventName;
     this.participantsService.postParticipants(this.participants).subscribe(response => {
      debugger;
        this.bsModalRef.hide();
     })
    }
    
  }

 