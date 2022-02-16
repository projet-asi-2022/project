import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PcPortableComponent } from './pc-portable.component';

describe('PcPortableComponent', () => {
  let component: PcPortableComponent;
  let fixture: ComponentFixture<PcPortableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PcPortableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PcPortableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
