import {Routes, RouterModule} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {Pages} from "./pages/pages.component";
import {Login} from "./pages/login/login.component";

export const routes: Routes = [
    {
        path: 'login',
        component: Login
    },
    {
        path: 'pages',
        component: Pages
    },
    {
        path: '', redirectTo: 'pages',
        pathMatch: 'full'
    }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, {useHash: true});
