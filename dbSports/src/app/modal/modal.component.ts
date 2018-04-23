import { Component } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

import { Participants } from '../participants/participants.model';
import { ParticipantsService } from '../participants/participants.service';
import { ParticipantsComponent } from '../participants/participants.component';
import { Events } from '../events/events.model';
import { EventsService } from '../events/events.service';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  events = new Events();
  isUpdate = false;
  callbackFunction : () => void;
  constructor(public bsModalRef: BsModalRef,
    public eventsService: EventsService) { }

    // onRegister() {
    //   if (this.isUpdate) {
    //     this.participantsService.putParticipants(this.participants, this.participants.id).subscribe(response => {
    //       this.callbackFunction();
    //       this.bsModalRef.hide();
    //     });
    //   } else {
    //     this.participantsService.postParticipants(this.participants).subscribe(response => {
    //       this.callbackFunction();
    //       this.bsModalRef.hide();
    //     });;
    //   }
    }
  

