import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule }   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HostpitalListComponent } from './hostpital-list/hostpital-list.component';
import { UserComponent } from './user/user.component';



import { SearchPipe} from './providers/search.pipe';

const appRoutes: Routes = [
  { path: 'home', component: AppComponent },
  { path: 'hospitals',  component: HostpitalListComponent },
  { path: 'users',  component: UserComponent },
 
  
  { path: '',
    redirectTo: '/users',
    pathMatch: 'full'
  },
  { path: '**', component: AppComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    HostpitalListComponent,
    UserComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
