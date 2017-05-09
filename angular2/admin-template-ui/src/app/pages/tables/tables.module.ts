import {NgModule}      from '@angular/core';
import {CommonModule}  from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgaModule} from '../../theme/nga.module';
import {Ng2SmartTableModule} from 'ng2-smart-table';

import {BasicTables} from './components/basicTables/basicTables.component';
import {BasicTablesService} from './components/basicTables/basicTables.service';
import {ResponsiveTable} from './components/basicTables/components/responsiveTable';
import {StripedTable} from './components/basicTables/components/stripedTable';
import {BorderedTable} from './components/basicTables/components/borderedTable';
import {HoverTable} from './components/basicTables/components/hoverTable';
import {CondensedTable} from './components/basicTables/components/condensedTable';
import {ContextualTable} from './components/basicTables/components/contextualTable';
import {SmartTables} from './components/smartTables/smartTables.component';
import {SmartTablesService} from './components/smartTables/smartTables.service';
import {Ng2TableModule} from "ng2-table";
import {Ng2Tables} from "./components/ng2Tables/ng2Tables.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {PaginationModule} from "../../theme/pagination/pagination.module";
import {DataTableModule} from '../../theme/plugin/primeNG/datatable/datatable';
import {PrimeNgDataTableComponent} from './components/primengDataTable/primeNgDataTable.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        NgaModule,
        Ng2SmartTableModule,
        Ng2TableModule,
        PaginationModule.forRoot(),
        DataTableModule
    ],
    declarations: [
        BasicTables,
        HoverTable,
        BorderedTable,
        CondensedTable,
        StripedTable,
        ContextualTable,
        ResponsiveTable,
        SmartTables,
        Ng2Tables,
        PrimeNgDataTableComponent
    ],
    providers: [
        BasicTablesService,
        SmartTablesService,
    ],
    entryComponents: [
        BasicTables,
        HoverTable,
        BorderedTable,
        CondensedTable,
        StripedTable,
        ContextualTable,
        ResponsiveTable,
        SmartTables,
        Ng2Tables,
        PrimeNgDataTableComponent
    ]
})
export class TablesModule {
}
