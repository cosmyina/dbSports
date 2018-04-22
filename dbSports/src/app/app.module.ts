import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { EventsComponent } from './events/events.component';

import { SliderComponent } from './slider/slider.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { EventsService } from './events/events.service';


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
    RouterModule.forRoot(appRoutes)
   ],
   declarations: [
    AppComponent, 
    HeaderComponent,
    EventsComponent,
    SliderComponent,
    FooterComponent,
  
  ],
  bootstrap: [AppComponent],
  providers: [HttpClientModule, EventsService]
})
export class AppModule { }
