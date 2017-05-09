import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { Dashboard } from './dashboard.component';

import { PopularApp } from './popularApp';
import { PieChart } from './pieChart';
import { TrafficChart } from './trafficChart';
import { Feed } from './feed';
import { Todo } from './todo';
import { Calendar } from './calendar';
import { CalendarService } from './calendar/calendar.service';
import { FeedService } from './feed/feed.service';
import { PieChartService } from './pieChart/pieChart.service';
import { TodoService } from './todo/todo.service';
import { TrafficChartService } from './trafficChart/trafficChart.service';
import {DashboardDetail} from "./dashboard-detail.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule
  ],
  declarations: [
    PopularApp,
    PieChart,
    TrafficChart,
    Feed,
    Todo,
    Calendar,
    Dashboard,
    DashboardDetail
  ],
  providers: [
    CalendarService,
    FeedService,
    PieChartService,
    TodoService,
    TrafficChartService
  ],
  entryComponents: [
    PopularApp,
    PieChart,
    TrafficChart,
    Feed,
    Todo,
    Calendar,
    Dashboard,
    DashboardDetail
  ]
})
export class DashboardModule {}
