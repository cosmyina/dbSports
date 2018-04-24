import { Component, OnInit } from '@angular/core';
import { ParticipantsService } from './participants.service';
import { Participants } from './participants.model';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-participants',
  templateUrl: './participants.component.html',
  styleUrls: ['./participants.component.css']
})
export class ParticipantsComponent implements OnInit {
  participantsList: Participants[];
  constructor(private participantsService: ParticipantsService) { }

  ngOnInit() {
    this.getParticipants();
  }
  getParticipants(){
    this.participantsService.getParticipants().subscribe((response) => {
      this.participantsList = response;
    })
  }
}
