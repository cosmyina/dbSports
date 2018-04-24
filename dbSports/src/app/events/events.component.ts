import { Component, OnInit} from '@angular/core';
import { EventsService } from './events.service';
import { Events } from './events.model';
import { RouterLink } from '@angular/router';
import { ModalComponent } from '../modal/modal.component';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { BsModalService } from 'ngx-bootstrap/modal/bs-modal.service';


@Component({
    selector: 'app-events',
    templateUrl: './events.component.html',
    styleUrls: ['./events.component.css']
  })
  export class EventsComponent implements OnInit{
    eventsList: Events[];
    bsModalRef: BsModalRef;;
    
   constructor(private eventsService: EventsService,
    private modalService: BsModalService
    ){

   }
   ngOnInit(){
     this.getEvents();
   }

   getEvents(){
     this.eventsService.getEvents().subscribe((response) => {
       console.log('get events', response);
       this.eventsList = response;
     })
   }

   openRegisterModal(eventId) {
    const initialState = { eventId };
    this.bsModalRef = this.modalService.show(ModalComponent, { initialState });
  }
  // getEventId(){
  //     const initialState = { events: Object.assign({}, events, callbackFunction: this. getEventId.bind(this), isUpdate: true};
  //     this.bsModalRef = this.modalService.show(ModalComponent, {initialState});

  // }
  }