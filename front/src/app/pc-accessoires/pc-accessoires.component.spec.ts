import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PcAccessoiresComponent } from './pc-accessoires.component';

describe('PcAccessoiresComponent', () => {
  let component: PcAccessoiresComponent;
  let fixture: ComponentFixture<PcAccessoiresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PcAccessoiresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PcAccessoiresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
