
import {Component, ElementRef} from '@angular/core';
import {AdminService, AdminUser} from './admin.component.service'
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})


export class AdminComponent {
 
  public user = new AdminUser('','');
  public errorMsg = '';

  constructor(
      private _service:AdminService) {}

  login() {
      if(!this._service.login(this.user)){
          this.errorMsg = 'Failed to login';
      }
  }
}
export class PrivateComponent {
 
  constructor(
      private _service:AdminService){}

  ngOnInit(){
      this._service.checkCredentials();
  }

  logout() {
      this._service.logout();
  }
}