/**
 * Created by Administrator on 2017/5/4.
 */
import { Component, OnInit } from '@angular/core';
import { TreeNode } from '../../theme/plugin/primeNG/common/api';
import { TreeData } from './tree.data';
import { DefaultModal } from '../ui/components/modals/default-modal/default-modal.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector:'test4',
  templateUrl:'./test4.html'
})

export class  Test4 implements OnInit{
  files: TreeNode[];

  constructor(private modalService: NgbModal) {}

  ngOnInit() {
    this.files = TreeData;
  }
  lgModalShow() {
    const activeModal = this.modalService.open(DefaultModal, {size: 'lg'});
    activeModal.componentInstance.modalHeader = 'Large Modal';
  }
}
