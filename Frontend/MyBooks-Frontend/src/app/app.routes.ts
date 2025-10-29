import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FormComponent } from './pages/form/form.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'form', component: FormComponent }
  ];
