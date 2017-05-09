import {Injectable} from "@angular/core";
import * as _ from "lodash";

import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Subject} from "rxjs";
import {DynamicMenuService, Permission} from "./dynamicMenuService.service";
import {TopMenu} from "../../components/baNavTop/baNavTop.component";

@Injectable()
export class BaMenuService {
  /**
   * left menu item
   */
  menuItems = new BehaviorSubject<any[]>([]);
  /**
   * top menu item
   */
  topItems = new BehaviorSubject<any[]>([]);

    protected _currentMenuItem = {};

    selectOp = new Subject<any>();

    private userDynamicMenu: Permission[];

    constructor(private dynamicMenuService: DynamicMenuService) {
      this.findUserDynamicMenu();
    }

  /**
   * dynamic load user permission as menu
   */
    public findUserDynamicMenu(){
      this.dynamicMenuService.getPagesMenuMock().then(userDynamicMenu => {
        this.userDynamicMenu = userDynamicMenu;
        this.fillTopMenu();
        this.fillSiderbarMenu();
      });
    }

    /**
     * Updates the routes in the menu
     *
     * @param {Routes} routes Type compatible with app.menu.ts
     */
    public fillSiderbarMenu(tab?: string) {
      /**
       * tab switch by path
       */
      let siderbarMenu: Permission;

      if (tab){
        siderbarMenu = this.userDynamicMenu.find(p => p.path === tab);
      }else{
        siderbarMenu = this.userDynamicMenu[0];
      }
      delete siderbarMenu.data;

      let convertedRoutes = this.convertRoutesToMenus(_.cloneDeep([].concat(siderbarMenu)));
      this.menuItems.next(convertedRoutes);
    }

    public convertRoutesToMenus(routes): any[] {
        let items = this._convertArrayToItems(routes);
        return this._skipEmpty(items);
    }

    public getCurrentItem(): any {
        return this._currentMenuItem;
    }

    public selectMenuItem(menuItems: any[]): any[] {
        let items = [];
        menuItems.forEach((item) => {
            this._selectItem(item);

            if (item.selected) {
                this._currentMenuItem = item;
            }

            if (item.children && item.children.length > 0) {
                item.children = this.selectMenuItem(item.children);
            }
            items.push(item);
        });
        return items;
    }

    protected _skipEmpty(items: any[]): any[] {
        let menu = [];
        items.forEach((item) => {
            let menuItem;
            if (item.skip) {
                if (item.children && item.children.length > 0) {
                    menuItem = item.children;
                }
            } else {
                menuItem = item;
            }

            if (menuItem) {
                menu.push(menuItem);
            }
        });

        return [].concat.apply([], menu);
    }

    protected _convertArrayToItems(routes: any[], parent?: any): any[] {
        let items = [];
        routes.forEach((route) => {
            items.push(this._convertObjectToItem(route, parent));
        });
        return items;
    }

    protected _convertObjectToItem(object, parent?: any): any {
        let item: any = {};
        if (object.data && object.data.menu) {
            // this is a menu object
            item = object.data.menu;
            item.route = object;
            delete item.route.data.menu;
        } else {
            item.route = object;
            item.skip = true;
        }

        // we have to collect all paths to correctly build the url then
        if (Array.isArray(item.route.path)) {
            item.route.paths = item.route.path;
        } else {
            item.route.paths = parent && parent.route && parent.route.paths ? parent.route.paths.slice(0) : ['/'];
            if (!!item.route.path) item.route.paths.push(item.route.path);
        }

        if (object.children && object.children.length > 0) {
            item.children = this._convertArrayToItems(object.children, item);
        }

        if (!!object.actClass) {
            item.actClass = object.actClass;
        }

        let prepared = this._prepareItem(item);

        // if current item is selected or expanded - then parent is expanded too
        if ((prepared.selected || prepared.expanded) && parent) {
            parent.expanded = true;
        }

        return prepared;
    }

    protected _prepareItem(object: any): any {
        if (!object.skip) {
            object.target = object.target || '';
            object.pathMatch = object.pathMatch || 'full';
            return this._selectItem(object);
        }

        return object;
    }

    protected _selectItem(object: any): any {

        // TODO: 根据浏览器URL选中菜单->根据上次打开的tab选中菜单

        // object.selected = this._router
        //   .isActive(this._router.createUrlTree(object.route.paths), object.pathMatch === 'full');

        return object;
    }

    publishData(item) {
        this.selectOp.next(item);
    }

    private fillTopMenu() {
      let topMenu: TopMenu[] = [];
      this.userDynamicMenu.forEach(m => topMenu.push({path: m.path, title: m.data.menu.title}));
      this.topItems.next(topMenu);
    }
}
