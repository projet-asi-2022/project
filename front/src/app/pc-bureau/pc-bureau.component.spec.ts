import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PcBureauComponent } from './pc-bureau.component';

describe('PcBureauComponent', () => {
  let component: PcBureauComponent;
  let fixture: ComponentFixture<PcBureauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PcBureauComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PcBureauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
