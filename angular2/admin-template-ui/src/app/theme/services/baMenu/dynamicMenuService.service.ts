import {Component, Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {PAGES_MENU} from "../../../pages/pages.menu";

export interface MenuItem{
  title: string;
  icon?: string;
  order?: number;
  selected?: boolean;
  expanded?: boolean;
}

export interface PermissionData{
  menu: MenuItem;
}

export interface Permission{
  path?: string;
  actClass?: Component;
  data?: PermissionData;
  children?: Permission[];
}

@Injectable()
export class DynamicMenuService{
  constructor(private http: Http){
  }

  getPagesMenu(): Promise<Permission[]>{
    return this.http
      .get('user/permission')
      .toPromise()
      .then(response => response.json().data as Permission[])
      .catch(this.errorHandler);
  }

  getPagesMenuMock(): Promise<Permission[]>{
    return new Promise(resovle => {
      setTimeout(() => resovle(PAGES_MENU), 1000);
    });
    // return Promise.resolve(PAGES_MENU);
  }

  private errorHandler(error: any){
    console.error('find user permission occur error: ', error);
    return Promise.reject(error.message || error);
  }
}
