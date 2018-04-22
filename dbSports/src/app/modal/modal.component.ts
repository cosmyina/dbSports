import { Component } from '@angular/core';
import { Events } from '../events/events.model';
import { EventsService } from '../events/events.service';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  events = new Events();
  callbackFunction : () => void;
  constructor(public bsModalRef: BsModalRef,
    public EventsService: EventsService) { }


}
