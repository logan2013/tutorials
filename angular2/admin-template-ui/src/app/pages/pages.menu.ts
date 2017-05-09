import {Dashboard} from "./dashboard/dashboard.component";
import {Ckeditor} from "./editors/components/ckeditor/ckeditor.component";
import {TreeView} from "./components/components/treeView/treeView.component";
import {SmartTables} from "./tables/components/smartTables/smartTables.component";
import {BasicTables} from "./tables/components/basicTables/basicTables.component";
import {Layouts} from "./forms/components/layouts/layouts.component";
import {Inputs} from "./forms/components/inputs/inputs.component";
import {Grid} from "./ui/components/grid/grid.component";
import {Modals} from "./ui/components/modals/modals.component";
import {Icons} from "./ui/components/icons/icons.component";
import {Buttons} from "./ui/components/buttons/buttons.component";
import {Typography} from "./ui/components/typography/typography.component";
import {ChartistJs} from "./charts/components/chartistJs/chartistJs.component";
import {Permission} from "../theme/services/baMenu/dynamicMenuService.service";
import { Test } from './test/test.component';
import { Test2 } from './test2/test2.component';
import {Ng2Tables} from "./tables/components/ng2Tables/ng2Tables.component";
import { Test3 } from './test3/test3.component';
import { Test4 } from './test4/test4.component';
import {PrimeNgDataTableComponent} from './tables/components/primengDataTable/primeNgDataTable.component';

export const PAGES_MENU: Permission[] = [
    {
        path: 'member',
        data: {
          menu: {
            title: '会员中心'
          }
        },
        children: [
            {
                actClass: Dashboard,
                path: 'dashboard',
                data: {
                    menu: {
                        title: '会员列表',
                        icon: 'ion-android-home',
                        selected: false,
                        expanded: false,
                        order: 0
                    }
                }
            },
          {
            actClass: Ckeditor,
            path: 'Ckeditor',
            data: {
              menu: {
                title: 'Ckeditor',
                icon: 'ion-android-home',
                selected: false,
                expanded: false,
                order: 0
              }
            }
          },
          {
            actClass: Test,
            path: 'test',
            data: {
              menu: {
                title: 'test',
                icon: 'ion-android-home',
                selected: false,
                expanded: false,
                order: 0
              }
            }
          },
          {
            actClass: Test2,
            path: 'test2',
            data: {
              menu: {
                title: 'test2',
                icon: 'ion-android-home',
                selected: false,
                expanded: false,
                order: 0
              }
            }
          },
          {
            actClass: Test3,
            path: 'test3',
            data: {
              menu: {
                title: 'test3',
                icon: 'ion-android-home',
                selected: false,
                expanded: false,
                order: 0
              }
            }
          },
          {
            actClass: Test4,
            path: 'test4',
            data: {
              menu: {
                title: 'test4',
                icon: 'ion-android-home',
                selected: false,
                expanded: false,
                order: 0
              }
            }
          },
            {
                path: 'editors',
                data: {
                    menu: {
                        title: '黑名单',
                        icon: 'ion-edit',
                        selected: false,
                        expanded: false,
                        order: 100,
                    }
                },
                children: [
                    {
                        actClass: Ckeditor,
                        path: 'ckeditor',
                        data: {
                            menu: {
                                title: '白名单',
                            }
                        }
                    }
                ]
            },
            {
                path: 'components',
                data: {
                    menu: {
                        title: 'components',
                        icon: 'ion-gear-a',
                        selected: false,
                        expanded: false,
                        order: 250,
                    }
                },
                children: [
                    {
                        actClass: TreeView,
                        path: 'treeview',
                        data: {
                            menu: {
                                title: 'treeview',
                            }
                        }
                    }
                ]
            },
            {
                path: 'charts',
                data: {
                    menu: {
                        title: 'charts',
                        icon: 'ion-stats-bars',
                        selected: false,
                        expanded: false,
                        order: 200,
                    }
                },
                children: [
                    {
                        actClass: ChartistJs,
                        path: 'chartist-js',
                        data: {
                            menu: {
                                title: 'chartist-js',
                            }
                        }
                    }
                ]
            },
            {
                path: 'ui',
                data: {
                    menu: {
                        title: 'ui',
                        icon: 'ion-android-laptop',
                        selected: false,
                        expanded: false,
                        order: 300,
                    }
                },
                children: [
                    {
                        actClass: Typography,
                        path: 'typography',
                        data: {
                            menu: {
                                title: 'typography',
                            }
                        }
                    },
                    {
                        actClass: Buttons,
                        path: 'buttons',
                        data: {
                            menu: {
                                title: 'buttons',
                            }
                        }
                    },
                    {
                        actClass: Icons,
                        path: 'icons',
                        data: {
                            menu: {
                                title: 'icons',
                            }
                        }
                    },
                    {
                        actClass: Modals,
                        path: 'modals',
                        data: {
                            menu: {
                                title: 'modals',
                            }
                        }
                    },
                    {
                        actClass: Grid,
                        path: 'grid',
                        data: {
                            menu: {
                                title: 'grid',
                            }
                        }
                    },
                ]
            },
            {
                path: 'forms',
                data: {
                    menu: {
                        title: 'forms',
                        icon: 'ion-compose',
                        selected: false,
                        expanded: false,
                        order: 400,
                    }
                },
                children: [
                    {
                        actClass: Inputs,
                        path: 'inputs',
                        data: {
                            menu: {
                                title: 'inputs',
                            }
                        }
                    },
                    {
                        actClass: Layouts,
                        path: 'layouts',
                        data: {
                            menu: {
                                title: 'layouts',
                            }
                        }
                    }
                ]
            },
            {
                path: 'tables',
                data: {
                    menu: {
                        title: 'tables',
                        icon: 'ion-grid',
                        selected: false,
                        expanded: false,
                        order: 500,
                    }
                },
                children: [
                    {
                      actClass: Ng2Tables,
                      path: 'ng2-tables',
                      data: {
                        menu: {
                          title: 'ng2-tables',
                        }
                      }
                    },
                    {
                        actClass: BasicTables,
                        path: 'basictables',
                        data: {
                            menu: {
                                title: 'basictables',
                            }
                        }
                    },
                    {
                        actClass: SmartTables,
                        path: 'smarttables',
                        data: {
                            menu: {
                                title: 'smarttables',
                            }
                        }
                    },
                    {
                        actClass: PrimeNgDataTableComponent,
                        path: 'PrimeNgDataTable',
                        data: {
                            menu: {
                                title: 'PrimeNgDataTable',
                            }
                        }
                    }
                ]
            }
        ]
    }, {
    path: 'finance',
    data: {
      menu: {
        title: '资金中心'
      }
    },
    children: [
      {
        actClass: Dashboard,
        path: 'dashboard',
        data: {
          menu: {
            title: '提现',
            icon: 'ion-android-home',
            selected: false,
            expanded: false,
            order: 0
          }
        }
      }
    ]
  }
];
