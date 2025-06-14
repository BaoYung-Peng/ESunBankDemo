import { Routes } from '@angular/router';
import { SeatingChartComponent } from './seating-chart/seating-chart.component';

export const routes: Routes = [
  {
    path: 'seating-chart',
    component: SeatingChartComponent,
  },
  {
    path: '',
    redirectTo: '/seating-chart',
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: '/seating-chart',
  }
];
