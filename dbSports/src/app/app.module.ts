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
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { AdminComponent } from './admin/admin.component';
import { EditComponent } from './edit/edit.component';
import { AdminService } from './admin/admin.component.service';
import { EditService } from './edit/edit.service';




const appRoutes: Routes = [
  { path: 'events',  component: EventsComponent },
  { path: '', redirectTo: '/events', pathMatch: 'full' },
  { path: 'participants', component: ParticipantsComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'admin/edit', component: EditComponent }

];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ModalModule.forRoot(),
    ButtonsModule.forRoot(),
    CarouselModule.forRoot()
   ],
   declarations: [
    AppComponent, 
    HeaderComponent,
    EventsComponent,
    SliderComponent,
    FooterComponent,
    ModalComponent,
    ParticipantsComponent,
    AdminComponent,
    EditComponent,
    
  ],

  bootstrap: [AppComponent],
  providers: [HttpClientModule, EventsService, ParticipantsService, AdminService, EditService],
  entryComponents: [ModalComponent, AdminComponent]
})
export class AppModule { }
