import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateSlipComponent } from './generate-slip.component';

describe('GenerateSlipComponent', () => {
  let component: GenerateSlipComponent;
  let fixture: ComponentFixture<GenerateSlipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GenerateSlipComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenerateSlipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
