import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HomeComponent} from './home/home.component';
import { LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';
const routes: Route[]= [{path: 'login', component: LoginComponent},
{path: '', component: LoginComponent},
{path: 'home', component: HomeComponent},
{path: 'logout', component: LoginComponent},
{path:'Signup',component: SignupComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
