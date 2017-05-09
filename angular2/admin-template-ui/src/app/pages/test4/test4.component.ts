/**
 * Created by Administrator on 2017/5/4.
 */
import { Component, OnInit } from '@angular/core';
import { TreeNode } from '../../theme/plugin/primeNG/common/api';
import { TreeData } from './tree.data';
@Component({
  selector:'test4',
  templateUrl:'./test4.html'
})

export class  Test4 implements OnInit{
  files: TreeNode[];

  constructor() {}

  ngOnInit() {
    this.files = TreeData;
  }
}
