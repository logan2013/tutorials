import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { TreeModule } from 'ng2-tree';

import { TreeView } from './components/treeView/treeView.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    TreeModule
  ],
  declarations: [
    TreeView
  ],
  entryComponents: [
    TreeView
  ]
})
export class ComponentsModule {}
