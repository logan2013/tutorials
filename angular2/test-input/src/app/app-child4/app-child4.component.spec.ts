/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AppChild4Component } from './app-child4.component';

describe('AppChild4Component', () => {
  let component: AppChild4Component;
  let fixture: ComponentFixture<AppChild4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppChild4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppChild4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
