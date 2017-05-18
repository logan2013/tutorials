import {NgModule, ModuleWithProviders} from '@angular/core';

import {NgbModalBackdrop} from './modal-backdrop';
import {NgbModalWindow} from './modal-window';
import {NgbModalStack} from './modal-stack';
import {TzbNgbModal} from './modal';

export {TzbNgbModal, NgbModalOptions} from './modal';
export {NgbModalRef, TzbNgbActiveModal} from './modal-ref';
export {ModalDismissReasons} from './modal-dismiss-reasons';

@NgModule({
  declarations: [NgbModalBackdrop, NgbModalWindow],
  entryComponents: [NgbModalBackdrop, NgbModalWindow],
  providers: [TzbNgbModal]
})
export class TzbNgbModalModule {
  static forRoot(): ModuleWithProviders { return {ngModule: TzbNgbModalModule, providers: [TzbNgbModal, NgbModalStack]}; }
}
