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

export const PAGES_MENU = [
    {
        path: 'pages',
        children: [
            {
                actClass: Dashboard,
                path: 'dashboard',
                data: {
                    menu: {
                        title: 'general.menu.dashboard',
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
                        title: 'general.menu.editors',
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
                                title: 'general.menu.ck_editor',
                            }
                        }
                    }
                ]
            },
            {
                path: 'components',
                data: {
                    menu: {
                        title: 'general.menu.components',
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
                                title: 'general.menu.tree_view',
                            }
                        }
                    }
                ]
            },
            {
                path: 'charts',
                data: {
                    menu: {
                        title: 'general.menu.charts',
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
                                title: 'general.menu.chartist_js',
                            }
                        }
                    }
                ]
            },
            {
                path: 'ui',
                data: {
                    menu: {
                        title: 'general.menu.ui_features',
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
                                title: 'general.menu.typography',
                            }
                        }
                    },
                    {
                        actClass: Buttons,
                        path: 'buttons',
                        data: {
                            menu: {
                                title: 'general.menu.buttons',
                            }
                        }
                    },
                    {
                        actClass: Icons,
                        path: 'icons',
                        data: {
                            menu: {
                                title: 'general.menu.icons',
                            }
                        }
                    },
                    {
                        actClass: Modals,
                        path: 'modals',
                        data: {
                            menu: {
                                title: 'general.menu.modals',
                            }
                        }
                    },
                    {
                        actClass: Grid,
                        path: 'grid',
                        data: {
                            menu: {
                                title: 'general.menu.grid',
                            }
                        }
                    },
                ]
            },
            {
                path: 'forms',
                data: {
                    menu: {
                        title: 'general.menu.form_elements',
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
                                title: 'general.menu.form_inputs',
                            }
                        }
                    },
                    {
                        actClass: Layouts,
                        path: 'layouts',
                        data: {
                            menu: {
                                title: 'general.menu.form_layouts',
                            }
                        }
                    }
                ]
            },
            {
                path: 'tables',
                data: {
                    menu: {
                        title: 'general.menu.tables',
                        icon: 'ion-grid',
                        selected: false,
                        expanded: false,
                        order: 500,
                    }
                },
                children: [
                    {
                        actClass: BasicTables,
                        path: 'basictables',
                        data: {
                            menu: {
                                title: 'general.menu.basic_tables',
                            }
                        }
                    },
                    {
                        actClass: SmartTables,
                        path: 'smarttables',
                        data: {
                            menu: {
                                title: 'general.menu.smart_tables',
                            }
                        }
                    }
                ]
            }
        ]
    }
];
