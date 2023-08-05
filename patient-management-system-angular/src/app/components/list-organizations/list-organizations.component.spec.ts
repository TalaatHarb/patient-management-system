import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOrganizationsComponent } from './list-organizations.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { MockModule } from 'ng-mocks';

describe('ListOrganizationsComponent', () => {
  let component: ListOrganizationsComponent;
  let fixture: ComponentFixture<ListOrganizationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListOrganizationsComponent],
      imports: [HttpClientTestingModule, MockModule(FormsModule)]
    });
    fixture = TestBed.createComponent(ListOrganizationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
