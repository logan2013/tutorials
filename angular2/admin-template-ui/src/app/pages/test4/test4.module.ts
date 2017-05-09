/**
 * Created by Administrator on 2017/5/4.
 */
import { NgModule } from '@angular/core';
import { Test4 } from "./test4.component";
import { TreeModule } from '../../theme/plugin/primeNG/tree/tree';
@NgModule({
  imports:[TreeModule],
  declarations:[Test4],
  entryComponents: [Test4]
})
export class Test4Module{

}
