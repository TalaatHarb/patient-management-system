import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOrganizationsComponent } from './list-organizations.component';

describe('ListOrganizationsComponent', () => {
  let component: ListOrganizationsComponent;
  let fixture: ComponentFixture<ListOrganizationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListOrganizationsComponent]
    });
    fixture = TestBed.createComponent(ListOrganizationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
