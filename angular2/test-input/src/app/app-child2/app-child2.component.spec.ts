/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AppChild2Component } from './app-child2.component';

describe('AppChild2Component', () => {
  let component: AppChild2Component;
  let fixture: ComponentFixture<AppChild2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppChild2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppChild2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
