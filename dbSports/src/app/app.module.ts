import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ModalModule } from 'ngx-bootstrap/modal';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { EventsComponent } from './events/events.component';

import { SliderComponent } from './slider/slider.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { EventsService } from './events/events.service';
import { ModalComponent } from './modal/modal.component';
import { ParticipantsComponent } from './participants/participants.component';
import { ParticipantsService } from './participants/participants.service';
import { ButtonsModule } from 'ngx-bootstrap/buttons';

const appRoutes: Routes = [
  { path: 'events', component: EventsComponent },
  { path: '', redirectTo: '/events', pathMatch: 'full' },
  { path: 'participants', component: ParticipantsComponent },
];


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ModalModule.forRoot(),
    ButtonsModule.forRoot()
   ],
   declarations: [
    AppComponent, 
    HeaderComponent,
    EventsComponent,
    SliderComponent,
    FooterComponent,
    ModalComponent,
    ParticipantsComponent,
  
  ],
  bootstrap: [AppComponent],
  providers: [HttpClientModule, EventsService, ParticipantsService],
  entryComponents: [ModalComponent]
})
export class AppModule { }
