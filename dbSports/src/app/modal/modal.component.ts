import { Component } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

import { ParticipantsService } from '../participants/participants.service';
import { ParticipantsComponent } from '../participants/participants.component';
import { Events } from '../events/events.model';
import { EventsService } from '../events/events.service';
import { Participants } from '../participants/participants.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  router: Router;
  participants = new Participants();
  eventId: number;
  
  constructor(public bsModalRef: BsModalRef,
    public participantsService: ParticipantsService,
    router: Router) { 
      this.router = router;
    }

    onSave(form) {
    
     this.participants.eventId= this.eventId;
     
     if(form.valid){ 
       this.participantsService.postParticipants(this.participants).subscribe(response => {
        this.bsModalRef.hide();
        
        this.router.navigate['/participants'];
       
     })
     }

    }
    
  }

 