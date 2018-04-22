import { Component, OnInit} from '@angular/core';
import { EventsService } from './events.service';
import { Events } from './events.model';
import { RouterLink } from '@angular/router';



@Component({
    selector: 'app-events',
    templateUrl: './events.component.html',
    styleUrls: ['./events.component.css']
  })
  export class EventsComponent implements OnInit{
    eventsList: Events[];
    
   constructor(private eventsService: EventsService
    ){
     
   }
   ngOnInit(){
     this.getEvents();
   }
   getEvents(){
     this.eventsService.getEvents().subscribe((response) => {
       this.eventsList = response;
     })
   }
  }