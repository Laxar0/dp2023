import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { EntityesComponent } from './cars/cars.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { DoPutFormComponent } from './doput-form/doput-form.component';
import { UpdateComponent } from './update/update.component';
import { EntitylistComponent } from './carlist/carlist.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    EntityesComponent,
    AboutComponent,
    HomeComponent,
    DoPutFormComponent,
    UpdateComponent,
    EntitylistComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}