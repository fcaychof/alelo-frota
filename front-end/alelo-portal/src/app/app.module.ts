import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VehicleComponent } from './dashboard/vehicle/vehicle.component';
import { AddComponent } from './dashboard/vehicle/add/add.component';
import { EditComponent } from './dashboard/vehicle/edit/edit.component';
import { ListComponent } from './dashboard/vehicle/list/list.component';
import { DeleteComponent } from './dashboard/vehicle/delete/delete.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    VehicleComponent,
    AddComponent,
    EditComponent,
    ListComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
