import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticuloItemComponent } from './articulo-item.component';

describe('ArticuloItemComponent', () => {
  let component: ArticuloItemComponent;
  let fixture: ComponentFixture<ArticuloItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArticuloItemComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ArticuloItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
