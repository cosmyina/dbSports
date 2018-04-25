import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Events } from '../events/events.model';
import { EventsService } from '../events/events.service';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: 'app-modal-event',
  templateUrl: './modal-event.component.html',
  styleUrls: ['./modal-event.component.css']
})

export class ModalEventComponent {

 
  router: Router;
  events = new Events();
  callbackFunction : () => void;
  
  
  constructor(public bsModalRef: BsModalRef,
    public eventsService: EventsService,
    router: Router) { 
      this.router = router;
    }

  onAddEvent(form) {
    
    if(form.valid){ 
      this.eventsService.postEvents(this.events).subscribe(response => {
       this.bsModalRef.hide();
       
       
    })
    }

   }


}
