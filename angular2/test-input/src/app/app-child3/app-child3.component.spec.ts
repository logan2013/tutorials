/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AppChild3Component } from './app-child3.component';

describe('AppChild3Component', () => {
  let component: AppChild3Component;
  let fixture: ComponentFixture<AppChild3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppChild3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppChild3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
