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


const appRoutes: Routes = [
  { path: 'events', component: EventsComponent },
  { path: 'events/:id', component: EventsComponent },
  { path: '', redirectTo: '/events', pathMatch: 'full' },
];


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ModalModule.forRoot()
   ],
   declarations: [
    AppComponent, 
    HeaderComponent,
    EventsComponent,
    SliderComponent,
    FooterComponent,
    ModalComponent,
  
  ],
  bootstrap: [AppComponent],
  providers: [HttpClientModule, EventsService],
  entryComponents: [ModalComponent]
})
export class AppModule { }
